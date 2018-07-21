package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.Straight;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StraightBuilderTest {
    @Test
    public void shouldReturnStraightWhenPokersAreStraight() {
        StraightBuilder handler = new StraightBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertEquals(5, ((Straight) result).getPokers().size());
    }

    @Test
    public void shouldReturnNullWhenPokersSizeIsNotFive() {
        StraightBuilder handler = new StraightBuilder();
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
        StraightBuilder handler = new StraightBuilder();
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