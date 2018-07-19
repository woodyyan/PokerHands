package com.woodystudio.poker;

import com.woodystudio.base.Poker;

public class FullHouse extends Pokers {
    private Poker fullPoker;
    private Poker pairPoker;

    public FullHouse(Poker fullPoker, Poker pairPoker) {
        this.fullPoker = fullPoker;
        this.pairPoker = pairPoker;
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
