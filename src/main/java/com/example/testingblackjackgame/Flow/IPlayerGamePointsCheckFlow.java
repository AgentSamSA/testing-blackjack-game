package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

public interface IPlayerGamePointsCheckFlow {
    int getResult(int points, ArrayList<String> deck, ArrayList<String> hand);
}
