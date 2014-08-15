package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import com.sodispolSoftware.redirect.Redireccionar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Este bean mantiene todos los objetos relacionados con la Ficha del Estudiante
 * que ha sido buscado por el Doctor.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("view")
public class FichaEstudianteBean {

    @Inject
    private UsuarioBean usuarioBean;
    
    @Inject
    private DoctorBo doctorBo;
    
    @Inject
    private EstudianteBo estudianteBo;

    private Estudiante estudiante;

    private Fichamedicaestudiante fichaMedica;

    private Calendar fechaActualCalendar;

    private Double estatura;

    private String examenPiel;

    private String aparatoRespiratorio;

    private String aparatoCirculatorio;

    private String pulso;

    private String ruidosCardiacos;

    private String aparatoDigestivo;

    private String aparatoUrinario;

    private String sistemaLinfatico;

    private String sistemaNervioso;

    private String observacion;

    private Double peso;

    private String temperatura;

    private ArrayList<Object[]> observacionesAnteriores;

    private ArrayList<Detallefichaestudiante> detallesAnteriores;

    private long numButtons = 1;

    private final int paginacion = 15;

    private Map<String, String> parametros = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

    private long modificador;

    private Detallefichaestudiante detalleFicha;

    /**
     * Se ejecuta despues del Constructor del bean, el cual se encarga de inicializar los 
     * parámetros.
     */
    @PostConstruct
    public void init() {
        try {
            inicializarParametros();
            cargarEstudiante();
            cargarFichaMedicaEstudiante(getEstudiante());
            validarTipoFicha();
        }catch (NumberFormatException ex) {//Si alguno de los parametros "modificador" o "iddetalleFicha"(si es que se lo usa) y no han sido seteados, hay una redireccion 
            Redireccionar.redirect("paciente.xhtml");
        }catch (NullPointerException ex) {
            Redireccionar.redirect("paciente.xhtml");
        }
    }

    public void inicializarParametros() {
        setModificador(Long.parseLong(getParametros().get("modificador")));
        setFechaActualCalendar(Calendar.getInstance());
    }

    public void cargarEstudiante() {
        setEstudiante(getUsuarioBean().getEstudiantePaciente());
        if(getEstudiante()==null){Redireccionar.redirect("paciente.xhtml");}
    }

    public void cargarFichaMedicaEstudiante(Estudiante estudiante) {
        setFichaMedica(getEstudianteBo().getFichaMedica(estudiante));
        /*ArrayList<Fichamedicaestudiante> fichas = new ArrayList<Fichamedicaestudiante>(estudiante.getFichamedicaestudiantes());
        for(Fichamedicaestudiante f: fichas){
            setFichaMedica(f);
        }
        if(getFichaMedica()==null){setFichaMedica(new Fichamedicaestudiante());}*/
    }
    
    public void cargarDetallesFichaMedicaEstudiante(Fichamedicaestudiante fichaEstudiante) {
        setDetallesAnteriores(getDoctorBo().getDetallesFicha(getEstudiante(), 1, paginacion));
        
    }

    public void validarTipoFicha() {
        if (getModificador() == 1) {//Si se va a crear un nuevo detalle de ficha medica
            getNumObservaciones();
            cargarDetallesFichaMedicaEstudiante(getFichaMedica());
        } 
        else {//Si solo se va a cargar un detalle de ficha estudiante
            long iddetalleFicha = Long.parseLong(getParametros().get("iddetalleFicha"));
            setDetalleFicha(getEstudianteBo().getDetalleFichaEstudiante(iddetalleFicha,getEstudiante()));
            setFechaActualCalendar(getDetalleFicha().getFecha());
        }
    }

    public String guardar(ActionEvent actionEvent) {
        guardarEstudiante();
        guardarFichaMedica();
        if (getModificador() == 1) {
            guardarDetalleFichaMedica();
        }

        return "succes.xhmtl";
    }

    public void guardarEstudiante() {
         
        getEstudianteBo().updateEstudiante(getEstudiante());
    }

    public void guardarFichaMedica() {
        if (getFichaMedica().getIdfichamedica() == 0)// Si la ficha es recién creada
        {
            getEstudianteBo().addFichaMedica(getEstudiante(), getFichaMedica());
        } else {
            getEstudianteBo().updateFichaMedica(getEstudiante(), getFichaMedica());
        }
    }

    public void guardarDetalleFichaMedica() {
        Detallefichaestudiante detalle = new Detallefichaestudiante();
        cargarDatosDetalleFicha(detalle);
        getDoctorBo().saveDetalleFichaEstudiante(detalle);
    }

