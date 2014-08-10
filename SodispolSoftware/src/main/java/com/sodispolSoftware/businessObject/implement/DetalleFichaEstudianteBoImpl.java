/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.DetalleFichaEstudianteBo;
import com.sodispolSoftware.dao.DetalleFichaEstudianteDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import java.util.ArrayList;
import java.util.Calendar;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Ricardo
 */
@Named
@Scope("prototype")
public class DetalleFichaEstudianteBoImpl implements DetalleFichaEstudianteBo{

    @Inject
    private DetalleFichaEstudianteDao detalleFichaEstudianteDao;
    
    @Override
    public void addDetalleFicha(Detallefichaestudiante detalleFicha) {
        getDetalleFichaEstudianteDao().addDetalleFicha(detalleFicha);
    }
    
    @Override
    public ArrayList<Object[]> getObservaciones(Estudiante estudiante,int firstResult,int maxResult) {
        ArrayList<Object[]> observaciones = getDetalleFichaEstudianteDao().getObservaciones(estudiante,firstResult,maxResult);
        for (Object[] object : observaciones) {
            object[0] = ((Calendar)object[0]).get(Calendar.DAY_OF_MONTH) + "/" +(((Calendar)object[0]).get(Calendar.MONTH)+1)+ "/" +((Calendar)object[0]).get(Calendar.YEAR) ;       
        }
        return observaciones;
    }
    
    @Override
    public ArrayList<Detallefichaestudiante> getDetallesFicha(Estudiante estudiante, int firstResult, int maxResult) {
        return getDetalleFichaEstudianteDao().getDetallesFicha(estudiante, firstResult, maxResult);
    }
   
    
    @Override
    public long getNumObservaciones(Estudiante estudiante) {
        return getDetalleFichaEstudianteDao().getNumObservaciones(estudiante);
    }

    @Override
    public Detallefichaestudiante getDetalleFichaEstudiante(long idDetalle,Estudiante estudiante) {
        return  getDetalleFichaEstudianteDao().getDetalleFichaEstudiante(idDetalle,estudiante);
    }

    
    /**
     * Get the value of detalleFichaEstudianteDao
     *
     * @return the value of detalleFichaEstudianteDao
     */
    public DetalleFichaEstudianteDao getDetalleFichaEstudianteDao() {
        return detalleFichaEstudianteDao;
    }

    /**
     * Set the value of detalleFichaEstudianteDao
     *
     * @param detalleFichaEstudianteDao new value of detalleFichaEstudianteDao
     */
    public void setDetalleFichaEstudianteDao(DetalleFichaEstudianteDao detalleFichaEstudianteDao) {
        this.detalleFichaEstudianteDao = detalleFichaEstudianteDao;
    }

    
    
}
