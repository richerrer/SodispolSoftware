package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.Calendar;
import java.util.Date;

/**
 * Detalleabastecimiento generated by hbm2java
 */
public class Detalleabastecimiento  implements java.io.Serializable {


     private long idabastecimiento;
     private Medicina medicina;
     private Enfermero enfermero;
     private Doctor doctor;
     private Calendar fechaabastecimiento;
     private Integer cajasantesabastecimiento;
     private Integer cajasdespuesabastecimiento;
     private Integer cajastotales;
     private Boolean estadoborrado;

    public Detalleabastecimiento() {
    }

	
    public Detalleabastecimiento(long idabastecimiento, Medicina medicina, Enfermero enfermero, Doctor doctor) {
        this.idabastecimiento = idabastecimiento;
        this.medicina = medicina;
        this.enfermero = enfermero;
        this.doctor = doctor;
    }
    public Detalleabastecimiento(long idabastecimiento, Medicina medicina, Enfermero enfermero, Doctor doctor, Calendar fechaabastecimiento, Integer cajasantesabastecimiento, Integer cajasdespuesabastecimiento, Integer cajastotales, Boolean estadoborrado) {
       this.idabastecimiento = idabastecimiento;
       this.medicina = medicina;
       this.enfermero = enfermero;
       this.doctor = doctor;
       this.fechaabastecimiento = fechaabastecimiento;
       this.cajasantesabastecimiento = cajasantesabastecimiento;
       this.cajasdespuesabastecimiento = cajasdespuesabastecimiento;
       this.cajastotales = cajastotales;
       this.estadoborrado = estadoborrado;
    }
   
    public long getIdabastecimiento() {
        return this.idabastecimiento;
    }
    
    public void setIdabastecimiento(long idabastecimiento) {
        this.idabastecimiento = idabastecimiento;
    }
    public Medicina getMedicina() {
        return this.medicina;
    }
    
    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }
    public Enfermero getEnfermero() {
        return this.enfermero;
    }
    
    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Calendar getFechaabastecimiento() {
        return this.fechaabastecimiento;
    }
    
    public void setFechaabastecimiento(Calendar fechaabastecimiento) {
        this.fechaabastecimiento = fechaabastecimiento;
    }
    public Integer getCajasantesabastecimiento() {
        return this.cajasantesabastecimiento;
    }
    
    public void setCajasantesabastecimiento(Integer cajasantesabastecimiento) {
        this.cajasantesabastecimiento = cajasantesabastecimiento;
    }
    public Integer getCajasdespuesabastecimiento() {
        return this.cajasdespuesabastecimiento;
    }
    
    public void setCajasdespuesabastecimiento(Integer cajasdespuesabastecimiento) {
        this.cajasdespuesabastecimiento = cajasdespuesabastecimiento;
    }
    public Integer getCajastotales() {
        return this.cajastotales;
    }
    
    public void setCajastotales(Integer cajastotales) {
        this.cajastotales = cajastotales;
    }
    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }

}


