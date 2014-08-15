package com.sodispolSoftware.dao.implement;

import com.sodispolSoftware.dao.FichaMedicaEstudianteDao;
import com.sodispolSoftware.model.Estudiante;
import com.sodispolSoftware.model.Fichamedicaestudiante;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Esta clase es una implementación de  FichaMedicaEstudianteDao, la cual define la 
 manera en que se acceden a los datos.
 *
 * @author: Ricardo D. Maya Herrera
 * @version: 1.0
 */
public class FichaMedicaEstudianteDaoImpl extends HibernateDaoSupport implements FichaMedicaEstudianteDao{

    @Override
    public Fichamedicaestudiante getFicha(Estudiante estudiante) {
        try
        {
            Object[] paramsFicha = new Object[]{estudiante};
            
            Fichamedicaestudiante ficha = (Fichamedicaestudiante)getHibernateTemplate().find("from Fichamedicaestudiante f where f.estudiante= ?",paramsFicha).get(0);  
            return ficha;
        }
        catch(Exception ex)//Cuando no se encuentra ningun objeto en la consulta
        {
            return null;
        }
    }

    @Override
    public void addFicha(Fichamedicaestudiante ficha) {
        getHibernateTemplate().save(ficha);
    }

    @Override
    public void updateFicha(Fichamedicaestudiante ficha) {
        getHibernateTemplate().update(ficha);
    }
    
}
