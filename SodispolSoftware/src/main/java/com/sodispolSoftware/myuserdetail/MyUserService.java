package com.sodispolSoftware.myuserdetail;

import com.sodispolSoftware.businessObject.DoctorBo;
import com.sodispolSoftware.businessObject.EstudianteBo;
import com.sodispolSoftware.manageBeans.UsuarioBean;
import com.sodispolSoftware.model.Doctor;
import com.sodispolSoftware.model.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.sodispolSoftware.webServiceEspol.WbServiceEspol;
import javax.inject.Inject;

/**
 * Esta clase es una implementación de  UserDetailsService, la cual define la 
 * lógica de ingreso a la aplicación, despues de haber validado correctamente el 
 * usernmae y password en CAS de Espol.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
public class MyUserService implements UserDetailsService {
    
    @Inject
    private DoctorBo doctorBo;
    
    @Inject
    private EstudianteBo estudianteBo;

    @Inject
    private UsuarioBean usuarioBean;
    
        /**
     * Get the value of estudianteBo
     *
     * @return the value of estudianteBo
     */
    public EstudianteBo getEstudianteBo() {
        return estudianteBo;
    }

    /**
     * Set the value of estudianteBo
     *
     * @param estudianteBo new value of estudianteBo
     */
    public void setEstudianteBo(EstudianteBo estudianteBo) {
        this.estudianteBo = estudianteBo;
    }

    

    /**
     * Get the value of doctorBo
     *
     * @return the value of doctorBo
     */
    public DoctorBo getDoctorBo() {
        return doctorBo;
    }

    /**
     * Set the value of doctorBo
     *
     * @param doctorBo new value of doctorBo
     */
    public void setDoctorBo(DoctorBo doctorBo) {
        this.doctorBo = doctorBo;
    }

    /**
     * Get the value of usuarioBean
     *
     * @return the value of usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * Set the value of usuarioBean
     *
     * @param usuarioBean new value of usuarioBean
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * Crea un Objeto, ya sea Doctor, Profesional o Estudiante dependiendo
     * de quién se haya logeado en el sistema
     *
     * @param username username ingresado en la página de CAS de Espol
     * @return un Objeto UserDetails, que contiene el rol de quien se logeo.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        String roleUser = WbServiceEspol.getRoleByUsername(username);
        boolean state = WbServiceEspol.getStateByUsername(username);

        if (roleUser.equals("P") && state)//Si es un profesional
        {
            Doctor doctor = getDoctorBo().getDoctor(username);
            if (doctor != null) //Si es un doctor
            {
                getUsuarioBean().setUser(doctor);
                return new MyUserDetails(username, doctor);
            } 
            else //Si es un paciente profesional
            {
            }

        }
        if (roleUser.equals("E") && state) {//Si es un paciente estudiante
            Estudiante estudiante = getEstudianteBo().getEstudiante(username);
            getUsuarioBean().setEstudiante(estudiante);
            return new MyUserDetails(username, estudiante);   
        }

        return null;
    }
}
