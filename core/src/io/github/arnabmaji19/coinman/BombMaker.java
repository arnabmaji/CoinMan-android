package io.github.arnabmaji19.coinman;

public class BombMaker extends MovingObjectMaker {

    private static final int BOMB_CREATION_DELAY = 300;

    public BombMaker(int screenHeight, int screenWidth) {
        super(BOMB_CREATION_DELAY, screenHeight, screenWidth);
    }

    @Override
    public void createObject() {
        int bombXPosition = getScreenWidth() - Bomb.getBombWidth(); //create coin extreme right of the screen
        int bombYPosition = (int) (getRandom().nextDouble() * (double) getScreenHeight()); // randomly create coin along y axis
        // create coin
        Bomb bomb = new Bomb(bombXPosition, bombYPosition);
        getMovingObjects().add(bomb); // add coin to all coins list
    }

}
