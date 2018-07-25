package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.ThreeOfAKing;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKingBuilder extends BasePokerBuilder {

    private static final int THREE_SIZE = 3;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == THREE_SIZE) {
            for (Poker poker : distinctPokers) {
                if (pokers.stream().filter(it -> it.equals(poker)).count() == THREE_SIZE) {
                    return new ThreeOfAKing(poker.getValue(), distinctPokers.stream().filter(it -> !it.equals(poker)).collect(Collectors.toList()));
                }
            }
        }
        return null;
    }
}
