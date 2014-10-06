
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WebServiceEspol;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class EstudianteDaoImpl extends HibernateDaoSupport implements EstudianteDao{

    @Inject
    private WebServiceEspol webService;
    
    /*Consulta con fetch si quiero filtrar por un atributo, pero puede que sea null
    "from Estudiante e left join fetch e.fichamedicaestudiantes f where (f.idfichamedica IS NULL or f.idfichamedica = 1) and e.matricula= ? and e.estadoborrado = ?";
    
    */
    private final String queryObtenerEstudianteAndRoleUser = "from Estudiante e left join fetch e.roleuser where e.username= ? and e.estadoborrado = ?";
    private final String queryObtenerEstudianteByMatricula = "from Estudiante e where e.matricula= ? and estadoborrado = ?";
    //from Estudiante e where e.matricula= ? and e.estadoborrado = ?
    /*private final String queryObtenerEstudianteByMatricula = "from Estudiante e left join fetch e.fichamedicaestudiantes f "
            + "                                               left join fetch f.detallefichaestudiantes d where e.matricula= ? and e.estadoborrado = ? "
            + "                                               order by 1 e.fecha desc";
    */
    private final String queryObtenerEstudianteByCedula = "from Estudiante e where e.cedula= ? and estadoborrado = ?";
    
    @Override
    public Estudiante getEstudiante(String username) {
        try
        {
            Object[] paramsEstudiante = new Object[]{username,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find(queryObtenerEstudianteAndRoleUser,paramsEstudiante).get(0); 
            webService.loadDataEstudianteByUsernameFromWebService(estudiante);
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
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find(queryObtenerEstudianteByMatricula,paramsEstudiante).get(0); 
            webService.loadDataEstudianteByMatriculaFromWebService(estudiante);
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
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find(queryObtenerEstudianteByCedula,paramsEstudiante).get(0); 
            webService.loadDataEstudianteByCedulaFromWebService(estudiante);
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
    
    
    public WebServiceEspol getWebService() {
        return webService;
    }

    public void setWebService(WebServiceEspol webService) {
        this.webService = webService;
    }
}
