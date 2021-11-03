package com.example.testingblackjackgame;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.testingblackjackgame.Scoring.ISumPoints;
import com.example.testingblackjackgame.Scoring.SumPoints;

public class SumPointsTest {

	
	
	@Test
	public void givenTwoAndTenGet12() {
		//Given: I am a user
		ISumPoints SP = new SumPoints();
		// When: I have a two and a ten
		int result = SP.sum(new int[] {2, 10});
		// Then: I should have 12 points
		assertEquals(12, result);
		
	}
	
	@Test
	public void givenThreeFiveTenGet18() {
		//Given: I am a user
		ISumPoints SP = new SumPoints();
		// When: I have a two and a ten
		int result = SP.sum(new int[] {3, 5, 10});
		// Then: I should have 18 points
		assertEquals(18, result);
		
	}
	
	@Test
	public void givenOneTwoThreeFourFiveGet15() {
		//Given: I am a user
		ISumPoints SP = new SumPoints();
		// When: I have a two and a ten
		int result = SP.sum(new int[] {1,2,3,4,5});
		// Then: I should have 15 points
		assertEquals(15, result);
		
	}

}
