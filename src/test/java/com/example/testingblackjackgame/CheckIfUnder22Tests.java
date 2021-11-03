package com.example.testingblackjackgame;

import static org.junit.Assert.assertEquals;

import com.example.testingblackjackgame.Scoring.CheckIfUnder22;
import com.example.testingblackjackgame.Scoring.ICheckIfUnder22;

import org.junit.Test;

public class CheckIfUnder22Tests {
    
    @Test
    public void givenOneReturnTrue() {
        //Given: I am a user
        //When: my point total is 1
        ICheckIfUnder22 ICIU21 = new CheckIfUnder22();
        boolean result = ICIU21.getResult(1);
        //Then: I will get back true
        assertEquals(true, result);
    }

    @Test
    public void givenTwentyReturnTrue() {
        //Given: I am a user
        //When: my point total is 20
        ICheckIfUnder22 ICIU21 = new CheckIfUnder22();
        boolean result = ICIU21.getResult(20);
        //Then: I will get back true
        assertEquals(true, result);
    }

    @Test
    public void givenTwentyOneReturnTrue() {
        //Given: I am a user
        //When: my point total is 1
        ICheckIfUnder22 ICIU21 = new CheckIfUnder22();
        boolean result = ICIU21.getResult(21);
        //Then: I will get back true
        assertEquals(true, result);
    }
}
