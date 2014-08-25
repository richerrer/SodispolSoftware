/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Categoriamedicinamedicina;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Medicina;
import com.sodispolSoftware.model.Medicinaepecifica;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface MedicinaDao {
 
   public Categoriamedicina getCategoria(Long medicinaId);
   
   public ArrayList<Medicina> getListaDeMedicinas();
   
   public ArrayList<Categoriamedicina> getListaDeCategorias();

   public void addMedicina(Medicina medicina);

    public void addRelacionMedicinaCategoria(Categoriamedicinamedicina cm);

    public void addCategoria(Categoriamedicina c);

    public void updateMedicina(Medicina med);
    
    public Categoriamedicina obtenerPorNombre(String categoria);

    public void addMedicinaEspecifica(Medicinaepecifica me);
}
