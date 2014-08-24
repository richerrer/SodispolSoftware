/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Doctor;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface DoctorDao {

    public Doctor getDoctor(String username);

    public boolean addDoctor(Doctor doctor);

    public ArrayList<Doctor> getAllDoctors();

    public boolean updateDoctor(Doctor doctor);
}
