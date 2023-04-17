package zelda_adventure.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import zelda_adventure.handler.GameHandler;
import zelda_adventure.resources.LoadImage;

public class ScoreBar {

	private GameHandler gameHandler;
	private LoadImage loadImage;

	public ScoreBar() {
		gameHandler = GameHandler.getInstance();
		loadImage = LoadImage.getInstance();
	}

	public void draw(Graphics g) {
		Font font = new Font("Helvetica", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);

		g.drawImage(loadImage.getPotion(), 5, 2, 45, 32, null);
		g.drawString("x : " + Integer.toString(gameHandler.getZelda().getPotion()), 55, 22);
		g.drawImage(loadImage.getChest(), 110, 2, 45, 32, null);
		g.drawString("x : " + Integer.toString(gameHandler.getZelda().getChest()), 165, 22);

		g.drawImage(loadImage.getSword(), 580, 2, 40, 32, null);
		g.drawString("x : " + Integer.toString(gameHandler.getZelda().getSword()), 630, 22);
		g.drawString("SCORE: " + Integer.toString(gameHandler.getZelda().getScore()), 680, 22);

	}
}
