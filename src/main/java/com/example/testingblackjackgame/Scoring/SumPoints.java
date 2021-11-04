package com.example.testingblackjackgame.Scoring;

import java.util.ArrayList;

public class SumPoints implements ISumPoints {

	@Override
	public int sum(ArrayList<Integer> cards) {
		int sum = 0;
		for (int i: cards) {
			sum += i;
		}
		return sum;
	}

}
