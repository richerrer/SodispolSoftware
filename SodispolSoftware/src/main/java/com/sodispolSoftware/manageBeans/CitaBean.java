/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.manageBeans;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Jose
 */
@Named
@Scope("view")
public class CitaBean {
    private String pac="Jose PEPE";

    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }
    
    
}
