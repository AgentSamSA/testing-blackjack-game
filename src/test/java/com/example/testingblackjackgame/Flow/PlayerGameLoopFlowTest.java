package com.example.testingblackjackgame.Flow;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.testingblackjackgame.Deck.*;
import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.*;

import org.junit.Test;
import org.mockito.Mock;


public class PlayerGameLoopFlowTest {
	@Mock
	IPlayerGameFlow mockPlayerGameFlow = mock(PlayerGameFlow.class);

	@Mock
	IDealtACardToHand mockDealtACardToHand = mock(IDealtACardToHand.class);

	@Mock
	ICheckIfUnder22 mockCheckIfUnder22 = mock(ICheckIfUnder22.class);

	@Mock
	IConvertAceToOne mockConvertAceToOne = mock(IConvertAceToOne.class);

	@Mock
	IConvertCardValue mockConvertCardValue = mock(IConvertCardValue.class);

	@Mock
	IMyScanner mockMyScanner = mock(IMyScanner.class);

	ArrayList<String> hand = new ArrayList<String>(Arrays.asList("A", "2", "3"));
	ArrayList<Integer> handPoints = new ArrayList<Integer>(Arrays.asList(11, 2, 3));

	ArrayList<String> deck = new ArrayList<String>(Arrays.asList("A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", 
																"4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", 
																"7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", 
																"10", "10", "10", "10", "J", "J", "J", "J", 
																"Q", "Q", "Q", "Q", "K", "K", "K", "K"));

	@Test
	public void givenPlayerGameTurnCallPlayerGameFlowOnetimes() {
		//Given: I am a Player
		given(mockPlayerGameFlow.getResult(hand)).willReturn(16);
		given(mockCheckIfUnder22.getResult(16)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("y");
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A");
		given(mockConvertCardValue.getResult("4")).willReturn(4);
		given(mockConvertAceToOne.getResult(handPoints)).willReturn(false);
		given(mockCheckIfUnder22.getResult(20)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("n");

		//when: I play in player's turn
		IPlayerGameLoopFlow IPGLF = new PlayerGameLoopFlow(mockPlayerGameFlow, mockDealtACardToHand, mockCheckIfUnder22, mockConvertAceToOne, mockConvertCardValue, mockMyScanner);
		IPGLF.getResult(deck, hand);

		//Then: mockPlayerGameFlow.getResult should called one time
		verify(mockPlayerGameFlow, times(1)).getResult(hand);
	}

	@Test
	public void givenPlayerGameTurnCallCheckIfUnder22Twotimes() {
		//Given: I am a Player
		given(mockPlayerGameFlow.getResult(hand)).willReturn(16);
		given(mockCheckIfUnder22.getResult(16)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("y");
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A");
		given(mockConvertCardValue.getResult("A")).willReturn(11);
		given(mockConvertAceToOne.getResult(handPoints)).willReturn(true);
		given(mockCheckIfUnder22.getResult(17)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("n");

		//when: I play in player's turn
		IPlayerGameLoopFlow IPGLF = new PlayerGameLoopFlow(mockPlayerGameFlow, mockDealtACardToHand, mockCheckIfUnder22, mockConvertAceToOne, mockConvertCardValue, mockMyScanner);
		IPGLF.getResult(deck, hand);

		//Then: mockCheckIfUnder22.getResult should called two time
		verify(mockCheckIfUnder22, times(2)).getResult(17);
	}

	@Test
	public void givenPlayerGameTurnCallMyScannerTwotimes() {
		//Given: I am a Player
		given(mockPlayerGameFlow.getResult(hand)).willReturn(16);
		given(mockCheckIfUnder22.getResult(16)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("y");
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A");
		given(mockConvertCardValue.getResult("A")).willReturn(11);
		given(mockConvertAceToOne.getResult(handPoints)).willReturn(true);
		given(mockCheckIfUnder22.getResult(17)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("n");

		//when: I play in player's turn
		IPlayerGameLoopFlow IPGLF = new PlayerGameLoopFlow(mockPlayerGameFlow, mockDealtACardToHand, mockCheckIfUnder22, mockConvertAceToOne, mockConvertCardValue, mockMyScanner);
		IPGLF.getResult(deck, hand);

		//Then: mockMyScanner.getResult should called two time
		verify(mockMyScanner, times(2)).getResult();
	}

	@Test
	public void givenPlayerGameTurnCallDealtACardToHandOneTimes() {
		//Given: I am a Player
		given(mockPlayerGameFlow.getResult(hand)).willReturn(16);
		given(mockCheckIfUnder22.getResult(16)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("y");
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn("A");
		given(mockConvertCardValue.getResult("A")).willReturn(11);
		given(mockConvertAceToOne.getResult(handPoints)).willReturn(true);
		given(mockCheckIfUnder22.getResult(17)).willReturn(true);
		given(mockMyScanner.getResult()).willReturn("n");

		//when: I play in player's turn
		IPlayerGameLoopFlow IPGLF = new PlayerGameLoopFlow(mockPlayerGameFlow, mockDealtACardToHand, mockCheckIfUnder22, mockConvertAceToOne, mockConvertCardValue, mockMyScanner);
		IPGLF.getResult(deck, hand);

		//Then: mockMyScanner.getResult should called two time
		verify(mockDealtACardToHand, times(1)).getResult(deck, hand);
	}
}
