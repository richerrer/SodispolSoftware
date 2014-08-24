/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.redirect.Redireccionar;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author usuario
 */
@Named
@Scope("view")
public class AgregarDoctores {

    private ArrayList<Doctor> listaUsuarios;

    private Doctor selectUsuario;

    @Inject
    private DoctorBo doctorBo;

    @Inject
    private UsuarioBean usuarioBean;

    private String username;

    private Date horaEntrada;

    private Date horaSalida;

    /**
     * Se ejecuta despues del Constructor del bean, el cual se encarga de
     * inicializar los parámetros.
     */
    @PostConstruct
    public void init() {

    }

    public ArrayList<Doctor> getListaUsuarios() {
        return getDoctorBo().getAllDoctors();
    }

    public Doctor getSelectUsuario() {
        return selectUsuario;
    }

    public void setSelectUsuario(Doctor selectUsuario) {
        this.selectUsuario = selectUsuario;
    }

    public DoctorBo getDoctorBo() {
        return doctorBo;
    }

    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public void agregarDoctor(ActionEvent actionEvent) {
        String msg;
        boolean succesGeneral = true;
        boolean succesUsername = getDoctorBo().verifyUsername(username);
        boolean succesTimes = getDoctorBo().verifyTimes(horaEntrada, horaSalida);
        Doctor doctor;

        if (!succesUsername) {
            msg = "Error el username no se encuentra en la base de ESPOL o no es de tipo Profesional";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            succesGeneral = false;
        }
        if (!succesTimes && succesGeneral) {
            msg = "Error la hora de entrada debe de ser antes que la hora de salida";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            succesGeneral = false;
        }

        if (succesGeneral) {
            boolean succes, succesStateDelete;
            doctor = new Doctor();
            doctor.setUsername(username);
            doctor.setHoraentrada(horaEntrada);
            doctor.setHorasalida(horaSalida);
            doctor.setEstadoborrado(false);

            succes = getDoctorBo().addDoctor(doctor);

            if (succes) {
                msg = "El doctor se creó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                succesStateDelete = getDoctorBo().changeStateDeleteDoctor(doctor);
                /*Si el usuario que se esta creando ya se encuentra en la base, pero en estado borrado
                 *se lo habilita nuevamente
                 */
                if (succesStateDelete) {
                    msg = "El doctor se creó correctamente";
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
        horaEntrada = null;
        horaSalida = null;
    }

    public void modificarDoctor(ActionEvent actionEvent) {
        String msg;
        boolean succesGeneral = true;
        boolean succesUsername = getDoctorBo().verifyUsername(getSelectUsuario().getUsername());
        boolean succesTimes = getDoctorBo().verifyTimes(getSelectUsuario().getHoraentrada(), getSelectUsuario().getHorasalida());
        Doctor doctor;

        if (!succesUsername) {
            msg = "Error el username no se encuentra en la base de ESPOL o no es de tipo Profesional";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            succesGeneral = false;
        }
        if (!succesTimes && succesGeneral) {
            msg = "Error la hora de entrada debe de ser antes que la hora de salida";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            succesGeneral = false;
        }

        if (succesGeneral) {
            boolean succes;

            succes = getDoctorBo().updateDoctor(getSelectUsuario());

            if (succes) {
                msg = "El doctor se modificó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                msg = "Error el username ya se encuentra en la base de datos";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        username = null;
        horaEntrada = null;
        horaSalida = null;

    }

    public void eliminarDoctor(ActionEvent actionEvent) {
        String msg;
        boolean succes;

        if (!getSelectUsuario().getUsername().equals(getUsuarioBean().getDoctor().getUsername())) {
            succes = getDoctorBo().eliminarDoctor(getSelectUsuario());

            if (succes) {
                msg = "El doctor se eliminó correctamente";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                msg = "Error el doctor no se eliminó correctamente";
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
