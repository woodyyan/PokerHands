package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;

import java.util.List;

public abstract class BasePokerHandler {

    private BasePokerHandler nextHandler;

    public Pokers createPokers(List<Poker> pokers) {
        Pokers pokersBySelf = createPokersBySelf(pokers);

        if (pokersBySelf == null && this.getNextHandler() != null) {
            return this.getNextHandler().createPokers(pokers);
        }

        return pokersBySelf;
    }

    protected abstract Pokers createPokersBySelf(List<Poker> pokers);

    public BasePokerHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(BasePokerHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
