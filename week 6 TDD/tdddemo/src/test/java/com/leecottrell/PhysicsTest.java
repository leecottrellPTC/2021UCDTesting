package com.leecottrell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;



public class PhysicsTest {
    static Physics test;

    @BeforeClass
    public static void setupTest(){
        
    }
    @Test
    public void testForce(){
        //mass = 5, accelaration = 20, force = 100;
        test  = new Physics();
        test.setAcceleration(20);
        test.setMass(5);
        double expected = 100;
        double actual = test.calcForce();

        assertEquals("Testing force with mass = 5, acc = 20", expected, actual, .01);
        
    }
    @Test
    public void testAvgVelocity() {
        
        test  = new Physics();
        double v0[] = {10, 19.6, 1.345};
        double v1[] = {20, 27.9, 9.545};
        double expecteds[] = {15, 23.75, 5.455};
        for(int x=0; x < v0.length; x++){
            test.setV0(v0[x]);
            test.setV1(v1[x]);
            double actual = test.avgVelocity();
            String theMessage="";
            theMessage = String.format("v0 = %.2f, v1 = %.2f", v0[x], v1[x]);
            assertEquals(theMessage, expecteds[x], actual, .01);

        }
        //test.setV0(10);
        //test.setV1(20);

        //double expected = 15;
        //double actual = test.avgVelocity();

        //assertEquals("Test avg velocity v0=10, v1=20", expected,actual, .01);
    }
}
