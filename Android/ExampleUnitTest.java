package com.leecottrell.stathelper;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Ignore
    public void addition_isCorrect() {
        assertEquals(5, 2 + 2);
    }

    @Test
    public void permutationWithRepetitionIsCorrect(){
        long number = 5;
        long repeats = 3;
        long expected = 125;    //5 ^ 3
        Stats test = new Stats(number, repeats);
        long actual = test.permutationWithRepetition();

        assertEquals(expected, actual);
    }

    @Test
    public void combinationWithoutRepetitionIsCorrect(){
        long number = 16;
        long repeats = 3;
        long expected = 560;    //16 choose 3
        Stats test = new Stats(number, repeats);
        long actual = test.combinationWithoutRepetition();

        assertEquals(expected, actual);
    }

    @Test
    public void checkButton(){
        
    }
}