/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.model.Patologia;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped

public class Estadisticas implements Serializable{
     
    private CartesianChartModel cartesianModel;
    private PieChartModel pieModel;
    
    private CartesianChartModel cartesianModelInfluenza;
    private CartesianChartModel cartesianModelCefalea;
    private CartesianChartModel cartesianModelHepatitis;
    
    private ArrayList<Patologia> patologias;
    
    @Inject
    private MedicinaBo medicinaBo;
    
    public Estadisticas(){  
         
        setMedicinaBo(medicinaBo);
        createCartesianModel();  
        createPieModel();
               
    }  

    public MedicinaBo getMedicinaBo() {
        return medicinaBo;
    }

    public void setMedicinaBo(MedicinaBo medicinaBo) {
        this.medicinaBo = medicinaBo;
    }
    
    public CartesianChartModel getCartesianModel() {  
        return cartesianModel;  
    }  
  
    public PieChartModel getPieModel() {  
        return pieModel;  
    } 
    
    public ArrayList<Patologia> getPatologias() {
        return patologias;
    }

    public void setPatologias(ArrayList<Patologia> patologias) {
        this.patologias = patologias;
    }
    
    
    
    public CartesianChartModel getCartesianModelInfluenza() {  
        return cartesianModelInfluenza;  
    }public CartesianChartModel getCartesianModelHepatitis() {  
        return cartesianModelHepatitis;  
    }public CartesianChartModel getCartesianModelCefalea() {  
        return cartesianModelCefalea;  
    }
    
    private void createCartesianModel() {  
        cartesianModel = new CartesianChartModel(); 
        
        
        
        cartesianModelInfluenza = new CartesianChartModel(); 
        cartesianModelHepatitis = new CartesianChartModel(); 
  
        ChartSeries influenza = new ChartSeries();  
        influenza.setLabel("Influenza"); 
        influenza.set("Octubre", 1);
        
        ChartSeries hepatitisB  = new ChartSeries();
        hepatitisB.setLabel("Hepatitis B");
        hepatitisB.set("Octubre", 1);
         
        
        
        cartesianModel.addSeries(influenza);  
        cartesianModel.addSeries(hepatitisB);
        
        cartesianModelInfluenza.addSeries(influenza); 
        cartesianModelHepatitis.addSeries(hepatitisB);
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();                 
        pieModel.set("Influenza", 362);  
        pieModel.set("Hepatitis B", 85);  
        pieModel.set("Cefálea", 186);  
    }  
    
    
    
}

