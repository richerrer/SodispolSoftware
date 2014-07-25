/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author usuario
 */
//@Named(value = "pacienteBean")
@Named
@Scope("view")
public class PacienteBean {
    
    @Inject
    private EstudianteBo estudianteBo;
    private Estudiante estudiante;
    private boolean encontrado = false;
    private String matricula;
    
    public PacienteBean() {
    }

    public EstudianteBo getEstudianteBo() {
        return estudianteBo;
    }
    
    public void setEstudianteBo(EstudianteBo estudianteBo) {
        this.estudianteBo = estudianteBo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
    public void consultar(){
        setEstudiante(null);
        setEstudiante(estudianteBo.getEstudianteByMatricula(getMatricula()));
        if(getEstudiante()!=null){
            this.encontrado = true;
        }
        else{
            this.encontrado = false;
        }
    }
    
    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        if(this.encontrado){
            addMessage("Si se encontro el paciente "+getEstudiante());
        }
        else{
            addMessage("No se encontro el paciente "+matricula);
        }
    }
    
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
