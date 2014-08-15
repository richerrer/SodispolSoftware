package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.DetalleFichaEstudianteBo;
import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.businessObject.FichaMedicaEstudianteBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Esta clase es una implementación de  EstudianteBo, la cual define la lógica de 
 * negocio del objeto Estudiante
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("prototype")
public class EstudianteBoImpl implements EstudianteBo{

    @Inject
    private EstudianteDao estudianteDao;

    @Inject
    private RoleUserBo roleUserBo;
    
    @Inject
    private FichaMedicaEstudianteBo fichaMedicaEstudianteBo;
    
    @Inject
    private DetalleFichaEstudianteBo detalleFichaEstudianteBo;
     
    /**
     * Get the value of detalleFichaEstudianteBo
     *
     * @return the value of detalleFichaEstudianteBo
     */
    public DetalleFichaEstudianteBo getDetalleFichaEstudianteBo() {
        return detalleFichaEstudianteBo;
    }

    /**
     * Set the value of detalleFichaEstudianteBo
     *
     * @param detalleFichaEstudianteBo new value of detalleFichaEstudianteBo
     */
    public void setDetalleFichaEstudianteBo(DetalleFichaEstudianteBo detalleFichaEstudianteBo) {
        this.detalleFichaEstudianteBo = detalleFichaEstudianteBo;
    }

    /**
     * Get the value of fichaMedicaEstudianteBo
     *
     * @return the value of fichaMedicaEstudianteBo
     */
    public FichaMedicaEstudianteBo getFichaMedicaEstudianteBo() {
        return fichaMedicaEstudianteBo;
    }

    /**
     * Set the value of fichaMedicaEstudianteBo
     *
     * @param fichaMedicaEstudianteBo new value of fichaMedicaEstudianteBo
     */
    public void setFichaMedicaEstudianteBo(FichaMedicaEstudianteBo fichaMedicaEstudianteBo) {
        this.fichaMedicaEstudianteBo = fichaMedicaEstudianteBo;
    }


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
     * Obtiene un Estudiante según su username, en el cual primero comprueba 
     * si ese username se encuentra en la base de datos, y en caso de que no se encuentre
     * en nuestra base de datos, se crea un nuevo Estudiante.
     *
     * @param username matricula del estudiante
     * @return Estudiante según la matrícula
     */
    @Override
    public Estudiante getEstudiante(String username) {
        Estudiante estudiante = getEstudianteDao().getEstudiante(username);
        if(estudiante == null)
        {  
            String autority = "ROLE_ESTUDIANTE";
            estudiante = new Estudiante(getRoleUserBo().getRoleUser(autority),false);
            WbServiceEspol.setDataEstudianteByUsernameFromWebService(estudiante, username);
            this.addEstudiante(estudiante);
            estudiante = getEstudianteDao().getEstudiante(username);
        }
        
        return estudiante;
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
        
        /*No se encuentra esa matrícula en la base de Espol*/
        if(!WbServiceEspol.verifyMatricula(matricula)){
            return null;
        }
        
        Estudiante estudiante = getEstudianteDao().getEstudianteByMatricula(matricula);
        
        /*Si el estudiante no se encuentra en nuestra base de datos*/
        if(estudiante==null){
            String autority = "ROLE_ESTUDIANTE";
            estudiante = new Estudiante(getRoleUserBo().getRoleUser(autority),false);
            WbServiceEspol.setDataEstudianteByMatriculaFromWebService(estudiante, matricula);
            this.addEstudiante(estudiante);
            estudiante = getEstudianteDao().getEstudianteByMatricula(matricula);
        }
        return estudiante;
    }
    
     /**
     * Obtiene un Estudiante según su cédula, en el cual primero comprueba 
     * si esa cédula se encuentra en el servicio web de Espol para luego
     * obtener el Estudiante de la base de datos, y en caso de que no se encuentre
     * en nuestra base de datos, se crea un nuevo Estudiante.
     *
     * @param cedula matricula del estudiante
     * @return Estudiante según la matrícula
     */
    @Override
    public Estudiante getEstudianteByCedula(String cedula) {
        
        /*No se encuentra esa matrícula en la base de Espol*/
        if(!WbServiceEspol.verifyCedula(cedula)){
            return null;
        }
        
        Estudiante estudiante = getEstudianteDao().getEstudianteByCedula(cedula);
        
        /*Si el estudiante no se encuentra en nuestra base de datos*/
        if(estudiante==null){
            String autority = "ROLE_ESTUDIANTE";
            estudiante = new Estudiante(getRoleUserBo().getRoleUser(autority),false);
            WbServiceEspol.setDataEstudianteByCedulaFromWebService(estudiante, cedula);
            this.addEstudiante(estudiante);
            estudiante = getEstudianteDao().getEstudianteByCedula(cedula);
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
        getEstudianteDao().addEstudiante(estudiante);
    }
    
    /**
     * Actualiza un estudiante en la base de datos.
     *
     * @param estudiante estudiante a actualizar
     */
    @Override
    public void updateEstudiante(Estudiante estudiante) {
        getEstudianteDao().updateEstudiante(estudiante);
    }

    /**
     * Obtiene la Ficha Médica del Estudiante.
     *
     * @param estudiante estudiante del cual se busca la ficha médica.
     * @return la ficha médica del estudiante
     */
    @Override
    public Fichamedicaestudiante getFichaMedica(Estudiante estudiante) {
        Fichamedicaestudiante ficha = getFichaMedicaEstudianteBo().getFicha(estudiante);
        if(ficha != null){
            return ficha;
        }
        ficha = new Fichamedicaestudiante();
        return ficha;
    }
 

    /**
     * Agrega una Ficha Médica del Estudiante.
     *
     * @param estudiante estudiante al cual se le añade una Ficha Medica.
     * @param ficha
     */
    @Override
    public void addFichaMedica(Estudiante estudiante, Fichamedicaestudiante ficha) {
        ficha.setEstudiante(estudiante);
        getFichaMedicaEstudianteBo().addFicha(ficha);
    }

    /**
     * Actualiza una Ficha Médica del Estudiante.
     *
     * @param estudiante estudiante al cual se le añade una Ficha Medica.
     * @param ficha
     */
    @Override
    public void updateFichaMedica(Estudiante estudiante, Fichamedicaestudiante ficha) {
        ficha.setEstudiante(estudiante);
        getFichaMedicaEstudianteBo().updateFicha(ficha);
    }
    
    @Override
    public Detallefichaestudiante getDetalleFichaEstudiante(long idDetalle,Estudiante estudiante) {
        return getDetalleFichaEstudianteBo().getDetalleFichaEstudiante(idDetalle,estudiante);
    }
  
}
