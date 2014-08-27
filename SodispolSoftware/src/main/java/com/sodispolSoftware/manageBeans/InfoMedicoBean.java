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
public class InfoMedicoBean {

    private ArrayList<Doctor> listaDoctores;

    @Inject
    private DoctorBo doctorBo;

    @Inject
    private UsuarioBean usuarioBean;
    
    @PostConstruct
    public void init() {
        loadDoctores();
    }

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public DoctorBo getDoctorBo() {
        return doctorBo;
    }

    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    public void loadDoctores()
    {
        ArrayList<Doctor> doctores = getDoctorBo().getAllDoctors();
        setListaDoctores(doctores);
        //return "";
    }


}
