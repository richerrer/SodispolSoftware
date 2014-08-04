/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.DetalleFichaEstudianteBo;
import com.sodispolSoftware.dao.DetalleFichaEstudianteDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
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
