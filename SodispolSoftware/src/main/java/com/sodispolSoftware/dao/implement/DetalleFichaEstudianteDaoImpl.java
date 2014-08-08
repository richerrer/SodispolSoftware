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
import org.hibernate.Query;
import org.hibernate.Session;
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
    public ArrayList<Object[]> getObservaciones(Estudiante estudiante,int firstResult,int maxResult) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try{
            /*Object[] paramsObservaciones = new Object[]{estudiante,false};
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select d.fecha,d.observaciones,doc.username from Detallefichaestudiante d join d.doctor as doc where d.fichamedicaestudiante.estudiante= ? and d.estadoborrado = ? order by 1 desc",paramsObservaciones); 
            */
            session.beginTransaction();
            Query query = session.createQuery("select d.fecha,d.observaciones,doc.username from Detallefichaestudiante d join d.doctor as doc where d.fichamedicaestudiante.estudiante= :estudiante and d.estadoborrado = :estado order by 1 desc");
            query.setParameter("estudiante",estudiante); 
            query.setParameter("estado",false);
            query.setMaxResults(maxResult);
            query.setFirstResult(maxResult * (firstResult-1));
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)query.list();
            session.beginTransaction().commit();
            session.close();
            //ArrayList<Object[]> consulta = new ArrayList<Object[]>();
            return consulta;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public long getNumObservaciones(Estudiante estudiante) {
        try
        {
            Object[] paramsDoctor = new Object[]{estudiante,false};
            
            long numero = (Long)getHibernateTemplate().find("select count(d) from Detallefichaestudiante d where d.fichamedicaestudiante.estudiante= ? and d.estadoborrado = ?",paramsDoctor).get(0); 
            
            return numero;
        }
        catch(IndexOutOfBoundsException ex)
        {
            return 0;
        }
    }
    
}
