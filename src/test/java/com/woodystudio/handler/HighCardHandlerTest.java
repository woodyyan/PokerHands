package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HighCardHandlerTest {
    @Test
    public void shouldReturnHighCardWhenPokersAreHighCard() {
        HighCardHandler handler = new HighCardHandler();
        List<Poker> pokers = new ArrayList<>();
        pokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V3));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V5));
        pokers.add(new Poker(Suit.Clubs, PokerValue.V6));
        pokers.add(new Poker(Suit.Diamonds, PokerValue.V8));
        Pokers result = handler.createPokersBySelf(pokers);

        Assert.assertEquals(5, ((HighCard) result).getPokers().size());
    }
}