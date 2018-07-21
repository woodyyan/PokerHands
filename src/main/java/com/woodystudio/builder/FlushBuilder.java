package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Flush;
import com.woodystudio.poker.Pokers;

import java.util.List;

public class FlushBuilder extends BasePokerBuilder {
    private static final int FLUSH_SIZE = 1;
    private static final int FIRST_INDEX = 0;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        long count = pokers.stream().map(Poker::getSuit).distinct().count();
        if (count == FLUSH_SIZE) {
            Suit suit = pokers.get(FIRST_INDEX).getSuit();
            return new Flush(suit, pokers);
        }
        return null;
    }
}
