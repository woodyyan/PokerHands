package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.TwoPairs;

import java.util.List;
import java.util.stream.Collectors;

public class TwoPairsBuilder extends BasePokerBuilder {

    private static final int TWO_PAIR_SIZE = 3;
    private static final int PAIR_SIZE = 2;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == TWO_PAIR_SIZE) {
            int count = 0;
            Poker firstPairPoker = null;
            Poker secondPairPoker = null;
            Poker restPoker = null;
            for (Poker poker : distinctPokers) {
                if (pokers.stream().filter(it -> it.equals(poker)).count() == PAIR_SIZE) {
                    if (firstPairPoker == null) {
                        firstPairPoker = poker;
                    } else {
                        secondPairPoker = poker;
                    }
                    count++;
                } else {
                    restPoker = poker;
                }
            }
            if (count == PAIR_SIZE) {
                return new TwoPairs(firstPairPoker.getValue(), secondPairPoker.getValue(), restPoker);
            }
        }
        return null;
    }
}
