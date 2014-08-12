/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.CitaBo;
import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.redirect.Redireccionar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Jose
 */
@Named
@Scope("view")
public class CitaBean {
    
    //Inject
    private CitaBo citaBo;    
    //@Inject
    private UsuarioBean usuarioBean;
    
    private EstudianteBo estudianteBo;
    
    private DoctorBo doctorBo;
    
    private Estudiante estudiante;

    private boolean encontrado = false;

    private String paramBusqueda;

    private String tipoBusqueda = "matricula";
    
    private String paciente;
   
    //private Doctor doctor;
    private String doctorUsername;
    
    private Date fecha;
    
    private Calendar hora;
    
    private ArrayList<Doctor> consultaDoctores;
    
    private int numDoctores=-2;
    
    
    @Inject
    public CitaBean(CitaBo citaBo,UsuarioBean usuarioBean, EstudianteBo estudianteBo, DoctorBo doctorBo)
    {
        setUsuarioBean(usuarioBean);
        setCitaBo(citaBo);
        setEstudianteBo(estudianteBo);
        setDoctorBo(doctorBo);
        
        
        // setNumDoctores(consultaDoctores.size());
        //setNcita(getUsuarioBean().getDoctor().getCitamedicas().iterator().next().getFechareg().toString());
        //setNcita(getUsuarioBean().getDoctor().getApellido1());
        //setO(nnams2());
        //setNcita((String) nnams2()[0]);
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public ArrayList<Doctor> getConsultaDoctores() {
        return consultaDoctores;
    }

    public void setConsultaDoctores(ArrayList<Doctor> consultaDoctores) {
        this.consultaDoctores = consultaDoctores;
    }

    public int getNumDoctores() {
        return numDoctores;
    }

    public void setNumDoctores(int numDoctores) {
        this.numDoctores = numDoctores;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public DoctorBo getDoctorBo() {
        return doctorBo;
    }

    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public String getParamBusqueda() {
        return paramBusqueda;
    }

    public void setParamBusqueda(String paramBusqueda) {
        this.paramBusqueda = paramBusqueda;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
    
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    public CitaBo getCitaBo() {
        return citaBo;
    }

    public void setCitaBo(CitaBo citaBo) {
        this.citaBo = citaBo;
    }
/*
    public String nnams()
    {
        ArrayList<Object[]> citasM;
        //citasM = getCitaBo().getCitas(getUsuarioBean().getDoctor());
        //setO(citasM.get(0));
        setNum(getCitaBo().getncitas());
        
        return "";
    } */
   
           
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
        HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        origRequest.setAttribute("estudiante", getEstudiante() );

        loadDoctores();
                
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        if (isEncontrado()) {
            addMessage("Si se encontro el paciente " + getEstudiante());
        } else {
            addMessage("No se encontro el paciente " + getParamBusqueda());
        }
    }
    
    public void addMessage(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void loadDoctores()
    {        
        ArrayList<Doctor> doctores = getDoctorBo().getAllDoctors();
        setConsultaDoctores(doctores);
    }
    
    public String guardarCita()
    {
        //Calendar fechaCita = newFechayHora(fecha.getDate(), fecha.getMonth(), fecha.getYear(), fecha.getHours(), fecha.getMinutes());
        //Citamedica citaNueva = new Citamedica(estudiante, getDoctorBo().getDoctor(doctorUsername), fechaCita, fechaCita);
        //getCitaBo().addCita(citaNueva);
        return "succes.xhtml";
    }
    
    /*
    private Calendar newFechayHora(int dia, int mes, int anio, int hora, int minuto) {
        Calendar t = (Calendar) today().clone();
        //t.set(Calendar.AM_PM, ampm);
        t.set(Calendar.DATE, dia);
        //t.set(Calendar.DAY_OF_MONTH, dia);
        t.set(Calendar.MONTH, mes);
        t.set(Calendar.YEAR, anio);
        t.set(Calendar.HOUR, hora);
        t.set(Calendar.MINUTE, minuto);
        
        return t;
    }*/
    
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        
        return calendar;
    }
}