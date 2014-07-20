/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.RoleUserDao;
import com.sodispolSoftware.model.Roleuser;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RoleUserBoImpl implements RoleUserBo{

    @Inject
    private RoleUserDao roleUserDao;

    public void setRoleUserDao(RoleUserDao roleUserDao) {
        this.roleUserDao = roleUserDao;
    }
    
    
    @Override
    public Roleuser getRoleUser(String descripcion) {
        return roleUserDao.getRoleUser(descripcion);
    }
    
}
