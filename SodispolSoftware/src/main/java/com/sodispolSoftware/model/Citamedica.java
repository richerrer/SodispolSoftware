package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Citamedica generated by hbm2java
 */
public class Citamedica  implements java.io.Serializable {


     private long idcita;
     private Estudiante estudiante;
     private Doctor doctor;
     private Calendar fechareg;
     private Calendar fechaprog;
     private String estadocita;
     private Boolean estadoborrado;
     private Set<Detallefichaestudiante> detallefichaestudiantes = new HashSet<Detallefichaestudiante>(0);

    public Citamedica() {
    }

    public Citamedica(Estudiante estudiante, Doctor doctor, Calendar fechareg, Calendar fechaprog) {
        this.idcita = idcita;
        this.estudiante = estudiante;
        this.doctor = doctor;
        this.fechareg = fechareg;
        this.fechaprog = fechaprog;
    }
	
    public Citamedica(long idcita, Estudiante estudiante, Doctor doctor, Calendar fechareg, Calendar fechaprog) {
        this.idcita = idcita;
        this.estudiante = estudiante;
        this.doctor = doctor;
        this.fechareg = fechareg;
        this.fechaprog = fechaprog;
    }
    
    public Citamedica(Estudiante estudiante, Doctor doctor, Calendar fechareg, Calendar fechaprog, String estadocita, Boolean estadoborrado) {
       //this.idcita = idcita;
       this.estudiante = estudiante;
       this.doctor = doctor;
       this.fechareg = fechareg;
       this.fechaprog = fechaprog;
       this.estadocita = estadocita;
       this.estadoborrado = estadoborrado;
    }
    
    public Citamedica(/*long idcita, */Estudiante estudiante, Doctor doctor, Calendar fechareg, Calendar fechaprog, String estadocita, Boolean estadoborrado, Set<Detallefichaestudiante> detallefichaestudiantes) {
       //this.idcita = idcita;
       this.estudiante = estudiante;
       this.doctor = doctor;
       this.fechareg = fechareg;
       this.fechaprog = fechaprog;
       this.estadocita = estadocita;
       this.estadoborrado = estadoborrado;
       this.detallefichaestudiantes = detallefichaestudiantes;
    }
   
    public long getIdcita() {
        return this.idcita;
    }
    
    public void setIdcita(long idcita) {
        this.idcita = idcita;
    }
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Calendar getFechareg() {
        return this.fechareg;
    }
    
    public void setFechareg(Calendar fechareg) {
        this.fechareg = fechareg;
    }
    public Calendar getFechaprog() {
        return this.fechaprog;
    }
    
    public void setFechaprog(Calendar fechaprog) {
        this.fechaprog = fechaprog;
    }
    public String getEstadocita() {
        return this.estadocita;
    }
    
    public void setEstadocita(String estadocita) {
        this.estadocita = estadocita;
    }
    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    public Set<Detallefichaestudiante> getDetallefichaestudiantes() {
        return this.detallefichaestudiantes;
    }
    
    public void setDetallefichaestudiantes(Set<Detallefichaestudiante> detallefichaestudiantes) {
        this.detallefichaestudiantes = detallefichaestudiantes;
    }




}


