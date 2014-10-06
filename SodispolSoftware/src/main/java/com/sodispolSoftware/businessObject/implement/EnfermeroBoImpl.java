/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.EnfermeroBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.EnfermeroDao;
import com.sodispolSoftware.model.Enfermero;
import com.sodispolSoftware.webServiceEspol.WebServiceEspol;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author usuario
 */
@Named
@Scope("session")//,proxyMode = ScopedProxyMode.TARGET_CLASS
public class EnfermeroBoImpl implements EnfermeroBo {

    @Inject
    private EnfermeroDao enfermeroDao;

    @Inject
    private RoleUserBo roleUserBo;
    
    @Inject
    private WebServiceEspol webService;

    
    public WebServiceEspol getWebService() {
        return webService;
    }

    public void setWebService(WebServiceEspol webService) {
        this.webService = webService;
    }

    @Override
    public Enfermero getEnfermero(String username) {
        return getEnfermeroDao().getEnfermero(username);
    }

    @Override
    public boolean addEnfermero(Enfermero enfermero) {
        enfermero.setRoleuser(getRoleUserBo().getRoleUser("ROLE_ENFERMERO"));
        return getEnfermeroDao().addEnfermero(enfermero);
    }

    @Override
    public boolean updateEnfermero(Enfermero enfermero) {
        return getEnfermeroDao().updateEnfermero(enfermero);
    }

    @Override
    public boolean eliminarEnfermero(Enfermero enfermero) {
        enfermero.setEstadoborrado(true);
        return getEnfermeroDao().updateEnfermero(enfermero);
    }
    
    @Override
    public boolean changeStateDeleteEnfermero(Enfermero enfermero) {
        return getEnfermeroDao().changeStateDeleteEnfermero(enfermero);
    }

    @Override
    public ArrayList<Enfermero> getAllEnfermeros() {
        ArrayList<Enfermero> enfermeros =getEnfermeroDao().getAllEnfermeros();
        return enfermeros;
    }
    
    @Override
    public boolean verifyUsername(String username){
        String role = webService.getRoleByUsername(username);
        return role!=null && role.equals("P");
    }
    

    public EnfermeroDao getEnfermeroDao() {
        return enfermeroDao;
    }

    public void setEnfermeroDao(EnfermeroDao enfermeroDao) {
        this.enfermeroDao = enfermeroDao;
    }

    public RoleUserBo getRoleUserBo() {
        return roleUserBo;
    }

    public void setRoleUserBo(RoleUserBo roleUserBo) {
        this.roleUserBo = roleUserBo;
    }

}
