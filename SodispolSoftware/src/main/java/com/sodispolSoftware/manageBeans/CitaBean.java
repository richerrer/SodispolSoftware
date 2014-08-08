/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.CitaBo;
import com.sodispolSoftware.model.Citamedica;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Jose
 */
@Named
@Scope("view")
public class CitaBean {
    
    //@Inject
    private CitaBo citaBo;
    
    
    private UsuarioBean usuarioBean;
    
    private ArrayList<Object[]> citas;
    private String pac="Jose PEPE";
    private String ncita;

    @Inject
    public CitaBean(CitaBo citaBo,UsuarioBean usuarioBean)
    {
        setUsuarioBean(usuarioBean);
        setCitaBo(citaBo);
        //setNcita(getUsuarioBean().getDoctor().getCitamedicas().iterator().next().getFechareg().toString());
        setNcita(getUsuarioBean().getDoctor().getApellido1());
    }

    public String getNcita() {
        return ncita;
    }

    public void setNcita(String ncita) {
        this.ncita = ncita;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public ArrayList<Object[]> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Object[]> citas) {
        this.citas = citas;
    }
    
    public CitaBo getCitaBo() {
        return citaBo;
    }

    public void setCitaBo(CitaBo citaBo) {
        this.citaBo = citaBo;
    }

    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }
    
    public String NNams()
    {
        ArrayList<Object[]> citasM;
        citasM = getCitaBo().getCitas(getUsuarioBean().getDoctor());
        return citasM.get(0)[0].toString();
    } 
           
}
