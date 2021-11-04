package com.example.testingblackjackgame.Deck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreateDeckTests {
    
    @Test
    public void givenCardOneReturnA() {
        //Given: I am a user
        //When: When I select the first card
        ICreateDeck ICD = new CreateDeck();
        String result = ICD.getResult().get(0);
        //Then: I get back "A"
        assertEquals("A", result);
    }

    @Test
    public void givenCardFiveReturn2() {
        //Given: I am a user
        //When: When I select the fifth card
        ICreateDeck ICD = new CreateDeck();
        String result = ICD.getResult().get(4);
        //Then: I get back "2"
        assertEquals("2", result);
    }

    @Test
    public void givenCardFiftyTwoReturnK() {
        //Given: I am a user
        //When: When I select the fifty-second card
        ICreateDeck ICD = new CreateDeck();
        String result = ICD.getResult().get(51);
        //Then: I get back "K"
        assertEquals("K", result);
    }
}
