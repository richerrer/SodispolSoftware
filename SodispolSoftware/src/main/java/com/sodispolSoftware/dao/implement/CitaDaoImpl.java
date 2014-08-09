
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.CitaDao;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class CitaDaoImpl extends HibernateDaoSupport implements CitaDao{

    @Override
    public ArrayList<Object[]> getCitas(Doctor doctor) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("select c.estudiante, c.estadocita, c.fechareg, c.fechaprog, c.idcita from Citamedica c where c.doctor = :doctor and c.estadoborrado = :estado order by 1 desc");
            query.setParameter("doctor",doctor); 
            query.setParameter("estado",false);
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)query.list();
            session.beginTransaction().commit();
            session.close();
            return consulta;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }
    /*
    @Override
    public ArrayList<Object[]> getCitas(Doctor doctor) {
        try{
            Object[] paramsCitas = new Object[]{doctor,false};
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select c.estadocita from Citamedica c where c.doctor = ? and c.estadoborrado = ?",paramsCitas); 
            
            return consulta;
        }
        catch(Exception ex){
            return null;
        }
    }*/

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

    @Override
    public void updateCita(Citamedica cita) {
        getHibernateTemplate().saveOrUpdate(cita);
    }

     
    
}
