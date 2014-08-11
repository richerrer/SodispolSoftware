/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;


import com.sodispolSoftware.businessObject.CitaBo;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.redirect.Redireccionar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class CalendarioCitasBean implements Serializable {
    
    
    private CitaBo citaBo;
    private UsuarioBean usuarioBean;
    
    private ArrayList<Object[]> consultaCitas;
    private ArrayList<Citamedica> citasCargadas=new ArrayList<Citamedica>();
    
    private ScheduleModel eventModel;
    //private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    
    @Inject       
    public CalendarioCitasBean(CitaBo citaBo,UsuarioBean usuarioBean)
    {
        setUsuarioBean(usuarioBean);
        setCitaBo(citaBo);
        setConsultaCitas(getCitaBo().getCitas(getUsuarioBean().getDoctor()));
    }
    
    @PostConstruct
    public void init(){
        eventModel = new DefaultScheduleModel();        
        loadCitas();        
    }
    
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);//set random day of month
        
        return date.getTime();
    }
    
    public Date getInitialDate() {
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);
        return calendar.getTime();
    }
    
    public ScheduleModel getEventModel() {
        return eventModel;
    }
    
    /*public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }*/
    
    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        
        return calendar;
    }
    
    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);
        
        return t.getTime();
    }
    
    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);
        
        return t.getTime();
    }
    
    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);
        
        return t.getTime();
    }
    
    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);
        
        return t.getTime();
    }
    
    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);
        
        return t.getTime();
    }
    
    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);
        
        return t.getTime();
    }
    
    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);
        
        return t.getTime();
    
    }
    
    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);
        
        return t.getTime();
    }
    
    public ScheduleEvent getEvent() {
        return event;
    }
    
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
    
    public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
        
        event = new DefaultScheduleEvent();
    }
    
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        Redireccionar.redirect("citas.xhtml");
    }
    
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        com.sodispolSoftware.redirect.Redireccionar.redirect("citas.xhtml");
    }
    
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        
        addMessage(message);
    }
    
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        
        addMessage(message);
    }
    
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public CitaBo getCitaBo() {
        return citaBo;
    }

    public void setCitaBo(CitaBo citaBo) {
        this.citaBo = citaBo;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public ArrayList<Object[]> getConsultaCitas() {
        return consultaCitas;
    }

    public void setConsultaCitas(ArrayList<Object[]> consultaCitas) {
        this.consultaCitas = consultaCitas;
    }

    
    /*@
    @requires 1 <= dia && dia <= 31;
    @requires 1 <= mes && mes <= 12;
    @requires 1 <= hora && hora <= 12;
    @requires 0 <= minuto && minuto <= 59;
    @requires 0 <= ampm && ampm <= 1;
    @*/
    private Date newFechayHora(int dia, int mes, int anio, int hora, int minuto, int ampm) {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, ampm);
        t.set(Calendar.DATE, dia);
        //t.set(Calendar.DAY_OF_MONTH, dia);
        t.set(Calendar.MONTH, mes-1);
        t.set(Calendar.YEAR, anio);
        t.set(Calendar.HOUR, hora);
        t.set(Calendar.MINUTE, minuto);
        
        return t.getTime();
    }
    
    public void loadCitas()
    {
        for(Object[] obj : consultaCitas)
        {
            Estudiante est = (Estudiante) obj[0];
            String estadoCita = (String) obj[1];
            Calendar fechaReg = (Calendar) obj[2];
            Calendar fechaProg = (Calendar) obj[3];
            Long citaId = (Long) obj[4];
            //String prueba = (String) obj[1];
            DefaultScheduleEvent ev = new DefaultScheduleEvent("  ID:"+citaId+", Paciente:"+est.getUsername(), fechaReg.getTime(), fechaReg.getTime(),estadoCita);
            
            //ev.setId(prueba);
            citasCargadas.add(new Citamedica(citaId.longValue(), est, getUsuarioBean().getDoctor(), fechaReg, fechaProg));
            
            eventModel.addEvent(ev);
        }
        
    }
    
    public Citamedica getCitaSeleccionada(long id)
    {
        for(Citamedica cmd : citasCargadas)
        {
            if(cmd.getIdcita()==id)
                return cmd;
        }
        return null;
    }
    
    public void guardarModificacion(ActionEvent actionEvent)
    {
        long idCitaSeleccionada = Long.valueOf(event.getTitle().substring(5, (event.getTitle().lastIndexOf(","))-1));
        getCitaBo().updateCita(getCitaSeleccionada(idCitaSeleccionada));
    }
    
    
}