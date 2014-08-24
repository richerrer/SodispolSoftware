package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Enfermero;
import com.sodispolSoftware.model.Estudiante;
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
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)//proxyMode = ScopedProxyMode.TARGET_CLASS se lo utiliza para poder inyectar este bean en MyUserDetails ver http://www.agile-works.com/blog/?p=254
public class UsuarioBean{

    private Doctor doctor;
    
    private Estudiante estudiante;
    
    private Enfermero enfermero;
   
    private Estudiante estudiantePaciente;
    
    private Doctor doctorConsulta;
    
    private String msgCreacionYEliminacion;

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

    public String getMsgCreacionYEliminacion() {
        return msgCreacionYEliminacion;
    }

    public void setMsgCreacionYEliminacion(String msgCreacionYEliminacion) {
        this.msgCreacionYEliminacion = msgCreacionYEliminacion;
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
    }
    
    
}
