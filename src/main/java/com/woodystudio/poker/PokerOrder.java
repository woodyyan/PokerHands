package com.woodystudio.poker;

public enum PokerOrder {
    HighCard(1), Pair(2), TwoPairs(3), ThreeOfAKing(4), Straight(5), Flush(6), FullHouse(7), FourOfAKing(8), StraightFlush(9);

    private final int value;

    PokerOrder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
