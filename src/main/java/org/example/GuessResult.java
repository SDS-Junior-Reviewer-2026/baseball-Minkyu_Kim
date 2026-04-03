package org.example;

public class GuessResult {

    private boolean solved;
    private int strikes;
    private int balls;

    public boolean isSolved() {
        return solved;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public GuessResult(boolean solved, int strikes, int balls) {
        this.balls = balls;
        this.solved = solved;
        this.strikes = strikes;
    }
}
