package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.ThreeOfAKing;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKingBuilder extends BasePokerBuilder {
    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == 3) {
            for (Poker poker : distinctPokers) {
                if (pokers.stream().filter(it -> it.equals(poker)).count() == 3) {
                    return new ThreeOfAKing(poker.getValue(), distinctPokers.stream().filter(it -> !it.equals(poker)).collect(Collectors.toList()));
                }
            }
        }
        return null;
    }
}
