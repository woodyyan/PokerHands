package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pokers;

import java.util.List;

public class HighCardBuilder extends BasePokerBuilder {
    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        return new HighCard(pokers);
    }
}
