package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pair;
import com.woodystudio.poker.Pokers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairBuilder extends BasePokerBuilder {
    private static final int PAIR_SIZE = 4;
    private static final int FIRST_INDEX = 0;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == PAIR_SIZE) {
            List<Poker> newPokers = new ArrayList<>(pokers);
            distinctPokers.forEach(newPokers::remove);
            Poker pairPoker = newPokers.get(FIRST_INDEX);
            distinctPokers.remove(pairPoker);
            return new Pair(pairPoker, distinctPokers);
        }
        return null;
    }
}
