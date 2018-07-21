package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.FullHouse;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FullHouseBuilderTest {
    @Test
    public void shouldReturnFullHouseWhenPokersAreFullHouse() {
        FullHouseBuilder houseHandler = new FullHouseBuilder();

        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));

        Pokers result = houseHandler.createPokersBySelf(pokers);

        Assert.assertTrue(((FullHouse) result).getFullPokerValue().equals(PokerValue.V3));
        Assert.assertTrue(((FullHouse) result).getPairPokerValue().equals(PokerValue.V2));
    }

    @Test
    public void shouldReturnFullHouseWhenPokersAreFullHouseWithoutOrder() {
        FullHouseBuilder houseHandler = new FullHouseBuilder();

        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));

        Pokers result = houseHandler.createPokersBySelf(pokers);

        Assert.assertTrue(((FullHouse) result).getFullPokerValue().equals(PokerValue.V3));
        Assert.assertTrue(((FullHouse) result).getPairPokerValue().equals(PokerValue.V2));
    }

    @Test
    public void shouldReturnNullWhenPokersAreFourOfAKing() {
        FullHouseBuilder houseHandler = new FullHouseBuilder();

        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));

        Pokers result = houseHandler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnNullWhenPokersOnlyHasThreePokers() {
        FullHouseBuilder houseHandler = new FullHouseBuilder();

        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));

        Pokers result = houseHandler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }
}