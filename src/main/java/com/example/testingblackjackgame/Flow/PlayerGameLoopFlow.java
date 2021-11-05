package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.testingblackjackgame.Deck.IConvertAceToOne;
import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.ICheckIfUnder22;
import com.example.testingblackjackgame.Scoring.ISumPoints;

public class PlayerGameLoopFlow implements IPlayerGameLoopFlow{

    private IPlayerGameFlow _IPGF;
    private IDealtACardToHand _IDCTH;
    private ICheckIfUnder22 _ICU21;
    private IConvertAceToOne _ICATO;
    private IConvertCardValue _ICCV;

    public PlayerGameLoopFlow(IPlayerGameFlow IPGF, IDealtACardToHand IDCTH, ICheckIfUnder22 ICU21, IConvertAceToOne ICATO, IConvertCardValue ICCV) {
        this._IPGF = IPGF;
        this._IDCTH = IDCTH;
        this._ICU21 = ICU21;
        this._ICATO = ICATO;
        this._ICCV = ICCV;
    }

    @Override
    public int getResult(ArrayList<String> deck, ArrayList<String> hand) {
        Scanner scanner = new Scanner(System.in);
        int totalPoints = this._IPGF.getResult(hand);
        ArrayList<Integer> pointsArray = new ArrayList<>();

        boolean hit = this._ICU21.getResult(totalPoints);
        while (hit){
            System.out.println("Would you want another card? Y/N");
            String wantMore =  scanner.nextLine();
            if (wantMore.equals("Y") || wantMore.equals("y")) {
                this._IDCTH.getResult(deck, hand);
                totalPoints = this._IPGF.getResult(hand);
                for (String s : hand) {
                    pointsArray.add(this._ICCV.getResult(s));
                }
                if (totalPoints > 21 && pointsArray.contains(11)) {
                    this._ICATO.getResult(pointsArray);
                }
                hit = this._ICU21.getResult(totalPoints);
            } else {
                hit = false;
            }
        }

        



        return totalPoints;
    }
    
}
