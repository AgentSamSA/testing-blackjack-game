package com.example.testingblackjackgame.Deck;

import java.util.ArrayList;

public class CreateDeck implements ICreateDeck {
    public ArrayList<String> getResult() {
        String[] deck = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<String> deckAsArrayList = new ArrayList<>();
        
        for (int i = 0; i < deck.length; i++) {
            for (int j = 0; j < 4; j++) {
                deckAsArrayList.add(deck[i]);
            }
        }

        return deckAsArrayList; 
    }
}
