package com.example.testingblackjackgame.Scoring;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComparePointTest {

	@Test
	public void Given13And20GetNegative1() {
//		Given: I am a user
//		When: I have 13 points and dealer has 20 points
//		Then: Return false (Lose)
		
		IComparePoint ICP = new ComparePoint();
		int result = ICP.getResult(13, 20);
		assertEquals(-1, result);
	}

	@Test
	public void Given21And17Get1() {
//		Given: I am a user
//		When: I have 21 points and dealer has 17 points
//		Then: Return true (Win)
		
		IComparePoint ICP = new ComparePoint();
		int result = ICP.getResult(21, 17);
		assertEquals(1, result);
	}
	
	@Test
	public void Given17And17Get0() {
//		Given: I am a user
//		When: I have 21 points and dealer has 17 points
//		Then: Return true (Win)
		
		IComparePoint ICP = new ComparePoint();
		int result = ICP.getResult(17, 17);
		assertEquals(0, result);
	}
	 
}
