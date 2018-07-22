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
        ThreeOfAKing otherThree = (ThreeOfAKing) other;
        if (this.getKingPokerValue().equals(otherThree.getKingPokerValue())) {
            for (Poker poker : this.getRestPokers()) {
                int count = 0;
                for (Poker otherPoker : otherThree.getRestPokers()) {
                    if (poker.getValue().getValue() > otherPoker.getValue().getValue()) {
                        count++;
                    }
                }
                if (count == this.getRestPokers().size()) {
                    return true;
                }
            }
        }
        return this.getKingPokerValue().getValue() > otherThree.getKingPokerValue().getValue();
    }
}
