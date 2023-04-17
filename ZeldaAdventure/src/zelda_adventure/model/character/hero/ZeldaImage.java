package zelda_adventure.model.character.hero;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import zelda_adventure.resources.LoadImage;
import zelda_adventure.config.Action;

public class ZeldaImage {

	private int index = 0;
	private LoadImage loadImage;
	private ArrayList<BufferedImage> animation;
	private ArrayList<BufferedImage> animationAttack;

	private BufferedImage currentImage;
	private BufferedImage currentImageAttack;

	public ZeldaImage() {
		loadImage = LoadImage.getInstance();
		animation = new ArrayList<BufferedImage>();
		setAnimation(Action.RIGHT, true, false);
		setAnimation(Action.RIGHT, false, false);

		setCurrentImage(animation.get(index));
		setCurrentImageAttack(animationAttack.get(index));
	}

	public void setAnimation(Action action, boolean attack, boolean move) {
		if (action == Action.RIGHT || action == Action.UP_RIGHT || action == Action.DOWN_RIGHT) {
			if (!attack)
				animation = loadImage.getRight();
			else
				animationAttack = loadImage.getRightAttack();
		} else if (action == Action.LEFT || action == Action.UP_LEFT || action == Action.DOWN_LEFT) {
			if (!attack)
				animation = loadImage.getLeft();
			else
				animationAttack = loadImage.getLeftAttack();
		} else if (action == Action.UP) {
			if (!attack)
				animation = loadImage.getUp();
			else
				animationAttack = loadImage.getUpAttack();
		} else if (action == Action.DOWN) {
			if (!attack)
				animation = loadImage.getDown();
			else
				animationAttack = loadImage.getDownAttack();
		}

		animationMove(move, attack);
	}

	private void animationMove(boolean move, boolean attack) {
		if (move == false) {
			index = 0;
		} else {
			index++;
			if (index == animation.size() || index == animationAttack.size())
				index = 0;
		}
		if (!attack)
			setCurrentImage(animation.get(index));
		else {
			setCurrentImageAttack(animationAttack.get(index));

		}
	}

	

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}

	public BufferedImage getCurrentImageAttack() {
		return currentImageAttack;
	}

	public void setCurrentImageAttack(BufferedImage currentImageAttack) {
		this.currentImageAttack = currentImageAttack;
	}
}
