package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Deck.IConvertAceToOne;
import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.IMyScanner;

public class PlayerGamePointsCheckFlow implements IPlayerGamePointsCheckFlow {
    private ICheckIfUnder22 _ICU21;
    private IDealtACardToHand _IDACTH;
    private IMyScanner _IMS;
    private IConvertCardValue _ICCV;
    private IConvertAceToOne _ICATO;

    public PlayerGamePointsCheckFlow(ICheckIfUnder22 ICU21, IDealtACardToHand IDACTH, IMyScanner IMS, IConvertCardValue ICCV, IConvertAceToOne ICATO) {
        this._ICU21 = ICU21;
        this._IDACTH = IDACTH;
        this._IMS = IMS;
        this._ICCV = ICCV;
        this._ICATO = ICATO;
    }

    @Override
    public int getResult(int points, ArrayList<String> deck, ArrayList<String> hand) {
        boolean under21Check = this._ICU21.getResult(points);
        ArrayList<Integer> intHand = new ArrayList<Integer>();
        
        for (String s : hand) {
        	int val = _ICCV.getResult(s);
        	intHand.add(val);
        }
        
        
        boolean hit = under21Check;
        while (under21Check) {
            hit = this._IMS.getResult();
            if(hit) {
                String card = this._IDACTH.getResult(deck, hand);
                int newPoint = this._ICCV.getResult(card);
                points += newPoint;
                // check if points are over 21 and convert aces to 1 if there are any
                if (points > 21 && intHand.contains(11)) { // maybe while instead of if here
               
                	boolean containsAce =_ICATO.getResult(intHand);
                	if (containsAce) {
                		points -= 10;
                	}
                }
                under21Check = this._ICU21.getResult(points);
            }
        } 
            
        return points;
        
    }
    
}
