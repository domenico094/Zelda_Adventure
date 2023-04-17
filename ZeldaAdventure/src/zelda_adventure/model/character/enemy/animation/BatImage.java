package zelda_adventure.model.character.enemy.animation;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import zelda_adventure.resources.LoadImage;

public class BatImage {
	private int index;
	private BufferedImage currentImage;
	private ArrayList<BufferedImage> animation;
	private LoadImage loadImage = LoadImage.getInstance();
	
	public BatImage() {
		index = 1;
		animation = loadImage.getBatImage();
		currentImage = animation.get(index);
	}
	
	
	public void setAnimation(boolean die) {
		if(die == false) {
			index++;
			if(index == animation.size())
				index = 1;
		} else {
			index = 0;
		}
		
		currentImage = animation.get(index);
	}
	
	public BufferedImage getCurrentImage() {
		return currentImage;
	}
}
