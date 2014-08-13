/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;
import com.sodispolSoftware.businessObject.CitaBo;
import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Categoriamedicinamedicina;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Medicina;
import javax.inject.Named;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.model.DefaultScheduleModel;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Usuario
 */
@Named
@ManagedBean
@Scope("view")
public class MedicinaBean{

    //@Inject
    private Categoriamedicina categoria;
  
    
    private MedicinaBo medicinaBo;
    
     private long idmedicina;
     private String descripcion;
     private Integer cajasdisponibles;
     private Boolean estadodisponible;
     private String categoriaSeleccionada;
     
     private ArrayList<Medicina> medicinas;
     private ArrayList<Categoriamedicina> categorias;
     private ArrayList<Medicina> medicinasCargadas=new ArrayList<Medicina>();
     private ArrayList<Categoriamedicina> categoriasCargadas=new ArrayList<Categoriamedicina>();
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

    public String getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(String categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }
    
   
    
     public void cargarMedicinas(){
       
        setMedicinas(getMedicinaBo().obtenerListaDeMedicinas());
        
        for(Medicina med : medicinas)
        {
             medicinasCargadas.add(med);
        }
         
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
    
    public String eliminarMedicina(Medicina medicina)
    {
       // deleteMedicina(medicina);
        return "succes.xhtml";
    }

    public void deleteMedicina(Medicina med) {
        med.setEstadoborrado(true);
        getMedicinaBo().updateMedicina(med);
        //agregarCategoria(medicina);        
    }
    
    
    public String guardarMedicina(ActionEvent actionEvent)
    {
        agregarNuevaMedicina();
        return "succes.xhtml";
    }

    public void agregarNuevaMedicina() {
        Medicina medicina = new Medicina(getDescripcion(), getCajasdisponibles(), true, false);       
        getMedicinaBo().agregarMedicina(medicina);
        //agregarCategoria(medicina);        
    }
    
    public void agregarCategoria(Medicina m) {
        Categoriamedicina c = obtenerCategoria(m);
        getMedicinaBo().agregarCategoria(c);     
        Categoriamedicinamedicina cm = new Categoriamedicinamedicina(false,m,c);
        getMedicinaBo().agregarRelacionMedicinaCategoria(cm);        
    }
    
}
