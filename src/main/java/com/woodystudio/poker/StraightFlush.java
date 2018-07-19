package com.woodystudio.poker;

import com.woodystudio.base.Poker;

import java.util.List;

public class StraightFlush extends Pokers {
    public StraightFlush(List<Poker> pokers) {

    }

    @Override
    protected int getOrder() {
        return PokerOrder.StraightFlush.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        return false;
    }
}
