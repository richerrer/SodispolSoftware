package com.sodispolSoftware.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Detallefichaestudiante implements Serializable
{
  private long iddetalleficha;
  private Citamedica citamedica;
  private Doctor doctor;
  private Fichamedicaestudiante fichamedicaestudiante;
  private Double estatura;
  private Double peso;
  private String presionarterial;
  private String pulso;
  private String ruidoscardiacos;
  private String observaciones;
  private String temperatura;
  private boolean estadoborrado;
  private Calendar fecha;
  private Set<Receta> recetas = new HashSet(0);
  private Set<Patologiadetalleficha> patologiadetallefichas = new HashSet(0);
  
  public Detallefichaestudiante() {}
  
  public Detallefichaestudiante(Doctor doctor, Fichamedicaestudiante fichamedicaestudiante, boolean estadoborrado, Calendar fecha)
  {
    this.doctor = doctor;
    this.fichamedicaestudiante = fichamedicaestudiante;
    this.estadoborrado = estadoborrado;
    this.fecha = fecha;
  }
  
  public Detallefichaestudiante(Citamedica citamedica, Doctor doctor, Fichamedicaestudiante fichamedicaestudiante, Double estatura, Double peso, String presionarterial, String pulso, String ruidoscardiacos, String observaciones, String temperatura, boolean estadoborrado, Calendar fecha, Set<Receta> recetas, Set<Patologiadetalleficha> patologiadetallefichas)
  {
    this.citamedica = citamedica;
    this.doctor = doctor;
    this.fichamedicaestudiante = fichamedicaestudiante;
    this.estatura = estatura;
    this.peso = peso;
    this.presionarterial = presionarterial;
    this.pulso = pulso;
    this.ruidoscardiacos = ruidoscardiacos;
    this.observaciones = observaciones;
    this.temperatura = temperatura;
    this.estadoborrado = estadoborrado;
    this.fecha = fecha;
    this.recetas = recetas;
    this.patologiadetallefichas = patologiadetallefichas;
  }
  
  public long getIddetalleficha()
  {
    return this.iddetalleficha;
  }
  
  public void setIddetalleficha(long iddetalleficha)
  {
    this.iddetalleficha = iddetalleficha;
  }
  
  public Citamedica getCitamedica()
  {
    return this.citamedica;
  }
  
  public void setCitamedica(Citamedica citamedica)
  {
    this.citamedica = citamedica;
  }
  
  public Doctor getDoctor()
  {
    return this.doctor;
  }
  
  public void setDoctor(Doctor doctor)
  {
    this.doctor = doctor;
  }
  
  public Fichamedicaestudiante getFichamedicaestudiante()
  {
    return this.fichamedicaestudiante;
  }
  
  public void setFichamedicaestudiante(Fichamedicaestudiante fichamedicaestudiante)
  {
    this.fichamedicaestudiante = fichamedicaestudiante;
  }
  
  public Double getEstatura()
  {
    return this.estatura;
  }
  
  public void setEstatura(Double estatura)
  {
    this.estatura = estatura;
  }
  
  public Double getPeso()
  {
    return this.peso;
  }
  
  public void setPeso(Double peso)
  {
    this.peso = peso;
  }
  
  public String getPresionarterial()
  {
    return this.presionarterial;
  }
  
  public void setPresionarterial(String presionarterial)
  {
    this.presionarterial = presionarterial;
  }
  
  public String getPulso()
  {
    return this.pulso;
  }
  
  public void setPulso(String pulso)
  {
    this.pulso = pulso;
  }
  
  public String getRuidoscardiacos()
  {
    return this.ruidoscardiacos;
  }
  
  public void setRuidoscardiacos(String ruidoscardiacos)
  {
    this.ruidoscardiacos = ruidoscardiacos;
  }
  
  public String getObservaciones()
  {
    return this.observaciones;
  }
  
  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }
  
  public String getTemperatura()
  {
    return this.temperatura;
  }
  
  public void setTemperatura(String temperatura)
  {
    this.temperatura = temperatura;
  }
  
  public boolean isEstadoborrado()
  {
    return this.estadoborrado;
  }
  
  public void setEstadoborrado(boolean estadoborrado)
  {
    this.estadoborrado = estadoborrado;
  }
  
  public Calendar getFecha()
  {
    return this.fecha;
  }
  
  public void setFecha(Calendar fecha)
  {
    this.fecha = fecha;
  }
  
  public Set<Receta> getRecetas()
  {
    return this.recetas;
  }
  
  public void setRecetas(Set<Receta> recetas)
  {
    this.recetas = recetas;
  }
  
  public Set<Patologiadetalleficha> getPatologiadetallefichas()
  {
    return this.patologiadetallefichas;
  }
  
  public void setPatologiadetallefichas(Set<Patologiadetalleficha> patologiadetallefichas)
  {
    this.patologiadetallefichas = patologiadetallefichas;
  }
}
