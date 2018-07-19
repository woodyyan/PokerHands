package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.FourOfAKing;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FourOfAKingHandlerTest {
    @Test
    public void shouldReturnFourOfAKingWhenPokersHaveFourSamePoker() {
        FourOfAKingHandler handler = new FourOfAKingHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        Pokers result = handler.createPokers(pokers);

        Assert.assertTrue(result instanceof FourOfAKing);
    }

    @Test
    public void shouldReturnFourOfAKingWhenPokersHaveFourSamePokerAndFirstIsNotKing() {
        FourOfAKingHandler handler = new FourOfAKingHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        Pokers result = handler.createPokers(pokers);

        Assert.assertTrue(result instanceof FourOfAKing);
    }

    @Test
    public void shouldReturnNullWhenPokersAreNotFourOfAKing() {
        FourOfAKingHandler handler = new FourOfAKingHandler();
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
        FourOfAKingHandler handler = new FourOfAKingHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V4));
        Pokers result = handler.createPokers(pokers);

        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnHighCardWhenPokersAreHighCardAndNextHandlerIsNotNull() {
        FourOfAKingHandler handler = new FourOfAKingHandler();
        BasePokerHandler testHandler = new TestBasePokerHandler();
        handler.setNextHandler(testHandler);
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V3));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V7));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V9));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        Pokers result = handler.createPokers(pokers);

        Assert.assertTrue(result instanceof HighCard);
    }

    private class TestBasePokerHandler extends BasePokerHandler {
        @Override
        public Pokers createPokers(List<Poker> pokers) {
            return new HighCard(pokers);
        }
    }
}