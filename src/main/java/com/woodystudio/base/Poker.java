package com.woodystudio.base;

public class Poker {
    private Suit suit;
    private PokerValue value;

    public Poker(Suit suit, PokerValue value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public PokerValue getValue() {
        return value;
    }

    public void setValue(PokerValue value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.getValue();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getValue().equals(((Poker) obj).getValue());
    }
}
