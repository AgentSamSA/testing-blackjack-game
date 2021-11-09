package com.example.testingblackjackgame.Deck;

import java.util.ArrayList;

public class ConvertAceToOne implements IConvertAceToOne{

	@Override
	public boolean getResult(ArrayList<Integer> hand) {
		int index = hand.indexOf(11);
		if (index != -1) {
			hand.set(index, 1);
			return true;
		}
		return false;
	}

}
