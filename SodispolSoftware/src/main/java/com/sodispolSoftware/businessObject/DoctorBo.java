/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject;

import com.sodispolSoftware.model.Doctor;

/**
 *
 * @author usuario
 */
public interface DoctorBo {
    public Doctor getDoctor(String username);
    public void addDoctor(Doctor doctor);
}
