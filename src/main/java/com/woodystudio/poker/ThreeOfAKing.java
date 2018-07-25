package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;

import java.util.List;
import java.util.stream.Collectors;

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
            List<Integer> values = this.getRestPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());
            List<Integer> otherValues = ((ThreeOfAKing) other).getRestPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());

            return compareBasedValues(values, otherValues);
        }
        return this.getKingPokerValue().getValue() > otherThree.getKingPokerValue().getValue();
    }
}
