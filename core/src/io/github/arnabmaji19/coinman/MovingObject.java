package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.graphics.Texture;

public abstract class MovingObject {

    private Texture texture;
    private int xPosition;
    private int yPosition;
    private int objectHeight;
    private int objectWidth;
    private int objectVelocity;

    public MovingObject(Texture texture, int xPosition, int yPosition, int objectHeight, int objectWidth, int objectVelocity) {
        this.texture = texture;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.objectHeight = objectHeight;
        this.objectWidth = objectWidth;
        this.objectVelocity = objectVelocity;
    }

    public Texture getTexture() {
        return texture;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void moveAlongXAxis(){
        this.xPosition -= objectVelocity;
    }

    public int getObjectHeight() {
        return objectHeight;
    }

    public int getObjectWidth() {
        return objectWidth;
    }
}
