
/*
package com.sodispolSoftware.dao.implement;
/*
import com.sodispolSoftware.dao.CitaDao;
import com.sodispolSoftware.model.Citamedica;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/java/com/sodispolSoftware/dao/implement/CitaDaoTransactionUnitTest-context.xml")
@TransactionConfiguration
@Transactional
public class CitaDaoTransactionUnitTest extends AbstractTransactionalJUnit4SpringContextTests{
    
    
    protected static int SIZE = 5;
    protected static long ID = 1;
    protected static String ESTADO = "P";
    protected static String APELLIDO_ESTUDIANTE = "Plaza";

    @Autowired
    protected CitaDao citaDao = null;
    
    @Test
    public void testGetAllCitas() {
        ArrayList<Citamedica> lCitas = citaDao.getAllCitas();

        assertNotNull("La lista de Citas es igual a null.", lCitas);
        assertEquals("El número de Citas debería ser " + SIZE + ".", SIZE, lCitas.size());

        Citamedica hCita = lCitas.get(0);

        long id = hCita.getIdcita();
        String estadoCita = hCita.getEstadocita();
        String apellidoEstudiante = hCita.getEstudiante().getApellido1();
        
        if (ID==id) {                
            assertEquals("El estado de la cita debería ser " + ESTADO + ".", ESTADO, estadoCita);
            assertEquals("El apellido del estudiante debería ser " + APELLIDO_ESTUDIANTE + ".", APELLIDO_ESTUDIANTE, apellidoEstudiante);
        }
    }
    
}
    
*/