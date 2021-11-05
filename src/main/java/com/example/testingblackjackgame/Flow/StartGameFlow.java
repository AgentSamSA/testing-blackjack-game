package com.example.testingblackjackgame.Flow;

import java.util.ArrayList;


import com.example.testingblackjackgame.Deck.*;


public class StartGameFlow implements IStartGameFlow {
	
	private ICreateDeck _ICD;
	private IShuffleDeck _ISD;

	public StartGameFlow(ICreateDeck ICD, IShuffleDeck ISD) {
		this._ICD = ICD;
		this._ISD = ISD;
	}
	
	public void getResult() {
		
		ArrayList<String> deck = new ArrayList<String>();
		deck = this._ICD.getResult();
		deck = this._ISD.getResult(deck);
	}
}

