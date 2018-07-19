package com.woodystudio.poker;

public abstract class Pokers {

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
}
