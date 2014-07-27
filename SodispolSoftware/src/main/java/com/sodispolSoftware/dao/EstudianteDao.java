/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Estudiante;

/**
 *
 * @author usuario
 */
public interface EstudianteDao {
    public Estudiante getEstudianteByMatricula(String matricula,Object[] attributes);
    public Estudiante getEstudianteByCedula(String matricula,Object[] attributes);
    public void addEstudiante(Estudiante estudiante);
    public void updateEstudiante(Estudiante estudiante);
}
