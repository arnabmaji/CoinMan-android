package io.github.arnabmaji19.coinman;

public abstract class MovingObject {

    private int xPosition;
    private int yPosition;
    private int objectHeight;
    private int objectWidth;
    private int objectVelocity;

    public MovingObject(int xPosition, int yPosition, int objectHeight, int objectWidth, int objectVelocity) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.objectHeight = objectHeight;
        this.objectWidth = objectWidth;
        this.objectVelocity = objectVelocity;
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
