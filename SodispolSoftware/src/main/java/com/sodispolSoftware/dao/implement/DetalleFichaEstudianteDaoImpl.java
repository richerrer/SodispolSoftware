/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.DetalleFichaEstudianteDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Estudiante;
import java.util.ArrayList;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Ricardo
 */
public class DetalleFichaEstudianteDaoImpl extends HibernateDaoSupport implements DetalleFichaEstudianteDao{

    @Override
    public void addDetalleFicha(Detallefichaestudiante detalleFicha) {
        getHibernateTemplate().save(detalleFicha);
    }

    @Override
    public ArrayList<Object[]> getObservaciones(Estudiante estudiante) {
        try{
            Object[] paramsObservaciones = new Object[]{estudiante,false};
            
            //ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select d.fecha,d.observaciones from Detallefichaestudiante d inner join d.fichamedicaestudiante f where f.estudiante= ? and d.estadoborrado = ? order by 1 desc",paramsObservaciones); 
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select d.fecha,d.observaciones from Detallefichaestudiante d  where d.fichamedicaestudiante.estudiante= ? and d.estadoborrado = ? order by 1 desc",paramsObservaciones); 
            
            return consulta;
        }
        catch(DataAccessException ex){
            return null;
        }
    }
    
}
