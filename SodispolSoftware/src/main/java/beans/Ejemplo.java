/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import ejemploClases.Persona;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author usuario
 */
@ManagedBean
@ViewScoped
public class Ejemplo {

    private ArrayList<Persona> personas = new ArrayList<Persona>();
    
    public Ejemplo() {
        Persona p = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p2 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p3 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p4 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p5 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p6 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p7 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p8 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p9 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p10 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        Persona p11 = new Persona("ricardo maya","10:30 - 11:30","Estudiante");
        personas.add(p);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);
        personas.add(p7);
        personas.add(p8);
        personas.add(p9);
        personas.add(p10);
        personas.add(p11);
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    
}
