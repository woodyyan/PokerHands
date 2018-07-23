package com.woodystudio;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HighCardTest {
    @Test
    public void shouldPairWinsHighCard() {
        List<Poker> pairPokers = new ArrayList<>();
        pairPokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        pairPokers.add(new Poker(Suit.Clubs, PokerValue.V2));
        pairPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        Pair pair = new Pair(new Poker(Suit.Clubs, PokerValue.V7), pairPokers);
        List<Poker> highCardPokers = new ArrayList<>();
        highCardPokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        highCardPokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        highCardPokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        highCardPokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        highCardPokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        HighCard highCard = new HighCard(highCardPokers);

        boolean isWin = pair.compare(highCard);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldTwoHighCardsCanCompare() {
        List<Poker> losePokers = new ArrayList<>();
        losePokers.add(new Poker(Suit.Clubs, PokerValue.A));
        losePokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V6));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        HighCard loseHighCard = new HighCard(losePokers);
        List<Poker> winPokers = new ArrayList<>();
        winPokers.add(new Poker(Suit.Clubs, PokerValue.A));
        winPokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V6));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.K));
        HighCard winHighCard = new HighCard(winPokers);

        boolean isWin = loseHighCard.compare(winHighCard);

        Assert.assertFalse(isWin);
    }

    @Test
    public void shouldReturnTrueWhenTwoHighCardsCompare() {
        List<Poker> losePokers = new ArrayList<>();
        losePokers.add(new Poker(Suit.Clubs, PokerValue.A));
        losePokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.V6));
        losePokers.add(new Poker(Suit.Clubs, PokerValue.Q));
        HighCard loseHighCard = new HighCard(losePokers);

        List<Poker> winPokers = new ArrayList<>();
        winPokers.add(new Poker(Suit.Clubs, PokerValue.A));
        winPokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.V6));
        winPokers.add(new Poker(Suit.Clubs, PokerValue.K));
        HighCard winHighCard = new HighCard(winPokers);

        boolean isWin = winHighCard.compare(loseHighCard);

        Assert.assertTrue(isWin);
    }
}