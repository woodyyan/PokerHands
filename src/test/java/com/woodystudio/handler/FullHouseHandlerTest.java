package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.FullHouse;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FullHouseHandlerTest {
    @Test
    public void shouldReturnFullHouseWhenPokersAreFullHouse() {
        FullHouseHandler houseHandler = new FullHouseHandler();

        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));

        Pokers result = houseHandler.createPokersBySelf(pokers);

        Assert.assertTrue(result instanceof FullHouse);
    }

    @Test
    public void shouldReturnFullHouseWhenPokersAreFullHouseWithoutOrder() {
        FullHouseHandler houseHandler = new FullHouseHandler();

        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));

        Pokers result = houseHandler.createPokersBySelf(pokers);

        Assert.assertTrue(result instanceof FullHouse);
    }

    @Test
    public void shouldReturnNullWhenPokersAreFourOfAKing() {
        FullHouseHandler houseHandler = new FullHouseHandler();

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
        FullHouseHandler houseHandler = new FullHouseHandler();

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