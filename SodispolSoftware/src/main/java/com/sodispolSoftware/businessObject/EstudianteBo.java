/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject;

import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;

/**
 *
 * @author usuario
 */
public interface EstudianteBo {
    public Estudiante getEstudianteByMatricula(String matricula);
    public Estudiante getEstudianteByCedula(String cedula);
    public Fichamedicaestudiante getFichaMedica(Estudiante estudiante);
    public void addEstudiante(Estudiante estudiante);
    public void updateEstudiante(Estudiante estudiante);
    public void addFichaMedica(Estudiante estudiante,Fichamedicaestudiante ficha);
    public void updateFichaMedica(Estudiante estudiante,Fichamedicaestudiante ficha);
}
