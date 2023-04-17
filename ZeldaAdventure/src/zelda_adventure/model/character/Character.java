package zelda_adventure.model.character;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import zelda_adventure.model.Tile;

public class Character extends Tile {

	private int speed;

	public Character(int x, int y, BufferedImage image) {
		super(x, y, image);
		setSpeed(4);
	}

	@Override
	public void draw(Graphics g) {
		
		super.draw(g);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Rectangle getResearch() {

		return new Rectangle(getX() - 50, getY() - 50, getDimension().width + 100, getDimension().height + 100);
	}

	public Rectangle getRNord() {
		return new Rectangle(getX() - 25, getY() - 50, getDimension().width + 50, getDimension().height / 2);
	}

	public Rectangle getRSud() {
		return new Rectangle(getX() - 25, getY() + 75, getDimension().width + 50, getDimension().height / 2);
	}

	public Rectangle getRWest() {
		return new Rectangle(getX() - 50, getY() - 25, getDimension().width / 2, getDimension().height + 50);
	}

	public Rectangle getREst() {
		return new Rectangle(getX() + 75, getY() - 25, getDimension().width / 2, getDimension().height + 50);
	}

}
