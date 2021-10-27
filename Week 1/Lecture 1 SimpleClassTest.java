package com.leecottrell.junitlecture1;

import static org.junit.Assert.assertEquals;
//import org.junit.Assert.*;

import org.junit.*;

public class SimpleClassTest {
  /*  @BeforeClass    //this runs before all tests
    @Before         //this runs before each test
    @AfterClass     //this runs after all tests are done
    @After          //this runs after each test
*/

    static private SimpleClass instance;

    @BeforeClass
    static public void beforeTestSetup(){
        instance = new SimpleClass();     
    }


    @Test
    public void testParamConstructor(){
        SimpleClass instance = new SimpleClass(206, "Lee Cottrell");
        //create expected values
        int expectedWeight = 206;
        String expectedName = "Lee Cottrell";

        //get the actual vales
        int actualWeight = instance.getWeight();
        String actualName = instance.getName();

        //tests here
        assertEquals("Testing constructor - weight value", expectedWeight, 
            actualWeight);

        assertEquals("Testing constructor - name value",expectedName, 
            actualName);
    }

    @Test
    public void testGetWeight(){
        //SimpleClass instance = new SimpleClass();
        instance.setWeight(100);

        int expected = 100;
        int actual = instance.getWeight();

        assertEquals("Testing setter and getter weight - 100 value", 
            expected, actual);
    }

    @Test
    public void testGetName() {
        
    }

    @Test
    public void testSetName() {
        
    }

    @Test
    public void testSetWeight() {
        
    }
}
