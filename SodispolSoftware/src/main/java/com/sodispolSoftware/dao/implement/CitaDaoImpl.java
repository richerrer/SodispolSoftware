
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.CitaDao;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class CitaDaoImpl extends HibernateDaoSupport implements CitaDao
{

    @Override
    public ArrayList<Citamedica> getAllCitas() 
    {
        try
        {
            ArrayList<Citamedica> citas = new ArrayList<Citamedica>();
            Object[] paramsCita = new Object[]{false};
            
            ArrayList<Object[]> consulta = (ArrayList<Object[]>) getHibernateTemplate().find("select c,e,d from Citamedica c join c.estudiante as e join c.doctor as d where c.estadoborrado = ?",paramsCita); 
            
            for(Object[] obj : consulta)
            {
                Citamedica cita = (Citamedica) obj[0];
                citas.add(cita);
            }
            return citas;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    @Override
    public ArrayList<Citamedica> getCitasByDoctor(Doctor doctor) 
    {
        try
        {
            ArrayList<Citamedica> citas = new ArrayList<Citamedica>();
            Object[] paramsCita = new Object[]{doctor,false};
            
            ArrayList<Object[]> consulta = (ArrayList<Object[]>) getHibernateTemplate().find("select c,e,d from Citamedica c join c.estudiante as e join c.doctor as d where c.doctor = ? and c.estadoborrado = ?",paramsCita); 
            
            for(Object[] obj : consulta)
            {
                Citamedica cita = (Citamedica) obj[0];
                citas.add(cita);
            }
            return citas;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    @Override
    public ArrayList<Citamedica> getCitasByFecha(Calendar fecha) 
    {
        try
        {
            ArrayList<Citamedica> citas = new ArrayList<Citamedica>();
            Object[] paramsCita = new Object[]{fecha,false};
            
            ArrayList<Object[]> consulta = (ArrayList<Object[]>) getHibernateTemplate().find("select c,e,d from Citamedica c join c.estudiante as e join c.doctor as d where c.fechareg = ? and c.estadoborrado = ?",paramsCita); 
            
            for(Object[] obj : consulta)
            {
                Citamedica cita = (Citamedica) obj[0];
                citas.add(cita);
            }
            return citas;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    @Override
    public ArrayList<Object[]> getCitas(Doctor doctor) 
    {
        
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

    @Override
    public void addCita(Citamedica cita)
    {
        getHibernateTemplate().save(cita);
    }

    @Override
    public void deleteCita(Citamedica cita) {
        getHibernateTemplate().update(cita);
    }
     
    
}
