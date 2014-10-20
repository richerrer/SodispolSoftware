/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.DoctorDao;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Patologia;
import com.sodispolSoftware.model.Patologiadetalleficha;
import com.sodispolSoftware.model.Roleuser;
import com.sodispolSoftware.webServiceEspol.WebServiceEspol;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class DoctorDaoImpl extends HibernateDaoSupport implements DoctorDao{

    @Inject
    private WebServiceEspol webService;
    
    private final String queryObtenerDoctorAndRoleUser = "from Doctor d left join fetch d.roleuser where d.username= ? and d.estadoborrado = ?";

    private final String queryGetAllDoctors = "from Doctor d left join fetch d.roleuser where d.estadoborrado = ?";
    
    @Override
    public Doctor getDoctor(String username)
    {
        try
        {
            Object[] paramsDoctor = new Object[]{username,false};
            
            Doctor doctor = (Doctor)getHibernateTemplate().find(queryObtenerDoctorAndRoleUser,paramsDoctor).get(0); 
            webService.loadDataDoctorFromWebService(doctor);
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
    public boolean changeStateDeleteDoctor(Doctor doctor) 
    {
        boolean succes = false;
        
        try
        {
            Object[] paramsDoctor = new Object[]{doctor.getUsername(),true};
            
            Doctor doctorBase = (Doctor)getHibernateTemplate().find(queryObtenerDoctorAndRoleUser,paramsDoctor).get(0); 
            if(doctorBase!=null){
                doctorBase.setHoraentrada(doctor.getHoraentrada());
                doctorBase.setHorasalida(doctor.getHorasalida());
                doctorBase.setEstadoborrado(false);
                getHibernateTemplate().update(doctorBase);
               succes = true;
            }
        }catch(Exception ex){succes = false;}
        return succes;
    }
    
    @Override
    public ArrayList<Doctor> getAllDoctors() 
    {       
        try
        {
            Object[] paramsDoctor = new Object[]{false};
            
            ArrayList<Doctor> doctors = (ArrayList<Doctor>)getHibernateTemplate().find(queryGetAllDoctors,paramsDoctor); 
            for(Doctor doctor: doctors)    
                webService.loadDataDoctorFromWebService(doctor);
            return doctors;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
       
    }
    
     public WebServiceEspol getWebService() {
        return webService;
    }

    public void setWebService(WebServiceEspol webService) {
        this.webService = webService;
    }

    @Override
    public Patologia obtenerPorNombre(String patologia) {
         try{
            Object[] paramsPatologia = new Object[]{patologia,false};
            Patologia pat = (Patologia)getHibernateTemplate().find("from Patologia c where c.nombre= ? and estadoborrado = ?",paramsPatologia).get(0); 
            return pat;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }  
    }

    @Override
    public void addRelacionFichaPatologia(Patologiadetalleficha pd) {
          getHibernateTemplate().save(pd);
    }
    
}
