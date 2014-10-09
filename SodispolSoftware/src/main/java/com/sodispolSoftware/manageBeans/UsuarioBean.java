package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Enfermero;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
/**
 * Este bean mantiene que usuario se encuentra registrado en la aplicación.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope(value = "session")//proxyMode = ScopedProxyMode.TARGET_CLASS se lo utiliza cuando un singleton tiene referencia a un objeto session o prototype etc.. ver http://www.agile-works.com/blog/?p=254
public class UsuarioBean{

    private Doctor doctor;
    
    private User usuario;
    
    private Estudiante estudiante;
    
    private Enfermero enfermero;
   
    private Estudiante estudiantePaciente;
    
    private Doctor doctorConsulta;
    
    private int tipoPaginaConsultaCitas=0;//0->consulta de citas del doctor logueado; 1->consulta de citas luego de una transaccion

    private Citamedica citaActual;
    
    /**
     * Get the value of estudiantePaciente
     *
     * @return the value of estudiantePaciente
     */
    public Estudiante getEstudiantePaciente() {
        return estudiantePaciente;
    }

    /**
     * Set the value of estudiantePaciente
     *
     * @param estudiantePaciente new value of estudiantePaciente
     */
    public void setEstudiantePaciente(Estudiante estudiantePaciente) {
        this.estudiantePaciente = estudiantePaciente;
    }

    
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
    private void setEstudiante(Estudiante estudiante) {
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
    private void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Enfermero getEnfermero() {
        return enfermero;
    }

    private void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }

    public Doctor getDoctorConsulta() {
        return doctorConsulta;
    }

    public void setDoctorConsulta(Doctor doctorConsulta) {
        this.doctorConsulta = doctorConsulta;
    }

    public int getTipoPaginaConsultaCitas() {
        return tipoPaginaConsultaCitas;
    }

    public void setTipoPaginaConsultaCitas(int tipoPaginaConsultaCitas) {
        this.tipoPaginaConsultaCitas = tipoPaginaConsultaCitas;
    }
    
    public Citamedica getCitaActual() {
        return citaActual;
    }

    public void setCitaActual(Citamedica citaActual) {
        this.citaActual = citaActual;
    }

    public User getUser(){
        return this.usuario;
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
            setEnfermero(null);
        }
        if(object instanceof Enfermero){
            setEnfermero((Enfermero)object);
            setEstudiante(null);
            setDoctor(null);
        }
        if(object instanceof Estudiante){
            setEstudiante((Estudiante)object);
            setDoctor(null);
            setEnfermero(null);
        }
        this.usuario = (User)object;
    }
    
}
