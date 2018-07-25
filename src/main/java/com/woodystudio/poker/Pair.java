package com.woodystudio.poker;

import com.woodystudio.base.Poker;

import java.util.List;
import java.util.stream.Collectors;

public class Pair extends Pokers {
    public Poker getPairPoker() {
        return pairPoker;
    }

    public List<Poker> getRestPokers() {
        return restPokers;
    }

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
    protected boolean compareSameLevelValues(Pokers other) {
        int pairValue = this.getPairPoker().getValue().getValue();
        int otherPairValue = ((Pair) other).getPairPoker().getValue().getValue();
        if (pairValue == otherPairValue) {
            List<Integer> values = this.getRestPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());
            List<Integer> otherValues = ((Pair) other).getRestPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());

            return compareBasedValues(values, otherValues);
        }
        return pairValue > otherPairValue;
    }
}
