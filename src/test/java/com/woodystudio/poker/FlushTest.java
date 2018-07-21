package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlushTest {
    @Test
    public void shouldReturnTrueWhenCompare() {
        List<Poker> losePokers = new ArrayList<>();
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V9));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V7));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V3));

        List<Poker> winPokers = new ArrayList<>();
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V9));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.J));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V3));

        Flush loseFlush = new Flush(Suit.Clubs, losePokers);
        Flush winFlush = new Flush(Suit.Clubs, winPokers);

        boolean isWin = winFlush.compareSameLevelValues(loseFlush);

        Assert.assertTrue(isWin);
        Assert.assertEquals(Suit.Clubs, loseFlush.getSuit());
        Assert.assertEquals(PokerOrder.Flush.getValue(), loseFlush.getOrder());
    }

    @Test
    public void shouldReturnFalseWhenCompare() {
        List<Poker> losePokers = new ArrayList<>();
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V9));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V7));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V3));

        List<Poker> winPokers = new ArrayList<>();
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V9));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.J));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V3));

        Flush loseFlush = new Flush(Suit.Clubs, losePokers);
        Flush winFlush = new Flush(Suit.Clubs, winPokers);

        boolean isWin = loseFlush.compareSameLevelValues(winFlush);

        Assert.assertFalse(isWin);
        Assert.assertEquals(Suit.Clubs, loseFlush.getSuit());
        Assert.assertEquals(PokerOrder.Flush.getValue(), loseFlush.getOrder());
    }
}