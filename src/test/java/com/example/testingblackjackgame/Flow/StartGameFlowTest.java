package com.example.testingblackjackgame.Flow;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;


import org.junit.Test;

import org.mockito.Mock;

import com.example.testingblackjackgame.Deck.*;

public class StartGameFlowTest {
	
	@Mock
	ICreateDeck mockCreateDeck = mock(ICreateDeck.class);
	
	@Mock
	IShuffleDeck mockShuffleDeck = mock(IShuffleDeck.class);
	
	ArrayList<String> deck = new ArrayList<String>(Arrays.asList("A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", 
																 "4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", 
																 "7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", 
																 "10", "10", "10", "10", "J", "J", "J", "J", 
																 "Q", "Q", "Q", "Q", "K", "K", "K", "K"));

	@Test
	public void givenStartGameFlowCallCreateDeckOnce() {

		// Given: I am a user
		given(mockCreateDeck.getResult()).willReturn(deck);
		given(mockShuffleDeck.getResult(deck)).willReturn(deck); 
	
		// When: I start a game
		IStartGameFlow ISGF = new StartGameFlow(mockCreateDeck, mockShuffleDeck);
		ISGF.getResult();
		
		// Then: mockCreateDeck will be called one time
		verify(mockCreateDeck, times(1)).getResult();
	}

	@Test
	public void givenStartGameFlowCallShuffleDeckOnce() {

		// Given: I am a user
		given(mockCreateDeck.getResult()).willReturn(deck);
		given(mockShuffleDeck.getResult(deck)).willReturn(deck); 
	
		// When: I start a game
		IStartGameFlow ISGF = new StartGameFlow(mockCreateDeck, mockShuffleDeck);
		ISGF.getResult();
		
		//Then: mockShuffleDeck will be called one time
		verify(mockShuffleDeck, times(1)).getResult(deck);
	}

}

