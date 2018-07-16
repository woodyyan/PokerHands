package com.woodystudio;

public abstract class Category {

    public Category() {
    }

    protected abstract int getOrder();

    public boolean compare(Category other) {
        if (this.getOrder() == other.getOrder()) {
            return compareValues(other);
        }

        return this.getOrder() > other.getOrder();
    }

    protected abstract boolean compareValues(Category other);
}
