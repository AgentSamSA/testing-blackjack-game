package com.example.testingblackjackgame.scanner;


import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.testingblackjackgame.scanner.*;

import org.junit.Test;
import org.mockito.Mock;

public class MyScannerTest {
	@Mock
	IMyScanner mockMyScanner = mock(IMyScanner.class);

	@Test
	public void givenYReturnTure() {
		//Given: I am a user
		//When: I enter "Y"
		IMyScanner IMS = new MyScanner();
		boolean res = IMS.getResult();

		//Then: return true
		assertEquals(true, res);
	}
}
