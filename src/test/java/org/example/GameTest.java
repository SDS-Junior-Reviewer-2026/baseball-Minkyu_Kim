package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput(){
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    private void assertIllegalArgument(String guessNumber) {
        try{
            game.guess(guessNumber);
            fail();
        }
        catch(IllegalArgumentException e){}
    }

    @Test
    void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");

        assertMatchedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIfUnMatchedNumber() {
        generateQuestion("123");

        assertMatchedNumber(game.guess("456"), false, 0, 0);
    }

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    private void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    @Test
    void returnUnSolvedResultIfSomematchedNumber() {
        generateQuestion("123");
        assertMatchedNumber(game.guess("120"), false, 2, 0);
        assertMatchedNumber(game.guess("061"), false, 0, 1);
        assertMatchedNumber(game.guess("136"), false, 1, 1);
    }
}