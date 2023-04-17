package zelda_adventure.model.game_object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda_adventure.model.Tile;

public class Obstacle extends Tile {

	public Obstacle(int x, int y, BufferedImage image) {
		super(x, y, image);

	}

	public void draw(Graphics g) {

		super.draw(g);
	}

	

}
