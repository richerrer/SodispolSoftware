package com.sodispolSoftware.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Fichamedicaestudiante implements Serializable
{
  private long idfichamedica;
  private Estudiante estudiante;
  private String antecedentespatologicos;
  private String enfermedadesinfancia;
  private String vacunasrecibidas;
  private String aparatorespiratorio;
  private String aparatocirculatorio;
  private String aparatodigestivo;
  private String aparatogenicourinario;
  private String sistemalinfatico;
  private String sistemanervioso;
  private String examenpiel;
  private Set<Detallefichaestudiante> detallefichaestudiantes = new HashSet(0);
  
  public Fichamedicaestudiante() {}
  
  public Fichamedicaestudiante(Estudiante estudiante, String antecedentespatologicos, String enfermedadesinfancia, String vacunasrecibidas, Boolean estadoborrado, Set<Detallefichaestudiante> detallefichaestudiantes)
  {
    this.estudiante = estudiante;
    this.antecedentespatologicos = antecedentespatologicos;
    this.enfermedadesinfancia = enfermedadesinfancia;
    this.vacunasrecibidas = vacunasrecibidas;
    this.detallefichaestudiantes = detallefichaestudiantes;
  }
  
  public Fichamedicaestudiante(Estudiante estudiante, String antecedentespatologicos, String enfermedadesinfancia, String vacunasrecibidas, String aparatorespiratorio, String aparatocirculatorio, String aparatodigestivo, String aparatogenicourinario, String sistemalinfatico, String sistemanervioso, String examenpiel, Set<Detallefichaestudiante> detallefichaestudiantes)
  {
    this.estudiante = estudiante;
    this.antecedentespatologicos = antecedentespatologicos;
    this.enfermedadesinfancia = enfermedadesinfancia;
    this.vacunasrecibidas = vacunasrecibidas;
    this.aparatorespiratorio = aparatorespiratorio;
    this.aparatocirculatorio = aparatocirculatorio;
    this.aparatodigestivo = aparatodigestivo;
    this.aparatogenicourinario = aparatogenicourinario;
    this.sistemalinfatico = sistemalinfatico;
    this.sistemanervioso = sistemanervioso;
    this.examenpiel = examenpiel;
    this.detallefichaestudiantes = detallefichaestudiantes;
  }
  
  public long getIdfichamedica()
  {
    return this.idfichamedica;
  }
  
  public void setIdfichamedica(long idfichamedica)
  {
    this.idfichamedica = idfichamedica;
  }
  
  public Estudiante getEstudiante()
  {
    return this.estudiante;
  }
  
  public void setEstudiante(Estudiante estudiante)
  {
    this.estudiante = estudiante;
  }
  
  public String getAntecedentespatologicos()
  {
    return this.antecedentespatologicos;
  }
  
  public void setAntecedentespatologicos(String antecedentespatologicos)
  {
    this.antecedentespatologicos = antecedentespatologicos;
  }
  
  public String getEnfermedadesinfancia()
  {
    return this.enfermedadesinfancia;
  }
  
  public void setEnfermedadesinfancia(String enfermedadesinfancia)
  {
    this.enfermedadesinfancia = enfermedadesinfancia;
  }
  
  public String getVacunasrecibidas()
  {
    return this.vacunasrecibidas;
  }
  
  public void setVacunasrecibidas(String vacunasrecibidas)
  {
    this.vacunasrecibidas = vacunasrecibidas;
  }
  
  public String getAparatorespiratorio()
  {
    return this.aparatorespiratorio;
  }
  
  public void setAparatorespiratorio(String aparatorespiratorio)
  {
    this.aparatorespiratorio = aparatorespiratorio;
  }
  
  public String getAparatocirculatorio()
  {
    return this.aparatocirculatorio;
  }
  
  public void setAparatocirculatorio(String aparatocirculatorio)
  {
    this.aparatocirculatorio = aparatocirculatorio;
  }
  
  public String getAparatodigestivo()
  {
    return this.aparatodigestivo;
  }
  
  public void setAparatodigestivo(String aparatodigestivo)
  {
    this.aparatodigestivo = aparatodigestivo;
  }
  
  public String getAparatogenicourinario()
  {
    return this.aparatogenicourinario;
  }
  
  public void setAparatogenicourinario(String aparatogenicourinario)
  {
    this.aparatogenicourinario = aparatogenicourinario;
  }
  
  public String getSistemalinfatico()
  {
    return this.sistemalinfatico;
  }
  
  public void setSistemalinfatico(String sistemalinfatico)
  {
    this.sistemalinfatico = sistemalinfatico;
  }
  
  public String getSistemanervioso()
  {
    return this.sistemanervioso;
  }
  
  public void setSistemanervioso(String sistemanervioso)
  {
    this.sistemanervioso = sistemanervioso;
  }
  
  public String getExamenpiel()
  {
    return this.examenpiel;
  }
  
  public void setExamenpiel(String examenpiel)
  {
    this.examenpiel = examenpiel;
  }
  
  public Set<Detallefichaestudiante> getDetallefichaestudiantes()
  {
    return this.detallefichaestudiantes;
  }
  
  public void setDetallefichaestudiantes(Set<Detallefichaestudiante> detallefichaestudiantes)
  {
    this.detallefichaestudiantes = detallefichaestudiantes;
  }
}
