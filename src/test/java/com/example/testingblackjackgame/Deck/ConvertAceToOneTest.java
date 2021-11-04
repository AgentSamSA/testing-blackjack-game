package com.example.testingblackjackgame.Deck;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConvertAceToOneTest {

	@Test
	public void givenElevenset1() {
		// Given: I am a user
		IConvertAceToOne ICAO = new ConvertAceToOne();
		// When: I have a hand with one card value 11
		ArrayList<Integer> hand = new ArrayList<Integer>();
		hand.add(11);
		int index = hand.indexOf(11);
		ICAO.getResult(hand);
		// Then: convert that 11 to 1 
		assertEquals(true, hand.get(index) == 1);
	}
	
	@Test
	public void givenTwoAces() {
		// Given: I am a user
		IConvertAceToOne ICAO = new ConvertAceToOne();
		// When: I have a hand with 2 card value 11
		ArrayList<Integer> hand = new ArrayList<Integer>();
		hand.add(11);
		hand.add(11);
		int index = hand.indexOf(11);
		ICAO.getResult(hand);
		// Then: convert that 11 to 1 
		assertEquals(true, hand.get(index) == 1);
	}
	
	@Test
	public void givenOneAndTwoAces() {
		// Given: I am a user
		IConvertAceToOne ICAO = new ConvertAceToOne();
		// When: I have a hand with 2 card value 11
		ArrayList<Integer> hand = new ArrayList<Integer>();
		hand.add(1);
		hand.add(11);
		hand.add(11);
		int index = hand.indexOf(11);
		ICAO.getResult(hand);
		// Then: convert that 11 to 1 
		assertEquals(true, hand.get(index) == 1);
	}

}