    public void cargarDatosDetalleFicha(Detallefichaestudiante detalle) {
        detalle.setEstadoborrado(false);
        detalle.setFichamedicaestudiante(getFichaMedica());
        detalle.setFecha(getFechaActualCalendar());
        detalle.setDoctor(getUsuarioBean().getDoctor());
        detalle.setEstatura(getEstatura());
        detalle.setPeso(getPeso());
        detalle.setExamenpiel(getExamenPiel());
        detalle.setAparatorespiratorio(getAparatoRespiratorio());
        detalle.setApartocirculatorio(getAparatoCirculatorio());
        detalle.setPulso(getPulso());
        detalle.setRuidoscardiacos(getRuidosCardiacos());
        detalle.setAparatodigestivo(getAparatoDigestivo());
        detalle.setAparatogenicourinario(getAparatoUrinario());
        detalle.setSitemalinfatico(getSistemaLinfatico());
        detalle.setSistemanervioso(getSistemaNervioso());
        detalle.setTemperatura(getTemperatura());
        detalle.setPresionarterial(getPresionArterial());
        detalle.setObservaciones(getObservacion());
    }

    public void getNumObservaciones() {
        long num = getDoctorBo().getNumObservaciones(getEstudiante());
        if ((num % paginacion) == 0) {
            setNumButtons(num / paginacion);
        } else {
            setNumButtons((int) (num / paginacion) + 1);
        }
    }

    public void paginarObservacionesAnteriores(int firstResult) {
        //setObservacionesAnteriores(getDoctorBo().getObservaciones(getEstudiante(),firstResult,paginacion));
        setDetallesAnteriores(getDoctorBo().getDetallesFicha(getEstudiante(), firstResult, paginacion));
    }

    /**
     * Get the value of detalleFicha
     *
     * @return the value of detalleFicha
     */
    public Detallefichaestudiante getDetalleFicha() {
        return detalleFicha;
    }

    /**
     * Set the value of detalleFicha
     *
     * @param detalleFicha new value of detalleFicha
     */
    public void setDetalleFicha(Detallefichaestudiante detalleFicha) {
        this.detalleFicha = detalleFicha;
    }

    /**
     * Get the value of modificador
     *
     * @return the value of modificador
     */
    public long getModificador() {
        return modificador;
    }

