/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.webServiceEspol;

import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Enfermero;
import com.sodispolSoftware.model.Estudiante;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * Simula un web service de espol en donde se le envía el username, y me
 * devuelve si es un profesional o un estudiante.
 */
@Named
@Scope(value = "session")
public class WebServiceEspol {

    @Resource(name = "clientWebServices")//Se lo puede usar en lugar de Inject, el id del bean del xml debe coincidir con el "name"
    private ClientWebServiceSodispol clientWebService;

    public String getRoleByUsername(String username) {
        
        String result = clientWebService.tipoUsuario(username);
        if (username.equals("rmaya")) {
            return "P";//Profesional
        }
        if (username.equals("gabapare")) {
            return "P";//Profesional
        }
        if (username.equals("raualmirA")) {
            return "P";//Profesional
        }
        if(result!=null){
            if (result.equals("PROFESIONAL")) {
                return "P";//Profesional
            }
            if (result.equals("ESTUDIANTE")) {
                return "E";//Profesional
            }
        }
        return null;
    }
    

    public Object[] loadDoctorsAttributes(String username) {
        if (username.equals("rmaya")) {
            return new Object[]{"RICARDO", "DAVID", "MAYA", "HERRERA"};
        }
        if (username.equals("raualmir")) {
            return new Object[]{"raul", "alberto", "mira", "rodriguez"};
        }
        if (username.equals("gabapare")) {
            return new Object[]{"gaby", "alejandra", "paredes", "torres"};
        }
        if (username.equals("joanrome")) {
            return new Object[]{"jose", "andres", "romero", "triviño"};
        }
        
        ArrayList result = clientWebService.datosProfesionalUsername(username);
        if (result.isEmpty()) {
            return null;
        } else {
            return new Object[]{result.get(3).toString(), result.get(4).toString(),
                result.get(5).toString(), result.get(6).toString()};
        }
    }

