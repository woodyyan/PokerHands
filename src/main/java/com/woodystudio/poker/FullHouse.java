package com.woodystudio.poker;

import com.woodystudio.base.PokerValue;

public class FullHouse extends Pokers {
    private PokerValue fullPokerValue;
    private PokerValue pairPokerValue;

    public FullHouse(PokerValue fullPokerValue, PokerValue pairPokerValue) {
        this.fullPokerValue = fullPokerValue;
        this.pairPokerValue = pairPokerValue;
    }

    public PokerValue getFullPokerValue() {
        return fullPokerValue;
    }

    public void setFullPokerValue(PokerValue fullPokerValue) {
        this.fullPokerValue = fullPokerValue;
    }

    public PokerValue getPairPokerValue() {
        return pairPokerValue;
    }

    public void setPairPokerValue(PokerValue pairPokerValue) {
        this.pairPokerValue = pairPokerValue;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.FullHouse.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return false;
    }
}
