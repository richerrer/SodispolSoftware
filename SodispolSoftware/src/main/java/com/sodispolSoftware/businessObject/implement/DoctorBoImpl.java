package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.DetalleFichaEstudianteBo;
import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.DoctorDao;
import com.sodispolSoftware.model.Citamedica;
import com.sodispolSoftware.model.Detallefichaestudiante;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Esta clase es una implementación de  DoctorBo, la cual define la lógica de 
 * negocio del objeto Doctor
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("prototype")
public class DoctorBoImpl implements DoctorBo{
   
    @Inject
    private DoctorDao doctorDao;
    
    @Inject
    private RoleUserBo roleUserBo;
    
    @Inject
    private DetalleFichaEstudianteBo detalleFichaEstudianteBo;
  


    /**
     * Get the value of detalleFichaEstudianteBo
     *
     * @return the value of detalleFichaEstudianteBo
     */
    public DetalleFichaEstudianteBo getDetalleFichaEstudianteBo() {
        return detalleFichaEstudianteBo;
    }

    /**
     * Set the value of detalleFichaEstudianteBo
     *
     * @param detalleFichaEstudianteBo new value of detalleFichaEstudianteBo
     */
    public void setDetalleFichaEstudianteBo(DetalleFichaEstudianteBo detalleFichaEstudianteBo) {
        this.detalleFichaEstudianteBo = detalleFichaEstudianteBo;
    }


    /**
     * Get the value of doctorDao
     *
     * @return the value of doctorDao
     */
    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    /**
     * Set the value of doctorDao
     *
     * @param doctorDao new value of doctorDao
     */
    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    /**
     * Get the value of roleUserBo
     *
     * @return the value of roleUserBo
     */
    public RoleUserBo getRoleUserBo() {
        return roleUserBo;
    }

    /**
     * Set the value of roleUserBo
     *
     * @param roleUserBo new value of roleUserBo
     */
    public void setRoleUserBo(RoleUserBo roleUserBo) {
        this.roleUserBo = roleUserBo;
    }

    /**
     * Devuelve el Doctor según su username. Este objeto lo obtiene del 
     * Objeto Dao asociado al Doctor.
     *
     * @param username username del Doctor
     * @return el Doctor asociado al username.
     */
    @Override
    public Doctor getDoctor(String username) {
        Doctor doctor = getDoctorDao().getDoctor(username);
        /*if(doctor==null){
            String autority = "ROLE_DOCTOR";
            doctor = new Doctor(username,roleUserBo.getRoleUser(autority),false);
            this.addDoctor(doctor);
            doctor = doctorDao.getDoctor(username);
        }*/
        return doctor;
    }
    
    /**
     * Agrega un nuevo Doctor.
     *
     * @param doctor es el Doctor a ser agregado
     */
    @Override
    public boolean addDoctor(Doctor doctor) {
        doctor.setRoleuser(getRoleUserBo().getRoleUser("ROLE_DOCTOR"));
        return getDoctorDao().addDoctor(doctor);
    }
    
    @Override
    public boolean updateDoctor(Doctor doctor) {
        return getDoctorDao().updateDoctor(doctor);
    }
    
    @Override
    public boolean eliminarDoctor(Doctor doctor) {
        doctor.setEstadoborrado(true);
        return getDoctorDao().updateDoctor(doctor);
    }
    
    @Override
    public boolean changeStateDeleteDoctor(Doctor doctor) {
        return getDoctorDao().changeStateDeleteDoctor(doctor);
    }

    @Override
    public void saveDetalleFichaEstudiante(Detallefichaestudiante detalleFicha) {
        getDetalleFichaEstudianteBo().addDetalleFicha(detalleFicha);
    }

    @Override
    public ArrayList<Object[]> getObservaciones(Estudiante estudiante,int firstResult,int maxResult) {
        ArrayList<Object[]> observaciones = getDetalleFichaEstudianteBo().getObservaciones(estudiante,firstResult,maxResult);
        for (Object[] object : observaciones) {
            object[2] = getDoctor((String)object[2]);
        }
        return observaciones;
    }
    
    @Override
    public ArrayList<Detallefichaestudiante> getDetallesFicha(Estudiante estudiante, int firstResult, int maxResult) {
        return getDetalleFichaEstudianteBo().getDetallesFicha(estudiante, firstResult, maxResult);
    }

    @Override
    public long getNumObservaciones(Estudiante estudiante) {
        return getDetalleFichaEstudianteBo().getNumObservaciones(estudiante);
    }

    @Override
    public ArrayList<Doctor> getAllDoctors()  {
        ArrayList<Doctor> doctores =getDoctorDao().getAllDoctors();
        return doctores;
    }
    
    @Override
    public boolean verifyUsername(String username){
        String role = WbServiceEspol.getRoleByUsername(username);
        return role!=null && role.equals("P");
    }
    
    @Override
    public boolean verifyTimes(Date horaEntrada,Date horaSalida){
        return horaSalida.after(horaEntrada);
    }
    
}
