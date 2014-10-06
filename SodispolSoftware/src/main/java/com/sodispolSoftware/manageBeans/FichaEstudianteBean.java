package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import com.sodispolSoftware.redirect.Redireccionar;
import com.sun.faces.taglib.html_basic.CommandButtonTag;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class FichaEstudianteBean
{
  @Inject
  private UsuarioBean usuarioBean;
  @Inject
  private DoctorBo doctorBo;
  @Inject
  private EstudianteBo estudianteBo;
  private Estudiante estudiante;
  private Fichamedicaestudiante fichaMedica;
  private Calendar fechaActualCalendar;
  private ArrayList<Object[]> observacionesAnteriores;
  private ArrayList<Detallefichaestudiante> detallesAnteriores;
  private long numButtons = 1L;
  private final int paginacion = 5;
  private Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
  private long modificador;
  private Detallefichaestudiante detalleFicha;
  
  @PostConstruct
  public void init()
  {
    try
    {
      inicializarParametros();
      cargarEstudiante();
      cargarFichaMedicaEstudiante(getEstudiante());
      validarTipoFicha();
    }
    catch (NumberFormatException ex)
    {
      Redireccionar.redirect("pages/doctor/paciente.xhtml");
    }
    catch (NullPointerException ex)
    {
      Redireccionar.redirect("pages/doctor/paciente.xhtml");
    }
  }
  
  public void inicializarParametros()
  {
    setModificador(Long.parseLong((String)getParametros().get("modificador")));
    setFechaActualCalendar(Calendar.getInstance());
    this.detalleFicha = new Detallefichaestudiante();
  }
  
  public void cargarEstudiante()
  {
    setEstudiante(getUsuarioBean().getEstudiantePaciente());
    if (getEstudiante() == null) {
      Redireccionar.redirect("pages/all/home.xhtml");
    }
  }
  
  public void cargarFichaMedicaEstudiante(Estudiante estudiante)
  {
    setFichaMedica(getEstudianteBo().getFichaMedica(estudiante));
  }
  
  public void validarTipoFicha()
  {
    if (getModificador() == 1) {
      cargarTipoFicha1();
    } else {
      cargarTipoFicha2();
    }
  }
  
  public void cargarTipoFicha1()
  {
    getNumObservaciones();
    cargarDetallesFichaMedicaEstudiante(getEstudiante(), 1, paginacion);
  }
  
  public void cargarTipoFicha2()
  {
    long iddetalleFicha = Long.parseLong((String)getParametros().get("iddetalleFicha"));
    setDetalleFicha(getEstudianteBo().getDetalleFichaEstudiante(iddetalleFicha, getEstudiante()));
    setFechaActualCalendar(getDetalleFicha().getFecha());
  }
  
  public void cargarDetallesFichaMedicaEstudiante(Estudiante estudiante, int grupo, int paginacion)
  {
    setDetallesAnteriores(getDoctorBo().getDetallesFicha(estudiante, grupo, paginacion));
  }
  
  public void guardar(ActionEvent actionEvent)
  {
    guardarEstudiante();
    guardarFichaMedica();
    if (getModificador() == 1) {
      guardarDetalleFichaMedica();
    }
    String msg = "Se agregó correctamente la observación ";//+actionEvent.getComponent().getAttributes().get("value")
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", msg);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
  
  public void guardarEstudiante()
  {
    getEstudianteBo().updateEstudiante(getEstudiante());
  }
  
  public void guardarFichaMedica()
  {
    if (getFichaMedica().getIdfichamedica() == 0) {
      getEstudianteBo().addFichaMedica(getEstudiante(), getFichaMedica());
    } else {
      getEstudianteBo().updateFichaMedica(getEstudiante(), getFichaMedica());
    }
  }
  
  public void guardarDetalleFichaMedica()
  {
    cargarDatosDetalleFicha(this.detalleFicha);
    getDoctorBo().saveDetalleFichaEstudiante(this.detalleFicha);
  }
  
  public void cargarDatosDetalleFicha(Detallefichaestudiante detalleFicha)
  {
    detalleFicha.setDoctor(getUsuarioBean().getDoctor());
    detalleFicha.setFichamedicaestudiante(getFichaMedica());
    detalleFicha.setEstadoborrado(false);
    detalleFicha.setFecha(getFechaActualCalendar());
  }
  
  public void getNumObservaciones()
  {
    long num = getDoctorBo().getNumObservaciones(getEstudiante());
    if (num % paginacion == 0) {
      setNumButtons(num / paginacion);
    } else {
      setNumButtons((int)(num / paginacion) + 1);
    }
  }
  
  public void paginarObservacionesAnteriores(int grupo)
  {
    cargarDetallesFichaMedicaEstudiante(getEstudiante(), grupo, paginacion);
  }
  
  public Detallefichaestudiante getDetalleFicha()
  {
    return this.detalleFicha;
  }
  
  public void setDetalleFicha(Detallefichaestudiante detalleFicha)
  {
    this.detalleFicha = detalleFicha;
  }
  
  public long getModificador()
  {
    return this.modificador;
  }
  
  public void setModificador(long modificador)
  {
    this.modificador = modificador;
  }
  
  public long getNumButtons()
  {
    return this.numButtons;
  }
  
  public void setNumButtons(long numButtons)
  {
    this.numButtons = numButtons;
  }
  
  public ArrayList<Object[]> getObservacionesAnteriores()
  {
    return this.observacionesAnteriores;
  }
  
  public void setObservacionesAnteriores(ArrayList<Object[]> observacionesAnteriores)
  {
    this.observacionesAnteriores = observacionesAnteriores;
  }
  
  public UsuarioBean getUsuarioBean()
  {
    return this.usuarioBean;
  }
  
  public void setUsuarioBean(UsuarioBean usuarioBean)
  {
    this.usuarioBean = usuarioBean;
  }
  
  public DoctorBo getDoctorBo()
  {
    return this.doctorBo;
  }
  
  public void setDoctorBo(DoctorBo doctorBo)
  {
    this.doctorBo = doctorBo;
  }
  
  public Calendar getFechaActualCalendar()
  {
    return this.fechaActualCalendar;
  }
  
  public void setFechaActualCalendar(Calendar fechaActual)
  {
    this.fechaActualCalendar = fechaActual;
  }
  
  public Fichamedicaestudiante getFichaMedica()
  {
    return this.fichaMedica;
  }
  
  public void setFichaMedica(Fichamedicaestudiante fichaMedica)
  {
    this.fichaMedica = fichaMedica;
  }
  
  public Estudiante getEstudiante()
  {
    return this.estudiante;
  }
  
  public void setEstudiante(Estudiante estudiante)
  {
    this.estudiante = estudiante;
  }
  
  public EstudianteBo getEstudianteBo()
  {
    return this.estudianteBo;
  }
  
  public ArrayList<Detallefichaestudiante> getDetallesAnteriores()
  {
    return this.detallesAnteriores;
  }
  
  public void setDetallesAnteriores(ArrayList<Detallefichaestudiante> detallesAnteriores)
  {
    this.detallesAnteriores = detallesAnteriores;
  }
  
  public void setEstudianteBo(EstudianteBo estudianteBo)
  {
    this.estudianteBo = estudianteBo;
  }
  
  public Map<String, String> getParametros()
  {
    return this.parametros;
  }
}
