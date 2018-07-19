package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.StraightFlush;

import java.util.List;
import java.util.stream.Collectors;

import static com.woodystudio.poker.Pokers.POKER_SIZE;

public class StraightFlushHandler extends BasePokerHandler {

    private static final int SUIT_SIZE = 1;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 4;

    @Override
    public Pokers createPokers(List<Poker> pokers) {

        if (isSameSuit(pokers) && isStraight(pokers)) {
            return new StraightFlush(pokers);
        }

        if (this.getNextHandler() != null) {
            return this.getNextHandler().createPokers(pokers);
        }
        return null;
    }

    private boolean isStraight(List<Poker> pokers) {
        List<Integer> values = pokers.stream().map(p -> p.getValue().getValue()).sorted().collect(Collectors.toList());
        if (values.size() == POKER_SIZE) {
            Integer first = values.get(FIRST_INDEX);
            Integer last = values.get(LAST_INDEX);
            if (last - first == LAST_INDEX) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameSuit(List<Poker> pokers) {
        List<Suit> suits = pokers.stream().map(Poker::getSuit).distinct().collect(Collectors.toList());
        return suits.size() == SUIT_SIZE;
    }
}
