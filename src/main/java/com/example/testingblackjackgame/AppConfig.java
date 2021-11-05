package com.example.testingblackjackgame;

import org.springframework.context.annotation.Bean;

import com.example.testingblackjackgame.Deck.*;
import com.example.testingblackjackgame.Flow.*;

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


}
