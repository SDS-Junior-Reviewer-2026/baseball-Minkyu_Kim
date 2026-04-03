package org.example;

public class GuessResult {

    public boolean solved;
    public int strikes;
    public int balls;

    public GuessResult(boolean solved, int strikes, int balls) {
        this.balls = balls;
        this.solved = solved;
        this.strikes = strikes;
    }
}
