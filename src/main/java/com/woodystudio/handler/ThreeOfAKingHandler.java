package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.ThreeOfAKing;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeOfAKingHandler extends BasePokerHandler {
    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        List<Poker> distinctPokers = pokers.stream().distinct().collect(Collectors.toList());
        if (distinctPokers.size() == 3) {
            for (Poker poker : distinctPokers) {
                if (pokers.stream().filter(it -> it.equals(poker)).count() == 3) {
                    return new ThreeOfAKing(poker, distinctPokers.stream().filter(it -> !it.equals(poker)).collect(Collectors.toList()));
                }
            }
        }
        return null;
    }
}
