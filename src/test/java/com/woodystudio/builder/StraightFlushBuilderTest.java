package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.StraightFlush;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StraightFlushBuilderTest {
    @Test
    public void shouldReturnStraightFlushWhenPokersAreStraightFlush() {
        StraightFlushBuilder handler = new StraightFlushBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        Pokers result = handler.createPokers(pokers);

        Assert.assertEquals(Suit.Diamonds, ((StraightFlush) result).getSuit());
        Assert.assertEquals(PokerValue.V6, ((StraightFlush) result).getMaxValue());
    }

    @Test
    public void shouldReturnNullWhenPokersAreStraightButNotFlush() {
        StraightFlushBuilder handler = new StraightFlushBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V6));
        Pokers result = handler.createPokers(pokers);

        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnNullWhenPokersAreNotStraightButFlush() {
        StraightFlushBuilder handler = new StraightFlushBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V7));
        Pokers result = handler.createPokers(pokers);

        Assert.assertNull(result);
    }
}