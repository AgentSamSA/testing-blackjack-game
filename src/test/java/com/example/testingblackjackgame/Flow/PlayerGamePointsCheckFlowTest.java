package com.example.testingblackjackgame.Flow;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.testingblackjackgame.Scoring.*;
import com.example.testingblackjackgame.scanner.*;

import org.junit.Test;
import org.mockito.Mock;


public class PlayerGamePointsCheckFlowTest {
	@Mock
	IPlayerGameFlow mockPlayerGameFlow = mock(PlayerGameFlow.class);

	@Mock
	ICheckIfUnder22 mockCheckIfUnder22 = mock(ICheckIfUnder22.class);

	ArrayList<String> hand = new ArrayList<String>(Arrays.asList("A", "10"));
	ArrayList<String> hand2 = new ArrayList<String>(Arrays.asList("5", "10"));
	
	@Test
	public void givenAceTenHandCallPlayerGameFlowOnce() {
		//Given: I am a user
		given(mockPlayerGameFlow.getResult(hand)).willReturn(21);
		given(mockCheckIfUnder22.getResult(21)).willReturn(false);

		//When: my hand is Ace and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockPlayerGameFlow, mockCheckIfUnder22);
		IPGLF.getResult(hand);

		//Then: mockPlayerGameFlow is called one time
		verify(mockPlayerGameFlow, times(1)).getResult(hand);
	}

	@Test
	public void givenAceTenHandCallCheckIfUnder22Once() {
		//Given: I am a user
		given(mockPlayerGameFlow.getResult(hand)).willReturn(21);
		given(mockCheckIfUnder22.getResult(21)).willReturn(false);

		//When: my hand is Ace and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockPlayerGameFlow, mockCheckIfUnder22);
		IPGLF.getResult(hand);

		//Then: mockCheckIfUnder22 is called one time
		verify(mockCheckIfUnder22, times(1)).getResult(21);
	}
	
	@Test
	public void givenFiveTenHandCallPlayerGameFlowOnce() {
		//Given: I am a user
		given(mockPlayerGameFlow.getResult(hand2)).willReturn(15);
		given(mockCheckIfUnder22.getResult(15)).willReturn(true);

		//When: my hand is 5 and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockPlayerGameFlow, mockCheckIfUnder22);
		IPGLF.getResult(hand2);

		//Then: mockPlayerGameFlow is called one time
		verify(mockPlayerGameFlow, times(1)).getResult(hand2);
	}

	@Test
	public void givenFiveTenHandCallCheckIfUnder22Once() {
		//Given: I am a user
		given(mockPlayerGameFlow.getResult(hand2)).willReturn(15);
		given(mockCheckIfUnder22.getResult(15)).willReturn(true);

		//When: my hand is 5 and 10
		IPlayerGamePointsCheckFlow IPGLF = new PlayerGamePointsCheckFlow(mockPlayerGameFlow, mockCheckIfUnder22);
		IPGLF.getResult(hand2);

		//Then: mockCheckIfUnder22 is called one time
		verify(mockCheckIfUnder22, times(1)).getResult(15);
	}
}
