package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Scoring.*;

public class PlayerGamePointsCheckFlow implements IPlayerGamePointsCheckFlow{

    private IPlayerGameFlow _IPGF;
    private ICheckIfUnder22 _ICU21;

    public PlayerGamePointsCheckFlow(IPlayerGameFlow IPGF, ICheckIfUnder22 ICU21) {
        this._IPGF = IPGF;
        this._ICU21 = ICU21;
    }

    @Override
    public boolean getResult(ArrayList<String> hand) {
        int totalPoints = this._IPGF.getResult(hand);
        boolean under21Check = this._ICU21.getResult(totalPoints);
        return under21Check;
    }
    
}
