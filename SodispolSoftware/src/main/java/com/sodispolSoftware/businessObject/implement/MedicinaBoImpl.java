/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.dao.MedicinaDao;
import com.sodispolSoftware.model.Medicina;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Usuario
 */
@Named
@Scope("prototype")
public class MedicinaBoImpl implements MedicinaBo {

    @Inject
    private MedicinaDao medicinaDao;

    public MedicinaDao getMedicinaDao() {
        return medicinaDao;
    }

    public void setMedicinaDao(MedicinaDao medicinaDao) {
        this.medicinaDao = medicinaDao;
    }

    
    @Override
    public ArrayList<Medicina> obtenerListaDeMedicinas() { 
        ArrayList<Medicina> medicinas = getMedicinaDao().getListaDeMedicinas();
        return medicinas;
    }

    
    
}
