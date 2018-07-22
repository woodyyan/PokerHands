package com.woodystudio.poker;

import com.woodystudio.base.PokerValue;
import org.junit.Assert;
import org.junit.Test;

public class FullHouseTest {
    @Test
    public void shouldReturnTrueWhenFullHouseIsNotSame() {
        FullHouse loser = new FullHouse(PokerValue.J, PokerValue.A);
        FullHouse winner = new FullHouse(PokerValue.A, PokerValue.V3);

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldReturnTrueWhenFullHouseIsSame() {
        FullHouse loser = new FullHouse(PokerValue.J, PokerValue.V2);
        FullHouse winner = new FullHouse(PokerValue.J, PokerValue.V3);

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }
}