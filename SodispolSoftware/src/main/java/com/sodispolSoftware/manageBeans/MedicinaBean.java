/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;
import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Categoriamedicinamedicina;
import com.sodispolSoftware.model.Medicina;
import com.sodispolSoftware.model.Medicinaepecifica;
import java.io.Serializable;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.EditableValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Usuario
 */
@Named
@ManagedBean
@Scope("view")
@RequestScoped
public class MedicinaBean{

    //@Inject
    private Categoriamedicina categoria;
  
    
     private MedicinaBo medicinaBo;
     
     private Medicina medicinaSeleccionada;
     private long idmedicina;
     private String descripcion;
     private Integer cajasdisponibles=1;
     private Integer cajasdisponiblesAccion=1;
     private Integer unidadesPorCaja=1;
     private Boolean estadodisponible;
     private Date fechaCaducidad;
     private Categoriamedicina categoriaSeleccionada;
     private String catSeleccionada;
     private String medicinaNuevoNombre;
     
     private Integer unidades;
     private ArrayList<Medicina> receta;
     private ArrayList<Medicina> medicinas;
      private ArrayList<Medicina> medicinasFiltradas;
     private ArrayList<Categoriamedicina> categorias;
     private ArrayList<Medicina> medicinasCargadas=new ArrayList<Medicina>();
     private ArrayList<Categoriamedicina> categoriasCargadas=new ArrayList<Categoriamedicina>();
     private ArrayList<ColumnModel> columnas;
     
     
    private final static List<String> VALID_COLUMN_KEYS = Arrays.asList("idmedicina", "descripcion", "cajasdisponibles", "estadodisponible", "estadoborrado");
     
    private String columnTemplate = "idmedicina descripcion cajasdisponibles";
    /*
     * Creates a new instance of MedicinaBean
     */
    @Inject
    public MedicinaBean(MedicinaBo medicinaBo)
    {
        setMedicinaBo(medicinaBo);
        
    }   
     
    @PostConstruct
    public void init(){
          cargarMedicinas();
          cargarCategorias();
          createDynamicColumns();
          
          
    }
     
    private void createDynamicColumns() {
        String[] columnKeys = columnTemplate.split(" ");
        columnas = new ArrayList<ColumnModel>();   
         
        for(String columnKey : columnKeys) {
            String key = columnKey.trim();
             
            if(VALID_COLUMN_KEYS.contains(key)) {
                columnas.add(new ColumnModel(columnKey.toUpperCase(), columnKey));
            }
        }
        
    }

    public ArrayList<Medicina> getReceta() {
        return receta;
    }

