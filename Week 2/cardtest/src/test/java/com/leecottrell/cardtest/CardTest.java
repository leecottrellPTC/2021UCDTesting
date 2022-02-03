package com.leecottrell.cardtest;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * Unit test for simple App.
 */
public class CardTest 
{
    /**
     * Rigorous Test :-)
     */
    @Ignore     //@Disabled
    public void shouldAnswerWithTrue()
    {
        assertTrue( "Should be true but was false ", true );
    }

    @Before
    public  void runBeforeEachTest(){
        System.out.println("I am running before each test");
        //setup the environment for each test
    }

    @BeforeClass
    public static void runBeforeEntireTest(){
        System.out.println("I will run once before all tests");
        //setup environoment for entire test
    }

    @After
    public void runAfterEachTest(){
        System.out.println("I am running AFTER each test");
        //cleanup the environment for each test
    }

    @AfterClass
    public static void runAfterEntireTest(){
        System.out.println("I will run once before all tests");
        //setup environoment for entire test
    }

    @Test
    public void testingCardEqualsFunction()
    {
        //setup
        Card c1 = new Card();
        Card c2 = new Card();
        c1.setSuit("Spades");
        c2.setSuit("Spades");

        c1.setValue(5);
        c2.setValue(6);

        //run the function
        boolean expected = true;
        boolean actual = c1.equals(c2); //running the method from the class

        //check the results
       // assertEquals("The cards should have been the same, but weren't ", expected, actual);
       assertEquals(expected, actual);
    }

    @Test
    public void properDeckIsGenerated(){
        //setup
        Card c = new Card();
        int [] correctCardCount = {4,4,4,4,4,4,4,4,4,4,4,4,4};
        int [] cardCounts = {0,0,0,0,0,0,0,0,0,0,0,0,0};
        //run the function
        for(int x=1; x <= 52; x++){
            c.pickCard();
            cardCounts[c.getValue() -1] ++;
        }
        assertArrayEquals(correctCardCount, cardCounts);
    }
}
