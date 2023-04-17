package zelda_adventure.model.character.enemy;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda_adventure.model.character.enemy.animation.SoliderImage;

public class Solider extends Enemy {

	private boolean moveInX;
	private int cont;
	private SoliderImage soliderImage;

	public Solider(int x, int y,BufferedImage image) {
		super(x, y,image);
		setCont(0);
		soliderImage = new SoliderImage();
		setDimension(50, 54);
		setMoveInX(true);
		setSpeed(4);
	}

	public void draw(Graphics g) {

		super.draw(g);
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public void update() {

		if (isDie())
			setSpeed(0);
		else
			move();

		soliderImage.setImage(isGoRight(), isGoUp(), isMoveInX(), isDie());
		setImage(soliderImage.getCurrentImage());

	}

	public void move() {
		assert (!isDie());
		if (isMoveInX()) {
			if (isGoRight())
				setX(getX() + getSpeed());
			else
				setX(getX() - getSpeed());
		} else {
			if (isGoUp())
				setY(getY() - getSpeed());
			else
				setY(getY() + getSpeed());
		}
	}

	public boolean isMoveInX() {
		return moveInX;
	}

	public void setMoveInX(boolean moveInX) {
		this.moveInX = moveInX;
	}

}
