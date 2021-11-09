package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.IMyScanner;

public class PlayerGamePointsCheckFlow implements IPlayerGamePointsCheckFlow {
    private ICheckIfUnder22 _ICU21;
    private IDealtACardToHand _IDACTH;
    private IMyScanner _IMS;
    private IConvertCardValue _ICCV;

    public PlayerGamePointsCheckFlow(ICheckIfUnder22 ICU21, IDealtACardToHand IDACTH, IMyScanner IMS, IConvertCardValue ICCV) {
        this._ICU21 = ICU21;
        this._IDACTH = IDACTH;
        this._IMS = IMS;
        this._ICCV = ICCV;
    }

    @Override
    public int getResult(int points, ArrayList<String> deck, ArrayList<String> hand) {
        boolean under21Check = this._ICU21.getResult(points);
        boolean hit = under21Check;
        if (under21Check) {
            hit = this._IMS.getResult();
            if(hit) {
                String card = this._IDACTH.getResult(deck, hand);
                int newPoint = this._ICCV.getResult(card);
                points += newPoint;
                under21Check = this._ICU21.getResult(points);
            }
        } else {
            return points;
        }
        return -1;
    }
    
}
