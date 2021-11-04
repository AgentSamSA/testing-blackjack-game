package com.example.testingblackjackgame.Deck;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleDeck implements IShuffleDeck {
    public ArrayList<String> getResult(ArrayList<String> deck) {
        Collections.shuffle(deck);
        return deck;
    }
}
