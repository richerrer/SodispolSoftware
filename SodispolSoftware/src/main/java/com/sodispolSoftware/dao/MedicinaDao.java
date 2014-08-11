/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Medicina;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface MedicinaDao {
 
   public Categoriamedicina getCategoria(Long medicinaId);
   
   public ArrayList<Object[]> getListaDeMedicinas();
   
   public ArrayList<Object[]> getListaDeCategorias();

   public void addMedicina(Medicina medicina);
    
}
