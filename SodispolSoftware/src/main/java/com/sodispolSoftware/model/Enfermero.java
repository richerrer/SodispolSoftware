package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Enfermero generated by hbm2java
 */
public class Enfermero  implements java.io.Serializable,User {


     private long idenfermero;
     private Roleuser roleuser;
     private String username;
     private Boolean estadoborrado;
     private Set<Detalleabastecimiento> detalleabastecimientos = new HashSet<Detalleabastecimiento>(0);

     /*Atributos de clase*/
     private String nombre1;
     private String nombre2;
     private String apellido1;
     private String apellido2;
     
    public Enfermero() {
    }

	
    public Enfermero(Roleuser roleuser) {
        this.roleuser = roleuser;
    }
    public Enfermero(Roleuser roleuser, String username, Boolean estadoborrado, Set<Detalleabastecimiento> detalleabastecimientos) {
       
       this.roleuser = roleuser;
       this.username = username;
       this.estadoborrado = estadoborrado;
       this.detalleabastecimientos = detalleabastecimientos;
    }
   
    public long getIdenfermero() {
        return this.idenfermero;
    }
    
    public void setIdenfermero(long idenfermero) {
        this.idenfermero = idenfermero;
    }
    public Roleuser getRoleuser() {
        return this.roleuser;
    }
    
    public void setRoleuser(Roleuser roleuser) {
        this.roleuser = roleuser;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
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

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public String toString(){
        return this.nombre1 + " "+ this.apellido1;
    }

    


}


