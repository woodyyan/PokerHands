package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pair;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PairHandlerTest {
    @Test
    public void shouldReturnPairWhenPokersHasOnlyOnePair() {
        PairHandler pairHandler = new PairHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        Pokers result = pairHandler.createPokersBySelf(pokers);

        Assert.assertTrue(((Pair) result).getPairPoker().getValue().equals(PokerValue.V2));
        Assert.assertEquals(3, ((Pair) result).getRestPokers().size());
    }

    @Test
    public void shouldReturnPairWhenPokersHasNoPair() {
        PairHandler pairHandler = new PairHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.J));
        Pokers result = pairHandler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }
}