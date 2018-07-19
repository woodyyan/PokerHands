package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.poker.Pokers;

import java.util.List;

public abstract class BasePokerHandler {

    private BasePokerHandler nextHandler;

    public abstract Pokers createPokers(List<Poker> pokers);

    public BasePokerHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(BasePokerHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
