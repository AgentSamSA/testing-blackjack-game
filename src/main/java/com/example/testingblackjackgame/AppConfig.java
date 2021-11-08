package com.example.testingblackjackgame;

import org.springframework.context.annotation.Bean;

import com.example.testingblackjackgame.Deck.*;
import com.example.testingblackjackgame.Flow.*;
import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.*;

public class AppConfig {

	@Bean(name = "ICreateDeck")
	public ICreateDeck createCreateDeck() {
		return new CreateDeck();
	}
	
	@Bean(name = "IShuffleDeck")
	public IShuffleDeck createShuffleDeck() {
		return new ShuffleDeck();
	}

	@Bean(name = "ICreateHand")
	public ICreateHand createCreateHand() {
		return new CreateHand();
	}

	@Bean(name = "IDealtACardToHand")
	public IDealtACardToHand createDealtACardToHand() {
		return new DealtACardToHand();
	}
	
	@Bean(name = "IStartGameFlow")
	public IStartGameFlow createStartGameFlow() {
		return new StartGameFlow(createCreateDeck(), createShuffleDeck());
	}

	@Bean(name = "ICreatePlayerHandFlow")
	public ICreateHandFlow createCreatePlayerHandFlow() {
		return new CreatePlayerHandFlow(createCreateHand(), createDealtACardToHand());
	}

	@Bean(name = "ICreateDealerHandFlow")
	public ICreateHandFlow createCreateDealerHandFlow() {
		return new CreateDealerHandFlow(createCreateHand(), createDealtACardToHand());
	}

	@Bean(name = "IConvertCardValue") 
	public IConvertCardValue createConvertCardValue() {
		return new ConvertCardValue();
	}
	
	@Bean(name = "ISumPoints")
	public ISumPoints createSumPoints() {
		return new SumPoints();
	}
	
	@Bean(name = "ICheckIfUnder22")
	public ICheckIfUnder22 createCheckIfUnder22() {
		return new CheckIfUnder22();
	}

	@Bean(name = "IMyScanner")
	public IMyScanner createMyScanner() {
		return new MyScanner();
	}
	
	@Bean(name = "IPlayerGameFlow") 
	public IPlayerGameFlow createPlayerGameFlow() {
		return new PlayerGameFlow(createConvertCardValue(), createSumPoints());
	}
	
	@Bean(name = "IConvertAceToOne") 
	public IConvertAceToOne createConvertAveToOne() {
		return new ConvertAceToOne();
	}
	@Bean(name = "IPlayerGamePointsCheckFlow") 
	public IPlayerGamePointsCheckFlow createPlayerGamePointsCheckFlow() {
		return new PlayerGamePointsCheckFlow(createCheckIfUnder22(), createDealtACardToHand());
	}

}
