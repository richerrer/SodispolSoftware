/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.validator;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.model.Doctor;
import javax.inject.Inject;
import javax.inject.Named;


public class Checker {
    
    /*@Inject
    private DoctorBo doctorBo;
    
    @Inject
    private RoleUserBo roleUserBo;

    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    public void setRoleUserBo(RoleUserBo roleUserBo) {
        this.roleUserBo = roleUserBo;
    }
    
    
    public Doctor verifdyDoctorByUsername(String username){
        Doctor doctor = doctorBo.getDoctor(username);
        
        if(doctor==null){
            String autority = "ROLE_DOCTOR";
            doctor = new Doctor(username,roleUserBo.getRoleUser(autority),false);
            doctorBo.addDoctor(doctor);
            doctor = doctorBo.getDoctor(username);
        }
        return doctor;
    }*/
}
