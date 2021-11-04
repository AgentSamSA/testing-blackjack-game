package com.example.testingblackjackgame.Deck;

public class ConvertCardValue implements IConvertCardValue{

	@Override
	public int getResult(String card) {
		int res = 0;
		switch(card) {
			case "A":
				res = 11;
				break;
			case "2":
				res = 2;
				break;
			case "3":
				res = 3;
				break;
			case "4":
				res = 4;
				break;
			case "5":
				res = 5;
				break;
			case "6":
				res = 6;
				break;
			case "7":
				res = 7;
				break;
			case "8":
				res = 8;
				break;
			case "9":
				res = 9;
				break;
			case "10":
				res = 10;
				break;
			case "J":
				res = 10;
				break;
			case "Q":
				res = 10;
				break;
			case "K":
				res = 10;
				break;
				
		}
		return res;
	}

}
