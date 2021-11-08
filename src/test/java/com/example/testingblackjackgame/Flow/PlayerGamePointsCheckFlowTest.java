package com.example.testingblackjackgame.Flow;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.*;

import org.junit.Test;
import org.mockito.Mock;


public class PlayerGamePointsCheckFlowTest {

	@Mock
	ICheckIfUnder22 mockCheckIfUnder22 = mock(ICheckIfUnder22.class);

	@Mock
	IDealtACardToHand mockDealtACardToHand = mock(IDealtACardToHand.class);

	ArrayList<String> hand = new ArrayList<String>(Arrays.asList("A", "10"));
	ArrayList<String> hand2 = new ArrayList<String>(Arrays.asList("5", "10"));
	ArrayList<String> deck = new ArrayList<String>(Arrays.asList("A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", 
																"4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", 
																"7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", 
																"10", "10", "10", "10", "J", "J", "J", "J", 
																"Q", "Q", "Q", "Q", "K", "K", "K", "K"));
	
	@Test
	public void givenAceTenHandCallCheckIfUnder22Once() {
		//Given: I am a user
		given(mockCheckIfUnder22.getResult(21)).willReturn(false);
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A");

		//When: my hand is Ace and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockCheckIfUnder22, mockDealtACardToHand);
		IPGLF.getResult(21, deck, hand);

		//Then: mockCheckIfUnder22 is called one time
		verify(mockCheckIfUnder22, times(1)).getResult(21);
	}

	@Test
	public void givenAceTenHandCallDealtACardToHandZeroTimes() {
		//Given: I am a user
		given(mockCheckIfUnder22.getResult(21)).willReturn(false);
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A");

		//When: my hand is Ace and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockCheckIfUnder22, mockDealtACardToHand);
		IPGLF.getResult(21, deck, hand);

		//Then: mockDealtACardToHand is called one time
		verify(mockDealtACardToHand, times(0)).getResult(deck, hand);
	}

	@Test
	public void givenFiveTenHandCallCheckIfUnder22Once() {
		//Given: I am a user
		given(mockCheckIfUnder22.getResult(15)).willReturn(true);
		given(mockDealtACardToHand.getResult(deck, hand2)).willReturn("A");

		//When: my hand is 5 and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockCheckIfUnder22, mockDealtACardToHand);
		IPGLF.getResult(15, deck, hand2);

		//Then: mockCheckIfUnder22 is called one time
		verify(mockCheckIfUnder22, times(1)).getResult(15);
	}

	@Test
	public void givenFiveTenHandCallDealtACardToHandOnce() {
		//Given: I am a user
		given(mockCheckIfUnder22.getResult(15)).willReturn(true);
		given(mockDealtACardToHand.getResult(deck, hand2)).willReturn("A");

		//When: my hand is 5 and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockCheckIfUnder22, mockDealtACardToHand);
		IPGLF.getResult(15, deck, hand2);

		//Then: mockDealtACardToHand is called one time
		verify(mockDealtACardToHand, times(1)).getResult(deck, hand2);
	}
}
