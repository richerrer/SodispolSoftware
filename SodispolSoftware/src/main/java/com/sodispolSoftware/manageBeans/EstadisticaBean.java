/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;
import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Patologia;
import javax.inject.Named;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Usuario
 */
@Named
@ManagedBean
@Scope("view")
@RequestScoped
public class EstadisticaBean{

    //@Inject
    private Categoriamedicina categoria;
  
    
     private MedicinaBo medicinaBo;
     
     private String descripcion;
     private Boolean estadodisponible;
     private Categoriamedicina categoriaSeleccionada;
     private Patologia patologiaSeleccionada;
     private String catSeleccionada;
     private ArrayList<Categoriamedicina> categorias;
     private ArrayList<Patologia> patologias;
     private ArrayList<Patologia> patologiasCargadas=new ArrayList<Patologia>();
     private CartesianChartModel cartesianModel;
     private PieChartModel pieModel;
     private CartesianChartModel cartesianModelInfluenza;
     private CartesianChartModel cartesianModelCefalea;
     private CartesianChartModel cartesianModelHepatitis;
     
    /*
     * Creates a new instance of MedicinaBean
     */
    @Inject
    public EstadisticaBean(MedicinaBo medicinaBo)
    {
        setMedicinaBo(medicinaBo);        
        createPieModel();
    }   
     
    @PostConstruct
    public void init(){
          cargarPatologias();         
          
    }

    public CartesianChartModel getCartesianModel() {
        return cartesianModel;
    }

    public void setCartesianModel(CartesianChartModel cartesianModel) {
        this.cartesianModel = cartesianModel;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public CartesianChartModel getCartesianModelInfluenza() {
        return cartesianModelInfluenza;
    }

    public void setCartesianModelInfluenza(CartesianChartModel cartesianModelInfluenza) {
        this.cartesianModelInfluenza = cartesianModelInfluenza;
    }

    public CartesianChartModel getCartesianModelCefalea() {
        return cartesianModelCefalea;
    }

    public void setCartesianModelCefalea(CartesianChartModel cartesianModelCefalea) {
        this.cartesianModelCefalea = cartesianModelCefalea;
    }

    public CartesianChartModel getCartesianModelHepatitis() {
        return cartesianModelHepatitis;
    }

    public void setCartesianModelHepatitis(CartesianChartModel cartesianModelHepatitis) {
        this.cartesianModelHepatitis = cartesianModelHepatitis;
    }
    
    public Categoriamedicina getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoriamedicina categoria) {
        this.categoria = categoria;
    }

    public MedicinaBo getMedicinaBo() {
        return medicinaBo;
    }

    public void setMedicinaBo(MedicinaBo medicinaBo) {
        this.medicinaBo = medicinaBo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isEstadodisponible() {
        return estadodisponible;
    }

    public void setEstadodisponible(Boolean estadodisponible) {
        this.estadodisponible = estadodisponible;
    }

    public Categoriamedicina getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categoriamedicina categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    public Patologia getPatologiaSeleccionada() {
        return patologiaSeleccionada;
    }

    public void setPatologiaSeleccionada(Patologia patologiaSeleccionada) {
        this.patologiaSeleccionada = patologiaSeleccionada;
    }

    public String getCatSeleccionada() {
        return catSeleccionada;
    }

    public void setCatSeleccionada(String catSeleccionada) {
        this.catSeleccionada = catSeleccionada;
    }

    public ArrayList<Categoriamedicina> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoriamedicina> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Patologia> getPatologias() {
        return patologias;
    }

    public void setPatologias(ArrayList<Patologia> patologias) {
        this.patologias = patologias;
    }

    public ArrayList<Patologia> getPatologiasCargadas() {
        return patologiasCargadas;
    }

    public void setPatologiasCargadas(ArrayList<Patologia> patologiasCargadas) {
        this.patologiasCargadas = patologiasCargadas;
    }
      
        
     public void cargarPatologias(){
        setPatologias(getMedicinaBo().obtenerListaDePatologias());
        for(Patologia p : patologias)
        {
            patologiasCargadas.add(p);
        }               
    }
     
     public void createPieModel() {  
        pieModel = new PieChartModel();  
        
        setPatologias(getMedicinaBo().obtenerListaDePatologias());
        for(Patologia p: patologias){
            pieModel.set(p.getNombre(),getCasos(p));  
        }           
    }  

    private int getCasos(Patologia p) {
        return getMedicinaBo().obtenerCasosDePatologia(p);
    }
    
    private void createCartesianModel() { 
        cartesianModel = new CartesianChartModel(); 
        setPatologias(getMedicinaBo().obtenerListaDePatologias());
        
        for(Patologia p: patologias){        
            
            CartesianChartModel cartesianModelP = new CartesianChartModel(); 
            ChartSeries patologia = new ChartSeries();  
            patologia.setLabel(p.getNombre()); 
            patologia.set("Octubre", getCasos(p));
            cartesianModel.addSeries(patologia);
            cartesianModelP.addSeries(patologia); 
        }   
           
        
    }  
     
     
}
