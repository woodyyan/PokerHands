package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Flush;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlushHandlerTest {
    @Test
    public void shouldReturnFlushGivenPokersAreFlush() {
        FlushHandler handler = new FlushHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V7));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V9));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.J));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertTrue(((Flush) result).getSuit().equals(Suit.Diamonds));
        Assert.assertEquals(5, ((Flush) result).getPokers().size());
    }

    @Test
    public void shouldReturnNullGivenPokersAreNotFlush() {
        FlushHandler handler = new FlushHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V5));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V7));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V9));
        pokers.add(new Poker(Suit.Clubs, PokerValue.J));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertNull(result);
    }
}