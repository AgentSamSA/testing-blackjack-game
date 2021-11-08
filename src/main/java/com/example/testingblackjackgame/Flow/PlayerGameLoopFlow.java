package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.testingblackjackgame.Deck.*;
import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.*;

public class PlayerGameLoopFlow implements IPlayerGameLoopFlow{

    private IPlayerGameFlow _IPGF;
    private IDealtACardToHand _IDCTH;
    private ICheckIfUnder22 _ICU21;
    private IConvertAceToOne _ICATO;
    private IConvertCardValue _ICCV;
    private IMyScanner _IMS;

    public PlayerGameLoopFlow(IPlayerGameFlow IPGF, IDealtACardToHand IDCTH, ICheckIfUnder22 ICU21, IConvertAceToOne ICATO, IConvertCardValue ICCV, IMyScanner IMS) {
        this._IPGF = IPGF;
        this._IDCTH = IDCTH;
        this._ICU21 = ICU21;
        this._ICATO = ICATO;
        this._ICCV = ICCV;
        this._IMS = IMS;
    }

    @Override
    public int getResult(ArrayList<String> deck, ArrayList<String> hand) {
        Scanner scanner = new Scanner(System.in);
        int totalPoints = this._IPGF.getResult(hand);
        ArrayList<Integer> pointsArray = new ArrayList<>();

        boolean hit = this._ICU21.getResult(totalPoints);
        while (hit){
            
            String wantMore = this._IMS.getResult();
            if (wantMore.equals("Y") || wantMore.equals("y")) {
                String card = this._IDCTH.getResult(deck, hand);
                int newPoint = this._ICCV.getResult(card);
                pointsArray.add(newPoint);
                totalPoints += newPoint;
                if (totalPoints > 21 && pointsArray.contains(11)) {
                    this._ICATO.getResult(pointsArray);
                    totalPoints -= 10;
                }

                hit = this._ICU21.getResult(totalPoints);
            } else {
                hit = false;
            }
        }

        scanner.close();
        return totalPoints;
    }
    
}
