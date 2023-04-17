package zelda_adventure.model.character.hero;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import zelda_adventure.model.character.Character;
import zelda_adventure.config.Action;
import zelda_adventure.config.Setting;

public class Zelda extends Character {

	private boolean attack;
	private Action action;
	private ZeldaImage zeldaImage;
	private boolean move;
	private int chest;
	private int potion;
	private int sword;
	private int score;


	public Zelda(int x, int y, BufferedImage image) {
		super(x, y, null);
		setAction(Action.NO_ACTION);
		setAttack(false);
		setDimension(40, 40);
		setScore(0);
		zeldaImage = new ZeldaImage();
		setMove(false);
		setPotion(3);
		setChest(0);
		setSword(0);
	}

	public void update() {
		if (isMove() == true && isAttack() == false) {
			setSpeed(Setting.Z_SPEED);

		}

		
		zeldaImage.setAnimation(getAction(), isAttack(), isMove());
		moviments();

	}

	public void draw(Graphics g) {

		if (getAttack() != null) {

			g.drawImage(zeldaImage.getCurrentImageAttack(), getX() - 14, getY() - 17,
					zeldaImage.getCurrentImageAttack().getWidth() + 40,
					zeldaImage.getCurrentImageAttack().getHeight() + 40, null);
		} else {
			g.drawImage(zeldaImage.getCurrentImage(), getX() - 14, getY() - 17,
					zeldaImage.getCurrentImageAttack().getWidth() + 40,
					zeldaImage.getCurrentImageAttack().getHeight() + 40, null);
		}

	}

	public void moviments() {

		switch (getAction()) {
		case RIGHT:
			setX(getX() + getSpeed());
			break;
		case LEFT:
			setX(getX() - getSpeed());
			break;
		case UP:
			setY(getY() - getSpeed());
			break;
		case DOWN:
			setY(getY() + getSpeed());

			break;
		case UP_RIGHT:
			setY(getY() - getSpeed());
			setX(getX() + getSpeed());

			break;
		case DOWN_RIGHT:
			setY(getY() + getSpeed());
			setX(getX() + getSpeed());

			break;
		case UP_LEFT:

			setY(getY() - getSpeed());
			setX(getX() - getSpeed());
			break;
		case DOWN_LEFT:
			setY(getY() + getSpeed());
			setX(getX() - getSpeed());
			break;
		default:
			break;
		}

	}

	public boolean isAttack() {
		return attack;
	}

	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	public Rectangle getAttack() {

		if ((getAction() == Action.RIGHT || getAction() == Action.DOWN_RIGHT || getAction() == Action.UP_RIGHT)
				&& isAttack()) {
			return new Rectangle(getX() + getDimension().width, getY(), getDimension().width - 18,
					getDimension().height);
		} else if ((getAction() == Action.LEFT || getAction() == Action.DOWN_LEFT || getAction() == Action.UP_LEFT)
				&& isAttack()) {
			return new Rectangle(getX() - getDimension().width / 2, getY(), getDimension().width - 12,
					getDimension().height);
		} else if ((getAction() == Action.UP) && isAttack()) {
			return new Rectangle(getX(), getY() - getDimension().height / 4, getDimension().width,
					getDimension().height / 4);
		} else if ((getAction() == Action.DOWN) && isAttack()) {
			return new Rectangle(getX(), getY() + getDimension().height, getDimension().width,
					getDimension().height / 4);

		}

		return null;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public void addScore(int score) {
		this.setScore(this.getScore() + score);

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getChest() {
		return chest;
	}

	public void setChest(int chest) {
		this.chest = chest;
	}

	public int getPotion() {
		return potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
		if (getPotion() >= 5)
			this.potion = 5;
	}

	public int getSword() {
		return sword;
	}

	public void setSword(int sword) {
		this.sword = sword;
	}
}
