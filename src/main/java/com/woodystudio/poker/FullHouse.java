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

    public PokerValue getPairPokerValue() {
        return pairPokerValue;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.FullHouse.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        FullHouse otherFullHouse = (FullHouse) other;

        if (this.getFullPokerValue().equals(otherFullHouse.getFullPokerValue())) {
            return this.getPairPokerValue().getValue() > otherFullHouse.getPairPokerValue().getValue();
        }

        return this.getFullPokerValue().getValue() > otherFullHouse.getFullPokerValue().getValue();
    }
}
