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
    public Estudiante getEstudiante(String matricula);
    public void addEstudiante(Estudiante estudiante);
}
