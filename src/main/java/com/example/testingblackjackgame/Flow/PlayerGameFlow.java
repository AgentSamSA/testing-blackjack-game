package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Scoring.ISumPoints;

public class PlayerGameFlow implements IPlayerGameFlow {

	private IConvertCardValue _ICCV;
	private ISumPoints _ISP;
	
	public PlayerGameFlow(IConvertCardValue ICCV, ISumPoints ISP) {
		_ICCV = ICCV;
		_ISP = ISP;
	}
	
	@Override
	public int getResult(ArrayList<String> hand) {
		ArrayList<Integer> cardValue = new ArrayList<Integer>();
		for (String s : hand) {
			int val = _ICCV.getResult(s);
			cardValue.add(val);
		}
		
		return _ISP.sum(cardValue);
	}

}
