package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Este bean mantiene todos los objetos relacionados con la Ficha del Estudiante
 * que ha sido buscado por el Doctor.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("view")
public class FichaEstudianteBean {

    private EstudianteBo estudianteBo;

    private Estudiante estudiante;

    private String paramBusqueda;

    private String tipoBusqueda;
    
    private Fichamedicaestudiante fichaMedica;

    /**
     * Get the value of fichaMedica
     *
     * @return the value of fichaMedica
     */
    public Fichamedicaestudiante getFichaMedica() {
        return fichaMedica;
    }

    /**
     * Set the value of fichaMedica
     *
     * @param fichaMedica new value of fichaMedica
     */
    public void setFichaMedica(Fichamedicaestudiante fichaMedica) {
        this.fichaMedica = fichaMedica;
    }


    private Map<String, String> parametros = FacesContext.getCurrentInstance().
            getExternalContext().getRequestParameterMap();

    /**
     * Constructor del bean, el cual se encarga de obtener al Estudiante según 
     * su matrícula o cédula, los cuales dependen del tipo de busqueda
     *
     * @param estudianteBo Maneja la lógica de negocio del Estudiante
     */
    @Inject
    public FichaEstudianteBean(EstudianteBo estudianteBo) {
        setEstudianteBo(estudianteBo);
        setTipoBusqueda(getParametros().get("tipoBusqueda"));
        setParamBusqueda(getParametros().get("paramBusqueda"));
        if (getTipoBusqueda().equals("matricula")) {
            setEstudiante(getEstudianteBo().getEstudianteByMatricula(getParamBusqueda()));
        }
        if (getTipoBusqueda().equals("cedula")) {
            setEstudiante(getEstudianteBo().getEstudianteByCedula(getParamBusqueda()));
        }
        setFichaMedica(getEstudianteBo().getFichaMedica(getEstudiante()));

    }

    /**
     * Get the value of tipoBusqueda
     *
     * @return the value of tipoBusqueda
     */
    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    /**
     * Set the value of tipoBusqueda
     *
     * @param tipoBusqueda new value of tipoBusqueda
     */
    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    /**
     * Get the value of paramBusqueda
     *
     * @return the value of paramBusqueda
     */
    public String getParamBusqueda() {
        return paramBusqueda;
    }

    /**
     * Set the value of paramBusqueda
     *
     * @param paramBusqueda new value of paramBusqueda
     */
    public void setParamBusqueda(String paramBusqueda) {
        this.paramBusqueda = paramBusqueda;
    }

    /**
     * Get the value of estudiante
     *
     * @return the value of estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Set the value of estudiante
     *
     * @param estudiante new value of estudiante
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Get the value of estudianteBo
     *
     * @return the value of estudianteBo
     */
    public EstudianteBo getEstudianteBo() {
        return estudianteBo;
    }

    /**
     * Set the value of estudianteBo
     *
     * @param estudianteBo new value of estudianteBo
     */
    public void setEstudianteBo(EstudianteBo estudianteBo) {
        this.estudianteBo = estudianteBo;
    }

    /**
     * Get the value of estudianteBo
     *
     * @return the value of parametros (los cuales son añadidos desde cualquier
     * página .xhtml)
     */
    public Map<String, String> getParametros() {
        return parametros;
    }
    
    public String guardar(ActionEvent actionEvent){
        getEstudianteBo().updateEstudiante(getEstudiante());
        if(getFichaMedica().getIdfichamedica() == 0)// Si la ficha es recién creada
        {
            getEstudianteBo().addFichaMedica(getEstudiante(), getFichaMedica());
        }
        else{
            getEstudianteBo().updateFichaMedica(getEstudiante(), getFichaMedica());
        }
        return "succes.xhmtl";
    }
    
}
