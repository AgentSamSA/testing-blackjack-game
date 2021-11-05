package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;


import com.example.testingblackjackgame.Deck.*;


public class StartGameFlow implements IStartGameFlow {
	
	private ICreateDeck _ICD;
	private IShuffleDeck _ISD;
	private IDealtACardToHand _IDACTH;
	public StartGameFlow(ICreateDeck ICD, IShuffleDeck ISD, IDealtACardToHand IDCTH) {
		this._ICD = ICD;
		this._ISD = ISD;
		this._IDACTH = IDCTH;

	}
	
	public void getResult() {
		
		ArrayList<String> deck = new ArrayList<String>();
		deck = this._ICD.getResult();
		deck = this._ISD.getResult(deck);

		ArrayList<String> playerHand = new ArrayList<String>();
		ArrayList<String> dealerHand = new ArrayList<String>();

		this._IDACTH.getResult(deck, playerHand);
		this._IDACTH.getResult(deck, playerHand);
		this._IDACTH.getResult(deck, dealerHand);

	}
}

