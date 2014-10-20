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
import com.sodispolSoftware.model.Medicinaepecifica;
import com.sodispolSoftware.model.Patologia;
import com.sodispolSoftware.model.Patologiadetalleficha;
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

    @Override
    public void addMedicinaEspecifica(Medicinaepecifica me) {
        getHibernateTemplate().save(me);
    }

    @Override
    public void updateMedicinasEspecificas(Medicina med){
            try{
            Object[] param = new Object[]{med.getIdmedicina(),false};
            ArrayList<Medicinaepecifica> listaMedicinas = (ArrayList<Medicinaepecifica>)getHibernateTemplate().find("from Medicinaepecifica cm where cm.medicina.idmedicina = ? and estadoborrado = ?",param);  
                for(Medicinaepecifica medi : listaMedicinas)
                { 
                    medi.setEstadoborrado(true);
                    getHibernateTemplate().update(medi);
                }
            }
            catch(IndexOutOfBoundsException ex){
            } 
    }

    @Override
    public void updateRelacionCategoriaMedicina(Medicina med) {   
        try{
            Object[] paramsCategoria = new Object[]{med.getIdmedicina(),false};
            Categoriamedicinamedicina cat = (Categoriamedicinamedicina)getHibernateTemplate().find("from Categoriamedicinamedicina c where c.medicina.idmedicina = ? and estadoborrado = ?",paramsCategoria).get(0); 
            cat.setEstadoborrado(true);
            getHibernateTemplate().update(cat);
        }catch(IndexOutOfBoundsException ex){
            } 
    }

    @Override
    public void updateMedicinasEspecificasRestadas(Medicina med) {
        try{
            Object[] param = new Object[]{med.getIdmedicina(),false};
            Medicinaepecifica medicine = (Medicinaepecifica)getHibernateTemplate().find("from Medicinaepecifica cm where cm.medicina.idmedicina = ? and estadoborrado = ?",param).get(0);  
               medicine.setEstadoborrado(true);
               getHibernateTemplate().update(medicine);
            }
            catch(IndexOutOfBoundsException ex){
            } 
    }
    
    @Override
    public ArrayList<Patologia> getListaDePatologias() {
        try{
            Object[] param = new Object[]{false};
            ArrayList<Patologia> listaPatologias = (ArrayList<Patologia>)getHibernateTemplate().find("from Patologia p where estadoborrado = ?",param);  
            return listaPatologias;
        }
        catch(Exception ex)
        {return null;}
    }

    @Override
    public int getCasosDePatologias(Patologia p) {
        try{
            Object[] param = new Object[]{p.getIdpatologia(),false};
            ArrayList<Patologiadetalleficha> listaCasos = (ArrayList<Patologiadetalleficha>)getHibernateTemplate().find("from Patologiadetalleficha p where p.patologia.idpatologia = ? and estadoborrado = ?",param);  
            return listaCasos.size();
        }
        catch(Exception ex)
        {return 0;}
    }
    
}
