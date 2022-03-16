package com.leecottrell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//
public class PhysicsTest {

  /*  @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            { 10, 19.6, 1.345 },
            { 20, 27.9, 9.545 }
        });
    }
*/
    private double v1;
    private  double v2;
    private  double expected;
    static Physics test;


    public static void testAvgVelocityParam(double v1, double v2, double expected) {

        test = new Physics();

    }

    

    
    @BeforeClass
    public static void setupTest() {

    }

    @Ignore
    public void testForce() {
        // mass = 5, accelaration = 20, force = 100;
        test = new Physics();
        test.setAcceleration(20);
        test.setMass(5);
        double expected = 100;
        double actual = test.calcForce();

        assertEquals("Testing force with mass = 5, acc = 20", expected, actual, .01);

    }

    @Ignore
    public void testAvgVelocity() {

        test = new Physics();
       
       
    
            test.setV0(10);
            test.setV1(15);
            double expected = 12.5;
            double actual = test.avgVelocity();
            assertEquals(expected, actual, .01);

      
    }

}
