package zelda_adventure.model.character.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda_adventure.model.character.enemy.animation.BatImage;

public class Bat extends Enemy {
private BatImage batImage;
	int cont;
	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public int getCont() {
		return cont;
	}
	public Bat(int x, int y,BufferedImage image) {
		super(x, y,image);
		batImage = new BatImage();
		setDimension(28, 22);
		setDie(false);
	}

	
	public void update() {
		batImage.setAnimation(isDie());
	
		if(isDie())
			setSpeed(0);
		move();
		
	}

	
	public void draw(Graphics g) {
		
	
		super.draw(g);
	}

	public void move() {
		if (isGoRight())
			setX(getX() + getSpeed());
		else if (!isGoRight())
			setX(getX() - getSpeed());

		if (isGoUp())
			setY(getY() - getSpeed());
		else if (!isGoUp())
			setY(getY() + getSpeed());
		
		setImage(batImage.getCurrentImage());
	}
}
