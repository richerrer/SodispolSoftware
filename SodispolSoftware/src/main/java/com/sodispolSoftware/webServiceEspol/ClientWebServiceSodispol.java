/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.webServiceEspol;


import com.webservicesodispol.WebServiceSodispol;
import com.webservicesodispol.WebServiceSodispol_Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.namespace.QName;

/**
 *
 * @author usuario
 */
public class ClientWebServiceSodispol {
    
    private String wsdl; // URL real del web service.
    
    private String service;  // copiado del código generado por wsimport
    
    private String name;

    public  String tipoUsuario(String usuario){
        try {
            WebServiceSodispol_Service unWebServiceService = new WebServiceSodispol_Service(
                    new URL(wsdl),new QName(service,name));
            WebServiceSodispol unWebService = unWebServiceService.getWebServiceSodispolPort();
           
            return unWebService.tipoUsuario(usuario);
        } catch (Exception ex) {
            return null;
        }
    }
    
    public  ArrayList datosEstudianteUsername(String username){
        try {
            WebServiceSodispol_Service unWebServiceService = new WebServiceSodispol_Service(
                    new URL(wsdl),new QName(service,name));
            WebServiceSodispol unWebService = unWebServiceService.getWebServiceSodispolPort();
           
            return (ArrayList)unWebService.datosEstudianteUsername(username);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    public  ArrayList datosEstudianteMatricula(String matricula){
        try {
            WebServiceSodispol_Service unWebServiceService = new WebServiceSodispol_Service(
                    new URL(wsdl),new QName(service,name));
            WebServiceSodispol unWebService = unWebServiceService.getWebServiceSodispolPort();
           
            return (ArrayList)unWebService.datosEstudianteMatricula(matricula);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    public  ArrayList datosEstudianteCedula(String cedula){
        try {
            WebServiceSodispol_Service unWebServiceService = new WebServiceSodispol_Service(
                    new URL(wsdl),new QName(service,name));
            WebServiceSodispol unWebService = unWebServiceService.getWebServiceSodispolPort();
           
            return (ArrayList)unWebService.datosEstudianteCedula(cedula);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    public  ArrayList datosProfesionalUsername(String username){
        try {
            WebServiceSodispol_Service unWebServiceService = new WebServiceSodispol_Service(
                    new URL(wsdl),new QName(service,name));
            WebServiceSodispol unWebService = unWebServiceService.getWebServiceSodispolPort();
           
            return (ArrayList)unWebService.datosProfesionalUsername(username);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    public  ArrayList datosProfesionalCedula(String cedula){
        try {
            WebServiceSodispol_Service unWebServiceService = new WebServiceSodispol_Service(
                    new URL(wsdl),new QName(service,name));
            WebServiceSodispol unWebService = unWebServiceService.getWebServiceSodispolPort();
           
            return (ArrayList)unWebService.datosProfesionalCedula(cedula);
        } catch (Exception ex) {
            return null;
        }
        
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
