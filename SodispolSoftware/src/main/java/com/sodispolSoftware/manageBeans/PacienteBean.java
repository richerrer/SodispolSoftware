/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author usuario
 */
@Named(value = "pacienteBean")
@SessionScoped
public class PacienteBean {

    private boolean encontrado = false;
    
    public PacienteBean() {
    }
    
    public void a(){
        this.encontrado = false;
    }
    
    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        if(this.encontrado){
            addMessage("Si se encontro el paciente");
        }
        else{
            addMessage("No se encontro el paciente");
        }
    }
    
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
