package zelda_adventure.handler;

import java.awt.Graphics;


import zelda_adventure.camera.Camera;
import zelda_adventure.model.character.hero.Zelda;
import zelda_adventure.config.GameStatus;

public class GameHandler {

	private static GameHandler instance = null;
	private GameStatus gameStatus;
	private CollisionHandler collisionHandler;
	private Camera camera;

	private GameHandler() {
		setGameStatus(GameStatus.INITIAL_MENU);
		
	}

	public void update() {
		if(getGameStatus() == GameStatus.GAME) {
			collisionHandler.update();
			camera.moveCamera(getZelda().getX(), getZelda().getY());
			if(collisionHandler.isGameOver()) 
				setGameStatus(GameStatus.GAME_OVER);
			else if(collisionHandler.isWin())
				setGameStatus(GameStatus.WIN);
		}
		
			
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public Zelda getZelda() {
		return collisionHandler.getWorld().getZelda();

	}

	public void drawWorld(Graphics g) {
		collisionHandler.getWorld().draw(g);
	}

	public void createWorld() {
		collisionHandler = new CollisionHandler();
		camera = new Camera();
		setGameStatus(GameStatus.GAME);
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}

	public static GameHandler getInstance() {
		if (instance == null) {
			instance = new GameHandler();
		}
		return instance;
	}
	
	
}