    /**
     * Set the value of modificador
     *
     * @param modificador new value of modificador
     */
    public void setModificador(long modificador) {
        this.modificador = modificador;
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
     * Get the value of ObservacionesAnteriores
     *
     * @return the value of ObservacionesAnteriores
     */
    public ArrayList<Object[]> getObservacionesAnteriores() {
        return observacionesAnteriores;
    }

    /**
     * Set the value of observacionesAnteriores
     *
     * @param observacionesAnteriores new value of observacionesAnteriores
     */
    public void setObservacionesAnteriores(ArrayList<Object[]> observacionesAnteriores) {
        this.observacionesAnteriores = observacionesAnteriores;
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
     * Get the value of temperatura
     *
     * @return the value of temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * Set the value of temperatura
     *
     * @param temperatura new value of temperatura
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
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
     * Get the value of observacion
     *
     * @return the value of observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * Set the value of observacion
     *
     * @param observacion new value of observacion
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * Get the value of peso
     *
     * @return the value of peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * Set the value of peso
     *
     * @param peso new value of peso
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * Get the value of sistemaNervioso
     *
     * @return the value of sistemaNervioso
     */
    public String getSistemaNervioso() {
        return sistemaNervioso;
    }

    /**
     * Set the value of sistemaNervioso
     *
     * @param sistemaNervioso new value of sistemaNervioso
     */
    public void setSistemaNervioso(String sistemaNervioso) {
        this.sistemaNervioso = sistemaNervioso;
    }

    /**
     * Get the value of sistemaLinfatico
     *
     * @return the value of sistemaLinfatico
     */
    public String getSistemaLinfatico() {
        return sistemaLinfatico;
    }

    /**
     * Set the value of sistemaLinfatico
     *
     * @param sistemaLinfatico new value of sistemaLinfatico
     */
    public void setSistemaLinfatico(String sistemaLinfatico) {
        this.sistemaLinfatico = sistemaLinfatico;
    }

    /**
     * Get the value of aparatoUrinario
     *
     * @return the value of aparatoUrinario
     */
    public String getAparatoUrinario() {
        return aparatoUrinario;
    }

    /**
     * Set the value of aparatoUrinario
     *
     * @param aparatoUrinario new value of aparatoUrinario
     */
    public void setAparatoUrinario(String aparatoUrinario) {
        this.aparatoUrinario = aparatoUrinario;
    }

    /**
     * Get the value of aparatoDigestivo
     *
     * @return the value of aparatoDigestivo
     */
    public String getAparatoDigestivo() {
        return aparatoDigestivo;
    }

    /**
     * Set the value of aparatoDigestivo
     *
     * @param aparatoDigestivo new value of aparatoDigestivo
     */
    public void setAparatoDigestivo(String aparatoDigestivo) {
        this.aparatoDigestivo = aparatoDigestivo;
    }

    /**
     * Get the value of radiosCardiacos
     *
     * @return the value of radiosCardiacos
     */
    public String getRuidosCardiacos() {
        return ruidosCardiacos;
    }

    /**
     * Set the value of radiosCardiacos
     *
     * @param ruidosCardiacos new value of radiosCardiacos
     */
    public void setRuidosCardiacos(String ruidosCardiacos) {
        this.ruidosCardiacos = ruidosCardiacos;
    }

    /**
     * Get the value of pulso
     *
     * @return the value of pulso
     */
    public String getPulso() {
        return pulso;
    }

    /**
     * Set the value of pulso
     *
     * @param pulso new value of pulso
     */
    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    private String presionArterial;

    /**
     * Get the value of presionArterial
     *
     * @return the value of presionArterial
     */
    public String getPresionArterial() {
        return presionArterial;
    }

    /**
     * Set the value of presionArterial
     *
     * @param presionArterial new value of presionArterial
     */
    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    /**
     * Get the value of aparatoCirculatorio
     *
     * @return the value of aparatoCirculatorio
     */
    public String getAparatoCirculatorio() {
        return aparatoCirculatorio;
    }

    /**
     * Set the value of aparatoCirculatorio
     *
     * @param aparatoCirculatorio new value of aparatoCirculatorio
     */
    public void setAparatoCirculatorio(String aparatoCirculatorio) {
        this.aparatoCirculatorio = aparatoCirculatorio;
    }

    /**
     * Get the value of aparatoRespiratorio
     *
     * @return the value of aparatoRespiratorio
     */
    public String getAparatoRespiratorio() {
        return aparatoRespiratorio;
    }

    /**
     * Set the value of aparatoRespiratorio
     *
     * @param aparatoRespiratorio new value of aparatoRespiratorio
     */
    public void setAparatoRespiratorio(String aparatoRespiratorio) {
        this.aparatoRespiratorio = aparatoRespiratorio;
    }

    /**
     * Get the value of examenPiel
     *
     * @return the value of examenPiel
     */
    public String getExamenPiel() {
        return examenPiel;
    }

    /**
     * Set the value of examenPiel
     *
     * @param examenPiel new value of examenPiel
     */
    public void setExamenPiel(String examenPiel) {
        this.examenPiel = examenPiel;
    }

    /**
     * Get the value of estatura
     *
     * @return the value of estatura
     */
    public Double getEstatura() {
        return estatura;
    }

    /**
     * Set the value of estatura
     *
     * @param estatura new value of estatura
     */
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    /**
     * Get the value of fechaActual
     *
     * @return the value of fechaActual
     */
    public Calendar getFechaActualCalendar() {
        return fechaActualCalendar;
    }

    /**
     * Set the value of fechaActual
     *
     * @param fechaActual new value of fechaActual
     */
    public void setFechaActualCalendar(Calendar fechaActual) {
        this.fechaActualCalendar = fechaActual;
    }

    /**
     * Get the value of fichaMedica
     *
     * @return the value of fichaMedica
     */
    public Fichamedicaestudiante getFichaMedica() {
        return fichaMedica;
    }

    /**
     * Set the value of fichaMedica
     *
     * @param fichaMedica new value of fichaMedica
     */
    public void setFichaMedica(Fichamedicaestudiante fichaMedica) {
        this.fichaMedica = fichaMedica;
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

    /**
     * Get the value of estudianteBo
     *
     * @return the value of estudianteBo
     */
    public EstudianteBo getEstudianteBo() {
        return estudianteBo;
    }

    public ArrayList<Detallefichaestudiante> getDetallesAnteriores() {
        return detallesAnteriores;
    }

    public void setDetallesAnteriores(ArrayList<Detallefichaestudiante> detallesAnteriores) {
        this.detallesAnteriores = detallesAnteriores;
    }

    /**
     * Set the value of estudianteBo
     *
     * @param estudianteBo new value of estudianteBo
     */
    public void setEstudianteBo(EstudianteBo estudianteBo) {
        this.estudianteBo = estudianteBo;
    }

    /**
     * Get the value of estudianteBo
     *
     * @return the value of parametros (los cuales son añadidos desde cualquier
     * página .xhtml)
     */
    public Map<String, String> getParametros() {
        return parametros;
    }

}
