package com.example.testingblackjackgame.Flow;


import java.util.ArrayList;
import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.IDealerPointCheck;
import com.example.testingblackjackgame.Scoring.ISumPoints;

public class DealerGameFlow implements IDealerGameFlow {
	private IConvertCardValue _ICCV;
	private ISumPoints _ISP;
	private IDealerPointCheck _IDPC;
	private IDealtACardToHand _IDACTH;
	
	public DealerGameFlow(IConvertCardValue ICCV, ISumPoints ISP, IDealerPointCheck IDPC, IDealtACardToHand IDACTH) {
		_ICCV = ICCV;
		_ISP = ISP;
		_IDPC = IDPC;
		_IDACTH = IDACTH;
	}
	
	@Override
	public String getResult(ArrayList<String> deck, ArrayList<String> handStr) {
		ArrayList<Integer> handInt = new ArrayList<Integer>();
		for(String s : handStr) {
			handInt.add( _ICCV.getResult(s) );
		}
		
		int sum = _ISP.sum(handInt);
		
		//stop if over 17
		while(_IDPC.getResult(sum)) {
			String cardDraw = _IDACTH.getResult(deck, handStr);
			int newCard = _ICCV.getResult(cardDraw);
			handInt.add( newCard );	
			sum = _ISP.sum(handInt);
		}

		return "Done Dealer Phase";
	}

}
