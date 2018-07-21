package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pair;
import com.woodystudio.poker.Pokers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairBuilder extends BasePokerBuilder {
    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == 4) {
            List<Poker> newPokers = new ArrayList<>(pokers);
            distinctPokers.forEach(newPokers::remove);
            Poker pairPoker = newPokers.get(0);
            distinctPokers.remove(pairPoker);
            return new Pair(pairPoker, distinctPokers);
        }
        return null;
    }
}
