/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
    
    public Estadisticas(){  
        createCartesianModel();  
        createPieModel();  
               
    }  
    
    public CartesianChartModel getCartesianModel() {  
        return cartesianModel;  
    }  
  
    public PieChartModel getPieModel() {  
        return pieModel;  
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
        cartesianModelCefalea = new CartesianChartModel(); 
        cartesianModelHepatitis = new CartesianChartModel(); 
  
        ChartSeries influenza = new ChartSeries();  
        influenza.setLabel("Influenza"); 
        influenza.set("Enero", 80);
        influenza.set("Febrero", 55);
        influenza.set("Marzo", 70);
        influenza.set("Abril", 50);
        influenza.set("Mayo", 50);
        influenza.set("Junio", 25);
        
        ChartSeries hepatitisB  = new ChartSeries();
        hepatitisB.setLabel("Hepatitis B");
        hepatitisB.set("Enero", 20);
        hepatitisB.set("Febrero", 16);
        hepatitisB.set("Marzo", 15);
        hepatitisB.set("Abril", 17);
        hepatitisB.set("Mayo", 8);
        hepatitisB.set("Junio", 19);
         
        ChartSeries cefalea  = new ChartSeries();
        cefalea.setLabel("Cefálea");
        cefalea.set("Enero", 37);
        cefalea.set("Febrero", 26);
        cefalea.set("Marzo", 39);
        cefalea.set("Abril", 29);
        cefalea.set("Mayo", 28);
        cefalea.set("Junio", 31);
        
        cartesianModel.addSeries(influenza);  
        cartesianModel.addSeries(hepatitisB);
        cartesianModel.addSeries(cefalea);
        
        cartesianModelInfluenza.addSeries(influenza); 
        cartesianModelCefalea.addSeries(cefalea); 
        cartesianModelHepatitis.addSeries(hepatitisB);
    }  
  
    private void createPieModel() {  
        pieModel = new PieChartModel();  
  
        pieModel.set("Influenza", 362);  
        pieModel.set("Hepatitis B", 85);  
        pieModel.set("Cefálea", 186);  
        pieModel.set("Anemia", 42);  
    }  
    
    
}
