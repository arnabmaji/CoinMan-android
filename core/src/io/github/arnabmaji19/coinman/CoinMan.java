package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CoinMan extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture backgroundTexture;

	private int height;
	private int width;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundTexture = new Texture("bg.png"); // create background image to display on screen
		// get screen height and width
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(backgroundTexture, 0, 0, width, height); // draw background image to the screen
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
