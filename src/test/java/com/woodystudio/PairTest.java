package com.woodystudio;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PairTest {
    @Test
    public void shouldOnePairCanWinAnotherPairWhenThenHaveDifferentPair() {
        List<Poker> losePokers = new ArrayList<>();
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        losePokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        Pair losePair = new Pair(new Poker(Suit.Clubs, PokerValue.V6), losePokers);
        List<Poker> winPokers = new ArrayList<>();
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        winPokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        Pair winPair = new Pair(new Poker(Suit.Clubs, PokerValue.V7), winPokers);

        boolean isWin = winPair.compare(losePair);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldOnePairCanWinAnotherPairWhenThenHaveSamePair() {
        List<Poker> losePokers = new ArrayList<>();
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        losePokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        Pair losePair = new Pair(new Poker(Suit.Clubs, PokerValue.V6), losePokers);
        List<Poker> winPokers = new ArrayList<>();
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        winPokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V5));
        Pair winPair = new Pair(new Poker(Suit.Clubs, PokerValue.V6), winPokers);

        boolean isWin = winPair.compare(losePair);

        Assert.assertTrue(isWin);
    }
}