    public static Object[] loadProfesionalAttributes(String username) {
        if (username.equals("raulalmir")) {
            return new Object[]{"1722904628", "Villa Club", "Casado", 21, "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "/SodispolSoftware/resources/images/raul.png"};
        }
        return null;
    }

    public static Object[] loadProfesionalAttributesByCedula(String cedula) {
        if (cedula.equals("17225545")) {
            return new Object[]{"raualmir", "Villa Club", "Casado", 21, "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "/SodispolSoftware/resources/images/raul.png"};
        }
        return null;
    }

    /**
     *
     * Simula un web service de espol en donde se le envía la matricula, y me
     * devuelve los datos relevantes del estudiante de esa matricula.
     *
     * @param matricula
     * @return
     */
    public Object[] loadEstudianteAttributesByMatricula(String matricula) {
        ArrayList result = clientWebService.datosEstudianteMatricula(matricula);
        if (result.isEmpty()) {
            return null;
        } else {
            return new Object[]{result.get(0).toString(), result.get(1).toString(),
                result.get(2).toString(), result.get(3).toString(), result.get(4).toString(),
                (Integer)result.get(5), result.get(6).toString(), result.get(7).toString(), result.get(8).toString(),
                result.get(9).toString(), result.get(10).toString(), result.get(11).toString()};
        }
        /*if (matricula.equals("201013448")) {
         return new Object[]{"1722904628", "raulalmir", "Villa Club", "Casado", "2246570", 21, "Ing. en Ciencias Computacionales Orientación Multimedia", "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "../resources/images/raul.png"};
         }*/
        /*if (matricula.equals("201011111")) {
         return new Object[]{"0999999999", "gabapare", "Leonidas Plaza y Oriente", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Gabriela", "Alejandra", "Paredes", "Torres", "1 de Mayo de 1992 ", "resources/images/raeul.png"};
        
         if (matricula.equals("201011111")) {
         return new Object[]{"0999999999", "joanrome", "La joya", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Jose", "Andres", "Triviño", "Romero", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }}*/
        /*if (matricula.equals("201045878")) {
         return new Object[]{"0994563999", "kplaza", "24 y cuenca", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Karla", "Denisse", "Plaza", "Paguay", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }
         if (matricula.equals("123456789")) {
         return new Object[]{"0997773999", "rivera", "24 y cuenca", "Soltero", "2666227", 27, "Ing. en Minas", "Renato", "Jhalmar", "Rivera", "Triviño", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }
         return null;*/
    }

    /**
     *
     * Simula un web service de espol en donde se le envía la cedula, y me
     * devuelve los datos relevantes del estudiante de esa cedula.
     *
     * @param cedula
     * @return
     */
    public Object[] loadEstudianteAttributesByCedula(String cedula) {
        ArrayList result = clientWebService.datosEstudianteCedula(cedula);
        if (result.isEmpty()) {
            return null;
        } else {
            return new Object[]{result.get(0).toString(), result.get(1).toString(),
                result.get(2).toString(), result.get(3).toString(), result.get(4).toString(),
                (Integer)result.get(5), result.get(6).toString(), result.get(7).toString(), result.get(8).toString(),
                result.get(9).toString(), result.get(10).toString(), result.get(11).toString()};
        }

        //if (cedula.equals("1722904628")) {
        //ArrayList result = clientWebService.datosCedula(cedula);
        //return new Object[]{result.get(0).toString(), result.get(1).toString(), result.get(2).toString(), result.get(3).toString(), result.get(4).toString(), 21,result.get(5).toString(), result.get(6).toString(), result.get(7).toString(), result.get(8).toString(), result.get(9).toString(), result.get(10).toString(), "/SodispolSoftware/resources/images/raul.png"};
        //}
        /*ArrayList result = clientWebService.datosCedula(cedula);
         return new Object[]{result.get(0).toString(), result.get(1).toString(), result.get(2).toString(), result.get(3).toString(), result.get(4).toString(), 21,result.get(5).toString(), result.get(6).toString(), result.get(7).toString(), result.get(8).toString(), result.get(9).toString(), result.get(10).toString(), "/SodispolSoftware/resources/images/raul.png"};
         */
        /*if (cedula.equals("0999999999")) {
         return new Object[]{"201011111", "gabapare", "Leonidas Plaza y Oriente", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Gabriela", "Alejandra", "Paredes", "Torres", "1 de Mayo de 1992 ", "resources/images/raeul.png"};
         }
         if (cedula.equals("0999999999")) {
         return new Object[]{"201011111", "joanrome", "La joya", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Jose", "Andres", "Triviño", "Romero", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }*/
        /*if (cedula.equals("0994563999")) {
         return new Object[]{"201045878", "kplaza", "24 y cuenca", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Karla", "Denisse", "Plaza", "Paguay", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }
         if (cedula.equals("0997773999")) {
         return new Object[]{"123456789", "rivera", "24 y cuenca", "Soltero", "2666227", 27, "Ing. en Minas", "Renato", "Jhalmar", "Rivera", "Triviño", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }*/
        //return null;
    }

    /**
     *
     * Simula un web service de espol en donde se le envía el username, y me
     * devuelve los datos relevantes del estudiante de esa username.
     *
     * @param username
     * @return
     */
    public Object[] loadEstudianteAttributes(String username) {

        ArrayList result = clientWebService.datosEstudianteUsername(username);
        if (result.isEmpty()) {
            return null;
        } else {
            return new Object[]{result.get(0).toString(), result.get(1).toString(),
                result.get(2).toString(), result.get(3).toString(), result.get(4).toString(),
                (Integer)result.get(5), result.get(6).toString(), result.get(7).toString(), result.get(8).toString(),
                result.get(9).toString(), result.get(10).toString(), result.get(11).toString()};
        }
        
        /*if (username.equals("raulalmir")) {
            return new Object[]{"201013448", "1722904628", "Villa Club", "Casado", "2246570", 21, "Ing. en Ciencias Computacionales Orientación Multimedia", "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "/SodispolSoftware/resources/images/raul.png"};
        }
        /*if (cedula.equals("0999999999")) {
         return new Object[]{"201011111", "gabapare", "Leonidas Plaza y Oriente", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Gabriela", "Alejandra", "Paredes", "Torres", "1 de Mayo de 1992 ", "resources/images/raeul.png"};
         }
         if (username.equals("joanrome")) {
         return new Object[]{"201011111", "0999999999", "La joya", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Jose", "Andres", "Triviño", "Romero", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
         }*/
        /*if (username.equals("kplaza")) {
            return new Object[]{"201045878", "0994563999", "24 y cuenca", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Karla", "Denisse", "Plaza", "Paguay", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        if (username.equals("rivera")) {
            return new Object[]{"123456789", "0997773999", "24 y cuenca", "Soltero", "2666227", 27, "Ing. en Minas", "Renato", "Jhalmar", "Rivera", "Triviño", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        return null;*/
    }
    
    /**
     *
     * Carga los datos a un objeto doctor segun su username, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param doctor
     */
    public void loadDataDoctorFromWebService(Doctor doctor) {
        if(doctor!=null){
            Object[] attributes = loadDoctorsAttributes(doctor.getUsername());
            doctor.setNombre1((String) attributes[0]);
            doctor.setNombre2((String) attributes[1]);
            doctor.setApellido1((String) attributes[2]);
            doctor.setApellido2((String) attributes[3]);
            // doctor.setCorreo((String) attributes[4]);
            // doctor.setEspecializacion((String) attributes[5]);
        }
    }

    public void loadDataEnfermeroFromWebService(Enfermero enfermero) {
        if(enfermero!=null){
            Object[] attributes = loadDoctorsAttributes(enfermero.getUsername());
            enfermero.setNombre1((String) attributes[0]);
            enfermero.setNombre2((String) attributes[1]);
            enfermero.setApellido1((String) attributes[2]);
            enfermero.setApellido2((String) attributes[3]);
        }
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su matricula, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param estudiante
     */
    public void loadDataEstudianteByMatriculaFromWebService(Estudiante estudiante) {
        if (estudiante != null) {
            Object[] attributes = loadEstudianteAttributesByMatricula(estudiante.getMatricula());
            estudiante.setNombre1((String) attributes[7]);
            estudiante.setNombre2((String) attributes[8]);
            estudiante.setApellido1((String) attributes[9]);
            estudiante.setApellido2((String) attributes[10]);
            estudiante.setCarrera((String) attributes[6]);
            estudiante.setEdad((Integer) attributes[5]);
           // estudiante.setFoto((String) attributes[12]);
            estudiante.setFechaNacimiento((String)attributes[11]);
        }
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su cedula, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param estudiante
     */
    public void loadDataEstudianteByCedulaFromWebService(Estudiante estudiante) {
        if (estudiante != null) {
            Object[] attributes = loadEstudianteAttributesByCedula(estudiante.getCedula());
            estudiante.setNombre1((String) attributes[7]);
            estudiante.setNombre2((String) attributes[8]);
            estudiante.setApellido1((String) attributes[9]);
            estudiante.setApellido2((String) attributes[10]);
            estudiante.setCarrera((String) attributes[6]);
            estudiante.setEdad((Integer) attributes[5]);
            //estudiante.setFoto((String) attributes[12]);
            estudiante.setFechaNacimiento((String)attributes[11]);
        }
        /*estudiante.setFechaNacimiento((String)attributes[11]);*/
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su username, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param estudiante
     */
    public void loadDataEstudianteByUsernameFromWebService(Estudiante estudiante) {
        if(estudiante!=null){
            Object[] attributes = loadEstudianteAttributes(estudiante.getUsername());
            estudiante.setNombre1((String) attributes[7]);
            estudiante.setNombre2((String) attributes[8]);
            estudiante.setApellido1((String) attributes[9]);
            estudiante.setApellido2((String) attributes[10]);
            estudiante.setCarrera((String) attributes[6]);
            estudiante.setEdad((Integer) attributes[5]);
           // estudiante.setFoto((String) attributes[12]);
            estudiante.setFechaNacimiento((String)attributes[11]);
        }
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su matricula, desde un web
     * service, para poder guardarlos en la base de datos Sodispol,la primera
     * vez que se lo ingrese al sistema (matricula,cedula,username,direccion
     * etc..)
     *
     * @param estudiante
     * @param matricula
     * @return 
     */
    public boolean setDataEstudianteByMatriculaFromWebService(Estudiante estudiante, String matricula) {
        Object[] attributes = loadEstudianteAttributesByMatricula(matricula);
        if (attributes == null) {
            return false;
        }else{
            estudiante.setMatricula(matricula);
            estudiante.setCedula((String) attributes[0]);
            estudiante.setUsername((String) attributes[1]);
            estudiante.setDireccion((String) attributes[2]);
            estudiante.setEstadocivil((String) attributes[3]);
            estudiante.setTelefono((String) attributes[4]);
            return true;
        }
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su cedula, desde un web
     * service, para poder guardarlos en la base de datos Sodispol,la primera
     * vez que se lo ingrese al sistema (matricula,cedula,username,direccion
     * etc..)
     *
     * @param estudiante
     * @param cedula
     * @return
     */
    public boolean setDataEstudianteByCedulaFromWebService(Estudiante estudiante, String cedula) {
        Object[] attributes = loadEstudianteAttributesByCedula(cedula);
        if (attributes == null) {
            return false;
        } else {
            estudiante.setCedula(cedula);
            estudiante.setMatricula((String) attributes[0]);
            estudiante.setUsername((String) attributes[1]);
            estudiante.setDireccion((String) attributes[2]);
            estudiante.setEstadocivil((String) attributes[3]);
            estudiante.setTelefono((String) attributes[4]);
            return true;
        }

    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su username, desde un web
     * service, para poder guardarlos en la base de datos Sodispol,la primera
     * vez que se lo ingrese al sistema (matricula,cedula,username,direccion
     * etc..)
     *
     * @param estudiante
     * @param username
     * @return 
     */
    public boolean setDataEstudianteByUsernameFromWebService(Estudiante estudiante, String username) {

        Object[] attributes = loadEstudianteAttributes(username);
        if (attributes == null) {
            return false;
        } else {
            estudiante.setMatricula((String) attributes[0]);
            estudiante.setCedula((String) attributes[1]);
            estudiante.setUsername(username);
            estudiante.setDireccion((String) attributes[2]);
            estudiante.setEstadocivil((String) attributes[3]);
            estudiante.setTelefono((String) attributes[4]);
            return true;
        }
    }
    
    /*Retorna el estado, es deir si esta activo o no

    public static boolean getStateByUsername(String username) {
        if (username.equals("rmaya")) {
            return true;//DOCTOR
        }
        if (username.equals("raualmir")) {
            return true;//ENFERMERO
        }
        if (username.equals("joanrome")) {
            return true;//PACIENTE PROFESIONALE
        }
        if (username.equals("gabapare")) {
            return true;//PACIENTE ESTUDIANTE
        }
        return false;
    }*/
    
        /**
     *
     * Simula un web service de espol en donde se le envía la cedula, y me
     * devuelve si esa cedula le pertenece a algun estudiante
     *
     * @param cedula
     * @return
     
    public static boolean verifyCedula(String cedula) {
        if (cedula.equals("1722904628")) {
            return true;
        }
        if (cedula.equals("0999999999")) {
            return true;
        }

        if (cedula.equals("0994563999")) {
            return true;
        }
        if (cedula.equals("0997773999")) {
            return true;
        }

        return false;
    }*/
    
        /**
     *
     * Simula un web service de espol en donde se le envía la matricula, y me
     * devuelve si esa matricula le pertenece a algun estudiante
     *
     * @param matricula
     * @return
     
    public static boolean verifyMatricula(String matricula) {
        if (matricula.equals("201013448")) {
            return true;
        }
        if (matricula.equals("201011111")) {
            return true;
        }
        if (matricula.equals("201045878")) {
            return true;
        }
        if (matricula.equals("123456789")) {
            return true;
        }
        return false;
    }*/

    public ClientWebServiceSodispol getClientWebService() {
        return clientWebService;
    }

    public void setClientWebService(ClientWebServiceSodispol clientWebService) {
        this.clientWebService = clientWebService;
    }
}
