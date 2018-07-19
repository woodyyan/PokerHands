package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.StraightFlush;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StraightFlushHandlerTest {
    @Test
    public void shouldReturnStraightFlushWhenPokersAreStraightFlush() {
        StraightFlushHandler handler = new StraightFlushHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        Pokers result = handler.createPokers(pokers);

        Assert.assertTrue(result instanceof StraightFlush);
    }

    @Test
    public void shouldReturnNullWhenPokersAreStraightButNotFlush() {
        StraightFlushHandler handler = new StraightFlushHandler();
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
        StraightFlushHandler handler = new StraightFlushHandler();
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