package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.TwoPairs;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TwoPairsHandlerTest {
    @Test
    public void shouldReturnTwoPairsWhenPokersAreTwoPairs() {
        TwoPairsHandler handler = new TwoPairsHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertTrue(result instanceof TwoPairs);
    }

    @Test
    public void shouldReturnTwoPairsWhenPokersAreNotTwoPairs() {
        TwoPairsHandler handler = new TwoPairsHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }
}