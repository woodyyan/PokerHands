package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import org.junit.Assert;
import org.junit.Test;

public class FourOfAKingTest {
    @Test
    public void shouldReturnTrueWhenKingValueIsNotSame() {
        FourOfAKing loser = new FourOfAKing(PokerValue.V3, new Poker(Suit.Clubs, PokerValue.V2));
        FourOfAKing winner = new FourOfAKing(PokerValue.J, new Poker(Suit.Clubs, PokerValue.V2));

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }

    @Test
    public void shouldReturnTrueWhenKingValueIsSame() {
        FourOfAKing loser = new FourOfAKing(PokerValue.V3, new Poker(Suit.Clubs, PokerValue.V2));
        FourOfAKing winner = new FourOfAKing(PokerValue.V3, new Poker(Suit.Clubs, PokerValue.V3));

        boolean isWin = winner.compare(loser);

        Assert.assertTrue(isWin);
    }
}