package zelda_adventure.view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import zelda_adventure.handler.GameHandler;

public class GraphicsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GameHandler gameHandler;
	private GameMenu gameMenu;
	private ScoreBar scoreBar;

	public GraphicsPanel() {
		gameHandler = GameHandler.getInstance();
		gameMenu = GameMenu.getInstance();
		scoreBar = new ScoreBar();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		switch (gameHandler.getGameStatus()) {
		case INITIAL_MENU:
			gameMenu.drawTitle(g);
			gameMenu.drawGameMenu(g);
			break;
		case GAME:
			g2.translate(-gameHandler.getCamera().getX(), -gameHandler.getCamera().getY());
			gameHandler.drawWorld(g);
			
			g2.translate(gameHandler.getCamera().getX(), gameHandler.getCamera().getY());
			gameMenu.drawOnGame(g);
			scoreBar.draw(g);
			
			break;
		case HELP:
			gameMenu.drawHelp(g);
			break;
		case PAUSE:
			gameMenu.drawPause(g);
			break;
		case WIN:
			gameMenu.drawWin(g);
			break;
		case GAME_OVER:
			gameMenu.drawGameOver(g);
			break;

		default:
			break;
		}
	}

	public void update() {
		repaint();
	}
}
