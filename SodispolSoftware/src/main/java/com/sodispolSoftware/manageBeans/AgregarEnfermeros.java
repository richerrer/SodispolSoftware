/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.EnfermeroBo;
import com.sodispolSoftware.model.Enfermero;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;



/**
 *
 * @author usuario
 */
@Named
@Scope("view")
public class AgregarEnfermeros {

    private ArrayList<Enfermero> listaUsuarios;

    private Enfermero selectUsuario;

    @Inject
    private EnfermeroBo enfermeroBo;

    @Inject
    private UsuarioBean usuarioBean;

    private String username;

    /**
     * Se ejecuta despues del Constructor del bean, el cual se encarga de
     * inicializar los parámetros.
     */
    @PostConstruct
    public void init() {

    }

    public ArrayList<Enfermero> getListaUsuarios() {
        return getEnfermeroBo().getAllEnfermeros();
    }

    public void setListaUsuarios(ArrayList<Enfermero> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Enfermero getSelectUsuario() {
        return selectUsuario;
    }

    public void setSelectUsuario(Enfermero selectUsuario) {
        this.selectUsuario = selectUsuario;
    }

    public EnfermeroBo getEnfermeroBo() {
        return enfermeroBo;
    }

    public void setEnfermeroBo(EnfermeroBo enfermeroBo) {
        this.enfermeroBo = enfermeroBo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public void agregarEnfermero(ActionEvent actionEvent) {
        String msg;
        boolean succesGeneral = true;
        boolean succesUsername = getEnfermeroBo().verifyUsername(username);
        Enfermero enfermero;

        if (!succesUsername) {
            msg = "Error el username no se encuentra en la base de ESPOL o no es de tipo Profesional";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            succesGeneral = false;
        }
       
        if (succesGeneral) {
            boolean succes, succesStateDelete;
            enfermero = new Enfermero();
            enfermero.setUsername(username);
            enfermero.setEstadoborrado(false);

            succes = getEnfermeroBo().addEnfermero(enfermero);

            if (succes) {
                msg = "El enfermero se creó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                succesStateDelete = getEnfermeroBo().changeStateDeleteEnfermero(enfermero);
                /*Si el usuario que se esta creando ya se encuentra en la base, pero en estado borrado
                 *se lo habilita nuevamente
                 */
                if (succesStateDelete) {
                    msg = "El enfermero se creó correctamente";
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                } else {
                    msg = "Error el username ya se encuentra en la base de datos";
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            }
        }
        username = null;
    }

    public void modificarEnfermero(ActionEvent actionEvent) {
        String msg;
        boolean succesGeneral = true;
        boolean succesUsername = getEnfermeroBo().verifyUsername(getSelectUsuario().getUsername());
        Enfermero enfermero;

        if (!succesUsername) {
            msg = "Error el username no se encuentra en la base de ESPOL o no es de tipo Profesional";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            succesGeneral = false;
        }
        
        if (succesGeneral) {
            boolean succes;

            succes = getEnfermeroBo().updateEnfermero(getSelectUsuario());

            if (succes) {
                msg = "El enfermero se modificó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                msg = "Error el username ya se encuentra en la base de datos";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        username = null;

    }

    public void eliminarEnfermero(ActionEvent actionEvent) {
        String msg;
        boolean succes;

        if (!getSelectUsuario().getUsername().equals(getUsuarioBean().getDoctor().getUsername())) {
            succes = getEnfermeroBo().eliminarEnfermero(getSelectUsuario());

            if (succes) {
                msg = "El enfermero se eliminó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                msg = "Error el enfermero no se eliminó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

        } else {
            msg = "Error no se puede eliminar el usuario que se encuentra en sesión";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

}
