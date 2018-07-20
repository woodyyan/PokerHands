package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;

public class TwoPairs extends Pokers {
    private PokerValue firstPairValue;
    private PokerValue secondPairValue;
    private Poker poker;

    public TwoPairs(PokerValue firstPairValue, PokerValue secondPairValue, Poker poker) {
        this.firstPairValue = firstPairValue;
        this.secondPairValue = secondPairValue;
        this.poker = poker;
    }

    public PokerValue getFirstPairValue() {
        return firstPairValue;
    }

    public void setFirstPairValue(PokerValue firstPairValue) {
        this.firstPairValue = firstPairValue;
    }

    public PokerValue getSecondPair() {
        return secondPairValue;
    }

    public void setSecondPair(PokerValue secondPair) {
        this.secondPairValue = secondPair;
    }

    public Poker getPoker() {
        return poker;
    }

    public void setPoker(Poker poker) {
        this.poker = poker;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.TwoPairs.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        TwoPairs otherTwoPairs = (TwoPairs) other;
        if (isPairEquals(otherTwoPairs)) {
            return poker.getValue().getValue() > otherTwoPairs.poker.getValue().getValue();
        }
        return isPairGreaterThanOthers(otherTwoPairs);
    }

    private boolean isPairEquals(TwoPairs otherTwoPairs) {
        return (this.firstPairValue.getValue() == otherTwoPairs.firstPairValue.getValue()
                && this.secondPairValue.getValue() == otherTwoPairs.secondPairValue.getValue())
                || (this.secondPairValue.getValue() == otherTwoPairs.firstPairValue.getValue()
                && this.firstPairValue.getValue() == otherTwoPairs.secondPairValue.getValue());
    }

    private boolean isPairGreaterThanOthers(TwoPairs otherTwoPairs) {
        return (this.firstPairValue.getValue() > otherTwoPairs.firstPairValue.getValue()
                && this.firstPairValue.getValue() > otherTwoPairs.secondPairValue.getValue())
                || (this.secondPairValue.getValue() > otherTwoPairs.firstPairValue.getValue()
                && this.secondPairValue.getValue() > otherTwoPairs.secondPairValue.getValue());
    }
}
