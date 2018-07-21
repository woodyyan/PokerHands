package com.woodystudio.poker;

import com.woodystudio.base.Poker;
import com.woodystudio.base.Suit;

import java.util.List;

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
        for (Poker poker : this.getPokers()) {
            int count = 0;
            for (Poker otherPoker : ((Flush) other).getPokers()) {
                if (poker.getValue().getValue() > otherPoker.getValue().getValue()) {
                    count++;
                }
            }
            if (count == this.getPokers().size()) {
                return true;
            }
        }
        return false;
    }
}
