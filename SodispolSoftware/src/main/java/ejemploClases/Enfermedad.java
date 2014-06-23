/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploClases;

/**
 *
 * @author usuario
 */
public class Enfermedad {
    private String nombre;
    private String tipo;
    
    public Enfermedad(String a,String b){
        nombre = a;
        tipo =b;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
