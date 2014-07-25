/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.myuserdetail;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.manageBeans.UsuarioBean;
import com.sodispolSoftware.model.Doctor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.sodispolSoftware.validator.Checker;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import javax.inject.Inject;


public class MyUserService implements UserDetailsService {
    
    @Inject
    private DoctorBo doctorBo;
    
    @Inject
    private UsuarioBean usuarioBean;
    
    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        String roleUser = WbServiceEspol.getRoleByUsername(username);
        boolean state = WbServiceEspol.getStateByUsername(username);
        
        if(roleUser.equals("P")&& state )//Si es un profesional
        {    
            Doctor doctor = doctorBo.getDoctor(username);
            if(doctor != null)        //Si es un doctor
            {
                usuarioBean.setUser(doctor);
                return new MyUserDetails(username,doctor);
            }
            else            //Si es un paciente profesional
            {
            }
            
        }
        if(roleUser.equals("E")&& state ){}
  
        return null;
    }
}
