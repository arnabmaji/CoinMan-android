package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.graphics.Texture;

public class Bomb extends MovingObject{

    private static final Texture BOMB_TEXTURE = new Texture("bomb.png");
    private static final int BOMB_HEIGHT = BOMB_TEXTURE.getHeight();
    private static final int BOMB_WIDTH = BOMB_TEXTURE.getWidth();
    private static final int BOMB_VELOCITY = 10;

    public Bomb(int xPosition, int yPosition) {
        super(BOMB_TEXTURE, xPosition, yPosition, BOMB_HEIGHT, BOMB_WIDTH, BOMB_VELOCITY);
    }

    public static int getBombWidth() {
        return BOMB_WIDTH;
    }

}
