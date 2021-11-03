package com.example.testingblackjackgame;

import static org.junit.Assert.assertEquals;

import com.example.testingblackjackgame.Scoring.DealerPointCheck;
import com.example.testingblackjackgame.Scoring.IDealerPointCheck;

import org.junit.Test;

public class DealerUnder17CheckTest {
    @Test
    public void given16ReturnTrue() {
        //given: I am a dealer
        //When: my pts are 16
        IDealerPointCheck IDPC = new DealerPointCheck();
        boolean result = IDPC.getResult(16);
        //Then: Return tsrue
        assertEquals(true, result);
    }
    @Test
    public void given4ReturnTrue() {
        //given: I am a dealer
        //When: my pts are 4
        IDealerPointCheck IDPC = new DealerPointCheck();
        boolean result = IDPC.getResult(4);
        //Then: Return true
        assertEquals(true, result);
    }
    @Test
    public void given17Returnfalse() {
        //given: I am a dealer
        //When: my pts are 17
        IDealerPointCheck IDPC = new DealerPointCheck();
        boolean result = IDPC.getResult(17);
        //Then: Return false
        assertEquals(false, result);
    }
    
}
