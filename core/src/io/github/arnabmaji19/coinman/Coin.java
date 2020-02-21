package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.graphics.Texture;

public class Coin extends MovingObject {

    private static final Texture COIN_TEXTURE = new Texture("coin.png");
    private static final int COIN_HEIGHT = COIN_TEXTURE.getHeight();
    private static final int COIN_WIDTH = COIN_TEXTURE.getWidth();
    private static final int COIN_VELOCITY = 10;

    public Coin(int xPosition, int yPosition) {
        super(COIN_TEXTURE, xPosition, yPosition, COIN_HEIGHT, COIN_WIDTH, COIN_VELOCITY);
    }

    public static int getCoinWidth() {
        return COIN_WIDTH;
    }
}
