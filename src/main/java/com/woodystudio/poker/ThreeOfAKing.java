package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;

import java.util.List;

public class ThreeOfAKing extends Pokers {
    private PokerValue kingPokerValue;
    private List<Poker> restPokers;

    public ThreeOfAKing(PokerValue kingPokerValue, List<Poker> restPokers) {
        this.kingPokerValue = kingPokerValue;
        this.restPokers = restPokers;
    }

    public void setKingPokerValue(PokerValue kingPokerValue) {
        this.kingPokerValue = kingPokerValue;
    }

    public void setRestPokers(List<Poker> restPokers) {
        this.restPokers = restPokers;
    }

    public PokerValue getKingPokerValue() {
        return kingPokerValue;
    }

    public List<Poker> getRestPokers() {
        return restPokers;
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
