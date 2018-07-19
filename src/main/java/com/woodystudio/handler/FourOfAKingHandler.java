package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.FourOfAKing;
import com.woodystudio.poker.Pokers;

import java.util.List;

import static com.woodystudio.poker.Pokers.POKER_SIZE;

public class FourOfAKingHandler extends BasePokerHandler {
    private static final long TWO = 2;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 4;
    private static final int FOUR_INDEX = 4;
    private static final long ONE = 1;

    @Override
    public Pokers createPokers(List<Poker> pokers) {
        if (pokers.size() == POKER_SIZE) {
            List<Poker> fourPokers = pokers.subList(FIRST_INDEX, FOUR_INDEX);
            Poker lastPoker = pokers.get(LAST_INDEX);
            if (fourPokers.stream().distinct().count() == ONE && !fourPokers.get(FIRST_INDEX).equals(lastPoker)) {
                Poker kingPoker = fourPokers.get(FIRST_INDEX);
                return new FourOfAKing(kingPoker, lastPoker);
            } else if (fourPokers.stream().distinct().count() == TWO && fourPokers.contains(lastPoker)) {
                Poker restPoker = fourPokers.stream().filter(p -> !p.equals(lastPoker)).findFirst().get();
                return new FourOfAKing(lastPoker, restPoker);
            }
        }

        if (this.getNextHandler() != null) {
            return this.getNextHandler().createPokers(pokers);
        }

        return null;
    }
}
