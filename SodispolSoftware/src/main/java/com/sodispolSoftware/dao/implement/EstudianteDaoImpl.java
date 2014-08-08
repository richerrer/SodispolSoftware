
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class EstudianteDaoImpl extends HibernateDaoSupport implements EstudianteDao{

     @Override
    public Estudiante getEstudiante(String username) {
        try
        {
            Object[] paramsEstudiante = new Object[]{username,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find("from Estudiante e where e.username= ? and estadoborrado = ?",paramsEstudiante).get(0); 
            estudiante.setRoleuser((Roleuser)getHibernateTemplate().get(Roleuser.class, estudiante.getRoleuser().getIdroleuser()));
            Object[] attributes = WbServiceEspol.loadEstudianteAttributes(username);
            loadDataFromWebService(estudiante,attributes);
            return estudiante;
        }
        catch(IndexOutOfBoundsException ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    @Override
    public Estudiante getEstudianteByMatricula(String matricula,Object[] attributes) {
        try
        {
            Object[] paramsEstudiante = new Object[]{matricula,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find("from Estudiante e where e.matricula= ? and estadoborrado = ?",paramsEstudiante).get(0); 
            loadDataFromWebService(estudiante,attributes);
             return estudiante;
        }
        catch(IndexOutOfBoundsException ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    @Override
    public Estudiante getEstudianteByCedula(String cedula, Object[] attributes) {
        try
        {
            Object[] paramsEstudiante = new Object[]{cedula,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find("from Estudiante e where e.cedula= ? and estadoborrado = ?",paramsEstudiante).get(0); 
            loadDataFromWebService(estudiante,attributes);
             return estudiante;
        }
        catch(IndexOutOfBoundsException ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    @Override
    public void addEstudiante(Estudiante estudiante) {
        getHibernateTemplate().save(estudiante);
    }
    
    public void loadDataFromWebService(Estudiante estudiante,Object[] attributes)
    {
        estudiante.setNombre1((String)attributes[7]);
        estudiante.setNombre2((String)attributes[8]);
        estudiante.setApellido1((String)attributes[9]);
        estudiante.setApellido2((String)attributes[10]);
        estudiante.setCarrera((String)attributes[6]);
        estudiante.setEdad((Integer)attributes[5]);
        estudiante.setFoto((String)attributes[12]);
        /*estudiante.setFechaNacimiento((String)attributes[11]);*/
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        getHibernateTemplate().update(estudiante);
    }
    
}
