package io.github.arnabmaji19.coinman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class CoinMan extends ApplicationAdapter {

	private GameSate gameSate;

	private SpriteBatch batch;
	private Texture backgroundTexture;
	private BitmapFont scoreBitmap;

	private int screenHeight;
	private int screenWidth;

	private Man man;
	private CoinMaker coinMaker;
	private BombMaker bombMaker;
	private ScoreBoard scoreBoard;

	@Override
	public void create () {
		batch = new SpriteBatch();
        // get screen screenHeight and screenWidth
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();
		backgroundTexture = new Texture("bg.png"); // create background image to display on screen

		// create score bitmap for displaying score on screen
		scoreBitmap = new BitmapFont();
		scoreBitmap.setColor(Color.WHITE);
		scoreBitmap.getData().scale(5);

		createNewGame(); // create new instance of the game
	}

	@Override
	public void render () {
		batch.begin();

		batch.draw(backgroundTexture, 0, 0, screenWidth, screenHeight); // draw background image to the screen

		if (gameSate.equals(GameSate.GAME_OVER)){
			drawMan(man.getGameOverTexture()); // draw game over texture for man
			displayScoreBoard(); // display final score board

			if(Gdx.input.justTouched()) createNewGame(); // create new instance of the game

			batch.end();
			return;
		}

		coinMaker.createObjectInInterval(); // create coins in a certain interval
		bombMaker.createObjectInInterval(); // create bombs in a certain interval

		drawMovingObjects(coinMaker); // draw coins on screen
		drawMovingObjects(bombMaker); // draw bombs on screen


		man.animateCharacter(); // change man character in every interval

		if (Gdx.input.justTouched()) man.jump(); // move man upwards upon touch

		man.move(); // let the man jump or fall off the gravity

		//draw man on the screen
		drawMan(man.getTexture());

		// look for object collision
        checkForCollision(coinMaker); // look for collision with coin
        checkForCollision(bombMaker); // look for collision with bomb

		displayScoreBoard(); // display score on screen

		batch.end();
	}

	private void displayScoreBoard(){
		scoreBitmap.draw(batch, scoreBoard.getScore() + "", 30.0f, 100.0f);
	}

	private void drawMan(Texture texture){
		batch.draw(texture, man.getXPosition(), man.getYPosition());
	}

	private void createNewGame(){
		man = new Man(screenHeight, screenWidth); // create man object
		coinMaker = new CoinMaker(screenHeight, screenWidth); // create CoinMaker for creating coins
		bombMaker = new BombMaker(screenHeight, screenWidth); // create BombMake for creating bombs
		scoreBoard = new ScoreBoard(); // create scoreboard to track scores
		gameSate = GameSate.RUNNING; // initial game state
	}

	private void checkForCollision(MovingObjectMaker movingObjectMaker){
	    // create rectangle for man's current position
        Rectangle manRectangle = new Rectangle(
                man.getXPosition(),
                man.getYPosition(),
                man.getManWidth(),
                man.getManHeight());

        // look for collision
		List<MovingObject> movingObjectList = movingObjectMaker.getMovingObjects();
        for (MovingObject object : movingObjectList){
            // create rectangle for current object
            Rectangle movingObjectRectangle = new Rectangle(
                    object.getXPosition(),
                    object.getYPosition(),
                    object.getObjectWidth(),
                    object.getObjectWidth()
            );

            // if current object collides with man
            if (Intersector.overlaps(manRectangle, movingObjectRectangle)){
            	if (object instanceof Coin){ // if its a coin
					scoreBoard.increaseScore(); // increase score
				} else { // if it is a bomb
					gameSate = GameSate.GAME_OVER; // change game state to Game Over
				}
            	movingObjectList.remove(object); // remove collided object from screen
            }
        }

    }
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	private void drawMovingObjects(MovingObjectMaker objectMaker){
		// move all existing objects along negative x axis
		for (MovingObject object : objectMaker.getMovingObjects()){
			batch.draw(object.getTexture(), object.getXPosition(), object.getYPosition()); //display object texture
			object.moveAlongXAxis(); // move coin position for next iteration
			objectMaker.removeLaterIfNecessary(object); // mark coin to be removed later
		}
		objectMaker.removeUnnecessaryObjects();
	}

	private enum GameSate { RUNNING, GAME_OVER}

}
