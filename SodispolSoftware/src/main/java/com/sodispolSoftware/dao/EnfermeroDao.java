/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao;

import com.sodispolSoftware.model.Enfermero;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface EnfermeroDao {
    
    public Enfermero getEnfermero(String username);
    
    public boolean addEnfermero(Enfermero enfermero);
    
    public boolean updateEnfermero(Enfermero enfermero);
    
    public boolean changeStateDeleteEnfermero(Enfermero enfermero);
    
    public ArrayList<Enfermero> getAllEnfermeros() ;
}
