/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.DetalleFichaEstudianteDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WebServiceEspol;
import java.util.ArrayList;
import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Ricardo
 */
public class DetalleFichaEstudianteDaoImpl extends HibernateDaoSupport implements DetalleFichaEstudianteDao{

    @Inject
    private WebServiceEspol webService;
    
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
        catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public ArrayList<Detallefichaestudiante> getDetallesFicha(Estudiante estudiante,int firstResult,int maxResult) {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try{
            /*Object[] paramsObservaciones = new Object[]{estudiante,false};
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)getHibernateTemplate().find("select d.fecha,d.observaciones,doc.username from Detallefichaestudiante d join d.doctor as doc where d.fichamedicaestudiante.estudiante= ? and d.estadoborrado = ? order by 1 desc",paramsObservaciones); 
            */
            ArrayList<Detallefichaestudiante> listaDetalle = new ArrayList<Detallefichaestudiante>();
            ArrayList<Doctor> doctores = new ArrayList<Doctor>();
            session.beginTransaction();
            Query query = session.createQuery("select d,doc from Detallefichaestudiante d join d.doctor as doc where d.fichamedicaestudiante.estudiante= :estudiante and d.estadoborrado = :estado order by d.fecha desc");
            query.setParameter("estudiante",estudiante); 
            query.setParameter("estado",false);
            query.setMaxResults(maxResult);
            query.setFirstResult(maxResult * (firstResult-1));
            ArrayList<Object[]> consulta = (ArrayList<Object[]>)query.list();
            for(Object[] array: consulta){
                Detallefichaestudiante d = (Detallefichaestudiante)array[0];
                /*Si varios detalles fueron escritor por el mismo doctor, se devuelve 
                * la misma referencia del doctor varias veces en la lista, es decir
                * si a uno agrego el nombre1,apellido1 etc.. del web service, todos
                * los demas doctores en la lista con igual id lo tendran ya que 
                * es una referencia a memoria.
                */
                if(((Doctor)array[1]).getNombre1()==null)
                {
                    webService.loadDataDoctorFromWebService((Doctor)array[1]);
                }
                listaDetalle.add(d);
            }
            session.beginTransaction().commit();
            session.close();
            //ArrayList<Object[]> consulta = new ArrayList<Object[]>();
            return listaDetalle;
        }
        catch(Exception ex){
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
        catch(Exception ex)
        {
            return 0;
        }
    }

    @Override
    public Detallefichaestudiante getDetalleFichaEstudiante(long idDetalle,Estudiante estudiante) {
        try
        {
            Object[] paramsDetalle = new Object[]{idDetalle,estudiante,false,false};
            
            Detallefichaestudiante detalle = (Detallefichaestudiante)getHibernateTemplate().find("select d from Detallefichaestudiante d inner join d.fichamedicaestudiante f where d.iddetalleficha= ? and f.estudiante = ?  and d.estadoborrado = ? and f.estudiante.estadoborrado = ?",paramsDetalle).get(0); 
            detalle.setDoctor((Doctor)getHibernateTemplate().get(Doctor.class, detalle.getDoctor().getIddoctor()));
            webService.loadDataDoctorFromWebService(detalle.getDoctor());
            return detalle;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }
    
    public WebServiceEspol getWebService() {
        return webService;
    }

    public void setWebService(WebServiceEspol webService) {
        this.webService = webService;
    }
    
}
