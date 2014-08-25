package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Detallefichaestudiante generated by hbm2java
 */
public class Detallefichaestudiante  implements java.io.Serializable {


     private long iddetalleficha;
     private Citamedica citamedica;
     private Doctor doctor;
     private Fichamedicaestudiante fichamedicaestudiante;
     private double estatura;
     private double peso;
     private String examenpiel;
     private String aparatorespiratorio;
     private String apartocirculatorio;
     private String presionarterial;
     private String pulso;
     private String ruidoscardiacos;
     private String aparatodigestivo;
     private String aparatogenicourinario;
     private String sitemalinfatico;
     private String sistemanervioso;
     private Calendar fecha;
     private String observaciones;
     private String temperatura;
     private Boolean estadoborrado;
     private Set<Receta> recetas = new HashSet<Receta>(0);
     private Set<Patologiadetalleficha> patologiadetallefichas = new HashSet<Patologiadetalleficha>(0);

    public Detallefichaestudiante() {
    }

	
    public Detallefichaestudiante(Citamedica citamedica, Doctor doctor, Fichamedicaestudiante fichamedicaestudiante, double estatura, double peso, String examenpiel, String aparatorespiratorio, String apartocirculatorio, String presionarterial, String pulso, String ruidoscardiacos, String aparatodigestivo, String aparatogenicourinario, String sitemalinfatico, String sistemanervioso, String observaciones) {
        
        this.citamedica = citamedica;
        this.doctor = doctor;
        this.fichamedicaestudiante = fichamedicaestudiante;
        this.estatura = estatura;
        this.peso = peso;
        this.examenpiel = examenpiel;
        this.aparatorespiratorio = aparatorespiratorio;
        this.apartocirculatorio = apartocirculatorio;
        this.presionarterial = presionarterial;
        this.pulso = pulso;
        this.ruidoscardiacos = ruidoscardiacos;
        this.aparatodigestivo = aparatodigestivo;
        this.aparatogenicourinario = aparatogenicourinario;
        this.sitemalinfatico = sitemalinfatico;
        this.sistemanervioso = sistemanervioso;
        this.observaciones = observaciones;
    }
    public Detallefichaestudiante(Citamedica citamedica, Doctor doctor, Fichamedicaestudiante fichamedicaestudiante, double estatura, double peso, String examenpiel, String aparatorespiratorio, String apartocirculatorio, String presionarterial, String pulso, String ruidoscardiacos, String aparatodigestivo, String aparatogenicourinario, String sitemalinfatico, String sistemanervioso, Calendar fecha, String observaciones, String temperatura, Boolean estadoborrado, Set<Receta> recetas, Set<Patologiadetalleficha> patologiadetallefichas) {
       
       this.citamedica = citamedica;
       this.doctor = doctor;
       this.fichamedicaestudiante = fichamedicaestudiante;
       this.estatura = estatura;
       this.peso = peso;
       this.examenpiel = examenpiel;
       this.aparatorespiratorio = aparatorespiratorio;
       this.apartocirculatorio = apartocirculatorio;
       this.presionarterial = presionarterial;
       this.pulso = pulso;
       this.ruidoscardiacos = ruidoscardiacos;
       this.aparatodigestivo = aparatodigestivo;
       this.aparatogenicourinario = aparatogenicourinario;
       this.sitemalinfatico = sitemalinfatico;
       this.sistemanervioso = sistemanervioso;
       this.fecha = fecha;
       this.observaciones = observaciones;
       this.temperatura = temperatura;
       this.estadoborrado = estadoborrado;
       this.recetas = recetas;
       this.patologiadetallefichas = patologiadetallefichas;
    }
   
    public long getIddetalleficha() {
        return this.iddetalleficha;
    }
    
    public void setIddetalleficha(long iddetalleficha) {
        this.iddetalleficha = iddetalleficha;
    }
    public Citamedica getCitamedica() {
        return this.citamedica;
    }
    
    public void setCitamedica(Citamedica citamedica) {
        this.citamedica = citamedica;
    }
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Fichamedicaestudiante getFichamedicaestudiante() {
        return this.fichamedicaestudiante;
    }
    
    public void setFichamedicaestudiante(Fichamedicaestudiante fichamedicaestudiante) {
        this.fichamedicaestudiante = fichamedicaestudiante;
    }
    public double getEstatura() {
        return this.estatura;
    }
    
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
    public double getPeso() {
        return this.peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getExamenpiel() {
        return this.examenpiel;
    }
    
    public void setExamenpiel(String examenpiel) {
        this.examenpiel = examenpiel;
    }
    public String getAparatorespiratorio() {
        return this.aparatorespiratorio;
    }
    
    public void setAparatorespiratorio(String aparatorespiratorio) {
        this.aparatorespiratorio = aparatorespiratorio;
    }
    public String getApartocirculatorio() {
        return this.apartocirculatorio;
    }
    
    public void setApartocirculatorio(String apartocirculatorio) {
        this.apartocirculatorio = apartocirculatorio;
    }
    public String getPresionarterial() {
        return this.presionarterial;
    }
    
    public void setPresionarterial(String presionarterial) {
        this.presionarterial = presionarterial;
    }
    public String getPulso() {
        return this.pulso;
    }
    
    public void setPulso(String pulso) {
        this.pulso = pulso;
    }
    public String getRuidoscardiacos() {
        return this.ruidoscardiacos;
    }
    
    public void setRuidoscardiacos(String ruidoscardiacos) {
        this.ruidoscardiacos = ruidoscardiacos;
    }
    public String getAparatodigestivo() {
        return this.aparatodigestivo;
    }
    
    public void setAparatodigestivo(String aparatodigestivo) {
        this.aparatodigestivo = aparatodigestivo;
    }
    public String getAparatogenicourinario() {
        return this.aparatogenicourinario;
    }
    
    public void setAparatogenicourinario(String aparatogenicourinario) {
        this.aparatogenicourinario = aparatogenicourinario;
    }
    public String getSitemalinfatico() {
        return this.sitemalinfatico;
    }
    
    public void setSitemalinfatico(String sitemalinfatico) {
        this.sitemalinfatico = sitemalinfatico;
    }
    public String getSistemanervioso() {
        return this.sistemanervioso;
    }
    
    public void setSistemanervioso(String sistemanervioso) {
        this.sistemanervioso = sistemanervioso;
    }
    public Calendar getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getTemperatura() {
        return this.temperatura;
    }
    
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    public Set<Receta> getRecetas() {
        return this.recetas;
    }
    
    public void setRecetas(Set<Receta> recetas) {
        this.recetas = recetas;
    }
    public Set<Patologiadetalleficha> getPatologiadetallefichas() {
        return this.patologiadetallefichas;
    }
    
    public void setPatologiadetallefichas(Set<Patologiadetalleficha> patologiadetallefichas) {
        this.patologiadetallefichas = patologiadetallefichas;
    }




}


