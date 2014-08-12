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
    public ArrayList<Doctor> getAllDoctors() 
    {       
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try{
           session.beginTransaction();
           Query query = session.createQuery("select d from Doctor d where d.estadoborrado = :estado order by 1 desc");
           query.setParameter("estado",false);
           ArrayList<Object> consulta = (ArrayList<Object>) query.list();
           //doctores =(ArrayList<Doctor>)query.list();
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
        }
       
    }
    @Override
    public int pruebaDoctor()
    {
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try{
           session.beginTransaction();
           Query query = session.createQuery("select d from Doctor d where d.estadoborrado = :estado order by 1 desc");
           //Query query = session.createQuery("select r from Restaurante r innerjoin r.menus m where m.idMenu=1 ");
           //query.setMaxResults(tamano_total);
           //query.setFirstResult(tamano_total * (pagina-1));
           query.setParameter("estado",false);
           ArrayList<Object[]> consulta = (ArrayList<Object[]>) query.list();
           //doctores =(ArrayList<Doctor>)query.list();
           for(Object[] array: consulta){
                Doctor d = (Doctor)array[0];
                if(d.getNombre1()==null)
                {
                    WbServiceEspol.loadDataDoctorFromWebService(d);
                }
                doctores.add(d);
            }
           session.beginTransaction().commit();
           session.close();
           return doctores.size();
        }
        catch(Exception ex){
            return -1;
        }
    }
    
}
