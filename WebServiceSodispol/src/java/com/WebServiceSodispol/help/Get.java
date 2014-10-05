/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WebServiceSodispol.help;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author usuario
 */
public class Get {

    public String getUsernameOfEmail(String email) {
        StringTokenizer tokens = new StringTokenizer(email, "@");
        return tokens.nextToken();
    }
    
    public  String getName(String name,boolean first) {
        StringTokenizer tokens = new StringTokenizer(name);
        String firstName = tokens.nextToken();
        if(first)
            return firstName;
        else
            return tokens.nextToken();
    }
    
    public  String comproveString(String string) {
        StringTokenizer tokens = new StringTokenizer(string);
        String stringResult = string;
        if(tokens.hasMoreTokens())
            stringResult = tokens.nextToken();
        return stringResult;
    }
    
    public String getFecha(String fecha) {
        StringTokenizer tokens = new StringTokenizer(fecha,"-T");
        String anio = tokens.nextToken();
        String mes = tokens.nextToken();
        String dia = tokens.nextToken();
        
        return dia+"/"+mes+"/"+anio;
    }
    
    public Date crearFechas(String fechaString){
        StringTokenizer tokens = new StringTokenizer(fechaString,"/");
        String dia = tokens.nextToken();
        String mes = tokens.nextToken();
        String anio = tokens.nextToken();
	Calendar fecha = Calendar.getInstance();
	fecha.clear(); //establece valores a 0
	fecha.set(Integer.valueOf(anio),Integer.valueOf(mes)-1, Integer.valueOf(dia)); //establece año, mes y dia
	return fecha.getTime();
    }
    
    public String estadoCivil(String estadoCivil){
        if(estadoCivil.equals("S")){
            return "SOLTERO(A)";
        }
        if(estadoCivil.equals("C")){
            return "CASADO(A)";
        }
        if(estadoCivil.equals("D")){
            return "DIVORCIADO(A)";
        }
        if(estadoCivil.equals("V")){
            return "VIUDO(A)";
        }
        if(estadoCivil.equals("U")){
            return "UNIDO(A)";
        }
        return "nuk";
    }
    
    public int calcularEdad(Date fechaNacimiento){
        Calendar fechaAct = Calendar.getInstance();
        Calendar fechaNac = Calendar.getInstance();
        fechaNac.setTime(fechaNacimiento);

        int dif_anios = fechaAct.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int dif_meses = fechaAct.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int dif_dias = fechaAct.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if(dif_meses<0 || (dif_meses==0 && dif_dias<0)){
            dif_anios--;
        }
        return dif_anios;
    }

}
