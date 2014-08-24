/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.DoctorDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class DoctorDaoImpl extends HibernateDaoSupport implements DoctorDao{

    private final String queryObtenerDoctorAndRoleUser = "from Doctor d left join fetch d.roleuser where d.username= ? and d.estadoborrado = ?";

    private final String queryGetAllDoctors = "from Doctor d left join fetch d.roleuser where d.estadoborrado = ?";
    
    @Override
    public Doctor getDoctor(String username)
    {
        try
        {
            Object[] paramsDoctor = new Object[]{username,false};
            
            Doctor doctor = (Doctor)getHibernateTemplate().find(queryObtenerDoctorAndRoleUser,paramsDoctor).get(0); 
            WbServiceEspol.loadDataDoctorFromWebService(doctor);
            return doctor;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    @Override
    public boolean addDoctor(Doctor doctor) 
    {
        boolean succes = true;
        try{
            getHibernateTemplate().save(doctor);
        }catch(Exception ex){succes = false;}
        return succes;
    }
    
    @Override
    public boolean updateDoctor(Doctor doctor) 
    {
        boolean succes = true;
        try{
            getHibernateTemplate().update(doctor);
        }catch(Exception ex){succes = false;}
        return succes;
    }
    
    @Override
    public ArrayList<Doctor> getAllDoctors() 
    {       
        /*ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try{
           session.beginTransaction();
           Query query = session.createQuery("select d from Doctor d where d.estadoborrado = :estado order by 1 desc");
           query.setParameter("estado",false);
           ArrayList<Object> consulta = (ArrayList<Object>) query.list();
           for(Object array: consulta)
           {
                Doctor d = (Doctor)array;
                if(d.getNombre1()==null)
                {
                    WbServiceEspol.loadDataDoctorFromWebService(d);
                }
                doctores.add(d);
            }
           session.beginTransaction().commit();
           session.close();
           return doctores;
        }
        catch(Exception ex){
            return null;
        }*/
        try
        {
            Object[] paramsDoctor = new Object[]{false};
            
            ArrayList<Doctor> doctors = (ArrayList<Doctor>)getHibernateTemplate().find(queryGetAllDoctors,paramsDoctor); 
            for(Doctor doctor: doctors)    
                WbServiceEspol.loadDataDoctorFromWebService(doctor);
            return doctors;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
       
    }
    
}
