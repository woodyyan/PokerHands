package com.woodystudio.poker;

import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;

public class StraightFlush extends Pokers {
    private Suit suit;
    private PokerValue maxValue;

    public StraightFlush(Suit suit, PokerValue maxValue) {
        this.suit = suit;
        this.maxValue = maxValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public PokerValue getMaxValue() {
        return maxValue;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.StraightFlush.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return this.getMaxValue().getValue() > ((StraightFlush) other).getMaxValue().getValue();
    }
}
