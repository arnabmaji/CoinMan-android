package io.github.arnabmaji19.coinman;

public class ScoreBoard {

    private static final int INCREMENT_SCORE_BY = 5;

    private int score;

    public ScoreBoard() {
        this.score = 0;
    }

    public void increaseScore(){
        score += INCREMENT_SCORE_BY;
    }

    public int getScore(){
        return this.score;
    }

}
