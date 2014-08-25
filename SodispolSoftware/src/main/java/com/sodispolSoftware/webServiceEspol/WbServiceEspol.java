/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.webServiceEspol;

import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Enfermero;
import com.sodispolSoftware.model.Estudiante;

/**
 *
 * Simula un web service de espol en donde se le envía el username, y me
 * devuelve si es un profesional o un estudiante.
 */
public class WbServiceEspol {

    public static String getRoleByUsername(String username) {
        if (username.equals("rmaya")) {
            return "P";//Profesional
        }
        if (username.equals("gabapare")) {
            return "P";//Profesional
        }
        if (username.equals("raualmir")) {
            return "P";//Estudiante
        }
        if (username.equals("joanrome")) {
            return "P";//Estudiante
        }
        if (username.equals("kplaza")) {
            return "E";//Estudiante
        }
        if (username.equals("rivera")) {
            return "E";//Profesional
        }
        return null;
    }
    /* Retorna el estado, es deir si esta activo o no*/

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
    }

    public static Object[] loadProfesionalAttributes(String username) {
        if (username.equals("rmaya")) {
            return new Object[]{"ricardo", "david", "maya", "herrera"};
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
        
        /*if (username.equals("raualmir")) {
            return new Object[]{"raul", "alberto", "mira", "rodriguez", "raualmir@espol.edu.ec", "Cardiologo"};
        }
        
        if (username.equals("joanrome")) {
            return new Object[]{"jose", "andres", "romero", "triviño", "joanrome@espol.edu.ec", "Cardiologo"};
        }*/
        return null;
    }

    /*public static Object[] loadDoctorAttributes(String username) {
        if (username.equals("rmaya")) {
            return new Object[]{"ricardo", "david", "maya", "herrera", "rmaya@espol.edu.ec", "Cardiologo"};
        }
        if (username.equals("raualmir")) {
            return new Object[]{"raul", "alberto", "mira", "rodriguez", "raualmir@espol.edu.ec", "Cardiologo"};
        }
        if (username.equals("gabapare")) {
            return new Object[]{"gaby", "alejandra", "paredes", "torres", "gabapare@espol.edu.ec", "Cardiologo"};
        }
        if (username.equals("joanrome")) {
            return new Object[]{"jose", "andres", "romero", "triviño", "joanrome@espol.edu.ec", "Cardiologo"};
        }
        return null;
    }*/

    /*public static Object[] loadEnfermeroAttributes(String username) {

        if (username.equals("gabapare")) {
            return new Object[]{"gaby", "alejandra", "paredes", "torres"};
        }
        return null;
    }*/

    /**
     *
     * Simula un web service de espol en donde se le envía la matricula, y me
     * devuelve los datos relevantes del estudiante de esa matricula.
     *
     * @param matricula
     * @return
     */
    public static Object[] loadEstudinateAttributesByMatricula(String matricula) {
        if (matricula.equals("201013448")) {
            return new Object[]{"1722904628", "raulalmir", "Villa Club", "Casado", "2246570", 21, "Ing. en Ciencias Computacionales Orientación Multimedia", "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "../resources/images/raul.png"};
        }
        /*if (matricula.equals("201011111")) {
            return new Object[]{"0999999999", "gabapare", "Leonidas Plaza y Oriente", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Gabriela", "Alejandra", "Paredes", "Torres", "1 de Mayo de 1992 ", "resources/images/raeul.png"};
        
        if (matricula.equals("201011111")) {
            return new Object[]{"0999999999", "joanrome", "La joya", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Jose", "Andres", "Triviño", "Romero", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }}*/
        if (matricula.equals("201045878")) {
            return new Object[]{"0994563999", "kplaza", "24 y cuenca", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Karla", "Denisse", "Plaza", "Paguay", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        if (matricula.equals("123456789")) {
            return new Object[]{"0997773999", "rivera", "24 y cuenca", "Soltero", "2666227", 27, "Ing. en Minas", "Renato", "Jhalmar", "Rivera", "Triviño", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        return null;
    }

    /**
     *
     * Simula un web service de espol en donde se le envía la cedula, y me
     * devuelve los datos relevantes del estudiante de esa cedula.
     *
     * @param cedula
     * @return
     */
    public static Object[] loadEstudinateAttributesByCedula(String cedula) {
        if (cedula.equals("1722904628")) {
            return new Object[]{"201013448", "raulalmir", "Villa Club", "Casado", "2246570", 21, "Ing. en Ciencias Computacionales Orientación Multimedia", "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "/SodispolSoftware/resources/images/raul.png"};
        }
        /*if (cedula.equals("0999999999")) {
            return new Object[]{"201011111", "gabapare", "Leonidas Plaza y Oriente", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Gabriela", "Alejandra", "Paredes", "Torres", "1 de Mayo de 1992 ", "resources/images/raeul.png"};
        }
        if (cedula.equals("0999999999")) {
            return new Object[]{"201011111", "joanrome", "La joya", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Jose", "Andres", "Triviño", "Romero", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }*/
        if (cedula.equals("0994563999")) {
            return new Object[]{"201045878", "kplaza", "24 y cuenca", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Karla", "Denisse", "Plaza", "Paguay", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        if (cedula.equals("0997773999")) {
            return new Object[]{"123456789", "rivera", "24 y cuenca", "Soltero", "2666227", 27, "Ing. en Minas", "Renato", "Jhalmar", "Rivera", "Triviño", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        return null;
    }

    /**
     *
     * Simula un web service de espol en donde se le envía el username, y me
     * devuelve los datos relevantes del estudiante de esa username.
     *
     * @param username
     * @return
     */
    public static Object[] loadEstudianteAttributes(String username) {

        if (username.equals("raulalmir")) {
            return new Object[]{"201013448", "1722904628", "Villa Club", "Casado", "2246570", 21, "Ing. en Ciencias Computacionales Orientación Multimedia", "Raul", "Alberto", "Mira", "Rodriguez", "1 de Enero de 1991 ", "/SodispolSoftware/resources/images/raul.png"};
        }
        /*if (cedula.equals("0999999999")) {
            return new Object[]{"201011111", "gabapare", "Leonidas Plaza y Oriente", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Gabriela", "Alejandra", "Paredes", "Torres", "1 de Mayo de 1992 ", "resources/images/raeul.png"};
        }
        if (username.equals("joanrome")) {
            return new Object[]{"201011111", "0999999999", "La joya", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Jose", "Andres", "Triviño", "Romero", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }*/
        if (username.equals("kplaza")) {
            return new Object[]{"201045878", "0994563999", "24 y cuenca", "Soltero", "2338227", 22, "Ing. en Electronica y Telecomunicaciones", "Karla", "Denisse", "Plaza", "Paguay", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        if (username.equals("rivera")) {
            return new Object[]{"123456789", "0997773999", "24 y cuenca", "Soltero", "2666227", 27, "Ing. en Minas", "Renato", "Jhalmar", "Rivera", "Triviño", "1 de Mayo de 1992 ", "/SodispolSoftware/resources/images/raeul.png"};
        }
        return null;
    }

    /**
     *
     * Simula un web service de espol en donde se le envía la matricula, y me
     * devuelve si esa matricula le pertenece a algun estudiante
     *
     * @param matricula
     * @return
     */
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
    }

    /**
     *
     * Simula un web service de espol en donde se le envía la cedula, y me
     * devuelve si esa cedula le pertenece a algun estudiante
     *
     * @param cedula
     * @return
     */
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
    }

    /**
     *
     * Carga los datos a un objeto doctor segun su username, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param doctor
     */
    public static void loadDataDoctorFromWebService(Doctor doctor) {
        Object[] attributes = WbServiceEspol.loadProfesionalAttributes(doctor.getUsername());
        doctor.setNombre1((String) attributes[0]);
        doctor.setNombre2((String) attributes[1]);
        doctor.setApellido1((String) attributes[2]);
        doctor.setApellido2((String) attributes[3]);
       // doctor.setCorreo((String) attributes[4]);
       // doctor.setEspecializacion((String) attributes[5]);
    }

    public static void loadDataEnfermeroFromWebService(Enfermero enfermero) {
        Object[] attributes = WbServiceEspol.loadProfesionalAttributes(enfermero.getUsername());
        enfermero.setNombre1((String) attributes[0]);
        enfermero.setNombre2((String) attributes[1]);
        enfermero.setApellido1((String) attributes[2]);
        enfermero.setApellido2((String) attributes[3]);
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su matricula, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param estudiante
     */
    public static void loadDataEstudianteByMatriculaFromWebService(Estudiante estudiante) {
        Object[] attributes = WbServiceEspol.loadEstudinateAttributesByMatricula(estudiante.getMatricula());
        estudiante.setNombre1((String) attributes[7]);
        estudiante.setNombre2((String) attributes[8]);
        estudiante.setApellido1((String) attributes[9]);
        estudiante.setApellido2((String) attributes[10]);
        estudiante.setCarrera((String) attributes[6]);
        estudiante.setEdad((Integer) attributes[5]);
        estudiante.setFoto((String) attributes[12]);
        /*estudiante.setFechaNacimiento((String)attributes[11]);*/
    }

    /**
     *
     * Carga los datos a un objeto estudiante segun su cedula, desde un web
     * service, que no maneja la base de datos interna Sodispol
     * (nombres,apellidos,correo etc...)
     *
     * @param estudiante
     */
    public static void loadDataEstudianteByCedulaFromWebService(Estudiante estudiante) {
        Object[] attributes = WbServiceEspol.loadEstudinateAttributesByCedula(estudiante.getCedula());
        estudiante.setNombre1((String) attributes[7]);
        estudiante.setNombre2((String) attributes[8]);
        estudiante.setApellido1((String) attributes[9]);
        estudiante.setApellido2((String) attributes[10]);
        estudiante.setCarrera((String) attributes[6]);
        estudiante.setEdad((Integer) attributes[5]);
        estudiante.setFoto((String) attributes[12]);
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
    public static void loadDataEstudianteByUsernameFromWebService(Estudiante estudiante) {
        Object[] attributes = WbServiceEspol.loadEstudianteAttributes(estudiante.getUsername());
        estudiante.setNombre1((String) attributes[7]);
        estudiante.setNombre2((String) attributes[8]);
        estudiante.setApellido1((String) attributes[9]);
        estudiante.setApellido2((String) attributes[10]);
        estudiante.setCarrera((String) attributes[6]);
        estudiante.setEdad((Integer) attributes[5]);
        estudiante.setFoto((String) attributes[12]);
        /*estudiante.setFechaNacimiento((String)attributes[11]);*/
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
     */
    public static void setDataEstudianteByMatriculaFromWebService(Estudiante estudiante, String matricula) {
        Object[] attributes = WbServiceEspol.loadEstudinateAttributesByMatricula(matricula);
        estudiante.setMatricula(matricula);
        estudiante.setCedula((String) attributes[0]);
        estudiante.setUsername((String) attributes[1]);
        estudiante.setDireccion((String) attributes[2]);
        estudiante.setEstadocivil((String) attributes[3]);
        estudiante.setTelefono((String) attributes[4]);
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
     */
    public static void setDataEstudianteByCedulaFromWebService(Estudiante estudiante, String cedula) {
        Object[] attributes = WbServiceEspol.loadEstudinateAttributesByCedula(cedula);
        estudiante.setCedula(cedula);
        estudiante.setMatricula((String) attributes[0]);
        estudiante.setUsername((String) attributes[1]);
        estudiante.setDireccion((String) attributes[2]);
        estudiante.setEstadocivil((String) attributes[3]);
        estudiante.setTelefono((String) attributes[4]);
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
     */
    public static void setDataEstudianteByUsernameFromWebService(Estudiante estudiante, String username) {

        Object[] attributes = WbServiceEspol.loadEstudianteAttributes(username);
        estudiante.setMatricula((String) attributes[0]);
        estudiante.setCedula((String) attributes[1]);
        estudiante.setUsername(username);
        estudiante.setDireccion((String) attributes[2]);
        estudiante.setEstadocivil((String) attributes[3]);
        estudiante.setTelefono((String) attributes[4]);
    }

}
