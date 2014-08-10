/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.businessObject.MedicinaBo;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Medicina;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Usuario
 */
@Named
@Scope("view")
public class MedicinaBean{

    @Inject
    private Categoriamedicina categoria;
    @Inject
    private MedicinaBo medicinaBo;
    
     private long idmedicina;
     private String descripcion;
     private Integer cajasdisponibles;
     private Boolean estadodisponible;
     
     private ArrayList<Medicina> medicinas;
    /**
     * Creates a new instance of MedicinaBean
     */
     
     public void inicializar() {
        
         setMedicinas(getMedicinaBo().obtenerListaDeMedicinas());
        
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
    
    
    
}
