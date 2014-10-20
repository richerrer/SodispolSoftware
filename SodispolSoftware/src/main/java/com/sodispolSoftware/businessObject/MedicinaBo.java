/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject;

import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Categoriamedicinamedicina;
import com.sodispolSoftware.model.Medicina;
import com.sodispolSoftware.model.Medicinaepecifica;
import com.sodispolSoftware.model.Patologia;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface MedicinaBo {

    
    public Categoriamedicina obtenerCategoria(Long medicinaId);
    
    public ArrayList<Medicina> obtenerListaDeMedicinas();
    
    public ArrayList<Categoriamedicina> obtenerListaDeCategorias();
    
    public void agregarMedicina(Medicina medicina);

    public void agregarRelacionMedicinaCategoria(Categoriamedicinamedicina cm);

    public void agregarCategoria(Categoriamedicina c);

    public void updateMedicina(Medicina med);
    
    public Categoriamedicina obtenerCategoria(String categoria);

    public void agregarMedicinaEspecifica(Medicinaepecifica me);

    public void eliminarMedicinasEspecificas(Medicina med);

    public void eliminarRelacionCategoriaMedicina(Medicina med);

    public void restarMedicinasEspecificas(Medicina med);

    public ArrayList<Patologia> obtenerListaDePatologias();

    public int obtenerCasosDePatologia(Patologia p);
    
   
}
