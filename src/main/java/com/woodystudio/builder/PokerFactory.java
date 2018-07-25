package com.woodystudio.builder;

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
        BasePokerBuilder basePokerHandler = prepareAllPokerHandlers();
        return basePokerHandler.createPokers(pokers);
    }

    private BasePokerBuilder prepareAllPokerHandlers() {
        StraightFlushBuilder straightFlushHandler = new StraightFlushBuilder();
        FourOfAKingBuilder fourOfAKingHandler = new FourOfAKingBuilder();
        FullHouseBuilder fullHouseHandler = new FullHouseBuilder();
        FlushBuilder flushHandler = new FlushBuilder();
        StraightBuilder straightHandler = new StraightBuilder();
        ThreeOfAKingBuilder threeOfAKingHandler = new ThreeOfAKingBuilder();
        TwoPairsBuilder twoPairsHandler = new TwoPairsBuilder();
        PairBuilder pairHandler = new PairBuilder();
        HighCardBuilder highCardHandler = new HighCardBuilder();

        straightFlushHandler.setNextBuilder(fourOfAKingHandler);
        fourOfAKingHandler.setNextBuilder(fullHouseHandler);
        fullHouseHandler.setNextBuilder(flushHandler);
        flushHandler.setNextBuilder(straightHandler);
        straightHandler.setNextBuilder(threeOfAKingHandler);
        threeOfAKingHandler.setNextBuilder(twoPairsHandler);
        twoPairsHandler.setNextBuilder(pairHandler);
        pairHandler.setNextBuilder(highCardHandler);

        return straightFlushHandler;
    }

    private List<Poker> parseCards(String cards) {
        String[] segments = cards.split(" ");
        List<Poker> pokers = new ArrayList<>();
        for (String seg : segments) {
            int beginIndex = 0;
            int endIndex = 1;
            String firstChar = seg.substring(beginIndex, endIndex);
            String secondChar = seg.substring(endIndex);
            PokerValue pokerValue = PokerValue.parse(firstChar);
            Suit suit = Suit.parse(secondChar);
            Poker poker = new Poker(suit, pokerValue);
            pokers.add(poker);
        }
        return pokers;
    }
}
