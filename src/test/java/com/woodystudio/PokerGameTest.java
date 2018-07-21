package com.woodystudio;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.builder.PokerFactory;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pair;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerGameTest {
    String playerOne = "2H 3D 5S 9C KD";
    String playerTwo = "2H 3D 5S 9C JD";

    @Test
    public void shouldCompareTwoHighCardsWhenPlayerOneWin() {
        PokerFactory factory = new TestPokerFactory();
        PokerGame game = new PokerGame(factory);
        game.setPlayerOne(playerOne);
        game.setPlayerTwo(playerTwo);
        String result = game.match();

        Assert.assertEquals(playerTwo, result);
    }

    @Test
    public void shouldCompareTwoHighCardsWhenPlayerTwoWin() {
        PokerFactory factory = new TestPokerFactory();
        PokerGame game = new PokerGame(factory);
        game.setPlayerOne(playerTwo);
        game.setPlayerTwo(playerOne);
        String result = game.match();

        Assert.assertEquals(playerTwo, result);
    }

    private class TestPokerFactory extends PokerFactory {
        @Override
        public Pokers create(String cards) {
            List<Poker> pokers = new ArrayList<>();
            if (cards.equals(playerOne)) {
                return new HighCard(pokers);
            } else {
                return new Pair(new Poker(Suit.Diamonds, PokerValue.K), new ArrayList<>());
            }
        }
    }
}