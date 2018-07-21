package com.woodystudio.poker;

import com.woodystudio.base.Poker;

import java.util.List;

public class Straight extends Pokers {
    private List<Poker> pokers;

    public Straight(List<Poker> pokers) {
        this.pokers = pokers;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    public void setPokers(List<Poker> pokers) {
        this.pokers = pokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.Straight.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        //TODO
        return false;
    }
}
