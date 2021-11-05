package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;

import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Scoring.ICheckIfUnder22;
import com.example.testingblackjackgame.Scoring.ISumPoints;

public class PlayerGameFlow implements IPlayerGameFlow {

	private IConvertCardValue _ICCV;
	private ISumPoints _ISP;
	private ICheckIfUnder22 _ICU22;
	
	public PlayerGameFlow(IConvertCardValue ICCV, ISumPoints ISP, ICheckIfUnder22 ICU22) {
		_ICCV = ICCV;
		_ISP = ISP;
		_ICU22 = ICU22;
	}
	
	@Override
	public boolean getResult(ArrayList<String> hand) {
		int sum = 0;
		ArrayList<Integer> cardValue = new ArrayList<Integer>();
		for (String s : hand) {
			int val = _ICCV.getResult(s);
			cardValue.add(val);
		}
		
		sum = _ISP.sum(cardValue);
		return _ICU22.getResult(sum);
	}

}
