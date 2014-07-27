package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Este bean mantiene que usuario se encuentra registrado en la aplicación.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@SessionScoped
public class UsuarioBean{

    private Doctor doctor;
    
    private Estudiante estudiante;
    
  
    /**
     * Get the value of estudiante
     *
     * @return the value of estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Set the value of estudiante
     *
     * @param estudiante new value of estudiante
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Get the value of doctor
     *
     * @return the value of doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Set the value of doctor
     *
     * @param doctor new value of doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Setea el Usuario que se encuentra registrado en la aplicación.
     *
     * @param object objecto que puede ser el Doctor,Profesional o Estudiante
     */
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
