
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
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
            WbServiceEspol.loadDataEstudianteByUsernameFromWebService(estudiante);
            return estudiante;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    @Override
    public Estudiante getEstudianteByMatricula(String matricula) {
        try
        {
            Object[] paramsEstudiante = new Object[]{matricula,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find("from Estudiante e where e.matricula= ? and estadoborrado = ?",paramsEstudiante).get(0); 
            WbServiceEspol.loadDataEstudianteByMatriculaFromWebService(estudiante);
             return estudiante;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    @Override
    public Estudiante getEstudianteByCedula(String cedula) {
        try
        {
            Object[] paramsEstudiante = new Object[]{cedula,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find("from Estudiante e where e.cedula= ? and estadoborrado = ?",paramsEstudiante).get(0); 
            WbServiceEspol.loadDataEstudianteByCedulaFromWebService(estudiante);
             return estudiante;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    @Override
    public void addEstudiante(Estudiante estudiante) {
        getHibernateTemplate().save(estudiante);
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        getHibernateTemplate().update(estudiante);
    }
    
}
