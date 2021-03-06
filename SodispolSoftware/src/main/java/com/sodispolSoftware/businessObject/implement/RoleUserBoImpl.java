package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.RoleUserDao;
import com.sodispolSoftware.model.Roleuser;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Esta clase es una implementación de  RoleUserBo, la cual define la lógica de 
 * negocio del objeto RoleUser
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("session")
public class RoleUserBoImpl implements RoleUserBo{

    @Inject
    private RoleUserDao roleUserDao;

    /**
     * Get the value of roleUserDao
     *
     * @return the value of roleUserDao
     */
    public RoleUserDao getRoleUserDao() {
        return roleUserDao;
    }

    /**
     * Set the value of roleUserDao
     *
     * @param roleUserDao new value of roleUserDao
     */
    public void setRoleUserDao(RoleUserDao roleUserDao) {
        this.roleUserDao = roleUserDao;
    }

    /**
     * Obtiene el RoleUser dependiendo de la descripción.
     *
     * @param descripcion rol que deseo obtener
     * @return RoleUser
     */
    @Override
    public Roleuser getRoleUser(String descripcion) {
        return getRoleUserDao().getRoleUser(descripcion);
    }
    
}
