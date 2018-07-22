package com.woodystudio.poker;

import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import org.junit.Assert;
import org.junit.Test;

public class StraightFlushTest {
    @Test
    public void shouldReturnTrueWhenCompare() {
        StraightFlush loser = new StraightFlush(Suit.Clubs, PokerValue.V7);
        StraightFlush winner = new StraightFlush(Suit.Clubs, PokerValue.J);

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
        Assert.assertTrue(winner.getSuit().equals(Suit.Clubs));
    }

    @Test
    public void shouldReturnFalseWhenCompare() {
        StraightFlush loser = new StraightFlush(Suit.Clubs, PokerValue.V7);
        StraightFlush winner = new StraightFlush(Suit.Clubs, PokerValue.J);

        boolean isWin = loser.compare(winner);

        Assert.assertFalse(isWin);
        Assert.assertTrue(winner.getSuit().equals(Suit.Clubs));
    }
}