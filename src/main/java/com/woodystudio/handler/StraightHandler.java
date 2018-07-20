package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.Straight;

import java.util.List;
import java.util.stream.Collectors;

import static com.woodystudio.poker.Pokers.POKER_SIZE;

public class StraightHandler extends BasePokerHandler {
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 4;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        if (isStraight(pokers)) {
            return new Straight(pokers);
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
}
