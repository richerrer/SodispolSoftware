/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.EnfermeroDao;
import com.sodispolSoftware.model.Enfermero;
import com.sodispolSoftware.webServiceEspol.WebServiceEspol;
import java.util.ArrayList;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class EnfermeroDaoImpl extends HibernateDaoSupport implements EnfermeroDao{
    
    @Inject
    private WebServiceEspol webService;
    
    private final String queryObtenerEnfermeroAndRoleUser = "from Enfermero e left join fetch e.roleuser where e.username= ? and e.estadoborrado = ?";

    private final String queryGetAllEnfermeros = "from Enfermero e left join fetch e.roleuser where e.estadoborrado = ?";
    
    @Override
    public Enfermero getEnfermero(String username)
    {
        try
        {
            Object[] paramsEnfermero = new Object[]{username,false};
            
            Enfermero enfermero = (Enfermero)getHibernateTemplate().find(queryObtenerEnfermeroAndRoleUser,paramsEnfermero).get(0); 
            webService.loadDataEnfermeroFromWebService(enfermero);
            return enfermero;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    @Override
    public boolean addEnfermero(Enfermero enfermero) 
    {
        boolean succes = true;
        try{
            getHibernateTemplate().save(enfermero);
        }catch(Exception ex){succes = false;}
        return succes;
    }
    
    @Override
    public boolean updateEnfermero(Enfermero enfermero) 
    {
        boolean succes = true;
        try{
            getHibernateTemplate().update(enfermero);
        }catch(Exception ex){succes = false;}
        return succes;
    }
    
    @Override
    public boolean changeStateDeleteEnfermero(Enfermero enfermero) 
    {
        boolean succes = false;
        
        try
        {
            Object[] paramsEnfermero = new Object[]{enfermero.getUsername(),true};
            
            Enfermero enfermeroBase = (Enfermero)getHibernateTemplate().find(queryObtenerEnfermeroAndRoleUser,paramsEnfermero).get(0); 
            if(enfermeroBase!=null){
                enfermeroBase.setEstadoborrado(false);
                getHibernateTemplate().update(enfermeroBase);
               succes = true;
            }
        }catch(Exception ex){succes = false;}
        return succes;
    }
    
    @Override
    public ArrayList<Enfermero> getAllEnfermeros() 
    {   
        try
        {
            Object[] paramsEnfermero = new Object[]{false};
            
            ArrayList<Enfermero> enfermeros = (ArrayList<Enfermero>)getHibernateTemplate().find(queryGetAllEnfermeros,paramsEnfermero); 
            for(Enfermero enfermero: enfermeros)    
                webService.loadDataEnfermeroFromWebService(enfermero);
            return enfermeros;
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
}
