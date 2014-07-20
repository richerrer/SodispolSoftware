package com.sodispolSoftware.model;
// Generated 18-jul-2014 18:32:52 by Hibernate Tools 3.6.0



/**
 * Receta generated by hbm2java
 */
public class Receta  implements java.io.Serializable {


     private long idreceta;
     private Medicinaepecifica medicinaepecifica;
     private Detallefichaestudiante detallefichaestudiante;
     private Integer dosis;
     private Boolean estadoborrado;

    public Receta() {
    }

	
    public Receta(long idreceta, Medicinaepecifica medicinaepecifica, Detallefichaestudiante detallefichaestudiante) {
        this.idreceta = idreceta;
        this.medicinaepecifica = medicinaepecifica;
        this.detallefichaestudiante = detallefichaestudiante;
    }
    public Receta(long idreceta, Medicinaepecifica medicinaepecifica, Detallefichaestudiante detallefichaestudiante, Integer dosis, Boolean estadoborrado) {
       this.idreceta = idreceta;
       this.medicinaepecifica = medicinaepecifica;
       this.detallefichaestudiante = detallefichaestudiante;
       this.dosis = dosis;
       this.estadoborrado = estadoborrado;
    }
   
    public long getIdreceta() {
        return this.idreceta;
    }
    
    public void setIdreceta(long idreceta) {
        this.idreceta = idreceta;
    }
    public Medicinaepecifica getMedicinaepecifica() {
        return this.medicinaepecifica;
    }
    
    public void setMedicinaepecifica(Medicinaepecifica medicinaepecifica) {
        this.medicinaepecifica = medicinaepecifica;
    }
    public Detallefichaestudiante getDetallefichaestudiante() {
        return this.detallefichaestudiante;
    }
    
    public void setDetallefichaestudiante(Detallefichaestudiante detallefichaestudiante) {
        this.detallefichaestudiante = detallefichaestudiante;
    }
    public Integer getDosis() {
        return this.dosis;
    }
    
    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }
    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }




}


