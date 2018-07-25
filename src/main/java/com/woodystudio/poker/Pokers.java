package com.woodystudio.poker;

import java.util.List;

public abstract class Pokers {

    public static final int POKER_SIZE = 5;

    public Pokers() {
    }

    protected abstract int getOrder();

    public boolean compare(Pokers other) {
        if (this.getOrder() == other.getOrder()) {
            return compareSameLevelValues(other);
        }

        return this.getOrder() > other.getOrder();
    }

    protected abstract boolean compareSameLevelValues(Pokers other);

    protected boolean compareBasedValues(List<Integer> mainValues, List<Integer> otherValues) {
        Integer max = mainValues.stream().mapToInt(it -> it).max().orElse(0);
        Integer otherMax = otherValues.stream().mapToInt(it -> it).max().orElse(0);
        while (max.equals(otherMax)) {
            mainValues.remove(max);
            otherValues.remove(otherMax);
            max = mainValues.stream().mapToInt(it -> it).max().orElse(0);
            otherMax = otherValues.stream().mapToInt(it -> it).max().orElse(0);
        }
        return max > otherMax;
    }
}
