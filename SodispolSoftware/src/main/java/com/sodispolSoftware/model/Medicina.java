package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Medicina generated by hbm2java
 */
public class Medicina  implements java.io.Serializable {


     private long idmedicina;
     private String descripcion;
     private Integer cajasdisponibles;
     private Boolean estadodisponible;
     private Boolean estadoborrado;
     private Set<Detalleabastecimiento> detalleabastecimientos = new HashSet<Detalleabastecimiento>(0);
     private Set<Medicinaepecifica> medicinaepecificas = new HashSet<Medicinaepecifica>(0);
     private Set<Categoriamedicinamedicina> categoriamedicinamedicinas = new HashSet<Categoriamedicinamedicina>(0);

    public Medicina() {
    }

	
    public Medicina(long idmedicina) {
        this.idmedicina = idmedicina;
    }
    public Medicina(long idmedicina, String descripcion, Integer cajasDisp, Boolean estadoDisp) {
        this.idmedicina = idmedicina;
        this.descripcion = descripcion;
        this.cajasdisponibles=cajasDisp;
        this.estadodisponible=estadoDisp;
    }
    public Medicina( String descripcion, Integer cajasDisp, Boolean estadoDisp) {
        this.descripcion = descripcion;
        this.cajasdisponibles=cajasDisp;
        this.estadodisponible=estadoDisp;
    }
    
    
    public Medicina(long idmedicina, String descripcion, Integer cajasdisponibles, Boolean estadodisponible, Boolean estadoborrado, Set<Detalleabastecimiento> detalleabastecimientos, Set<Medicinaepecifica> medicinaepecificas, Set<Categoriamedicinamedicina> categoriamedicinamedicinas) {
       this.idmedicina = idmedicina;
       this.descripcion = descripcion;
       this.cajasdisponibles = cajasdisponibles;
       this.estadodisponible = estadodisponible;
       this.estadoborrado = estadoborrado;
       this.detalleabastecimientos = detalleabastecimientos;
       this.medicinaepecificas = medicinaepecificas;
       this.categoriamedicinamedicinas = categoriamedicinamedicinas;
    }
   
    public long getIdmedicina() {
        return this.idmedicina;
    }
    
    public void setIdmedicina(long idmedicina) {
        this.idmedicina = idmedicina;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getCajasdisponibles() {
        return this.cajasdisponibles;
    }
    
    public void setCajasdisponibles(Integer cajasdisponibles) {
        this.cajasdisponibles = cajasdisponibles;
    }
    public Boolean getEstadodisponible() {
        return this.estadodisponible;
    }
    
    public void setEstadodisponible(Boolean estadodisponible) {
        this.estadodisponible = estadodisponible;
    }
    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    public Set<Detalleabastecimiento> getDetalleabastecimientos() {
        return this.detalleabastecimientos;
    }
    
    public void setDetalleabastecimientos(Set<Detalleabastecimiento> detalleabastecimientos) {
        this.detalleabastecimientos = detalleabastecimientos;
    }
    public Set<Medicinaepecifica> getMedicinaepecificas() {
        return this.medicinaepecificas;
    }
    
    public void setMedicinaepecificas(Set<Medicinaepecifica> medicinaepecificas) {
        this.medicinaepecificas = medicinaepecificas;
    }
    public Set<Categoriamedicinamedicina> getCategoriamedicinamedicinas() {
        return this.categoriamedicinamedicinas;
    }
    
    public void setCategoriamedicinamedicinas(Set<Categoriamedicinamedicina> categoriamedicinamedicinas) {
        this.categoriamedicinamedicinas = categoriamedicinamedicinas;
    }




}


