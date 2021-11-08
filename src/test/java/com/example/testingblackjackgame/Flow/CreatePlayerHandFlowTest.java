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


public class CreatePlayerHandFlowTest {

	@Mock
	ICreateHand mockCreateHand = mock(ICreateHand.class);
	
	@Mock
	IDealtACardToHand mockDealtACardToHand = mock(IDealtACardToHand.class);


	ArrayList<String> deck = new ArrayList<String>(Arrays.asList("A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", 
																"4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", 
																"7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", 
																"10", "10", "10", "10", "J", "J", "J", "J", 
																"Q", "Q", "Q", "Q", "K", "K", "K", "K"));


	@Test
	public void givenAStartingHandCallCreateHandOnce() {

		ArrayList<String> hand = new ArrayList<String>();

		// Given: I am a player
		given(mockCreateHand.getResult()).willReturn(new ArrayList<String>());
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A"); 
	
		// When: I get my starting hand
		ICreateHandFlow ICHF = new CreatePlayerHandFlow(mockCreateHand, mockDealtACardToHand);
		ICHF.getResult(deck);
		
		// Then: mockCreateHand will be called one time
		verify(mockCreateHand, times(1)).getResult();
	}

	@Test
	public void givenAStartingHandCallDealtACardToHandTwice() {

		ArrayList<String> hand = new ArrayList<String>();

		// Given: I am a player
		given(mockCreateHand.getResult()).willReturn(new ArrayList<String>());
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A"); 
	
		// When: I get my starting hand
		ICreateHandFlow ICHF = new CreatePlayerHandFlow(mockCreateHand, mockDealtACardToHand);
		ICHF.getResult(deck);
		
		// Then: mockDealtACardToHand will be called two times
		verify(mockDealtACardToHand, times(2)).getResult(deck, hand);

	}
}
