package com.example.testingblackjackgame.Scoring;

public class SumPoints implements ISumPoints {

	@Override
	public int sum(int[] cards) {
		int sum = 0;
		for (int i: cards) {
			sum += i;
		}
		return sum;
	}

}
