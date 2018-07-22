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

    public Poker getRestPoker() {
        return restPoker;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.FourOfAKing.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        FourOfAKing otherPokers = (FourOfAKing) other;
        if (this.getKingValue() == otherPokers.getKingValue()) {
            return this.getRestPoker().getValue().getValue() > otherPokers.getRestPoker().getValue().getValue();
        }

        return this.getKingValue().getValue() > otherPokers.getKingValue().getValue();
    }
}
