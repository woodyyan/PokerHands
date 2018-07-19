package com.woodystudio.poker;

import com.woodystudio.base.Poker;

public class FourOfAKing extends Pokers {
    private Poker kingPoker;
    private Poker restPoker;

    public FourOfAKing(Poker kingPoker, Poker restPoker) {
        this.kingPoker = kingPoker;
        this.restPoker = restPoker;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.FourOfAKing.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return false;
    }
}
