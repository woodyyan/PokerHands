package com.woodystudio;

public enum PokerValue {
    A(14), V2(2), V3(3), V4(4), V5(5), V6(6), V7(7), V8(8), V9(9), V10(10), J(11), Q(12), K(13);

    private final int value;

    PokerValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PokerValue parse(String name) {
        switch (name) {
            case "A":
                return A;
            case "2":
                return V2;
            case "3":
                return V3;
            case "4":
                return V4;
            case "5":
                return V5;
            case "6":
                return V6;
            case "7":
                return V7;
            case "8":
                return V8;
            case "9":
                return V9;
            case "T":
                return V10;
            case "J":
                return J;
            case "Q":
                return Q;
            case "K":
                return K;
            default:
                return A;
        }
    }
}
