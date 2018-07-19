package com.woodystudio.base;

public enum Suit {
    Clubs, Diamonds, Hearts, Spades;

    public static Suit parse(String value) {
        switch (value) {
            case "D":
                return Suit.Diamonds;
            case "C":
                return Suit.Clubs;
            case "H":
                return Suit.Hearts;
            case "S":
                return Suit.Spades;
        }
        return Suit.Spades;
    }
}