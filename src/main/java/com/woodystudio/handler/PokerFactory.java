package com.woodystudio.handler;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;

import java.util.ArrayList;
import java.util.List;

public class PokerFactory {
    public Pokers create(String cards) {
        List<Poker> pokers = parseCards(cards);
        return createPokers(pokers);
    }

    private Pokers createPokers(List<Poker> pokers) {
        BasePokerHandler basePokerHandler = prepareAllPokerHandlers();
        return basePokerHandler.createPokers(pokers);
    }

    private BasePokerHandler prepareAllPokerHandlers() {
        StraightFlushHandler straightFlushHandler = new StraightFlushHandler();
        FourOfAKingHandler fourOfAKingHandler = new FourOfAKingHandler();
        FullHouseHandler fullHouseHandler = new FullHouseHandler();
        FlushHandler flushHandler = new FlushHandler();
        StraightHandler straightHandler = new StraightHandler();
        ThreeOfAKingHandler threeOfAKingHandler = new ThreeOfAKingHandler();
        TwoPairsHandler twoPairsHandler = new TwoPairsHandler();
        PairHandler pairHandler = new PairHandler();
        HighCardHandler highCardHandler = new HighCardHandler();

        straightFlushHandler.setNextHandler(fourOfAKingHandler);
        fourOfAKingHandler.setNextHandler(fullHouseHandler);
        fullHouseHandler.setNextHandler(flushHandler);
        flushHandler.setNextHandler(straightHandler);
        straightHandler.setNextHandler(threeOfAKingHandler);
        threeOfAKingHandler.setNextHandler(twoPairsHandler);
        twoPairsHandler.setNextHandler(pairHandler);
        pairHandler.setNextHandler(highCardHandler);

        return straightFlushHandler;
    }

    private List<Poker> parseCards(String cards) {
        String[] segments = cards.split(" ");
        List<Poker> pokers = new ArrayList<>();
        for (String seg : segments) {
            String firstChar = seg.substring(0, 1);
            String secondChar = seg.substring(1);
            PokerValue pokerValue = PokerValue.parse(firstChar);
            Suit suit = Suit.parse(secondChar);
            Poker poker = new Poker(suit, pokerValue);
            pokers.add(poker);
        }
        return pokers;
    }
}
