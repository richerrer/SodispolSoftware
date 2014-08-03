package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Categoriamedicina generated by hbm2java
 */
public class Categoriamedicina  implements java.io.Serializable {


     private int idcategoriamedicina;
     private Boolean estadoborrado;
     private String descripcion;
     private Set<Categoriamedicinamedicina> categoriamedicinamedicinas = new HashSet<Categoriamedicinamedicina>(0);

    public Categoriamedicina() {
    }

	
    public Categoriamedicina(int idcategoriamedicina) {
        this.idcategoriamedicina = idcategoriamedicina;
    }
    public Categoriamedicina(int idcategoriamedicina, Boolean estadoborrado, String descripcion, Set<Categoriamedicinamedicina> categoriamedicinamedicinas) {
       this.idcategoriamedicina = idcategoriamedicina;
       this.estadoborrado = estadoborrado;
       this.descripcion = descripcion;
       this.categoriamedicinamedicinas = categoriamedicinamedicinas;
    }
   
    public int getIdcategoriamedicina() {
        return this.idcategoriamedicina;
    }
    
    public void setIdcategoriamedicina(int idcategoriamedicina) {
        this.idcategoriamedicina = idcategoriamedicina;
    }
    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }
    
    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Categoriamedicinamedicina> getCategoriamedicinamedicinas() {
        return this.categoriamedicinamedicinas;
    }
    
    public void setCategoriamedicinamedicinas(Set<Categoriamedicinamedicina> categoriamedicinamedicinas) {
        this.categoriamedicinamedicinas = categoriamedicinamedicinas;
    }




}

