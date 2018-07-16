package com.woodystudio;

import org.junit.Test;

import static org.junit.Assert.*;

public class PokerFactoryTest {
    @Test
    public void shouldCreateHighCardWhenInputIsHighCard() {
        PokerFactory factory = new PokerFactory();
        String input = "";
        factory.create(input);
    }
}