/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject;

import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author usuario
 */
public interface CitaBo {
    public ArrayList<Object[]> getCitas(Doctor doctor);
    public void updateCita(Citamedica cita);
    public int getncitas();
    public void addCita(Citamedica cita);
    public ArrayList<Citamedica> getAllCitas();
    public ArrayList<Citamedica> getCitasByFecha(Calendar fecha);
    public void deleteCita(Citamedica cita);
    public ArrayList<Citamedica> getCitasByDoctor(Doctor doctor);
}
