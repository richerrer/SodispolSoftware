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
import java.util.Date;

/**
 *
 * @author usuario
 */
public interface DoctorBo {

    public Doctor getDoctor(String username);

    public boolean addDoctor(Doctor doctor);
    
    public boolean updateDoctor(Doctor doctor) ;

    public void saveDetalleFichaEstudiante(Detallefichaestudiante detalleFicha);

    public ArrayList<Object[]> getObservaciones(Estudiante estudiante, int firstResult, int maxResult);

    public ArrayList<Detallefichaestudiante> getDetallesFicha(Estudiante estudiante, int firstResult, int maxResult);

    public long getNumObservaciones(Estudiante estudiante);
    
    public ArrayList<Doctor> getAllDoctors() ;
    
    public boolean verifyUsername(String username);
    
    public boolean verifyTimes(Date horaEntrada,Date horaSalida);
    
    public boolean eliminarDoctor(Doctor doctor);
    
    public boolean changeStateDeleteDoctor(Doctor doctor);
}
