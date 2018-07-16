package com.woodystudio;

import org.junit.Assert;
import org.junit.Test;

public class TwoPairsTest {
    @Test
    public void shouldSmallTwoPairsLoseToLargeTwoPairs() {
        TwoPairs loseTwoPairs = new TwoPairs(new Poker(Suit.Clubs, PokerValue.V5),
                new Poker(Suit.Diamonds, PokerValue.V4),
                new Poker(Suit.Diamonds, PokerValue.Q));
        TwoPairs winTwoPairs = new TwoPairs(new Poker(Suit.Clubs, PokerValue.V5),
                new Poker(Suit.Diamonds, PokerValue.V6),
                new Poker(Suit.Diamonds, PokerValue.Q));

        boolean isWin = winTwoPairs.compare(loseTwoPairs);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldTwoPairsCanCompareWhenTheyHasSamePairs() {
        TwoPairs loseTwoPairs = new TwoPairs(new Poker(Suit.Clubs, PokerValue.V5),
                new Poker(Suit.Diamonds, PokerValue.V4),
                new Poker(Suit.Diamonds, PokerValue.Q));
        TwoPairs winTwoPairs = new TwoPairs(new Poker(Suit.Clubs, PokerValue.V5),
                new Poker(Suit.Diamonds, PokerValue.V4),
                new Poker(Suit.Diamonds, PokerValue.K));

        boolean isWin = winTwoPairs.compare(loseTwoPairs);

        Assert.assertTrue(isWin);
    }
}