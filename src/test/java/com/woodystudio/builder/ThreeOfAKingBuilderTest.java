package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.ThreeOfAKing;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeOfAKingBuilderTest {
    @Test
    public void shouldReturnThreeOfAkingWhenPokersAreThreeOfAKing() {
        ThreeOfAKingBuilder handler = new ThreeOfAKingBuilder();
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
        ThreeOfAKingBuilder handler = new ThreeOfAKingBuilder();
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