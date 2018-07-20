package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.TwoPairs;

import java.util.List;
import java.util.stream.Collectors;

public class TwoPairsHandler extends BasePokerHandler {
    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == 3) {
            int count = 0;
            Poker firstPairPoker = null;
            Poker secondPairPoker = null;
            Poker restPoker = null;
            for (Poker poker : distinctPokers) {
                if (pokers.stream().filter(it -> it.equals(poker)).count() == 2) {
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
            if (count == 2) {
                return new TwoPairs(firstPairPoker.getValue(), secondPairPoker.getValue(), restPoker);
            }
        }
        return null;
    }
}
