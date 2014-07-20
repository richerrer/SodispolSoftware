/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Estudiante;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class FichaEstudianteBean {

     
     private EstudianteBo estudianteBo;
     private Estudiante estudiante;
     private String matricula;
     
     Map<String, String> parametros =FacesContext.getCurrentInstance().
                   getExternalContext().getRequestParameterMap();

     
    @Inject
    public FichaEstudianteBean(EstudianteBo estudianteBo) {
        this.estudianteBo = estudianteBo;
        matricula=parametros.get("matricula");
        estudiante = estudianteBo.getEstudiante(matricula);
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
    
    
    
}
