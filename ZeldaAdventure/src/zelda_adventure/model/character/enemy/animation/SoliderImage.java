package zelda_adventure.model.character.enemy.animation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import zelda_adventure.resources.LoadImage;


public class SoliderImage {

	private int index;
	private BufferedImage currentImage = null;
	private ArrayList<BufferedImage> animationX;
	private ArrayList<BufferedImage> animationY;
	private LoadImage load = LoadImage.getInstance();

	public SoliderImage() {
		index = 0;
		animationX = new ArrayList<BufferedImage>();
		animationY = new ArrayList<BufferedImage>();
		setImage(true, true, true, false);
	}

	public void setImage(boolean goRight, boolean goUp, boolean moveInX, boolean die) {
		if (moveInX) {
			if (goRight)
				animationX = load.getSoliderRight();
			else
				animationX = load.getSoliderLeft();
		} else if (!moveInX) {
			if (goUp)
				animationY = load.getSoliderUp();
			else
				animationY = load.getSoliderDown();
		}

		getAnimation(die, moveInX);

	}

	public void getAnimation(boolean die, boolean moveInX) {
		if (!die) {
			index++;
			if (index == animationX.size() - 1 || index == animationY.size() - 1)
				index = 0;
			if (moveInX)
				currentImage = animationX.get(index);
			else
				currentImage = animationY.get(index);
		} 

	}

	

	public BufferedImage getCurrentImage() {
		return currentImage;
	}
}
