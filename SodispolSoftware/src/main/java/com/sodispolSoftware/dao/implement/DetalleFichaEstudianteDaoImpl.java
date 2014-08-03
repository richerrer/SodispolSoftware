/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.DetalleFichaEstudianteDao;
import com.sodispolSoftware.model.Detallefichaestudiante;
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
    
}
