package zelda_adventure.resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import zelda_adventure.config.Setting;


public class LoadImage {
	private static LoadImage instance = null;
	private BufferedImage image;

	private ArrayList<BufferedImage> right;
	private ArrayList<BufferedImage> left;
	private ArrayList<BufferedImage> up;
	private ArrayList<BufferedImage> down;
	private ArrayList<BufferedImage> rightAttack;
	private ArrayList<BufferedImage> leftAttack;
	private ArrayList<BufferedImage> upAttack;
	private ArrayList<BufferedImage> downAttack;
	private ArrayList<BufferedImage> batImage;

	private ArrayList<BufferedImage> soliderRight ;
	private ArrayList<BufferedImage> soliderLeft ;
	private ArrayList<BufferedImage> soliderUp ;
	private ArrayList<BufferedImage> soliderDown ;
	
	private BufferedImage chest;
	private BufferedImage floor;
	private BufferedImage garden;
	private BufferedImage tile;
	private BufferedImage potion;
	private BufferedImage sword;
	
	private BufferedImage wall;
	private BufferedImage stairs;
	private BufferedImage stone;
	
	private LoadImage() {
		image = null;
		right = new ArrayList<BufferedImage>();
		up = new ArrayList<BufferedImage>();
		down = new ArrayList<BufferedImage>();
		left = new ArrayList<BufferedImage>();
		rightAttack = new ArrayList<BufferedImage>();
		upAttack = new ArrayList<BufferedImage>();
		downAttack = new ArrayList<BufferedImage>();
		leftAttack = new ArrayList<BufferedImage>();
		batImage = new ArrayList<BufferedImage>();
		soliderRight = new ArrayList<BufferedImage>();
		soliderLeft = new ArrayList<BufferedImage>();
		soliderUp = new ArrayList<BufferedImage>();
		soliderDown = new ArrayList<BufferedImage>();
		setAllImage();
		
	}

	private void setAllImage() {
		for (int i = 0; i < 4; i++) {
			right.add(getImage(Setting.R_ZELDA + "right" + i + ".png"));
			left.add(getImage(Setting.R_ZELDA + "left" + i + ".png"));
			up.add(getImage(Setting.R_ZELDA + "up" + i + ".png"));

			down.add(getImage(Setting.R_ZELDA + "down" + i + ".png"));
		}
		for (int i = 0; i < 5; i++) {
			rightAttack.add(getImage(Setting.R_ZELDA + "rightAttack" + i + ".png"));
			leftAttack.add(getImage(Setting.R_ZELDA + "leftAttack" + i + ".png"));
			upAttack.add(getImage(Setting.R_ZELDA + "upAttack" + i + ".png"));

			downAttack.add(getImage(Setting.R_ZELDA + "downAttack" + i + ".png"));
		}
		setBatImage();
		setSoliderImage();
		setOtherImage();
	}

	private void setOtherImage() {
		setChest(getImage(Setting.R_IMAGE + "chest.png"));
		setPotion(getImage(Setting.R_IMAGE + "potion.png"));
		setSword(getImage(Setting.R_IMAGE + "sword.png"));
		setTile(getImage(Setting.R_IMAGE + "tile.png"));
		setFloor(getImage(Setting.R_IMAGE + "floor.png"));
		setGarden(getImage(Setting.R_IMAGE + "garden.png"));
		setStone(getImage(Setting.R_IMAGE + "stone.png"));
		setWall(getImage(Setting.R_IMAGE + "wall.png"));
		setStairs(getImage(Setting.R_IMAGE + "stairs.png"));
		
	}
	
	private void setSoliderImage() {
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				soliderRight.add(getImage(Setting.R_ENEMY + "s_right" + i + ".png"));
				soliderLeft.add(getImage(Setting.R_ENEMY + "s_left" + i + ".png"));
			}

			soliderUp.add(getImage(Setting.R_ENEMY + "s_up" + i + ".png"));
			soliderDown.add(getImage(Setting.R_ENEMY + "s_down" + i + ".png"));

		}

	}

	private void setBatImage() {

		for (int i = -1; i < 3; i++) {

			batImage.add(getImage(Setting.R_ENEMY + "bat" + i + ".png"));
		}
	}

	public BufferedImage getImage(String str) {

		try {
			image = ImageIO.read(new File(str));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	public static LoadImage getInstance() {
		if (instance == null) {
			instance = new LoadImage();
		}

		return instance;

	}

	public ArrayList<BufferedImage> getRight() {
		return right;
	}

	public ArrayList<BufferedImage> getLeft() {
		return left;
	}

	public ArrayList<BufferedImage> getUp() {
		return up;
	}

	public ArrayList<BufferedImage> getDown() {
		return down;
	}

	public ArrayList<BufferedImage> getRightAttack() {
		return rightAttack;
	}

	public ArrayList<BufferedImage> getLeftAttack() {
		return leftAttack;
	}

	public ArrayList<BufferedImage> getUpAttack() {
		return upAttack;
	}

	public ArrayList<BufferedImage> getDownAttack() {
		return downAttack;
	}

	public ArrayList<BufferedImage> getBatImage() {
		return batImage;
	}
	
	public ArrayList<BufferedImage> getSoliderRight() {
		return soliderRight;
	}
	
	public ArrayList<BufferedImage> getSoliderLeft() {
		return soliderLeft;
	}
	
	public ArrayList<BufferedImage> getSoliderUp() {
		return soliderUp;
	}
	public ArrayList<BufferedImage> getSoliderDown() {
		return soliderDown;
	}

	public BufferedImage getChest() {
		return chest;
	}

	public void setChest(BufferedImage chest) {
		this.chest = chest;
	}

	public BufferedImage getFloor() {
		return floor;
	}

	public void setFloor(BufferedImage floor) {
		this.floor = floor;
	}

	public BufferedImage getGarden() {
		return garden;
	}

	public void setGarden(BufferedImage garden) {
		this.garden = garden;
	}

	public BufferedImage getTile() {
		return tile;
	}

	public void setTile(BufferedImage tile) {
		this.tile = tile;
	}

	public BufferedImage getPotion() {
		return potion;
	}

	public void setPotion(BufferedImage potion) {
		this.potion = potion;
	}

	public BufferedImage getSword() {
		return sword;
	}

	public void setSword(BufferedImage sword) {
		this.sword = sword;
	}

	public BufferedImage getWall() {
		return wall;
	}

	public void setWall(BufferedImage wall) {
		this.wall = wall;
	}

	public BufferedImage getStairs() {
		return stairs;
	}

	public void setStairs(BufferedImage stairs) {
		this.stairs = stairs;
	}

	public BufferedImage getStone() {
		return stone;
	}

	public void setStone(BufferedImage stone) {
		this.stone = stone;
	}
}
