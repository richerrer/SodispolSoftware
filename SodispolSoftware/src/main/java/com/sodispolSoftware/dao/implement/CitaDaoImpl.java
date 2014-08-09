
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.CitaDao;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Doctor;
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
    public ArrayList<Object[]> getCitas(Doctor doctor) {
        try{
            Object[] paramsCitas = new Object[]{false};
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select c.estadocita from Citamedica c where c.estadoborrado = ? order by 1 desc",paramsCitas); 
            System.out.println(consulta.size());
            return consulta;
        }
        catch(DataAccessException ex){
            return null;
        }
    }

    @Override
    public int getncitas() {
        try{
            Object[] paramsCitas = new Object[]{false};
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select c.estadocita from Citamedica c where c.estadoborrado = ? order by 1 desc",paramsCitas); 
            int nconsul = consulta.size();
            return nconsul;
        }
        catch(DataAccessException ex){
            return -1;
        }
    }

     
    
}
