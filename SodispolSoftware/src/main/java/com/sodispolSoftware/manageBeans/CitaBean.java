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
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
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
        
    private ArrayList<Citamedica> citasCargadas = new ArrayList<Citamedica>();
    
    private ArrayList<Citamedica> citasDataTable = new ArrayList<Citamedica>();
  
    private boolean citaVacia;
    
    private Citamedica citaSeleccionada;
    
    private String nombreCompletoEstudiante;
    
    @Inject
    public CitaBean(CitaBo citaBo,UsuarioBean usuarioBean, EstudianteBo estudianteBo, DoctorBo doctorBo)
    {
        setUsuarioBean(usuarioBean);
        setCitaBo(citaBo);
        setEstudianteBo(estudianteBo);
        setDoctorBo(doctorBo);
        
        setFecha(Calendar.getInstance().getTime());
    }

    public String getNombreCompletoEstudiante() {
        return nombreCompletoEstudiante;
    }

    public void setNombreCompletoEstudiante(String nombreCompletoEstudiante) {
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
    }

    public Citamedica getCitaSeleccionada() {
        return citaSeleccionada;
    }

    public void setCitaSeleccionada(Citamedica citaSeleccionada) {
        this.citaSeleccionada = citaSeleccionada;
    }

    public boolean isCitaVacia() {
        return citaVacia;
    }

    public void setCitaVacia(boolean citaVacia) {
        this.citaVacia = citaVacia;
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
            setNombreCompletoEstudiante(getEstudiante().getNombre1()+" "+getEstudiante().getApellido1());
            setEncontrado(getEstudiante() != null);
        }
        if (getTipoBusqueda().equals("cedula")) {
            setEstudiante(getEstudianteBo().getEstudianteByCedula(getParamBusqueda()));
            setNombreCompletoEstudiante(getEstudiante().getNombre1()+" "+getEstudiante().getApellido1());
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
    
    public void consultarCitas() 
    {
        //setDoctor(null);
        
        getUsuarioBean().setDoctorConsulta(null);
        
        getUsuarioBean().setDoctorConsulta(getDoctorBo().getDoctor(doctorUsername));
        //setDoctor(getDoctorBo().getDoctor(doctorUsername));
        setDoctorSeleccionado(getUsuarioBean().getDoctorConsulta() != null);
        llenarCitasDataTable(1);
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
    
    public void newFechayHora(int dia, int mes, int anio, int hora, int minuto) 
    {
        fechaBase.set(Calendar.DATE, dia);
        fechaBase.set(Calendar.MONTH, mes);
        fechaBase.set(Calendar.YEAR, anio);
        fechaBase.set(Calendar.HOUR_OF_DAY, hora);
        fechaBase.set(Calendar.MINUTE, minuto);
    }
    
    /*
    *   @param tipoPagina 0 si la pagina de consulta es la del doctor logueado; 1 si es la pagina luego de alguna transaccion
    *
    */
    
    public Doctor obtenerDoctorRespectivo(int tipoPagina)
    {
        Doctor doctor = null;
        if(tipoPagina==0)
        {
            doctor = getUsuarioBean().getDoctor();
        }            
        if(tipoPagina==1)
        {
            doctor = getUsuarioBean().getDoctorConsulta();
        }
        return doctor;
    }
    
    public void llenarCitasCargadas(ArrayList<Citamedica> citasProvisional)
    {
        for(Citamedica cm : citasProvisional)
        {
            if((cm.getFechareg().getTime().getDate() == fecha.getDate()) && (cm.getFechareg().getTime().getMonth() == fecha.getMonth()) && ((cm.getFechareg().getTime().getYear()) == fecha.getYear()))
            {
                setOcupacionEstudiante(cm.getEstudiante());
                citasCargadas.add(cm);
            }
        }
    }
    
    
    public void agregarCitaEncontrada(Citamedica cm2, int horaInicio, int minutoInicio, int horaFin, int minutoFin)
    {
        Citamedica cita= cm2;
        agregarHoraACita(cita, horaInicio, minutoInicio, horaFin, minutoFin);
        cita.setVacio(false);
        citasDataTable.add(cita);
    }
    
    public void agregarCitaNoEncontrada(int horaInicio, int minutoInicio, int horaFin, int minutoFin)
    {
        setFechaBase(Calendar.getInstance());
        newFechayHora(fecha.getDate(), fecha.getMonth(), fecha.getYear()+1900, horaInicio, minutoInicio);
        Citamedica cita = new Citamedica(fechaBase);
        //int hora2= cita.getFechareg().get(Calendar.HOUR_OF_DAY);
        //int min2 = cita.getFechareg().get(Calendar.MINUTE);
        agregarHoraACita(cita, horaInicio, minutoInicio, horaFin, minutoFin);
        cita.setVacio(true);
        citasDataTable.add(cita);
    }
    
    public void vaciarListasCitas()
    {
        citasCargadas.removeAll(citasCargadas); 
        citasDataTable.removeAll(citasDataTable); 
    }
    
    public void llenarCitasDataTable(int tipoPagina)
    {
        Doctor doctorPagina = obtenerDoctorRespectivo(tipoPagina);    
        ArrayList<Citamedica> citasProvisional = getCitaBo().getCitasByDoctor(doctorPagina);
            
        vaciarListasCitas();
        
        llenarCitasCargadas(citasProvisional);
        
        int entrada = (doctorPagina.getHoraentrada().getHours() *60) + doctorPagina.getHoraentrada().getMinutes();
        int salida = (doctorPagina.getHorasalida().getHours() *60) + doctorPagina.getHorasalida().getMinutes();
        int numCitasDia = (salida - entrada)/15;
        
        for(int i=0; i<numCitasDia; i++)
        {
            int horaInicio = (entrada + (i*15))/60;
            int minutoInicio = (entrada + (i*15)) - (horaInicio*60);
            int horaFin = (entrada + (i*15) + 15)/60;
            int minutoFin = (entrada + (i*15) + 15) - (horaFin*60);
            boolean agregoCita = false;
            
            for(Citamedica cm2 : citasCargadas)
            {
                int hora1 =cm2.getFechareg().get(Calendar.HOUR_OF_DAY);
                int min1 = cm2.getFechareg().get(Calendar.MINUTE);
                //if((cm2.getFechareg().getTime().getHours()==horaInicio) && (cm2.getFechareg().getTime().getMinutes()==minutoInicio))
                if((hora1==horaInicio) && (min1==minutoInicio))
                {
                    agregarCitaEncontrada(cm2, horaInicio, minutoInicio, horaFin, minutoFin);
                    agregoCita = true;
                }
            }
            
            if(agregoCita == false)
            {
                agregarCitaNoEncontrada(horaInicio, minutoInicio, horaFin, minutoFin);
            }
                
        }
    }
    
    
    public void agregarHoraACita(Citamedica cita, int horaInicio, int minInicio, int horaFin, int minFin)
    {
        String horaInicioCita = obtenerHoraCorregida(horaInicio, minInicio);
        String horaFinCita = obtenerHoraCorregida(horaFin, minFin);
        
        cita.setHora(horaInicioCita+" - "+horaFinCita);
    }
    
    public String obtenerHoraCorregida(int hora, int minuto)
    {
         String horaCita = "";
//        if((hora<10) && (minuto<10))
//            horaCita = "0"+Integer.toString(hora)+":"+"0"+Integer.toString(minuto);
//        if((hora<10) && (minuto>=10))
//            horaCita = "0"+Integer.toString(hora)+":"+Integer.toString(minuto);
        if(minuto<10)
            horaCita = Integer.toString(hora)+":"+"0"+Integer.toString(minuto);
        else
            horaCita = Integer.toString(hora)+":"+Integer.toString(minuto);
        
        return horaCita;
    }
    
    public void setOcupacionEstudiante(Estudiante est)
    {
        String rolUser = est.getRoleuser().getDescripcion();
        
        if(rolUser.equals("ROLE_ESTUDIANTE"))
            est.setOcupacion("Estudiante");
        else
            est.setOcupacion("Profesional");        
    }
    
    public String verificarAccionDelBotonCrear()
    {        
        //if(citaSeleccionada.isVacio())
            return "PF('dlgCrearCita').show();";
        //return "PF('dlgErrorCrearCita').show();";
    }
    
    public String eliminarCita()
    {
        if(citaSeleccionada.isVacio())
        {
            addMessageByType("No existe ninguna cita que eliminar en este horario", 0);
        }
        else
        {
            getCitaSeleccionada().setEstadoborrado(true);
            getCitaBo().deleteCita(getCitaSeleccionada());      
            addMessageByType("La cita se eliminó correctamente.", 1);
        }
        return "citas.xhtml";        
    }
    
    public String guardarCita()
    {
        if(citaSeleccionada.isVacio())
        {
            Citamedica citaNueva = new Citamedica("P", getEstudiante(), false, getUsuarioBean().getDoctorConsulta(), citaSeleccionada.getFechareg(), citaSeleccionada.getFechareg());
            getCitaBo().addCita(citaNueva);
            addMessageByType("La cita se agregó correctamente.", 1);
        }
        else
        {
            addMessageByType("No se pudo agregar la cita, debido a que ya existe una en este horario", 0);
        }
        
        return "citas.xhtml";
    }
   
    public String atenderCita()
    {
        String nextPage = "";
        
        //if((citaSeleccionada.getEstadocita().equals("P")) && (citaSeleccionada.getFechareg().getTime().equals(Calendar.getInstance().getTime())))
        int d=Calendar.getInstance().get(Calendar.DATE);
        int m=Calendar.getInstance().get(Calendar.MONTH);
        int a=Calendar.getInstance().get(Calendar.YEAR);
        
        int d2=citaSeleccionada.getFechareg().get(Calendar.DATE);
        int m2 = citaSeleccionada.getFechareg().get(Calendar.MONTH);
        int a2=citaSeleccionada.getFechareg().get(Calendar.YEAR);
        
        if((d2==d) && (m2==m) && (a2==a))
        {
            nextPage = "observacion.xhtml";
        }
        else
        {
            addMessageByType("Operacion Fallida: La cita ya fue atendida, o no existe cita en este horario", 0);
        }
       
        return nextPage;
    }
    
    public String llenarDataTablePagina2()
    {
        //addMessage("Hola hola");
        llenarCitasDataTable(1);
        return getUsuarioBean().getDoctorConsulta().getApellido1();
    }
    
    /*
    
    *    @param tipo, es 1 si la transaccion es exitosa; o 0 si no lo es
    */
    
    public void addMessageByType(String msj, int tipo)
    {
        if(tipo==1)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msj, ""));
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, ""));
    }
    
    public String llenarDatatablePaginaCitasDoctor()
    {
        llenarCitasDataTable(0);
        return getUsuarioBean().getDoctor().getApellido1();
    }
}