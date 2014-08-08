/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import com.sodispolSoftware.businessObject.CitaBo;
import com.sodispolSoftware.model.Citamedica;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Jose
 */
@Named
@Scope("view")
public class CitaBean {
    
    @Inject
    private CitaBo citaBo;
    
    private ArrayList<Object[]> citas;
    private String pac="Jose PEPE";

    @Inject
    public CitaBean()
    {
        
    }

    public ArrayList<Object[]> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Object[]> citas) {
        this.citas = citas;
    }
    
    public CitaBo getCitaBo() {
        return citaBo;
    }

    public void setCitaBo(CitaBo citaBo) {
        this.citaBo = citaBo;
    }

    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }
    
    
}
