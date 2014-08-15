package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Fichamedicaestudiante generated by hbm2java
 */
public class Fichamedicaestudiante  implements java.io.Serializable {


     private long idfichamedica;
     private Estudiante estudiante;
     private String antecedentespatologicos;
     private String enfermedadesinfancia;
     private String vacunasrecibidas;
     private Set<Detallefichaestudiante> detallefichaestudiantes = new HashSet<Detallefichaestudiante>(0);

    public Fichamedicaestudiante() {
    }

    public Fichamedicaestudiante(Estudiante estudiante, String antecedentespatologicos, String enfermedadesinfancia, String vacunasrecibidas, Boolean estadoborrado, Set<Detallefichaestudiante> detallefichaestudiantes) {
       
       this.estudiante = estudiante;
       this.antecedentespatologicos = antecedentespatologicos;
       this.enfermedadesinfancia = enfermedadesinfancia;
       this.vacunasrecibidas = vacunasrecibidas;
       this.detallefichaestudiantes = detallefichaestudiantes;
    }
   
    public long getIdfichamedica() {
        return this.idfichamedica;
    }
    
    public void setIdfichamedica(long idfichamedica) {
        this.idfichamedica = idfichamedica;
    }
    public Estudiante getEstudiante() {
        return this.estudiante;
    }
    
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public String getAntecedentespatologicos() {
        return this.antecedentespatologicos;
    }
    
    public void setAntecedentespatologicos(String antecedentespatologicos) {
        this.antecedentespatologicos = antecedentespatologicos;
    }
    public String getEnfermedadesinfancia() {
        return this.enfermedadesinfancia;
    }
    
    public void setEnfermedadesinfancia(String enfermedadesinfancia) {
        this.enfermedadesinfancia = enfermedadesinfancia;
    }
    public String getVacunasrecibidas() {
        return this.vacunasrecibidas;
    }
    
    public void setVacunasrecibidas(String vacunasrecibidas) {
        this.vacunasrecibidas = vacunasrecibidas;
    }
    
    public Set<Detallefichaestudiante> getDetallefichaestudiantes() {
        return this.detallefichaestudiantes;
    }
    
    public void setDetallefichaestudiantes(Set<Detallefichaestudiante> detallefichaestudiantes) {
        this.detallefichaestudiantes = detallefichaestudiantes;
    }




}


