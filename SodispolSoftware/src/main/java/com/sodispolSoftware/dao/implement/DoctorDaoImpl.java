/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.DoctorDao;
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

    @Override
    public Doctor getDoctor(String username)
    {
        try
        {
            Object[] paramsDoctor = new Object[]{username,false};
            
            Doctor doctor = (Doctor)getHibernateTemplate().find("from Doctor d where d.username= ? and estadoborrado = ?",paramsDoctor).get(0); 
            doctor.setRoleuser((Roleuser)getHibernateTemplate().get(Roleuser.class, doctor.getRoleuser().getIdroleuser()));
            WbServiceEspol.loadDataDoctorFromWebService(doctor);
            return doctor;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
 

    @Override
    public void addDoctor(Doctor doctor) 
    {
        getHibernateTemplate().save(doctor);
    }
    
    
    
       
    //username = "r' or d.username like '%";
            //Doctor doctor = (Doctor)getHibernateTemplate().find("from Doctor d where d.username='"+username+"' and estadoborrado = False").get(0);
            
    /*
    Doctor doctor = null;
        //long a = 1;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try{
           session.beginTransaction();
           doctor =(Doctor)session.createSQLQuery("select * from getDoctorByUsername(:username)").addEntity(Doctor.class).setParameter("username", username).uniqueResult();
           //doctor =(Doctor)session.load(com.baseDatos.POJOS.Doctor.class,a);
           session.beginTransaction().commit();
       
        }
        catch(Exception ex){
            session.beginTransaction().rollback();
        }
    */

    @Override
    public List<Doctor> getAllDoctors() {
        try
        {
            //Object[] paramsDoctor = new Object[]{username,false};
            
            List<Doctor> doctores = getHibernateTemplate().loadAll(Doctor.class);
            //Doctor doctor = (Doctor)getHibernateTemplate().find("from Doctor d where d.username= ? and estadoborrado = ?",paramsDoctor).get(0); 
            //doctor.setRoleuser((Roleuser)getHibernateTemplate().get(Roleuser.class, doctor.getRoleuser().getIdroleuser()));
            for(Doctor doc : doctores)
            {
                WbServiceEspol.loadDataDoctorFromWebService(doc);
            }
            //WbServiceEspol.loadDataDoctorFromWebService(doctor);
            return doctores;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
}
