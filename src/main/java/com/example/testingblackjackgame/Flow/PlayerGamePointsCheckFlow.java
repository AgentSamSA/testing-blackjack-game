package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.*;

public class PlayerGamePointsCheckFlow implements IPlayerGamePointsCheckFlow {
    private ICheckIfUnder22 _ICU21;
    private IDealtACardToHand _IDACTH;

    public PlayerGamePointsCheckFlow(ICheckIfUnder22 ICU21, IDealtACardToHand IDACTH) {
        this._ICU21 = ICU21;
        this._IDACTH = IDACTH;
    }

    @Override
    public int getResult(int points, ArrayList<String> deck, ArrayList<String> hand) {
        boolean under21Check = this._ICU21.getResult(points);
        
        if (under21Check) {
            this._IDACTH.getResult(deck, hand);
        } else {
            return points;
        }
        return -1;
    }
    
}
