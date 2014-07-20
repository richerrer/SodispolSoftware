/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author usuario
 */
@Named
//@Scope("session")
@SessionScoped
public class UsuarioBean{

    private Doctor doctor;
    private Estudiante estudiante;
    
    public UsuarioBean() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    private void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    private void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    

    public void setUser(Object object){
        if(object instanceof Doctor){
            setDoctor((Doctor)object);
            setEstudiante(null);
        }
        if(object instanceof Estudiante){
            setEstudiante((Estudiante)object);
            setDoctor(null);
        }
    }
    
    
}
