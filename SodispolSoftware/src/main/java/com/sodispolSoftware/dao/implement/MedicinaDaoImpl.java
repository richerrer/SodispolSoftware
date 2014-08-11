/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.MedicinaDao;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import com.sodispolSoftware.model.Medicina;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Usuario
 */
public class MedicinaDaoImpl extends HibernateDaoSupport implements MedicinaDao {

    @Override
    public ArrayList<Object[]> getListaDeMedicinas() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            Query query = session.createQuery("select m.idmedicina, m.descripcion, m.cajasdisponibles, m.estadodisponible from Medicina m where m.estadoborrado = :estado order by 1 desc");
            query.setParameter("estado",false);
            ArrayList<Object[]> lista = (ArrayList<Object[]>)query.list();
            session.beginTransaction().commit();
            session.close();
            return lista;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public Categoriamedicina getCategoria(Long medicinaId) {
               
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            Query query = session.createQuery("select c.categoriamedicina from Categoriamedicinamedicina c where c.medicina.idmedicina = :id and c.estadoborrado = :estado order by 1 desc");
            query.setParameter("estado",false);
            query.setParameter("id", medicinaId);
            ArrayList<Categoriamedicina> lista = (ArrayList<Categoriamedicina>)query.list(); 
            session.beginTransaction().commit();
            session.close();
            return lista.get(0);
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
        
    }

    @Override
    public ArrayList<Object[]> getListaDeCategorias() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        
        try{
            session.beginTransaction();
            Query query = session.createQuery("select c.idcategoriamedicina, c.descripcion from Categoriamedicina c where c.estadoborrado = :estado order by 1 desc");
            query.setParameter("estado",false);
            ArrayList<Object[]> lista = (ArrayList<Object[]>)query.list();
            session.beginTransaction().commit();
            session.close();
            return lista;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public void addMedicina(Medicina medicina) {
         getHibernateTemplate().save(medicina);
    }
   
}
