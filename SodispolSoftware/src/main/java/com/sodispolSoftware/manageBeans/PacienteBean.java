package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Estudiante;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;

/**
 * Este bean mantiene el paciente consultado por el Doctor.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("view")
public class PacienteBean {

    @Inject
    private EstudianteBo estudianteBo;

    @Inject
    private UsuarioBean usuarioBean;

    private Estudiante estudiante;

    private boolean encontrado = false;

    private String paramBusqueda;

    private String tipoBusqueda = "matricula";

    /**
     * Dependiendo del tipo de búsqueda, se busca al Estudiante por matrícula o
     * cédula.
     */
    public void consultar() {
        setEstudiante(null);
        if (getTipoBusqueda().equals("matricula")) {
            setEstudiante(getEstudianteBo().getEstudianteByMatricula(getParamBusqueda()));
            setEncontrado(getEstudiante() != null);
        }
        if (getTipoBusqueda().equals("cedula")) {
            setEstudiante(getEstudianteBo().getEstudianteByCedula(getParamBusqueda()));
            setEncontrado(getEstudiante() != null);
        }
        getUsuarioBean().setEstudiantePaciente(getEstudiante());
        //HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //origRequest.setAttribute("estudiante", getEstudiante() );

    }

    /**
     * Dependiendo de si se encontró al estudiante, se añade un tipo de mensaje.
     *
     * @param actionEvent
     */
    public void buttonAction(ActionEvent actionEvent) {
        if (isEncontrado()) {
            addMessage("Si se encontro el paciente " + getEstudiante());
        } else {
            addMessage("No se encontro el paciente " + getParamBusqueda());
        }
    }

    /**
     * Se añade el mensaje al objeto growl.
     *
     * @param mensaje
     */
    public void addMessage(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Get the value of usuarioBean
     *
     * @return the value of usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * Set the value of usuarioBean
     *
     * @param usuarioBean new value of usuarioBean
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * Get the value of tipoBusqueda
     *
     * @return the value of tipoBusqueda (matricula o cedula)
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
     * Get the value of encontrado
     *
     * @return the value of encontrado
     */
    public boolean isEncontrado() {
        return encontrado;
    }

    /**
     * Set the value of encontrado
     *
     * @param encontrado new value of encontrado
     */
    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
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

}
