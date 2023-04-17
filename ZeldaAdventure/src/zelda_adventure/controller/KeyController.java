package zelda_adventure.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import zelda_adventure.handler.GameHandler;
import zelda_adventure.config.Action;
import zelda_adventure.config.GameStatus;

public class KeyController implements KeyListener {
	private GameHandler gameHandler;
	private boolean up;
	private boolean down;
	private boolean right;
	private boolean left;
	private boolean flag = true;

	public KeyController() {
		gameHandler = GameHandler.getInstance();
		up = false;
		down = false;
		right = false;
		left = false;

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		
		switch (key) {
		case KeyEvent.VK_S:
			if (gameHandler.getGameStatus() == GameStatus.INITIAL_MENU) {
				gameHandler.createWorld();
			}
			break;
		case KeyEvent.VK_Q:
			System.exit(0);
			break;
		case KeyEvent.VK_H:
			if (gameHandler.getGameStatus() == GameStatus.INITIAL_MENU) {
				gameHandler.setGameStatus(GameStatus.HELP);
			}
			break;
		case KeyEvent.VK_P:
			if (gameHandler.getGameStatus() == GameStatus.GAME) {
				gameHandler.setGameStatus(GameStatus.PAUSE);
			}
			break;
		case KeyEvent.VK_R:
			if (gameHandler.getGameStatus() == GameStatus.PAUSE) {
				gameHandler.setGameStatus(GameStatus.GAME);
			}
			break;
		case KeyEvent.VK_M:
			if (gameHandler.getGameStatus() == GameStatus.HELP) {
				gameHandler.setGameStatus(GameStatus.INITIAL_MENU);
			}
			break;
		default:
			break;
		}

		switch (key) {
		case KeyEvent.VK_RIGHT:
			if (flag == true) {
				right = true;
				if (up == true && !down) {
					gameHandler.getZelda().setAction(Action.UP_RIGHT);
				} else if (down == true) {
					gameHandler.getZelda().setAction(Action.DOWN_RIGHT);
				} else {
					gameHandler.getZelda().setAction(Action.RIGHT);
				}
				gameHandler.getZelda().setMove(true);

				gameHandler.getZelda().moviments();
			}
			break;
		case KeyEvent.VK_LEFT:
			if (flag == true) {
				left = true;
				if (up == true && !down) {
					gameHandler.getZelda().setAction(Action.UP_LEFT);
				} else if (down == true) {
					gameHandler.getZelda().setAction(Action.DOWN_LEFT);
				} else {
					gameHandler.getZelda().setAction(Action.LEFT);
				}
				gameHandler.getZelda().setMove(true);

				gameHandler.getZelda().moviments();
			}
			break;
		case KeyEvent.VK_UP:
			if (flag == true) {
				up = true;

				if (right == true && !left) {
					gameHandler.getZelda().setAction(Action.UP_RIGHT);
				} else if (left == true) {
					gameHandler.getZelda().setAction(Action.UP_LEFT);
				} else {
					gameHandler.getZelda().setAction(Action.UP);
				}
				gameHandler.getZelda().setMove(true);

				gameHandler.getZelda().moviments();
			}
			break;
		case KeyEvent.VK_DOWN:
			if (flag == true) {
				down = true;
				if (right == true && !left) {
					gameHandler.getZelda().setAction(Action.DOWN_RIGHT);
				} else if (left == true) {
					gameHandler.getZelda().setAction(Action.DOWN_LEFT);
				} else {
					gameHandler.getZelda().setAction(Action.DOWN);
				}
				gameHandler.getZelda().setMove(true);

				gameHandler.getZelda().moviments();
			}
			break;
		case KeyEvent.VK_SPACE:
			gameHandler.getZelda().setAttack(true);
			gameHandler.getZelda().setMove(true);
			gameHandler.getZelda().setSpeed(0);
			flag = false;

			break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			gameHandler.getZelda().setAttack(false);
			flag = true;
			gameHandler.getZelda().setMove(false);
		}

		if (key == KeyEvent.VK_UP) {
			up = false;
			gameHandler.getZelda().setSpeed(0);
			gameHandler.getZelda().setMove(false);

		}
		if (key == KeyEvent.VK_DOWN) {
			down = false;

			gameHandler.getZelda().setSpeed(0);
			gameHandler.getZelda().setMove(false);

		}
		if (key == KeyEvent.VK_RIGHT) {
			right = false;
			gameHandler.getZelda().setSpeed(0);
			gameHandler.getZelda().setMove(false);

		}
		if (key == KeyEvent.VK_LEFT) {
			left = false;
			gameHandler.getZelda().setSpeed(0);
			gameHandler.getZelda().setMove(false);

		}
		

	}

}
