package zelda_adventure.model.game_object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import zelda_adventure.model.Tile;
import zelda_adventure.config.Setting;
import zelda_adventure.config.TypePrize;

public class Prize extends Tile {

	private TypePrize type;

	public Prize(int x, int y, BufferedImage image, TypePrize type) {
		super(x, y, image);

		setType(type);
		setTypeDimension();

	}

	public void draw(Graphics g) {
		super.draw(g);
	}

	public void setTypeDimension() {
		if (getType() == TypePrize.CHEST)
			setDimension(44, 34);
		else
			setDimension(Setting.P_WIDTH, Setting.P_HEIGHT);
	}

	public TypePrize getType() {
		return type;
	}

	public void setType(TypePrize type) {
		this.type = type;

	}

}
