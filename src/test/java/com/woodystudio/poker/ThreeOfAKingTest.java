package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeOfAKingTest {
    @Test
    public void shouldReturnTrueWhenThreeIsNotSame() {
        List<Poker> loserPokers = new ArrayList<>();
        loserPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        loserPokers.add(new Poker(Suit.Clubs, PokerValue.V5));
        ThreeOfAKing loser = new ThreeOfAKing(PokerValue.V2, loserPokers);

        List<Poker> winnerPokers = new ArrayList<>();
        winnerPokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        winnerPokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        ThreeOfAKing winner = new ThreeOfAKing(PokerValue.A, winnerPokers);

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldReturnTrueWhenThreeIsSame() {
        List<Poker> loserPokers = new ArrayList<>();
        loserPokers.add(new Poker(Suit.Clubs, PokerValue.V4));
        loserPokers.add(new Poker(Suit.Clubs, PokerValue.V5));
        ThreeOfAKing loser = new ThreeOfAKing(PokerValue.V2, loserPokers);

        List<Poker> winnerPokers = new ArrayList<>();
        winnerPokers.add(new Poker(Suit.Diamonds, PokerValue.V2));
        winnerPokers.add(new Poker(Suit.Diamonds, PokerValue.V6));
        ThreeOfAKing winner = new ThreeOfAKing(PokerValue.V2, winnerPokers);

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }
}