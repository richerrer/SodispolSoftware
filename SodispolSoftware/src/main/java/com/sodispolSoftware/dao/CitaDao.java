/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface CitaDao {
    public ArrayList<Object[]> getCitas(Doctor doctor);
}
