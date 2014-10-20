/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.WebServiceSodispol.wsEspol;

import ec.edu.espol.academico.webservices.DatosEstudianteCedulaResponse;
import ec.edu.espol.academico.webservices.DatosEstudianteMatriculaResponse;
import ec.edu.espol.academico.webservices.DatosEstudianteUsuarioResponse;
import ec.edu.espol.academico.webservices.DatosProfesionalCedulaResponse;
import ec.edu.espol.academico.webservices.DatosProfesionalUsuarioResponse;
import ec.edu.espol.academico.webservices.DatosUsuarioResponse;

/**
 *
 * @author usuario
 */
public class WebServiceEspol {

    public static DatosEstudianteCedulaResponse.DatosEstudianteCedulaResult datosEstudianteCedula(java.lang.String cedula) {
        ec.edu.espol.academico.webservices.WsSODIS service = new ec.edu.espol.academico.webservices.WsSODIS();
        ec.edu.espol.academico.webservices.WsSODISSoap port = service.getWsSODISSoap();
        return port.datosEstudianteCedula(cedula);
    }

    public static DatosEstudianteMatriculaResponse.DatosEstudianteMatriculaResult datosEstudianteMatricula(java.lang.String matricula) {
        ec.edu.espol.academico.webservices.WsSODIS service = new ec.edu.espol.academico.webservices.WsSODIS();
        ec.edu.espol.academico.webservices.WsSODISSoap port = service.getWsSODISSoap();
        return port.datosEstudianteMatricula(matricula);
    }

    public static DatosEstudianteUsuarioResponse.DatosEstudianteUsuarioResult datosEstudianteUsuario(java.lang.String username) {
        ec.edu.espol.academico.webservices.WsSODIS service = new ec.edu.espol.academico.webservices.WsSODIS();
        ec.edu.espol.academico.webservices.WsSODISSoap port = service.getWsSODISSoap();
        return port.datosEstudianteUsuario(username);
    }

    public static DatosProfesionalCedulaResponse.DatosProfesionalCedulaResult datosProfesionalCedula(java.lang.String cedula) {
        ec.edu.espol.academico.webservices.WsSODIS service = new ec.edu.espol.academico.webservices.WsSODIS();
        ec.edu.espol.academico.webservices.WsSODISSoap port = service.getWsSODISSoap();
        return port.datosProfesionalCedula(cedula);
    }

    public static DatosProfesionalUsuarioResponse.DatosProfesionalUsuarioResult datosProfesionalUsuario(java.lang.String username) {
        ec.edu.espol.academico.webservices.WsSODIS service = new ec.edu.espol.academico.webservices.WsSODIS();
        ec.edu.espol.academico.webservices.WsSODISSoap port = service.getWsSODISSoap();
        return port.datosProfesionalUsuario(username);
    }

    public static DatosUsuarioResponse.DatosUsuarioResult datosUsuario(java.lang.String username) {
        ec.edu.espol.academico.webservices.WsSODIS service = new ec.edu.espol.academico.webservices.WsSODIS();
        ec.edu.espol.academico.webservices.WsSODISSoap port = service.getWsSODISSoap();
        return port.datosUsuario(username);
    }

    
}
