package com.example.testingblackjackgame.Flow;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.testingblackjackgame.Deck.IConvertCardValue;
import com.example.testingblackjackgame.Deck.IDealtACardToHand;
import com.example.testingblackjackgame.Scoring.ICheckIfUnder22;
import com.example.testingblackjackgame.Scoring.ISumPoints;

import org.junit.Test;
import org.mockito.Mock;




public class PlayerGameFlowTest {
    @Mock
    IConvertCardValue mockConvertCardValue = mock(IConvertCardValue.class);

    @Mock
	ISumPoints mockSumPoints = mock(ISumPoints.class);



    @Test
	public void PlayerGameFlowTest() {

		// Given: I am a user
        given(mockConvertCardValue.getResult("A")).willReturn(11);
		given(mockSumPoints.sum(new ArrayList<Integer>(Arrays.asList(11)))).willReturn(11);
	
		// When: I Player a game
		IPlayerGameFlow IPGF = new PlayerGameFlow(mockConvertCardValue, mockSumPoints);
		ArrayList<String> hand = new ArrayList<String>(Arrays.asList("A"));
		IPGF.getResult(hand);
		
		// Then: mockConvertCardValue will be called one time
		//		mockSumPoints will be called one time
		verify(mockConvertCardValue, times(1)).getResult("A");
        verify(mockSumPoints, times(1)).sum(new ArrayList<Integer>(Arrays.asList(11)));

	}
}
