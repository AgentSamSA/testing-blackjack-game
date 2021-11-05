package com.example.testingblackjackgame.Scoring;

public class CheckIfUnder22 implements ICheckIfUnder22 {
    public boolean getResult(int num) {
        return num < 21;
    }
}
