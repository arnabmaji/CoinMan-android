package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoinMan extends ApplicationAdapter {

	private static final int MAX_MAN_STATE_CHANGE_DELAY = 8;

	private SpriteBatch batch;
	private Texture backgroundTexture;
	private Texture[] man;

	private int height;
	private int width;
	private int manHeight;
	private int manWidth;

	private int manState = 0;
	private int manStateChangeDelay = 0;
	private float velocity = 0f;
	private float gravity = 0.2f;
	private float manYPosition;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
        // get screen height and width
        height = Gdx.graphics.getHeight();
        width = Gdx.graphics.getWidth();
		backgroundTexture = new Texture("bg.png"); // create background image to display on screen
        man = new Texture[4]; // create all graphics assets for the man
        // set all types of man textures
        man[0] = new Texture("frame-1.png");
        man[1] = new Texture("frame-2.png");
        man[2] = new Texture("frame-3.png");
        man[3] = new Texture("frame-4.png");


        // get height and width of man texture
        manHeight = man[0].getHeight();
        manWidth = man[0].getWidth();

        manYPosition = height / 2; // initial position for man in air

	}

	@Override
	public void render () {
		batch.begin();

		batch.draw(backgroundTexture, 0, 0, width, height); // draw background image to the screen


		// set frequency for changing man state
		if (manStateChangeDelay < MAX_MAN_STATE_CHANGE_DELAY){
			manStateChangeDelay++;
		} else {
			manStateChangeDelay = 0;
			// toggle between various man states
			if (manState < man.length-1){
				manState++;
			} else {
				manState = 0;
			}
		}

		// define velocity for falling down
		velocity += gravity;
		manYPosition -= velocity;

		if (manYPosition < 0) manYPosition = 0; // prevent man from going out of the screen
		//draw man in the middle of the screen
		batch.draw(man[manState], (width - manWidth)/2, manYPosition);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
