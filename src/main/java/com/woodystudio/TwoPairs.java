package com.woodystudio;

public class TwoPairs extends Pokers {

    private Poker firstPair;
    private Poker secondPair;
    private Poker poker;

    public TwoPairs(Poker firstPair, Poker secondPair, Poker poker) {
        this.firstPair = firstPair;
        this.secondPair = secondPair;
        this.poker = poker;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.TwoPairs.getValue();
    }

    @Override
    protected boolean compareValues(Pokers other) {
        TwoPairs otherTwoPairs = (TwoPairs) other;
        if (isPairEquals(otherTwoPairs)) {
            return poker.getValue().getValue() > otherTwoPairs.poker.getValue().getValue();
        }
        return isPairGreaterThanOthers(otherTwoPairs);
    }

    private boolean isPairEquals(TwoPairs otherTwoPairs) {
        return (this.firstPair.getValue().getValue() == otherTwoPairs.firstPair.getValue().getValue()
                && this.secondPair.getValue().getValue() == otherTwoPairs.secondPair.getValue().getValue())
                || (this.secondPair.getValue().getValue() == otherTwoPairs.firstPair.getValue().getValue()
                && this.firstPair.getValue().getValue() == otherTwoPairs.secondPair.getValue().getValue());
    }

    private boolean isPairGreaterThanOthers(TwoPairs otherTwoPairs) {
        return (this.firstPair.getValue().getValue() > otherTwoPairs.firstPair.getValue().getValue()
                && this.firstPair.getValue().getValue() > otherTwoPairs.secondPair.getValue().getValue())
                || (this.secondPair.getValue().getValue() > otherTwoPairs.firstPair.getValue().getValue()
                && this.secondPair.getValue().getValue() > otherTwoPairs.secondPair.getValue().getValue());
    }
}
