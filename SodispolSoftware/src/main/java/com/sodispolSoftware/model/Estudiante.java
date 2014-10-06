package com.sodispolSoftware.model;
// Generated 20-jul-2014 15:20:16 by Hibernate Tools 3.6.0

import java.util.HashSet;
import java.util.Set;

/**
 * Estudiante generated by hbm2java
 */
public class Estudiante implements java.io.Serializable, User {

    /*Atributos de la base de datos*/
    private long idestudiante;
    private Roleuser roleuser;
    private String matricula;
    private String cedula;
    private String username;
    private String direccion;
    private String estadocivil;
    private String telefono;
    private Boolean estadoborrado;
    private Set<Citamedica> citamedicas = new HashSet<Citamedica>(0);
    private Set<Fichamedicaestudiante> fichamedicaestudiantes = new HashSet<Fichamedicaestudiante>(0);

    /*Atributos de clase*/
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String carrera;
    private int edad;
    private String fechaNacimiento;
    //private String foto;
    private String ocupacion;

    public Estudiante() {
    }
    
    public Estudiante(String vacio) {
        this.nombre1 = vacio;
        this.nombre2 = vacio;
        this.apellido1 = vacio;
        this.apellido2 = vacio;
    }

    public Estudiante(Roleuser roleuser, boolean estadoborrado) {
        this.roleuser = roleuser;
        this.estadoborrado = estadoborrado;
    }

    public Estudiante(Roleuser roleuser, String matricula, String cedula, String username, String direccion, String estadocivil, String telefono, Boolean estadoborrado, Set<Citamedica> citamedicas, Set<Fichamedicaestudiante> fichamedicaestudiantes) {
        // this.idestudiante = idestudiante;
        this.roleuser = roleuser;
        this.matricula = matricula;
        this.cedula = cedula;
        this.username = username;
        this.direccion = direccion;
        this.estadocivil = estadocivil;
        this.telefono = telefono;
        this.estadoborrado = estadoborrado;
        this.citamedicas = citamedicas;
        this.fichamedicaestudiantes = fichamedicaestudiantes;
    }

    public long getIdestudiante() {
        return this.idestudiante;
    }

    public void setIdestudiante(long idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Roleuser getRoleuser() {
        return this.roleuser;
    }

    public void setRoleuser(Roleuser roleuser) {
        this.roleuser = roleuser;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadocivil() {
        return this.estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstadoborrado() {
        return this.estadoborrado;
    }

    public void setEstadoborrado(Boolean estadoborrado) {
        this.estadoborrado = estadoborrado;
    }

    public Set<Citamedica> getCitamedicas() {
        return this.citamedicas;
    }

    public void setCitamedicas(Set<Citamedica> citamedicas) {
        this.citamedicas = citamedicas;
    }

    public Set<Fichamedicaestudiante> getFichamedicaestudiantes() {
        return this.fichamedicaestudiantes;
    }

    public void setFichamedicaestudiantes(Set<Fichamedicaestudiante> fichamedicaestudiantes) {
        this.fichamedicaestudiantes = fichamedicaestudiantes;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombres() {
        return nombre1 + " " + nombre2;
    }

    public String getApellidos() {
        return apellido1 + " " + apellido2;
    }

    /*public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }*/

    @Override
    public String toString() {
        return nombre1 + " " + apellido1+" "+apellido2;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    
}
