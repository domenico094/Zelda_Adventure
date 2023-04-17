package zelda_adventure.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import zelda_adventure.config.Setting;

public class Tile {

	private int x;
	private int y;
	private BufferedImage image;
	private Dimension dimension;

	public Tile(int x, int y,BufferedImage image) {
		setX(x);
		setY(y);
		setDimension(Setting.T_WIDTH, Setting.T_HEIGHT);
		setImage(image);
	}
	
	public void draw(Graphics g) {
		if(getImage() != null) 
			g.drawImage(getImage(), getX(), getY(), getDimension().width, getDimension().height , null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(int w, int h) {
		dimension = new Dimension(w, h);
	}

	public Rectangle getMain() {
		return new Rectangle(getX(), getY(), getDimension().width, getDimension().height);
	}

	public Rectangle getNord() {
		return new Rectangle(getX() + 4, getY(), getDimension().width - 8, getDimension().height / 4);
	}

	public Rectangle getSud() {
		return new Rectangle(getX() + 4, getY() + (getDimension().height / 2 + getDimension().height / 4) + 1,
				getDimension().width - 8, getDimension().height / 4);
	}

	public Rectangle getEst() {
		return new Rectangle(getX() + (getDimension().width - getDimension().width / 4), getY() + 8,
				getDimension().width / 4, getDimension().height - 16);
	}

	public Rectangle getWest() {
		return new Rectangle(getX(), getY() + 8, getDimension().width / 4, getDimension().height - 16);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
