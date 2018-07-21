package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.FourOfAKing;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FourOfAKingBuilderTest {
    @Test
    public void shouldReturnFourOfAKingWhenPokersHaveFourSamePoker() {
        FourOfAKingBuilder handler = new FourOfAKingBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        Pokers result = handler.createPokers(pokers);

        Assert.assertTrue(((FourOfAKing) result).getKingValue().equals(PokerValue.V2));
        Assert.assertTrue(((FourOfAKing) result).getRestPoker().getValue().equals(PokerValue.V3));
        Assert.assertTrue(((FourOfAKing) result).getRestPoker().getSuit().equals(Suit.Clubs));
    }

    @Test
    public void shouldReturnFourOfAKingWhenPokersHaveFourSamePokerAndFirstIsNotKing() {
        FourOfAKingBuilder handler = new FourOfAKingBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        Pokers result = handler.createPokers(pokers);

        Assert.assertTrue(((FourOfAKing) result).getKingValue().equals(PokerValue.V2));
        Assert.assertTrue(((FourOfAKing) result).getRestPoker().getValue().equals(PokerValue.V3));
        Assert.assertTrue(((FourOfAKing) result).getRestPoker().getSuit().equals(Suit.Diamonds));
    }

    @Test
    public void shouldReturnNullWhenPokersAreNotFourOfAKing() {
        FourOfAKingBuilder handler = new FourOfAKingBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        Pokers result = handler.createPokers(pokers);

        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnNullWhenPokersSizeAreNotFive() {
        FourOfAKingBuilder handler = new FourOfAKingBuilder();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        Pokers result = handler.createPokers(pokers);

        Assert.assertNull(result);
    }
}