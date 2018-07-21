package com.woodystudio;

import com.woodystudio.builder.PokerFactory;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pair;
import com.woodystudio.poker.Pokers;
import org.junit.Assert;
import org.junit.Test;

public class PokerFactoryTest {
    private PokerFactory factory = new PokerFactory();

    @Test
    public void shouldCreateHighCardWhenInputIsHighCard() {
        String input = "2H 3D 5S 9C KD";
        Pokers pokers = factory.create(input);

        Assert.assertTrue(pokers instanceof HighCard);
    }

    @Test
    public void shouldCreatePairWhenInputIsPair() {
        String input = "2H 3D 5S 9C 9D";
        Pokers pokers = factory.create(input);

        Assert.assertTrue(pokers instanceof Pair);
    }
}