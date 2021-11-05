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

public class CreateDealerHandFlowTest {
	@Mock
	ICreateHand mockCreateDealerHand = mock(ICreateHand.class);
	
	@Mock
	IDealtACardToHand mockDealtACardToHand = mock(IDealtACardToHand.class);


	ArrayList<String> deck = new ArrayList<String>(Arrays.asList("A", "A", "A", "A", "2", "2", "2", "2", "3", "3", "3", "3", 
																"4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", 
																"7", "7", "7", "7", "8", "8", "8", "8", "9", "9", "9", "9", 
																"10", "10", "10", "10", "J", "J", "J", "J", 
																"Q", "Q", "Q", "Q", "K", "K", "K", "K"));

	@Test
	public void createDealerHandFlowTest() {

		ArrayList<String> hand = new ArrayList<String>();

		// Given: I am a dealer
		given(mockCreateDealerHand.getResult()).willReturn(new ArrayList<String>());
		given(mockDealtACardToHand.getResult(deck, hand)).willReturn(hand); 
	
		// When: I get my starting hand
		ICreateHandFlow ICHF = new CreateDealerHandFlow(mockCreateDealerHand, mockDealtACardToHand);
		ICHF.getResult(deck);
		
		// Then: mockCreateHand will be called one time
		//		mockDealtACardToHand will be called one times
		verify(mockCreateDealerHand, times(1)).getResult();
		verify(mockDealtACardToHand, times(1)).getResult(deck, hand);

	}
}