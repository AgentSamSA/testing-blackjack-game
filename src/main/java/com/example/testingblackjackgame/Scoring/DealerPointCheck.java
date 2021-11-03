package com.example.testingblackjackgame.Scoring;

public class DealerPointCheck implements IDealerPointCheck{
    public boolean getResult(int num) {
        return num <= 16;
    }
}
