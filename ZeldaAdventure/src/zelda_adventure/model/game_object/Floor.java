package zelda_adventure.model.game_object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda_adventure.model.Tile;

public class Floor extends Tile {

	public Floor(int x, int y, BufferedImage image) {
		super(x, y, image);

	}

	public void draw(Graphics g) {

		g.drawImage(this.getImage(), getX() + getDimension().width, getY(), getDimension().width, getDimension().height,
				null);

		super.draw(g);

	}

}
