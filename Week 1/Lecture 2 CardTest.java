package com.leecottrell.cardprojectvsc;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CardTest {

    @Test
    public void testEquals(){
        Card c1 = new Card();
        Card c2 = new Card();
        c1.setSuit("Spades");
        c2.setSuit("Spades");
        boolean expected = true;
        boolean actual;

        // c1.setValue(3);
        // c2.setValue(3);
        // actual = c1.equals(c2);
        // assertEquals(expected, actual, "Cards are the same");

        for(int x=1; x < 14; x++){
            c1.setValue(x);
            c2.setValue(x);

            String message = String.format("Testing %d of Spades ", x);
            actual = c1.equals(c2);
            assertEquals(expected, actual, message);
        }
    }//end of test equals
    
    @Test
    public void testPickCard(){
        Card c = new Card();
        int [] expectedCount = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        //13 4
        int [] cardCounts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int x=1; x <= 52; x++){
            c.pickCard();
            cardCounts[c.getValue() - 1]++;
        }
        assertArrayEquals(expectedCount, cardCounts, "Deal is bad ");

    }//end of testPickCard
}
