package com.example.testingblackjackgame.Scoring;

public class ComparePoint implements IComparePoint {

	@Override
	public int getResult(int user, int dealer) {
		if(user  > dealer) {
			return 1;
		} else if(user < dealer) {
			return -1;
		} 
		return 0;
	}

}
