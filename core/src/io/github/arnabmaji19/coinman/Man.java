package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.graphics.Texture;

public class Man {

    private final static float GRAVITY = 0.2f;
    private static final int MAN_STATE_CHANGE_DELAY = 8;
    private final static int JUMP_VELOCITY = 12;

    private Texture[] textures;

    private int manHeight;
    private int manWidth;
    private int textureState;

    private int stateChangeDelay;

    private float velocity;

    private float xPosition;
    private float yPosition;

    private int screenHeight;

    private boolean isJumping;

    public Man(int screenHeight, int screenWidth) {
        textures = new Texture[4];
        // set all types of man textures
        textures[0] = new Texture("frame-1.png");
        textures[1] = new Texture("frame-2.png");
        textures[2] = new Texture("frame-3.png");
        textures[3] = new Texture("frame-4.png");

        // set man's height and width
        manHeight = textures[0].getHeight();
        manWidth = textures[0].getWidth();
        textureState = 0;
        stateChangeDelay = 0;
        velocity = 0f;
        this.screenHeight = screenHeight;
        yPosition = this.screenHeight / 2; // initial position for man in air along y axis
        xPosition = (screenWidth - manWidth) / 2; // position for man in x axis
        isJumping = false;
    }

    public void animateCharacter(){
        // set frequency for changing man state
        if (stateChangeDelay < MAN_STATE_CHANGE_DELAY){
            stateChangeDelay++;
        } else {
            stateChangeDelay = 0;
            // toggle between various man states
            if (textureState < textures.length-1){
                textureState++;
            } else {
                textureState = 0;
            }
        }
    }

    public void move(){

        if (isJumping){
            // make the man jump
            yPosition += velocity;
            velocity -= GRAVITY;
            if (velocity <= 0) isJumping = false; // if upward velocity becomes 0 the man is not jumping anymore

        } else {
            // make the man fall off the gravity
            velocity += GRAVITY;
            yPosition -= velocity;

        }

        if (yPosition <= 0) { // if man hits ground stop it
            yPosition = 0; // do not make man fall out of screen
            velocity = 0; // set velocity to zero
        }

        if ((yPosition + manHeight) > screenHeight){ // if man hits upper end stop it
            yPosition = screenHeight - manHeight; // hold the man in upper end
            velocity = 0; // make it's velocity 0
        }
    }


    public void jump(){
        if (isJumping){ // if it is already jumping
            velocity += (JUMP_VELOCITY / 2.0); // add some extra velocity
            return;
        }
        isJumping = true;
        velocity = JUMP_VELOCITY; // increase velocity in opposite direction
    }

    public Texture getTexture(){
        return textures[textureState];
    }

    public float getXPosition() {
        return xPosition;
    }

    public float getYPosition() {
        return yPosition;
    }

    public int getManHeight() {
        return manHeight;
    }

    public int getManWidth() {
        return manWidth;
    }
}
