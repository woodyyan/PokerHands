package com.woodystudio.poker;

import com.woodystudio.base.Poker;

import java.util.List;
import java.util.stream.Collectors;

public class HighCard extends Pokers {
    private List<Poker> pokers;

    public HighCard(List<Poker> pokers) {
        this.pokers = pokers;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.HighCard.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        List<Integer> values = this.getPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());
        List<Integer> otherValues = ((HighCard) other).getPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());

        return compareBasedValues(values, otherValues);
    }
}
