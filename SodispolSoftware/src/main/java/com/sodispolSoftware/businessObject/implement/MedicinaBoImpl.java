/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.dao.MedicinaDao;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Categoriamedicinamedicina;
import com.sodispolSoftware.model.Medicina;
import com.sodispolSoftware.model.Medicinaepecifica;
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
        return getMedicinaDao().getListaDeMedicinas();
    }

    @Override
    public Categoriamedicina obtenerCategoria(Long medicinaId) {
        return getMedicinaDao().getCategoria(medicinaId);
    }

    @Override
    public ArrayList<Categoriamedicina> obtenerListaDeCategorias() {
        return getMedicinaDao().getListaDeCategorias();
    }

    @Override
    public void agregarMedicina(Medicina medicina) {
       getMedicinaDao().addMedicina(medicina);
    }

    @Override
    public void agregarRelacionMedicinaCategoria(Categoriamedicinamedicina cm) {
        getMedicinaDao().addRelacionMedicinaCategoria(cm);
    }

    @Override
    public void agregarCategoria(Categoriamedicina c) {
        getMedicinaDao().addCategoria(c);
    }

    @Override
    public void updateMedicina(Medicina med) {
        getMedicinaDao().updateMedicina(med);
    }

    @Override
    public Categoriamedicina obtenerCategoria(String categoria) {
        return getMedicinaDao().obtenerPorNombre(categoria); 
    }

    @Override
    public void agregarMedicinaEspecifica(Medicinaepecifica me) {
        getMedicinaDao().addMedicinaEspecifica(me);
    }

    
    
}
