package zelda_adventure.model.character.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda_adventure.model.character.Character;

public class Enemy extends Character {
	private boolean die;
	private int score;
	private boolean goUp;
	private boolean goRight;

	public Enemy(int x, int y, BufferedImage image) {
		super(x, y, image);
		setDie(false);
	}
	
	public void draw(Graphics g ) {
		super.draw(g);
	}

	public boolean isGoUp() {
		return goUp;
	}

	public void setGoUp(boolean goUp) {
		this.goUp = goUp;
	}

	public boolean isGoRight() {
		return goRight;
	}

	public void setGoRight(boolean goRight) {
		this.goRight = goRight;
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

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isDie() {
		return die;
	}

	public void setDie(boolean die) {
		this.die = die;
	}

}
