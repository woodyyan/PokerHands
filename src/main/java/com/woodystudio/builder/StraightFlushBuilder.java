package com.woodystudio.builder;

import com.woodystudio.base.Poker;
import com.woodystudio.base.PokerValue;
import com.woodystudio.base.Suit;
import com.woodystudio.poker.Pokers;
import com.woodystudio.poker.StraightFlush;

import java.util.List;
import java.util.stream.Collectors;

import static com.woodystudio.poker.Pokers.POKER_SIZE;

public class StraightFlushBuilder extends BasePokerBuilder {

    private static final int SUIT_SIZE = 1;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 4;

    @Override
    public Pokers createPokersBySelf(List<Poker> pokers) {

        Suit suit = getSameSuitIfHas(pokers);
        PokerValue value = getMaxStraightValueIfHas(pokers);
        if (suit != null && value != null) {
            return new StraightFlush(suit, value);
        }

        return null;
    }

    private PokerValue getMaxStraightValueIfHas(List<Poker> pokers) {
        List<PokerValue> values = pokers.stream().map(Poker::getValue).sorted().collect(Collectors.toList());
        if (values.size() == POKER_SIZE) {
            Integer first = values.get(FIRST_INDEX).getValue();
            Integer last = values.get(LAST_INDEX).getValue();
            if (last - first == LAST_INDEX) {
                return values.get(LAST_INDEX);
            }
        }
        return null;
    }

    private Suit getSameSuitIfHas(List<Poker> pokers) {
        List<Suit> suits = pokers.stream().map(Poker::getSuit).distinct().collect(Collectors.toList());
        if (suits.size() == SUIT_SIZE) {
            return suits.get(FIRST_INDEX);
        }

        return null;
    }
}
