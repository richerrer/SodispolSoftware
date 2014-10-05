/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebServiceSodispol;

import com.WebServiceSodispol.help.Get;
import com.WebServiceSodispol.wsEspol.WebServiceEspol;
import ec.edu.espol.academico.webservices.DatosEstudianteCedulaResponse;
import ec.edu.espol.academico.webservices.DatosEstudianteMatriculaResponse;
import ec.edu.espol.academico.webservices.DatosEstudianteUsuarioResponse;
import ec.edu.espol.academico.webservices.DatosProfesionalCedulaResponse;
import ec.edu.espol.academico.webservices.DatosProfesionalUsuarioResponse;
import ec.edu.espol.academico.webservices.DatosUsuarioResponse;
import java.util.ArrayList;
import java.util.Calendar;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.w3c.dom.Element;

/**
 *
 * @author usuario
 */
@WebService(serviceName = "WebServiceSodispol")
public class WebServiceSodispol {

    
    @WebMethod(operationName = "datosEstudianteCedula")
    public ArrayList datosEstudianteCedula(@WebParam(name = "cedula") String cedula) {
        try {
            Get help = new Get();
            ArrayList resultados;
            DatosEstudianteCedulaResponse.DatosEstudianteCedulaResult datosEstudiante;
            Element nodoResultanteXML;
            Integer edad;
            String fecha;
            
            resultados = new ArrayList();
            datosEstudiante = WebServiceEspol.datosEstudianteCedula(cedula);
            nodoResultanteXML = (Element) datosEstudiante.getAny();
            fecha = help.getFecha(nodoResultanteXML.getElementsByTagName("FECHANACIMIENTO").item(0).getTextContent());
            edad = help.calcularEdad(help.crearFechas(fecha));
            
            resultados.add(help.comproveString(nodoResultanteXML.getElementsByTagName("MATRICULA").item(0).getTextContent()));
            resultados.add(help.getUsernameOfEmail(nodoResultanteXML.getElementsByTagName("EMAIL").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("DIRECCION").item(0).getTextContent());
            resultados.add(help.estadoCivil(nodoResultanteXML.getElementsByTagName("ESTADOCIVIL").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("TELEFONO").item(0).getTextContent());
            resultados.add(edad);
            resultados.add(nodoResultanteXML.getElementsByTagName("ESPECIALIZACION").item(0).getTextContent());
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),false));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),false));
            resultados.add(fecha);
            
            return resultados;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "datosEstudianteMatricula")
    public ArrayList datosEstudianteMatricula(@WebParam(name = "matricula") String matricula) {
        try {
            Get help = new Get();
            ArrayList resultados;
            DatosEstudianteMatriculaResponse.DatosEstudianteMatriculaResult datosEstudiante;
            Element nodoResultanteXML;
            Integer edad;
            String fecha;
            
            resultados = new ArrayList();
            datosEstudiante = WebServiceEspol.datosEstudianteMatricula(matricula);
            nodoResultanteXML = (Element) datosEstudiante.getAny();
            fecha = help.getFecha(nodoResultanteXML.getElementsByTagName("FECHANACIMIENTO").item(0).getTextContent());
            edad = help.calcularEdad(help.crearFechas(fecha));
            
            resultados.add(help.comproveString(nodoResultanteXML.getElementsByTagName("CEDULA").item(0).getTextContent()));
            resultados.add(help.getUsernameOfEmail(nodoResultanteXML.getElementsByTagName("EMAIL").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("DIRECCION").item(0).getTextContent());
            resultados.add(help.estadoCivil(nodoResultanteXML.getElementsByTagName("ESTADOCIVIL").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("TELEFONO").item(0).getTextContent());
            resultados.add(edad);
            resultados.add(nodoResultanteXML.getElementsByTagName("ESPECIALIZACION").item(0).getTextContent());
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),false));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),false));
            resultados.add(fecha);
            
            return resultados;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "datosEstudianteUsername")
    public ArrayList datosEstudianteUsername(@WebParam(name = "username") String username) {
        try {
            Get help = new Get();
            ArrayList resultados;
            DatosEstudianteUsuarioResponse.DatosEstudianteUsuarioResult datosEstudiante;
            Element nodoResultanteXML;
            Integer edad;
            String fecha;
            
            resultados = new ArrayList();
            datosEstudiante = WebServiceEspol.datosEstudianteUsuario(username);
            nodoResultanteXML = (Element) datosEstudiante.getAny();
            fecha = help.getFecha(nodoResultanteXML.getElementsByTagName("FECHANACIMIENTO").item(0).getTextContent());
            edad = help.calcularEdad(help.crearFechas(fecha));
            
            resultados.add(help.comproveString(nodoResultanteXML.getElementsByTagName("MATRICULA").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("CEDULA").item(0).getTextContent());
            resultados.add(nodoResultanteXML.getElementsByTagName("DIRECCION").item(0).getTextContent());
            resultados.add(help.estadoCivil(nodoResultanteXML.getElementsByTagName("ESTADOCIVIL").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("TELEFONO").item(0).getTextContent());
            resultados.add(edad);
            resultados.add(nodoResultanteXML.getElementsByTagName("ESPECIALIZACION").item(0).getTextContent());
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),false));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),false));
            resultados.add(fecha);
            
            return resultados;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "datosProfesionalUsername")
    public ArrayList datosProfesionalUsername(@WebParam(name = "username") String username) {
        try {
            Get help = new Get();
            ArrayList resultados;
            DatosProfesionalUsuarioResponse.DatosProfesionalUsuarioResult datosEstudiante;
            Element nodoResultanteXML;
            Integer edad;
            Calendar fecha;
            
            resultados = new ArrayList();
            datosEstudiante = WebServiceEspol.datosProfesionalUsuario(username);
            nodoResultanteXML = (Element) datosEstudiante.getAny();
            
            resultados.add(nodoResultanteXML.getElementsByTagName("CEDULA").item(0).getTextContent());
            resultados.add(nodoResultanteXML.getElementsByTagName("DIRECCION").item(0).getTextContent());
            resultados.add(nodoResultanteXML.getElementsByTagName("ESTADOCIVIL").item(0).getTextContent());
            //falta edad
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),false));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),false));
            resultados.add(nodoResultanteXML.getElementsByTagName("FECHANACIMIENTO").item(0).getTextContent());
            
            return resultados;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "datosProfesionalCedula")
    public ArrayList datosProfesionalCedula(@WebParam(name = "cedula") String cedula) {
        try {
            Get help = new Get();
            ArrayList resultados;
            DatosProfesionalCedulaResponse.DatosProfesionalCedulaResult datosEstudiante;
            Element nodoResultanteXML;
            Integer edad;
            Calendar fecha;
            
            resultados = new ArrayList();
            datosEstudiante = WebServiceEspol.datosProfesionalCedula(cedula);
            nodoResultanteXML = (Element) datosEstudiante.getAny();
            
            resultados.add(help.getUsernameOfEmail(nodoResultanteXML.getElementsByTagName("EMAIL").item(0).getTextContent()));
            resultados.add(nodoResultanteXML.getElementsByTagName("DIRECCION").item(0).getTextContent());
            resultados.add(nodoResultanteXML.getElementsByTagName("ESTADOCIVIL").item(0).getTextContent());
            //falta edad
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("NOMBRES").item(0).getTextContent(),false));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),true));
            resultados.add(help.getName(nodoResultanteXML.getElementsByTagName("APELLIDOS").item(0).getTextContent(),false));
            resultados.add(nodoResultanteXML.getElementsByTagName("FECHANACIMIENTO").item(0).getTextContent());
            
            return resultados;
        } catch (Exception ex) {
            return null;
        }
    }
    
    @WebMethod(operationName = "tipoUsuario")
    public String tipoUsuario(@WebParam(name = "username") String username) {
        try {
            DatosUsuarioResponse.DatosUsuarioResult datosEstudiante;
            Element nodoResultanteXML;
            String tipoUsuario;
            
            datosEstudiante = WebServiceEspol.datosUsuario(username);
            nodoResultanteXML = (Element) datosEstudiante.getAny();
            tipoUsuario = nodoResultanteXML.getElementsByTagName("TIPO_USUARIO").item(0).getTextContent();
            
            return tipoUsuario;
        } catch (Exception ex) {
            return null;
        }
    }
}
