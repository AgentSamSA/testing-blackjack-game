package com.example.testingblackjackgame.Flow;
import com.example.testingblackjackgame.Deck.*;
import java.util.ArrayList;

public class CreateDealerHandFlow implements ICreateHandFlow{
        
    private ICreateHand _ICH;
    private IDealtACardToHand _IDCTH;

    public CreateDealerHandFlow(ICreateHand ICH, IDealtACardToHand IDCTH) {
        this._ICH = ICH;
        this._IDCTH = IDCTH;
    }

    @Override
    public ArrayList<String> getResult(ArrayList<String> deck) {
        ArrayList<String> hand = this._ICH.getResult();
        this._IDCTH.getResult(deck, hand);
        return hand;
    }
}
