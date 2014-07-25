package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Esta clase es una implementación de  EstudianteBo, la cual define la lógica de 
 * negocio del objeto Estudiante
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
public class EstudianteBoImpl implements EstudianteBo{

    @Inject
    private EstudianteDao estudianteDao;

    @Inject
    private RoleUserBo roleUserBo;

    /**
     * Get the value of roleUserBo
     *
     * @return the value of roleUserBo
     */
    public RoleUserBo getRoleUserBo() {
        return roleUserBo;
    }

    /**
     * Set the value of roleUserBo
     *
     * @param roleUserBo new value of roleUserBo
     */
    public void setRoleUserBo(RoleUserBo roleUserBo) {
        this.roleUserBo = roleUserBo;
    }

    /**
     * Get the value of estudianteDao
     *
     * @return the value of estudianteDao
     */
    public EstudianteDao getEstudianteDao() {
        return estudianteDao;
    }

    /**
     * Set the value of estudianteDao
     *
     * @param estudianteDao new value of estudianteDao
     */
    public void setEstudianteDao(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }

    /**
     * Obtiene un Estudiante según su matrícula, en el cual primero comprueba 
     * si esa matrícula se encuentra en el servicio web de Espol para luego
     * obtener el Estudiante de la base de datos, y en caso de que no se encuentre
     * en nuestra base de datos, se crea un nuevo Estudiante.
     *
     * @param matricula matricula del estudiante
     * @return Estudiante según la matrícula
     */
    @Override
    public Estudiante getEstudianteByMatricula(String matricula) {
        Object[] attributes = WbServiceEspol.loadEstudinateAttributesByMatricula(matricula);
        
        /*No se encuentra esa matrícula en la base de Espol*/
        if(attributes==null){
            return null;
        }
        
        Estudiante estudiante = getEstudianteDao().getEstudiante(matricula,attributes);
        
        /*Si el estudiante no se encuentra en nuestra base de datos*/
        if(estudiante==null){
            String autority = "ROLE_ESTUDIANTE";
            estudiante = new Estudiante(getRoleUserBo().getRoleUser(autority),false);
            estudiante.setMatricula(matricula);
            estudiante.setCedula((String)attributes[0]);
            estudiante.setUsername((String)attributes[1]);
            estudiante.setDireccion((String)attributes[2]);
            estudiante.setEstadocivil((String)attributes[3]);
            estudiante.setTelefono((String)attributes[4]);
            this.addEstudiante(estudiante);
            estudiante = getEstudianteDao().getEstudiante(matricula,attributes);
        }
        return estudiante;
    }

     /**
     * Agrega un nuevo estudiante a la base de datos.
     *
     * @param estudiante estudiante a agregar
     */
    @Override
    public void addEstudiante(Estudiante estudiante) {
        this.getEstudianteDao().addEstudiante(estudiante);
    }
    
    
    
}
