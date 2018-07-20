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

        Assert.assertTrue(((TwoPairs) result).getFirstPairValue().equals(PokerValue.V2));
        Assert.assertTrue(((TwoPairs) result).getSecondPair().equals(PokerValue.V3));
        Assert.assertTrue(((TwoPairs) result).getPoker().equals(new Poker(Suit.Clubs, PokerValue.V4)));
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