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
            loadDataFromWebService(doctor);
            return doctor;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
 

    @Override
    public void addDoctor(Doctor doctor) 
    {
        getHibernateTemplate().save(doctor);
    }
    
    public void loadDataFromWebService(Doctor doctor)
    {
        Object[] attributes = WbServiceEspol.loadDoctorAttributes(doctor.getUsername());
        doctor.setNombre1((String)attributes[0]);
        doctor.setNombre2((String)attributes[1]);
        doctor.setApellido1((String)attributes[2]);
        doctor.setApellido2((String)attributes[3]);
        doctor.setCorreo((String)attributes[4]);
        doctor.setEspecializacion((String)attributes[5]);
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
    
}
