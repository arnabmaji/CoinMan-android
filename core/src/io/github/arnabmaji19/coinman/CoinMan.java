package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoinMan extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture backgroundTexture;
	private Texture[] man;

	private int height;
	private int width;
	private int manHeight;
	private int manWidth;

	
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

	}

	@Override
	public void render () {
		batch.begin();

		batch.draw(backgroundTexture, 0, 0, width, height); // draw background image to the screen

        //draw man in the middle of the screen
        batch.draw(man[0], (width - manWidth)/2, (height - manHeight)/2);

        batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
