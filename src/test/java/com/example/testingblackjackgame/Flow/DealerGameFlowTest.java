package com.example.testingblackjackgame.Flow;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mock;

import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.IDealerPointCheck;
import com.example.testingblackjackgame.Scoring.ISumPoints;

public class DealerGameFlowTest {

	@Mock
	IConvertCardValue mockConvertCardValue = mock(IConvertCardValue.class);
	
    @Mock
	ISumPoints mockSumPoints = mock(ISumPoints.class);
    
    @Mock
    IDealerPointCheck mockDealerPointCheck = mock(IDealerPointCheck.class);

    @Mock
    IDealtACardToHand mockDealtACardToHand = mock(IDealtACardToHand.class);
    
    ArrayList<String> deck = new ArrayList<String>(Arrays.asList("A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", 
			 "4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", 
			 "7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", 
			 "10", "10", "10", "10", "J", "J", "J", "J", 
			 "Q", "Q", "Q", "Q", "K", "K", "K", "K"));
    @Test
	public void givenIDealtACardToHandCallZero() {  	
    	ArrayList<String> handStr = new ArrayList<String>(Arrays.asList("A", "6"));
    	ArrayList<Integer> handInt  = new ArrayList<Integer>(Arrays.asList(11, 6));
		// Given: I am a user
    	given(mockConvertCardValue.getResult("A")).willReturn(11);
    	given(mockConvertCardValue.getResult("6")).willReturn(6);
		given(mockSumPoints.sum(handInt)).willReturn(17);
		given(mockDealerPointCheck.getResult(17)).willReturn(false);
		
		// When: I Player a game
		IDealerGameFlow IPGF = new DealerGameFlow(mockConvertCardValue, mockSumPoints, mockDealerPointCheck, mockDealtACardToHand);
		IPGF.getResult(deck, handStr);
		
		// Then: mockDealtACardToHand will be called 0 time
		verify(mockDealtACardToHand, times(0)).getResult(deck, handStr);
	}
    
    @Test
	public void givenIDealtACardToHandCallOnce() {
    	ArrayList<String> handStr = new ArrayList<String>(Arrays.asList("A", "5"));
    	ArrayList<Integer> handInt  = new ArrayList<Integer>(Arrays.asList(11, 5));
		// Given: I am a user
    	given(mockConvertCardValue.getResult("A")).willReturn(11);
    	given(mockConvertCardValue.getResult("5")).willReturn(5);
		given(mockSumPoints.sum(handInt)).willReturn(16);
		given(mockDealerPointCheck.getResult(16)).willReturn(true);
		given(mockDealtACardToHand.getResult(deck, handStr)).willReturn(handStr);
		
		// When: I Player a game
		IDealerGameFlow IPGF = new DealerGameFlow(mockConvertCardValue, mockSumPoints, mockDealerPointCheck, mockDealtACardToHand);
		IPGF.getResult(deck, handStr);
		
		// Then: mockDealtACardToHand will be called one time
		verify(mockDealtACardToHand, times(1)).getResult(deck, handStr);
	}
}
