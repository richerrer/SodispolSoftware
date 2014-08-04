package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.FichaMedicaEstudianteBo;
import com.sodispolSoftware.dao.FichaMedicaEstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * Esta clase es una implementación de  FichaMedicaEstudianteBo, la cual define 
 * la lógica de negocio del objeto Fichamedicaestudiante 
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
@Named
@Scope("prototype")
public class FichaMedicaEstudianteBoImpl implements FichaMedicaEstudianteBo{

    @Inject
    private FichaMedicaEstudianteDao fichaMedicaEstudianteDao;

    /**
     * Get the value of fichaMedicaEstudianteDao
     *
     * @return the value of fichaMedicaEstudianteDao
     */
    public FichaMedicaEstudianteDao getFichaMedicaEstudianteDao() {
        return fichaMedicaEstudianteDao;
    }

    /**
     * Set the value of fichaMedicaEstudianteDao
     *
     * @param fichaMedicaEstudianteDao new value of fichaMedicaEstudianteDao
     */
    public void setFichaMedicaEstudianteDao(FichaMedicaEstudianteDao fichaMedicaEstudianteDao) {
        this.fichaMedicaEstudianteDao = fichaMedicaEstudianteDao;
    }

    /**
     * Obtiene la ficha médica del estudiante.
     *
     * @param estudiante estudiante del cual se busca la ficha médica
     * @return ficha médica del estudiante.
     */
    @Override
    public Fichamedicaestudiante getFicha(Estudiante estudiante) {
        return getFichaMedicaEstudianteDao().getFicha(estudiante);
    }

    /**
     * Añade una nueva ficha medica de estudiante a la base.
     *
     * @param ficha estudiante del cual se busca la ficha médica
     */
    @Override
    public void addFicha(Fichamedicaestudiante ficha) {
        getFichaMedicaEstudianteDao().addFicha(ficha);
    }

     /**
     * Actualiza una ficha medica de estudiante.
     *
     * @param ficha estudiante del cual se busca la ficha médica
     */
    @Override
    public void updateFicha(Fichamedicaestudiante ficha) {
        getFichaMedicaEstudianteDao().updateFicha(ficha);
    }
    
    
    
}
