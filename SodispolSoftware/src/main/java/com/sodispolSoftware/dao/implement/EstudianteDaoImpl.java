/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class EstudianteDaoImpl extends HibernateDaoSupport implements EstudianteDao{

    @Override
    public Estudiante getEstudiante(String matricula,Object[] attributes) {
        try
        {
            Object[] paramsEstudiante = new Object[]{matricula,false};
            
            Estudiante estudiante = (Estudiante)getHibernateTemplate().find("from Estudiante e where e.matricula= ? and estadoborrado = ?",paramsEstudiante).get(0); 
            loadDataFromWebService(estudiante,attributes);
             return estudiante;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    @Override
    public void addEstudiante(Estudiante estudiante) {
        getHibernateTemplate().save(estudiante);
    }
    
    public void loadDataFromWebService(Estudiante estudiante,Object[] attributes)
    {
        estudiante.setNombre1((String)attributes[7]);
        estudiante.setNombre2((String)attributes[8]);
        estudiante.setApellido1((String)attributes[9]);
        estudiante.setApellido2((String)attributes[10]);
        estudiante.setCarrera((String)attributes[6]);
        estudiante.setEdad((Integer)attributes[5]);
        estudiante.setFoto((String)attributes[12]);
        /*estudiante.setFechaNacimiento((String)attributes[11]);*/
    }

    
    
    
}
