package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.Suit;

import java.util.List;
import java.util.stream.Collectors;

public class Flush extends Pokers {
    public Suit getSuit() {
        return suit;
    }

    public List<Poker> getPokers() {
        return pokers;
    }

    private Suit suit;
    private List<Poker> pokers;

    public Flush(Suit suit, List<Poker> pokers) {

        this.suit = suit;
        this.pokers = pokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.Flush.getValue();
    }

    @Override
    protected boolean compareSameLevelValues(Pokers other) {
        List<Integer> values = this.getPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());
        List<Integer> otherValues = ((HighCard) other).getPokers().stream().map(it -> it.getValue().getValue()).collect(Collectors.toList());

        return compareBasedValues(values, otherValues);
    }
}
