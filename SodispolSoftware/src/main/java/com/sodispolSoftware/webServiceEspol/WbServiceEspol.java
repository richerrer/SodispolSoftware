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
            return "P";//Profesional
        }
        if(username.equals("joanrome")){
            return "P";//Profesional
        }
        if(username.equals("gabapare")){
            return "E";//Estudiante
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
            return true;//PACIENTE PROFESIONALE
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
        /*if(username.equals("gabapare")){
            return new Object[]{"gaby","alejandra","paredes","torres","gabapare@espol.edu.ec","Cardiologo"};
        }*/
        if(username.equals("joanrome")){
            return new Object[]{"jose","andres","romero","triviño","joanrome@espol.edu.ec","Cardiologo"};
        }
        return null;
    }
    
    public static Object[] loadEstudinateAttributesByMatricula(String matricula)
    {
        if(matricula.equals("201013448")){
            return new Object[]{"1722904628","raulalmir","Villa Club","Casado","2246570",21,"Ing. en Ciencias Computacionales Orientación Multimedia","Raul","Alberto","Mira","Rodriguez","1 de Enero de 1991 ","resources/images/raul.png"};
        }
        if(matricula.equals("201011111")){
            return new Object[]{"0999999999","gabapare","Leonidas Plaza y Oriente","Soltero","2338227",22,"Ing. en Electronica y Telecomunicaciones","Gabriela","Alejandra","Paredes","Torres","1 de Mayo de 1992 ","resources/images/raeul.png"};
        }
        
        return null;
    }
    
    public static Object[] loadEstudinateAttributesByCedula(String cedula)
    {
        if(cedula.equals("1722904628")){
            return new Object[]{"201013448","raulalmir","Villa Club","Casado","2246570",21,"Ing. en Ciencias Computacionales Orientación Multimedia","Raul","Alberto","Mira","Rodriguez","1 de Enero de 1991 ","resources/images/raul.png"};
        }
        if(cedula.equals("0999999999")){
            return new Object[]{"201011111","gabapare","Leonidas Plaza y Oriente","Soltero","2338227",22,"Ing. en Electronica y Telecomunicaciones","Gabriela","Alejandra","Paredes","Torres","1 de Mayo de 1992 ","resources/images/raeul.png"};
        }
        return null;
    }
    
    public static Object[] loadEstudianteAttributes(String username)
    {
        
        if(username.equals("gabapare")){
            return new Object[]{"201011111","0999999999","Leonidas Plaza y Oriente","Soltero","2338227",22,"Ing. en Electronica y Telecomunicaciones","Gabriela","Alejandra","Paredes","Torres","1 de Mayo de 1992 ","resources/images/raul.png"};
        }
        return null;
    }
}
