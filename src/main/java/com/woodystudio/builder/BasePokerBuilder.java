package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;

import java.util.List;

public abstract class BasePokerBuilder {

    private BasePokerBuilder nextBuilder;

    public Pokers createPokers(List<Poker> pokers) {
        Pokers pokersBySelf = createPokersBySelf(pokers);

        if (pokersBySelf == null && this.getNextBuilder() != null) {
            return this.getNextBuilder().createPokers(pokers);
        }

        return pokersBySelf;
    }

    protected abstract Pokers createPokersBySelf(List<Poker> pokers);

    public BasePokerBuilder getNextBuilder() {
        return nextBuilder;
    }

    public void setNextBuilder(BasePokerBuilder nextBuilder) {
        this.nextBuilder = nextBuilder;
    }
}
