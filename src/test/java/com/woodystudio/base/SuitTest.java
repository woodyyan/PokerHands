package com.woodystudio.base;

import org.junit.Assert;
import org.junit.Test;

public class SuitTest {
    @Test
    public void shouldReturnClubsGivenC() {
        Suit suit = Suit.parse("C");

        Assert.assertTrue(suit == Suit.Clubs);
    }

    @Test
    public void shouldReturnDiamondsGivenD() {
        Suit suit = Suit.parse("D");

        Assert.assertTrue(suit == Suit.Diamonds);
    }

    @Test
    public void shouldReturnHeartsGivenH() {
        Suit suit = Suit.parse("H");

        Assert.assertTrue(suit == Suit.Hearts);
    }

    @Test
    public void shouldReturnSpadesGivenS() {
        Suit suit = Suit.parse("S");

        Assert.assertTrue(suit == Suit.Spades);
    }

    @Test
    public void shouldReturnSpadesGivenWrongValue() {
        Suit suit = Suit.parse("a");

        Assert.assertTrue(suit == Suit.Spades);
    }
}