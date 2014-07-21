/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.webServiceEspol;

/**
 *
 * Simula un web service de espol
 */
public class WbServiceEspol {
    
    public static String getRoleByUsername(String username){
        if(username.equals("rmaya")){
            return "D";//DOCTOR
        }
        if(username.equals("raulalmir")){
            return "E";//ENFERMERO
        }
        if(username.equals("joanrome")){
            return "PP";//PACIENTE PROFESIONALE
        }
        if(username.equals("gabapare")){
            return "D";//PACIENTE ESTUDIANTE  PE
        }
        return null;
    }
    /* Retorna el estado, es deir si esta activo o no*/
    public static boolean getStateByUsername(String username){
        if(username.equals("rmaya")){
            return true;//DOCTOR
        }
        if(username.equals("raulalmir")){
            return true;//ENFERMERO
        }
        if(username.equals("joanrome")){
            return false;//PACIENTE PROFESIONALE
        }
        if(username.equals("gabapare")){
            return true;//PACIENTE ESTUDIANTE
        }
        return false;
    }
    
    public static Object[] loadDoctorAttributes(String username)
    {
        if(username.equals("rmaya")){
            return new Object[]{"ricardo","david","maya","herrera","rmaya@espol.edu.ec","Cardiologo"};
        }
        if(username.equals("gabapare")){
            return new Object[]{"gaby","alejandra","paredes","torres","gabapare@espol.edu.ec","Cardiologo"};
        }
        return null;
    }
    
        public static Object[] loadEstudinateAttributesByMatricula(String matricula)
    {
        if(matricula.equals("201013448")){
            return new Object[]{"0954787589","raulalmir","Villa Club","Casado","2246570",21,"Ing. en Ciencias Computacionales Orientación Multimedia","Raul","Alberto","Mira","Rodriguez","1 de Enero de 1991 ","resources/images/raul.png"};
        }
        
        return null;
    }
}
