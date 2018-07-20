package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.Straight;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StraightHandlerTest {
    @Test
    public void shouldReturnStraightWhenPokersAreStraight() {
        StraightHandler handler = new StraightHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertTrue(result instanceof Straight);
    }

    @Test
    public void shouldReturnNullWhenPokersSizeIsNotFive() {
        StraightHandler handler = new StraightHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnNullWhenPokersAreNotStraight() {
        StraightHandler handler = new StraightHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V8));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }
}