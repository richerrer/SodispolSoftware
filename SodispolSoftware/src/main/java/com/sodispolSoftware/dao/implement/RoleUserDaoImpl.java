/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.RoleUserDao;
import com.sodispolSoftware.model.Roleuser;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author usuario
 */
public class RoleUserDaoImpl extends HibernateDaoSupport implements RoleUserDao {

    @Override
    public Roleuser getRoleUser(String descripcion) {
        try {
            Object[] paramsRoleUser = new Object[]{descripcion};
            Roleuser roleUser = (Roleuser) getHibernateTemplate().find("from Roleuser r where r.descripcion = ?", paramsRoleUser).get(0);
            return roleUser;
        } catch (IndexOutOfBoundsException ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }

}
