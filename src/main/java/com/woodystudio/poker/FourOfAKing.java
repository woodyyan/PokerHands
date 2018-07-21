package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;

public class FourOfAKing extends Pokers {
    private PokerValue kingValue;
    private Poker restPoker;

    public FourOfAKing(PokerValue kingValue, Poker restPoker) {
        this.kingValue = kingValue;
        this.restPoker = restPoker;
    }

    public PokerValue getKingValue() {
        return kingValue;
    }

    public void setKingValue(PokerValue kingPoker) {
        this.kingValue = kingPoker;
    }

    public Poker getRestPoker() {
        return restPoker;
    }

    public void setRestPoker(Poker restPoker) {
        this.restPoker = restPoker;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.FourOfAKing.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        //TODO
        return false;
    }
}
