package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Deck.*;

public class CreatePlayerHandFlow implements ICreateHandFlow{
    
    private ICreateHand _ICH;
    private IDealtACardToHand _IDCTH;

    public CreatePlayerHandFlow(ICreateHand ICH, IDealtACardToHand IDCTH) {
        this._ICH = ICH;
        this._IDCTH = IDCTH;
    }

    @Override
    public ArrayList<String> getResult(ArrayList<String> deck) {
        ArrayList<String> hand = this._ICH.getResult();
        this._IDCTH.getResult(deck, hand);
        this._IDCTH.getResult(deck, hand);
        return hand;
    }
    
}
