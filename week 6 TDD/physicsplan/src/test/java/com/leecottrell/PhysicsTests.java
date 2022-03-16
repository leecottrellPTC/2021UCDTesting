package com.leecottrell;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;


public class PhysicsTests {

    @Test
    public void avgVelocityShouldCalculateCorrectly(){
        Physics test = new Physics();
        test.setV0(10);
        test.setV1(20);

        double expected = 15;
        test.avgVelocity();
        double actual = test.getVelocity();//will write a function that stores in velocity

        assertEquals(expected, actual, .01);
    }

    @Test
    public void forceShouldCalcCorrectly(){
        Physics test = new Physics();
        test.setAcceleration(5);
        test.setMass(2.5);
        double expected = 12.5;

        test.calcForce();
        double actual = test.getForce();
        assertEquals(expected, actual, .01);
    }
}
