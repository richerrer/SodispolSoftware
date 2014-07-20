/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */
@ManagedBean
@ViewScoped
public class Ejemplo2 {
    Map<String, String> parametros =FacesContext.getCurrentInstance().
                   getExternalContext().getRequestParameterMap();
    private long modificador;
    private String matricula;
    
    public Ejemplo2() {
        modificador=Long.parseLong(parametros.get("modificador"));
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    
    public long getModificador() {
        return modificador;
    }

    public void setModificador(long modificador) {
        this.modificador = modificador;
    }
    
}