    public void setReceta(ArrayList<Medicina> receta) {
        this.receta = receta;
    }

    
    
    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }
    
    

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getUnidadesPorCaja() {
        return unidadesPorCaja;
    }

    public void setUnidadesPorCaja(Integer unidadesPorCaja) {
        this.unidadesPorCaja = unidadesPorCaja;
    }

    
    public MedicinaBo getMedicinaBo() {
        return medicinaBo;
    }

    public void setMedicinaBo(MedicinaBo medicinaBo) {
        this.medicinaBo = medicinaBo;
    }

    public Categoriamedicina getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoriamedicina categoria) {
        this.categoria = categoria;
    }

    public long getIdmedicina() {
        return idmedicina;
    }

    public void setIdmedicina(long idmedicina) {
        this.idmedicina = idmedicina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Medicina getMedicinaSeleccionada() {
        return medicinaSeleccionada;
    }

    public String getCatSeleccionada() {
        return catSeleccionada;
    }

    public void setCatSeleccionada(String catSeleccionada) {
        this.catSeleccionada = catSeleccionada;
    }

    public void setMedicinaSeleccionada(Medicina medicinaSeleccionada) {
        this.medicinaSeleccionada = medicinaSeleccionada;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCajasdisponibles() {
        return cajasdisponibles;
    }

    public void setCajasdisponibles(Integer cajasdisponibles) {
        this.cajasdisponibles = cajasdisponibles;
    }

    public Boolean isEstadodisponible() {
        return estadodisponible;
    }

    public void setEstadodisponible(Boolean estadodisponible) {
        this.estadodisponible = estadodisponible;
    }

    public Integer getCajasdisponiblesAccion() {
        return cajasdisponiblesAccion;
    }

    public void setCajasdisponiblesAccion(Integer cajasdisponiblesAccion) {
        this.cajasdisponiblesAccion = cajasdisponiblesAccion;
    }

    public ArrayList<ColumnModel> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<ColumnModel> columnas) {
        this.columnas = columnas;
    }

    public String getMedicinaNuevoNombre() {
        return medicinaNuevoNombre;
    }

    public void setMedicinaNuevoNombre(String medicinaNuevoNombre) {
        this.medicinaNuevoNombre = medicinaNuevoNombre;
    }

    public String getColumnTemplate() {
        return columnTemplate;
    }

    public void setColumnTemplate(String columnTemplate) {
        this.columnTemplate = columnTemplate;
    }

    
    
    public ArrayList<Medicina> getMedicinas() {
        return medicinas;
    }

    public void setMedicinas(ArrayList<Medicina> medicinas) {
        this.medicinas = medicinas;
    }
    
    public ArrayList<Medicina> getMedicinasCargadas() {
        return medicinasCargadas;
    }

    public void setMedicinasCargadas(ArrayList<Medicina> medicinasCargadas) {
        this.medicinasCargadas = medicinasCargadas;
    }

    public ArrayList<Categoriamedicina> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoriamedicina> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Categoriamedicina> getCategoriasCargadas() {
        return categoriasCargadas;
    }

    public void setCategoriasCargadas(ArrayList<Categoriamedicina> categoriasCargadas) {
        this.categoriasCargadas = categoriasCargadas;
    }

    public Categoriamedicina getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categoriamedicina categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }
    
    public void cargarMedicinas(){
       
        setMedicinas(getMedicinaBo().obtenerListaDeMedicinas());        
        for(Medicina med : medicinas)
        { medicinasCargadas.add(med);}
         
    }

    public ArrayList<Medicina> getMedicinasFiltradas() {
        return medicinasFiltradas;
    }

    public void setMedicinasFiltradas(ArrayList<Medicina> medicinasFiltradas) {
        this.medicinasFiltradas = medicinasFiltradas;
    }

    
    
    public void updateCajasdisponiblesAccion(ValueChangeEvent e) {
        //Integer n = (Integer)((EditableValueHolder) e.getComponent().getParent()).getValue(); 
        
        setCajasdisponiblesAccion(1);
     } 
    
     
    public Categoriamedicina obtenerCategoria(Medicina med){
        return getMedicinaBo().obtenerCategoria(med.getIdmedicina());
    }
     
    public void cargarCategorias() {
        setCategorias(getMedicinaBo().obtenerListaDeCategorias());
        for(Categoriamedicina c : categorias)
        {
            categoriasCargadas.add(c);
        }
    }
    
    public void eliminarMedicina(ActionEvent actionEvent)
    {
        deleteMedicina();
        cargarMedicinas();
        addMessage("Medicina Eliminada Correctamente");
    }
    
    public void agregarReceta(ActionEvent actionEvent)
    {
        sumaReceta();
        restaMedicina();
        cargarMedicinas();
        addMessage("Agregado a la receta, restan"+medicinaSeleccionada.getCajasdisponibles());
    }
    public void quitarReceta(ActionEvent actionEvent)
    {
        restaReceta();
        sumaMedicina();
        cargarMedicinas();
        addMessage("Quitado de la receta, restan"+medicinaSeleccionada.getCajasdisponibles());
    }
    
    public void sumaReceta(){
        Medicina med = (Medicina)getMedicinaSeleccionada();
        //receta.add(med);
    }
    public void restaReceta(){
        Medicina med = (Medicina)getMedicinaSeleccionada();
        //getReceta().remove(med);
    }
    
    public void agregarMedicina(ActionEvent actionEvent)
    {
        sumaMedicina();
        cargarMedicinas();
        addMessage("Caja agregada,"+medicinaSeleccionada.getCajasdisponibles());
    }
    public void restarMedicina(ActionEvent actionEvent)
    {
        restaMedicina();
        cargarMedicinas();
        addMessage("Caja restada,"+medicinaSeleccionada.getCajasdisponibles());
    }

    public void deleteMedicina() {
        Medicina med = (Medicina)getMedicinaSeleccionada();
        med.setEstadoborrado(true);
        getMedicinaBo().updateMedicina(med);
        //agregarCategoria(medicina);  
    }
   
    public void sumaMedicina() {
        Medicina med = (Medicina)getMedicinaSeleccionada();
        
        med.setCajasdisponibles(med.getCajasdisponibles()+ 1);
        getMedicinaBo().updateMedicina(med);
        setUnidadesPorCaja(5);
        setFechaCaducidad(new Date(2014, 10, 20));
        crearMedicinasEspecificas(1,med);
        //agregarCategoria(medicina);        
    }
    public void restaMedicina() {
        Medicina med = (Medicina)getMedicinaSeleccionada();
        med.setCajasdisponibles(med.getCajasdisponibles()- 1);
        getMedicinaBo().updateMedicina(med);
        //eliminarMedicinasEspecificas(1,med);
//agregarCategoria(medicina);        
    }
    
    public void guardarMedicina(ActionEvent actionEvent)
    {
        agregarNuevaMedicina();
        //addMessage("Medicina agregada correctamente");
        //return "succes.xhtml";
        cargarMedicinas();
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Medicina eliminada correctamente");
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void agregarNuevaMedicina() {
        Medicina medicina = new Medicina(getDescripcion(),getCajasdisponibles(), true, false); 
        getMedicinaBo().agregarMedicina(medicina);
        setCategoria(medicina);    
        crearMedicinasEspecificas(getCajasdisponibles(),medicina);
        //agregarCategoria(medicina);        
    }
    
    public void crearMedicinasEspecificas(Integer cajas,Medicina med) {
        for (int i = 0; i < cajas; i++) {
            Medicinaepecifica me = new Medicinaepecifica(getUnidadesPorCaja(), false, false, med, dateToCalendar(getFechaCaducidad()));
            getMedicinaBo().agregarMedicinaEspecifica(me);
        }
    }
    
   
    
    public static Calendar dateToCalendar(Date date){ 
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
    }
    
    public void setCategoria(Medicina med){
        Categoriamedicina cat = (Categoriamedicina)obtenerCategoriaPorNombre(catSeleccionada);
        Categoriamedicinamedicina cmm = new Categoriamedicinamedicina(false, med, cat);
        getMedicinaBo().agregarRelacionMedicinaCategoria(cmm);
    }
    
    public void agregarCategoria(Medicina m) {
        Categoriamedicina c = obtenerCategoria(m);
        getMedicinaBo().agregarCategoria(c);     
        Categoriamedicinamedicina cm = new Categoriamedicinamedicina(false,m,c);
        getMedicinaBo().agregarRelacionMedicinaCategoria(cm);        
    }

    private Categoriamedicina obtenerCategoriaPorNombre( String categoria) {
        return getMedicinaBo().obtenerCategoria(categoria);
    }
    
    static public class ColumnModel implements Serializable {
 
        private String header;
        private String property;
 
        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }
 
        public String getHeader() {
            return header;
        }
 
        public String getProperty() {
            return property;
        }
    }
    
    
    
}
