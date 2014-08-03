/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import ejemploClases.Enfermedad;
import ejemploClases.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class Patologias implements Serializable {
    
    private ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
    
    public Patologias() {
        Enfermedad p = new Enfermedad("Enfermedad de Alzheimer","Neurologica");
        Enfermedad p2 = new Enfermedad("Déficit atencional","Neurologica");
        Enfermedad p3 = new Enfermedad("Trastorno obsesivo-compulsivo","Neurologica");
        Enfermedad p4 = new Enfermedad("Esquizofrenia","Neurologica");
        Enfermedad p5 = new Enfermedad("Síndrome de Stress posttrauma","Neurologica");
        Enfermedad p6 = new Enfermedad("Epilepsia compleja","Neurologica");
        Enfermedad p7 = new Enfermedad("Daño por sustancias neurotóxicas","Neurologica");
        Enfermedad p8 = new Enfermedad("Enfermedad bipolar","Neurologica");
        enfermedades.add(p);
        enfermedades.add(p2);
        enfermedades.add(p3);
        enfermedades.add(p4);
        enfermedades.add(p5);
    }

    public ArrayList<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }
}
