package com.example.testingblackjackgame.Deck;

import static org.junit.Assert.*;

import org.junit.Test;


public class ConvertCardValueTest {

	@Test
	public void GivenJReturn10() {
//		Given: I am a user
//		When: I have the card “J”
//		Then: that card is worth 10 point
		IConvertCardValue ICCV = new ConvertCardValue();
		int result = ICCV.getResult("J");
		assertEquals(10, result);
	}

	@Test
	public void Given5Return5() {
//		Given: I am a user
//		When: I have the card “5”
//		Then: that card is worth 5 point
		IConvertCardValue ICCV = new ConvertCardValue();
		int result = ICCV.getResult("5");
		assertEquals(5, result);
	}
	
	@Test
	public void GivenAReturn11() {
//		Given: I am a user
//		When: I have the card “A”
//		Then: that card is worth 11 point
		IConvertCardValue ICCV = new ConvertCardValue();
		int result = ICCV.getResult("A");
		assertEquals(11, result);
	}
}
