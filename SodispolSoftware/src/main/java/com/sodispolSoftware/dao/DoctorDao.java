/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface DoctorDao {
    public Doctor getDoctor(String username);
    public void addDoctor(Doctor doctor);
    public ArrayList<Doctor> getAllDoctors() ;
}
