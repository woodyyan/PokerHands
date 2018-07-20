package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.Suit;

import java.util.List;

public class Flush extends Pokers {
    private Suit suit;
    private List<Poker> pokers;

    public Flush(Suit suit, List<Poker> pokers) {

        this.suit = suit;
        this.pokers = pokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.Flush.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return false;
    }
}
