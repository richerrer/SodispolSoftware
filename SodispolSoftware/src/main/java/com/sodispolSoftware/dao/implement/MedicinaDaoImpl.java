/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.MedicinaDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Medicina;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Usuario
 */
public class MedicinaDaoImpl extends HibernateDaoSupport implements MedicinaDao {

    @Override
    public ArrayList<Medicina> getListaDeMedicinas() {
        try
        {
            List<Medicina> medicinas = getSessionFactory().getCurrentSession().createQuery("from Medicina where estadoborrado = false").list();
            return (ArrayList) medicinas;
             
        }
        catch(DataAccessException ex)
        {
            return null;
        }
        
    }
    
}
