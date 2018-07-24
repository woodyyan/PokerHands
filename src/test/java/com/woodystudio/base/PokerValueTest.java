package com.woodystudio.base;

import org.junit.Assert;
import org.junit.Test;

public class PokerValueTest {
    @Test
    public void shouldReturnCorrectPokerValueGivenCorrectString() {
        PokerValue a = PokerValue.parse("A");
        Assert.assertTrue(a == PokerValue.A);

        PokerValue v2 = PokerValue.parse("2");
        Assert.assertTrue(v2 == PokerValue.V2);

        PokerValue v3 = PokerValue.parse("3");
        Assert.assertTrue(v3 == PokerValue.V3);

        PokerValue v4 = PokerValue.parse("4");
        Assert.assertTrue(v4 == PokerValue.V4);

        PokerValue v5 = PokerValue.parse("5");
        Assert.assertTrue(v5 == PokerValue.V5);

        PokerValue v6 = PokerValue.parse("6");
        Assert.assertTrue(v6 == PokerValue.V6);

        PokerValue v7 = PokerValue.parse("7");
        Assert.assertTrue(v7 == PokerValue.V7);

        PokerValue v8 = PokerValue.parse("8");
        Assert.assertTrue(v8 == PokerValue.V8);

        PokerValue v9 = PokerValue.parse("9");
        Assert.assertTrue(v9 == PokerValue.V9);

        PokerValue v10 = PokerValue.parse("T");
        Assert.assertTrue(v10 == PokerValue.V10);

        PokerValue j = PokerValue.parse("J");
        Assert.assertTrue(j == PokerValue.J);

        PokerValue q = PokerValue.parse("Q");
        Assert.assertTrue(q == PokerValue.Q);

        PokerValue k = PokerValue.parse("K");
        Assert.assertTrue(k == PokerValue.K);

        PokerValue other = PokerValue.parse("h");
        Assert.assertTrue(other == PokerValue.A);
    }
}