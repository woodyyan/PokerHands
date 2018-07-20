package com.woodystudio;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.TwoPairs;
import org.junit.Assert;
import org.junit.Test;

public class TwoPairsTest {
    @Test
    public void shouldSmallTwoPairsLoseToLargeTwoPairs() {
        TwoPairs loseTwoPairs = new TwoPairs(PokerValue.V5, PokerValue.V4, new Poker(Suit.Diamonds, PokerValue.Q));
        TwoPairs winTwoPairs = new TwoPairs(PokerValue.V5, PokerValue.V6, new Poker(Suit.Diamonds, PokerValue.Q));

        boolean isWin = winTwoPairs.compare(loseTwoPairs);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldTwoPairsCanCompareWhenTheyHasSamePairs() {
        TwoPairs loseTwoPairs = new TwoPairs(PokerValue.V5, PokerValue.V4, new Poker(Suit.Diamonds, PokerValue.Q));
        TwoPairs winTwoPairs = new TwoPairs(PokerValue.V5, PokerValue.V4, new Poker(Suit.Diamonds, PokerValue.K));

        boolean isWin = winTwoPairs.compare(loseTwoPairs);

        Assert.assertTrue(isWin);
    }
}