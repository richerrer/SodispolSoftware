/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.redirect.Redireccionar;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Este bean mantiene todos los detalles de una ficha medica de un estudiante.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("view")
public class DetallesFichaEstudianteBean {

    private UsuarioBean usuarioBean;
    
    private DoctorBo doctorBo;

    private Estudiante estudiante;

    private long numButtons = 1;

    private final int paginacion = 2000;
    
    private ArrayList<Detallefichaestudiante> detallesAnteriores;

    @Inject
    public DetallesFichaEstudianteBean(DoctorBo doctorBo,UsuarioBean usuarioBean) {
        inicializarParametros(doctorBo,usuarioBean);
        cargarEstudiante();
        getNumObservaciones();
        setDetallesAnteriores(getDoctorBo().getDetallesFicha(getEstudiante(),1,paginacion));
    }

    public void inicializarParametros(DoctorBo doctorBo,UsuarioBean usuarioBean) {
        
        setUsuarioBean(usuarioBean);
        setDoctorBo(doctorBo);
    }
    
    public void cargarEstudiante() {
        setEstudiante(getUsuarioBean().getEstudiantePaciente());
        if(getEstudiante()==null){Redireccionar.redirect("paciente.xhtml");}
    }
    
    public void getNumObservaciones(){
        long num = getDoctorBo().getNumObservaciones(getEstudiante());
        if((num%paginacion)==0){
            setNumButtons(num /paginacion);
        }else{
            setNumButtons((int)(num/paginacion)+1);
        }
    }
    
    public void paginarObservacionesAnteriores(int firstResult){
        setDetallesAnteriores(getDoctorBo().getDetallesFicha(getEstudiante(),firstResult,paginacion));
    }
    
    public ArrayList<Detallefichaestudiante> getDetallesAnteriores() {
        return detallesAnteriores;
    }

    public void setDetallesAnteriores(ArrayList<Detallefichaestudiante> detallesAnteriores) {
        this.detallesAnteriores = detallesAnteriores;
    }
    
    /**
     * Get the value of doctorBo
     *
     * @return the value of doctorBo
     */
    public DoctorBo getDoctorBo() {
        return doctorBo;
    }

    /**
     * Set the value of doctorBo
     *
     * @param doctorBo new value of doctorBo
     */
    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }
    
    /**
     * Get the value of numButtons
     *
     * @return the value of numButtons
     */
    public long getNumButtons() {
        return numButtons;
    }

    /**
     * Set the value of numButtons
     *
     * @param numButtons new value of numButtons
     */
    public void setNumButtons(long numButtons) {
        this.numButtons = numButtons;
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

    

    public int getPaginacion() {
        return paginacion;
    }

 
    
    
}
