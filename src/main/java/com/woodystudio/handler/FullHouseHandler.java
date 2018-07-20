package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.FullHouse;
import com.woodystudio.poker.Pokers;

import java.util.List;
import java.util.stream.Collectors;

public class FullHouseHandler extends BasePokerHandler {
    private static final int FULL_HOUSE_POKER_SIZE = 2;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 1;
    private static final long THREE_POKER_SIZE = 3;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == FULL_HOUSE_POKER_SIZE) {
            Poker firstPoker = distinctPokers.get(FIRST_INDEX);
            Poker secondPoker = distinctPokers.get(LAST_INDEX);
            if (pokers.stream().filter(p -> p.equals(firstPoker)).count() == THREE_POKER_SIZE) {
                return new FullHouse(firstPoker.getValue(), secondPoker.getValue());
            } else if (pokers.stream().filter(p -> p.equals(secondPoker)).count() == THREE_POKER_SIZE) {
                return new FullHouse(secondPoker.getValue(), firstPoker.getValue());
            }
        }
        return null;
    }
}
