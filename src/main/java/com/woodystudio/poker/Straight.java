package com.woodystudio.poker;

import com.woodystudio.base.PokerValue;

public class Straight extends Pokers {
    private PokerValue maxValue;

    public Straight(PokerValue maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.Straight.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return this.getMaxValue().getValue() > ((Straight) other).getMaxValue().getValue();
    }

    public PokerValue getMaxValue() {
        return maxValue;
    }
}
