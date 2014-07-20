/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.DoctorDao;
import com.sodispolSoftware.model.Doctor;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DoctorBoImpl implements DoctorBo{
    @Inject 
    private DoctorDao doctorDao;
    
    @Inject
    private RoleUserBo roleUserBo;

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }
    
    public void setRoleUserBo(RoleUserBo roleUserBo) {
        this.roleUserBo = roleUserBo;
    }

    @Override
    public Doctor getDoctor(String username) {
        Doctor doctor = doctorDao.getDoctor(username);
        
        if(doctor==null){
            String autority = "ROLE_DOCTOR";
            doctor = new Doctor(username,roleUserBo.getRoleUser(autority),false);
            this.addDoctor(doctor);
            doctor = doctorDao.getDoctor(username);
        }
        return doctor;
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }
    
}
