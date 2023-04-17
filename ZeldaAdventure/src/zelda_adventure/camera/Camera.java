package zelda_adventure.camera;

import zelda_adventure.config.Setting;

public class Camera {
	private int x;
	private int y;
	private int limintX;
	private int limintY;
	private boolean change;

	public Camera() {
		setX(0);
		setY(0);
		setLimintX(Setting.WIDTH);
		setLimintY(Setting.HEIGHT);
	}

	public void moveCamera(int otherX, int otherY) {
		if (otherX >= limintX) {
			setX(limintX);

			limintX += limintX;
		} else if (otherX <= limintX - Setting.WIDTH) {
			if ((limintX - Setting.WIDTH - Setting.WIDTH) <= 0)
				setX(0);
			else
				setX(limintX - Setting.WIDTH - Setting.WIDTH);
			limintX = limintX - Setting.WIDTH;
		}

		if (otherY >= limintY) {
			setY(limintY);

			limintY += limintY;
		} else if (otherY <= limintY - Setting.HEIGHT) {
			if ((limintY - Setting.HEIGHT - Setting.HEIGHT) <= 0)
				setY(0);
			else
				setY(limintY - Setting.HEIGHT - Setting.HEIGHT);
			limintY = limintY - Setting.HEIGHT;
		}
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

	public int getLimintX() {
		return limintX;
	}

	public void setLimintX(int limintX) {
		this.limintX = limintX;
	}

	public int getLimintY() {
		return limintY;
	}

	public void setLimintY(int limintY) {
		this.limintY = limintY;
	}

	public boolean isChange() {
		return change;
	}

	public void setChange(boolean change) {
		this.change = change;
	}
}
