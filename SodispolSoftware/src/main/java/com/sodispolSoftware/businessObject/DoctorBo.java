/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.businessObject;

import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface DoctorBo {

    public Doctor getDoctor(String username);

    public void addDoctor(Doctor doctor);

    public void saveDetalleFichaEstudiante(Detallefichaestudiante detalleFicha);

    public ArrayList<Object[]> getObservaciones(Estudiante estudiante, int firstResult, int maxResult);

    public ArrayList<Detallefichaestudiante> getDetallesFicha(Estudiante estudiante, int firstResult, int maxResult);

    public long getNumObservaciones(Estudiante estudiante);
    
    public List<Doctor> getAllDoctors();
}
