package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.javac.util.List.of;

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

    public PokerValue getSecondPair() {
        return secondPairValue;
    }

    public Poker getPoker() {
        return poker;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.TwoPairs.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        TwoPairs otherTwoPairs = (TwoPairs) other;
        if (isPairEquals(otherTwoPairs)) {
            return this.getPoker().getValue().getValue() > otherTwoPairs.getPoker().getValue().getValue();
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
        List<Integer> values = new ArrayList<>(of(this.getFirstPairValue().getValue(), this.getSecondPair().getValue()));
        List<Integer> otherValues = new ArrayList<>(of(otherTwoPairs.getFirstPairValue().getValue(), otherTwoPairs.getSecondPair().getValue()));

        return compareBasedValues(values, otherValues);
    }
}
