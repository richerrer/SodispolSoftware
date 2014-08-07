
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.CitaDao;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class CitaDaoImpl extends HibernateDaoSupport implements CitaDao{

    @Override
    public ArrayList<Object[]> getCitas() {
        try{
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select * from Citamedica c"); 
            
            return consulta;
        }
        catch(DataAccessException ex){
            return null;
        }
    }

     
    
}
