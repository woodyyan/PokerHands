package com.woodystudio;

import java.util.List;

public class HighCard extends Category {

    private List<Poker> pokers;

    public HighCard(List<Poker> pokers) {
        //TODO validate pokers
        this.pokers = pokers;
    }

    @Override
    protected int getOrder() {
        return PokerOrder.HighCard.getValue();
    }

    @Override
    protected boolean compareValues(Category other) {
        for (Poker poker : this.pokers) {
            int count = 0;
            for (Poker otherPoker : ((HighCard) other).pokers) {
                if (poker.getValue().getValue() > otherPoker.getValue().getValue()) {
                    count++;
                }
            }
            if (count == pokers.size()) {
                return true;
            }
        }
        return false;
    }
}
