package com.woodystudio.poker;

import com.woodystudio.base.Poker;

import java.util.List;

public class ThreeOfAKing extends Pokers {
    private final Poker kingPoker;
    private final List<Poker> restPokers;

    public ThreeOfAKing(Poker kingPoker, List<Poker> restPokers) {

        this.kingPoker = kingPoker;
        this.restPokers = restPokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.ThreeOfAKing.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return false;
    }
}
