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
 * @author Ricardo
 */
public interface FichaMedicaEstudianteBo {
    public Fichamedicaestudiante getFicha(Estudiante estudiante);
    public void addFicha(Fichamedicaestudiante ficha);
    public void updateFicha(Fichamedicaestudiante ficha);
}
