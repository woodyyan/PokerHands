package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.ThreeOfAKing;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeOfAKingHandlerTest {
    @Test
    public void shouldReturnThreeOfAkingWhenPokersAreThreeOfAKing() {
        ThreeOfAKingHandler handler = new ThreeOfAKingHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertTrue(((ThreeOfAKing) result).getKingPokerValue().equals(PokerValue.V2));
        Assert.assertEquals(2, ((ThreeOfAKing) result).getRestPokers().size());
    }

    @Test
    public void shouldReturnNullWhenPokersAreTwoPairs() {
        ThreeOfAKingHandler handler = new ThreeOfAKingHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }
}