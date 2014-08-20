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

    private Doctor doctor;
    
    private boolean encontrado = false;
    
    private boolean doctorSeleccionado = false;

    private String paramBusqueda;

    private String tipoBusqueda = "matricula";
    
    private String paciente;
   
    //private Doctor doctor;
    private String doctorUsername;
    
    private Date fecha;
    
    private Calendar fechaBase=Calendar.getInstance();
    
    private ArrayList<Doctor> consultaDoctores;
    
    private int numDoctores=-2;
    
    private String nombrePaciente;
    
    private ArrayList<Citamedica> citasCargadas = new ArrayList<Citamedica>();
    
    private ArrayList<Citamedica> citasDataTable = new ArrayList<Citamedica>();
    
    @Inject
    public CitaBean(CitaBo citaBo,UsuarioBean usuarioBean, EstudianteBo estudianteBo, DoctorBo doctorBo)
    {
        setUsuarioBean(usuarioBean);
        setCitaBo(citaBo);
        setEstudianteBo(estudianteBo);
        setDoctorBo(doctorBo);
        
        setFecha(Calendar.getInstance().getTime());
    }

    public ArrayList<Citamedica> getCitasCargadas() {
        return citasCargadas;
    }

    public void setCitasCargadas(ArrayList<Citamedica> citasCargadas) {
        this.citasCargadas = citasCargadas;
    }

    public ArrayList<Citamedica> getCitasDataTable() {
        return citasDataTable;
    }

    public void setCitasDataTable(ArrayList<Citamedica> citasDataTable) {
        this.citasDataTable = citasDataTable;
    }

    public boolean isDoctorSeleccionado() {
        return doctorSeleccionado;
    }

    public void setDoctorSeleccionado(boolean doctorSeleccionado) {
        this.doctorSeleccionado = doctorSeleccionado;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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

    public Calendar getFechaBase() {
        return fechaBase;
    }

    public void setFechaBase(Calendar fechaBase) {
        this.fechaBase = fechaBase;
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
        setNombrePaciente(getEstudiante().getNombre1()+" "+getEstudiante().getApellido1());
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
    
    public void consultarCitas() 
    {
        setDoctor(null);

        setDoctor(getDoctorBo().getDoctor(doctorUsername));
        setDoctorSeleccionado(getDoctor() != null);
        llenarCitasDataTable();
    }
    /*
    public void buttonAction2(ActionEvent actionEvent) {
        if (isEncontrado()) {
            addMessage("Si se encontro el paciente " + getEstudiante());
        } else {
            addMessage("No se encontro el paciente " + getParamBusqueda());
        }
    }*/
    
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
        newFechayHora(fecha.getDate(), fecha.getMonth(), fecha.getYear()+1900, fecha.getHours(), fecha.getMinutes());
        Citamedica citaNueva = new Citamedica(estudiante, getDoctorBo().getDoctor(doctorUsername), fechaBase, fechaBase,"P",false);
        getCitaBo().addCita(citaNueva);
        return "succes.xhtml";
        
    }
    
    
    public void newFechayHora(int dia, int mes, int anio, int hora, int minuto) 
    {
        fechaBase.set(Calendar.DATE, dia);
        fechaBase.set(Calendar.MONTH, mes);
        fechaBase.set(Calendar.YEAR, anio);
        fechaBase.set(Calendar.HOUR, hora);
        fechaBase.set(Calendar.MINUTE, minuto);
    }
    
    public void llenarCitasDataTable()
    {
        //Calendar fechaProvisional = Calendar.getInstance();
        ArrayList<Citamedica> citasProvisional = getCitaBo().getAllCitas();
        citasCargadas.removeAll(citasCargadas); 
        citasDataTable.removeAll(citasDataTable); 
        
        for(Citamedica cm : citasProvisional)
        {
            if((cm.getFechareg().getTime().getDate() == fecha.getDate()) && (cm.getFechareg().getTime().getMonth() == fecha.getMonth()) && ((cm.getFechareg().getTime().getYear()) == fecha.getYear()))
            {
                citasCargadas.add(cm);
            }
        }
        int entrada = (getDoctor().getHoraentrada().getHours() *60) + getDoctor().getHoraentrada().getMinutes();
        int salida = (getDoctor().getHorasalida().getHours() *60) + getDoctor().getHorasalida().getMinutes();
        int numCitasDia = (salida - entrada)/15;
        
        for(int i=0; i<numCitasDia; i++)
        {
            int horaInicio = (entrada + (i*15))/60;
            int minutoInicio = (entrada + (i*15)) - (horaInicio*60);
            int horaFin = (entrada + (i*15) + 15)/60;
            int minutoFin = (entrada + (i*15) + 15) - (horaFin*60);
            boolean agregoCita = false;
//*********************************************************************************
//             ESTA MAL XQ SOLO VERIFICA EL PRIMERO ELEMENTO DE CITASCARGADAS
//**************************************************************************************
            
            
            
            
            for(Citamedica cm2 : citasCargadas)
            {
                int hora1 =cm2.getFechareg().get(Calendar.HOUR_OF_DAY);
                int min1 = cm2.getFechareg().get(Calendar.MINUTE);
                //if((cm2.getFechareg().getTime().getHours()==horaInicio) && (cm2.getFechareg().getTime().getMinutes()==minutoInicio))
                if((hora1==horaInicio) && (min1==minutoInicio))
                {
                    Citamedica cita= citasCargadas.get(i);
                    int hora2= cita.getFechareg().get(Calendar.HOUR_OF_DAY);
                    int min2 = cita.getFechareg().get(Calendar.MINUTE);
                    citasDataTable.add(cita);
                    agregoCita = true;
                    //break;
                }
            }
            if(agregoCita = false)
            {
                setFechaBase(Calendar.getInstance());
                newFechayHora(fecha.getDate(), fecha.getMonth(), fecha.getYear()+1900, horaInicio, minutoInicio);
                Citamedica cita = new Citamedica(fechaBase);
                int hora2= cita.getFechareg().get(Calendar.HOUR_OF_DAY);
                int min2 = cita.getFechareg().get(Calendar.MINUTE);
                citasDataTable.add(cita);
            }
                
        }
    }
    
}