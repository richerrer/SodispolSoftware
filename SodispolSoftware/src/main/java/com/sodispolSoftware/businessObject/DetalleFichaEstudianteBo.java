/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject;

import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public interface DetalleFichaEstudianteBo {
    public void addDetalleFicha(Detallefichaestudiante detalleFicha);
    public ArrayList<Object[]> getObservaciones(Estudiante estudiante,int firstResult,int maxResult);
    public long getNumObservaciones(Estudiante estudiante);
}
