package com.example.testingblackjackgame.Deck;

import java.util.ArrayList;

public class DealtACardToHand implements IDealtACardToHand{

    @Override
    public String getResult(ArrayList<String> deck, ArrayList<String> hand) {
        String card = deck.remove(0);
        hand.add(card);
        return "Card Dealt!";
    }
    
}
