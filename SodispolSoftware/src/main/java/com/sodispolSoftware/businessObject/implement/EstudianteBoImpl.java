/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EstudianteBoImpl implements EstudianteBo{

    @Inject
    private EstudianteDao estudianteDao;

    @Inject
    private RoleUserBo roleUserBo;
    
    public void setEstudianteDao(EstudianteDao estudianteDao) {
        this.estudianteDao = estudianteDao;
    }
    
    public void setRoleUserBo(RoleUserBo roleUserBo) {
        this.roleUserBo = roleUserBo;
    }
    
    @Override
    public Estudiante getEstudiante(String matricula) {
        Object[] attributes = WbServiceEspol.loadEstudinateAttributesByMatricula(matricula);
        if(attributes==null){
            return null;
        }
        Estudiante estudiante = estudianteDao.getEstudiante(matricula);
        
        if(estudiante==null){
            String autority = "ROLE_ESTUDIANTE";
            estudiante = new Estudiante(roleUserBo.getRoleUser(autority),false);
            estudiante.setMatricula(matricula);
            estudiante.setCedula((String)attributes[0]);
            estudiante.setUsername((String)attributes[1]);
            estudiante.setDireccion((String)attributes[2]);
            estudiante.setEstadocivil((String)attributes[3]);
            estudiante.setTelefono((String)attributes[4]);
            this.addEstudiante(estudiante);
            estudiante = estudianteDao.getEstudiante(matricula);
        }
        return estudiante;
    }

    @Override
    public void addEstudiante(Estudiante estudiante) {
        this.estudianteDao.addEstudiante(estudiante);
    }
    
    
    
}
