package com.woodystudio.poker;

import com.woodystudio.base.PokerValue;
import org.junit.Assert;
import org.junit.Test;

public class StraightTest {
    @Test
    public void shouldReturnTrueWhenCompareStraight() {
        Straight loser = new Straight(PokerValue.V6);

        Straight winner = new Straight(PokerValue.V7);

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldReturnFalseWhenCompareStraight() {
        Straight loser = new Straight(PokerValue.V6);

        Straight winner = new Straight(PokerValue.V7);

        boolean isWin = loser.compare(winner);

        Assert.assertFalse(isWin);
    }
}