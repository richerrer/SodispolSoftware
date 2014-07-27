/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sodispolSoftware.businessObject.implement;

import com.sodispolSoftware.businessObject.RoleUserBo;
import com.sodispolSoftware.dao.DoctorDao;
import com.sodispolSoftware.model.Doctor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Ricardo
 */
public class DoctorBoImplTest {
    
    private ApplicationContext  factory;   
    public DoctorBoImplTest() {
    }
    
    @Before
    public  void setUpClass() {
        this.factory = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/springConfig/testapplicationContext.xml");
    }
    
    

    /**
     * Test of getDoctor method, of class DoctorBoImpl.
     */
    @Test
    public void testGetDoctor() {
        System.out.println("getDoctor");
        String username = "rmaya";
        DoctorBoImpl instance = new DoctorBoImpl();
        Doctor expResult = null;
        Doctor result = instance.getDoctor(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addDoctor method, of class DoctorBoImpl.
     */
    /*@Test
    public void testAddDoctor() {
        System.out.println("addDoctor");
        Doctor doctor = null;
        DoctorBoImpl instance = new DoctorBoImpl();
        instance.addDoctor(doctor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
