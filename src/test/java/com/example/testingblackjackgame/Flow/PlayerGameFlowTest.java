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
	
    @Mock
    ICheckIfUnder22 mockCheckIfUnder22 = mock(ICheckIfUnder22.class);

    


    @Test
	public void PlayerGameFlowTest() {

		// Given: I am a user
        given(mockConvertCardValue.getResult("A")).willReturn(11);
		given(mockSumPoints.sum(new ArrayList<Integer>())).willReturn(2);
		given(mockCheckIfUnder22.getResult(9)).willReturn(true); 
	
		// When: I Player a game
		IPlayerGameFlow IPGF = new PlayerGameFlow(mockConvertCardValue, mockSumPoints, mockCheckIfUnder22);
		ArrayList<String> hand = new ArrayList<String>();
		IPGF.getResult(hand);
		
		// Then: mockCreateDeck will be called one time
		//		mockCheckIfUnder22 will be called one time
		verify(mockConvertCardValue, times(2)).getResult("A");
        verify(mockSumPoints, times(1)).sum(new ArrayList<Integer>());
		verify(mockCheckIfUnder22, times(1)).getResult(9);

	}
}
