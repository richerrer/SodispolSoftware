/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.MedicinaDao;
import com.sodispolSoftware.model.Categoriamedicina;
import com.sodispolSoftware.model.Categoriamedicinamedicina;
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
    public ArrayList<Medicina> getListaDeMedicinas() {
        try{
            Object[] param = new Object[]{false};
            ArrayList<Medicina> listaMedicinas = (ArrayList<Medicina>)getHibernateTemplate().find("from Medicina m where estadoborrado = ?",param);  
            return listaMedicinas;
        }catch(Exception ex)
        {return null;}
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
    public ArrayList<Categoriamedicina> getListaDeCategorias() {
        try{
            Object[] param = new Object[]{false};
            ArrayList<Categoriamedicina> listaCategorias = (ArrayList<Categoriamedicina>)getHibernateTemplate().find("from Categoriamedicina cm where estadoborrado = ?",param);  
            return listaCategorias;
        }
        catch(Exception ex)
        {return null;}
    }

    @Override
    public void addMedicina(Medicina medicina) {
         getHibernateTemplate().save(medicina);
    }

    @Override
    public void addRelacionMedicinaCategoria(Categoriamedicinamedicina cm) {
         getHibernateTemplate().save(cm);
    }

    @Override
    public void addCategoria(Categoriamedicina c) {
         getHibernateTemplate().save(c);
    }

    @Override
    public void updateMedicina(Medicina med) {
         getHibernateTemplate().update(med);
    }
   
    @Override
    public Categoriamedicina obtenerPorNombre(String categoria) {
        try{
            Object[] paramsCategoria = new Object[]{categoria,false};
            Categoriamedicina cat = (Categoriamedicina)getHibernateTemplate().find("from Categoriamedicina c where c.descripcion= ? and estadoborrado = ?",paramsCategoria).get(0); 
            return cat;
        }
        catch(IndexOutOfBoundsException ex){
            return null;
        }  
    }
    
}
