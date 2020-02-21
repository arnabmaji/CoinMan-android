package io.github.arnabmaji19.coinman;

public class CoinMaker extends MovingObjectMaker {

    private static final int COIN_CREATION_DELAY = 100;

    public CoinMaker(int screenHeight, int screenWidth) {
        super(COIN_CREATION_DELAY, screenHeight, screenWidth);
    }

    @Override
    protected void createObject() {
        int coinXPosition = getScreenWidth() - Coin.getCoinWidth(); //create coin extreme right of the screen
        int coinYPosition = (int) (getRandom().nextDouble() * (double) getScreenHeight()); // randomly create coin along y axis
        // create coin
        Coin coin = new Coin(coinXPosition, coinYPosition);
        getMovingObjects().add(coin); // add coin to all coins list
    }
}
