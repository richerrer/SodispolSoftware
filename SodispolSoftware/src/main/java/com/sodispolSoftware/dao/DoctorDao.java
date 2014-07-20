/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Doctor;

/**
 *
 * @author usuario
 */
public interface DoctorDao {
    public Doctor getDoctor(String username);
    public void addDoctor(Doctor doctor);
}
