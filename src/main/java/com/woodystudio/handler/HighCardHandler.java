package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.HighCard;
import com.woodystudio.poker.Pokers;

import java.util.List;

public class HighCardHandler extends BasePokerHandler {
    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {
        return new HighCard(pokers);
    }
}
