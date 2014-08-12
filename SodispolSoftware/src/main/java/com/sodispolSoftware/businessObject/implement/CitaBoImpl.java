package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.CitaBo;
import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.businessObject.FichaMedicaEstudianteBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.CitaDao;
import com.sodispolSoftware.dao.EstudianteDao;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Esta clase es una implementación de  EstudianteBo, la cual define la lógica de 
 * negocio del objeto Estudiante
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("prototype")
public class CitaBoImpl implements CitaBo{

    @Inject
    private CitaDao citaDao;

    public CitaDao getCitaDao() {
        return citaDao;
    }

    public void setCitaDao(CitaDao citaDao) {
        this.citaDao = citaDao;
    }

    
    
    @Override
    public ArrayList<Citamedica> getCitas(Doctor doctor) {
        return getCitaDao().getCitas(doctor);
    }

    @Override
    public int getncitas() {
        return getCitaDao().getncitas();
    }

    @Override
    public void updateCita(Citamedica cita) {
        getCitaDao().updateCita(cita);
    }

    @Override
    public void addCita(Citamedica cita)
    {
        getCitaDao().addCita(cita);
    }
   
}
