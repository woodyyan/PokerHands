package com.woodystudio;

import java.util.List;

public class Pair extends Pokers {
    private Poker pairPoker;
    private List<Poker> restPokers;

    public Pair(Poker pairPoker, List<Poker> restPokers) {
        this.pairPoker = pairPoker;
        this.restPokers = restPokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.Pair.getValue();
    }

    @Override
    protected boolean compareValues(Pokers other) {
        int pairValue = this.pairPoker.getValue().getValue();
        int otherPairValue = ((Pair) other).pairPoker.getValue().getValue();
        if (pairValue == otherPairValue) {
            for (Poker poker : this.restPokers) {
                int count = 0;
                for (Poker otherPoker : ((Pair) other).restPokers) {
                    if (poker.getValue().getValue() > otherPoker.getValue().getValue()) {
                        count++;
                    }
                }
                if (count == restPokers.size()) {
                    return true;
                }
            }
            return false;
        }
        return pairValue > otherPairValue;
    }
}
