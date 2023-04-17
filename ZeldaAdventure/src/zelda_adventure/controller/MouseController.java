package zelda_adventure.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import zelda_adventure.config.GameStatus;
import zelda_adventure.config.Setting;
import zelda_adventure.handler.GameHandler;
import zelda_adventure.view.GameMenu;

public class MouseController implements MouseListener, MouseMotionListener {

	private GameMenu gameMenu;
	private GameHandler gameHandler;

	public MouseController() {
		gameMenu = GameMenu.getInstance();
		gameHandler = GameHandler.getInstance();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (gameHandler.getGameStatus() == GameStatus.INITIAL_MENU) {

			if (x > Setting.IM_W_R1 && x < Setting.IM_W_R1 + Setting.IM_W_R
					|| x > Setting.IM_W_C1 && x < Setting.IM_W_C1 + Setting.IM_W_C2) {
				if (y > Setting.IM_H_S && y < Setting.IM_H_S + Setting.IM_H_R) {
					gameHandler.createWorld();
				}

				if (y > Setting.IM_H_H && y < Setting.IM_H_H + Setting.IM_H_R) {
					gameHandler.setGameStatus(GameStatus.HELP);

				} 
				if (y > Setting.IM_H_Q && y < Setting.IM_H_Q + Setting.IM_H_R) {
					System.exit(0);

				}
			} 
		} else {
			if (x > 0 && x < 160) {
				if (y > 458 && y < 458 + 40) {
					if (gameHandler.getGameStatus() == GameStatus.GAME)
						gameHandler.setGameStatus(GameStatus.PAUSE);
					else if(gameHandler.getGameStatus() == GameStatus.HELP)
						gameHandler.setGameStatus(GameStatus.INITIAL_MENU);
				}

			} else if (x > 5 && x < 186) {
				if (y > 458 && y < 458 + 40) {
					if (gameHandler.getGameStatus() == GameStatus.PAUSE)
						gameHandler.setGameStatus(GameStatus.GAME);
				}

			}
			if (x > 680 && x < 680 + 115) {
				if (y > 458 && y < 458 + 40) {
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (gameHandler.getGameStatus() == GameStatus.INITIAL_MENU) {
			if (x > Setting.IM_W_R1 && x < Setting.IM_W_R1 + Setting.IM_W_R
					|| x > Setting.IM_W_C1 && x < Setting.IM_W_C1 + Setting.IM_W_C2) {
				if (y > Setting.IM_H_S && y < Setting.IM_H_S + Setting.IM_H_R) {
					gameMenu.setStart(true);

				} else {
					gameMenu.setStart(false);
				}

				if (y > Setting.IM_H_H && y < Setting.IM_H_H + Setting.IM_H_R) {
					gameMenu.setHelp(true);
				} else {
					gameMenu.setHelp(false);
				}
				if (y > Setting.IM_H_Q && y < Setting.IM_H_Q + Setting.IM_H_R) {
					gameMenu.setQuit(true);
				} else {
					gameMenu.setQuit(false);
				}
			} else {
				gameMenu.setStart(false);
				gameMenu.setHelp(false);
				gameMenu.setQuit(false);
			}

		} else {
			if (x > 0 && x < 160) {
				if (y > 458 && y < 458 + 40) {
					if (gameHandler.getGameStatus() == GameStatus.GAME)
						gameMenu.setPause(true);
					

				}

			} else if (x > 5 && x < 186) {
				if (y > 458 && y < 458 + 40) {
					if (gameHandler.getGameStatus() == GameStatus.PAUSE)
						gameMenu.setPause(true);
				}

			} else {
				gameMenu.setPause(false);
			}
			if (x > 680 && x < 680 + 115) {
				if (y > 458 && y < 458 + 40) {
					gameMenu.setQuit(true);
				}
			} else {
				gameMenu.setQuit(false);
			}
		}

	}

}
