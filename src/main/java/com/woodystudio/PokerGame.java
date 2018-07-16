package com.woodystudio;

public class PokerGame {
    private String playerOne;
    private String playerTwo;
    private PokerFactory pokerFactory;

    public PokerGame(PokerFactory pokerFactory) {
        this.pokerFactory = pokerFactory;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public String match() {
        Pokers pokersOne = pokerFactory.create(getPlayerOne());
        Pokers pokersTwo = pokerFactory.create(getPlayerTwo());
        if (pokersOne.compare(pokersTwo)) {
            return playerOne;
        } else {
            return playerTwo;
        }
    }
}
