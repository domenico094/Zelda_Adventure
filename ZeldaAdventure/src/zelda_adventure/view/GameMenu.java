package zelda_adventure.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import zelda_adventure.config.Setting;
import zelda_adventure.resources.LoadImage;

public class GameMenu {

	private boolean start;
	private boolean help;
	private boolean quit;

	private boolean pause;

	private Font font;
	private LoadImage loadImage;
	public static GameMenu instance = null;

	public static GameMenu getInstance() {
		if (instance == null)
			instance = new GameMenu();
		return instance;
	}

	private GameMenu() {
		loadImage = LoadImage.getInstance();
		setStart(false);
		setHelp(false);
		setQuit(false);
		setPause(false);
	}

	public void drawTitle(Graphics g) {
		g.drawImage(loadImage.getImage(Setting.R_MENU + "menu.png"), 0, 0, Setting.WIDTH, Setting.HEIGHT, null);
		

		font = new Font("HELVETICA", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.RED);
		String title = "ZELDA ADVENTURE";
		g.drawString(title, 142, 100);
	}

	public void drawGameMenu(Graphics g) {

		font = new Font("HELVETICA", Font.BOLD, 50);
		g.setFont(font);

		drawRectangleMenu(g);

		g.setColor(Color.WHITE);
		g.drawString("S", 242, 240);
		g.drawString("H", 242, 320);
		g.drawString("Q", 240, 410);
		g.drawString("START", 330, 240);
		g.drawString("HELP", 350, 320);
		g.drawString("QUIT", 355, 410);

		font = new Font("HELVETICA", Font.BOLD, 15);
		g.setFont(font);
		String str = " clicca o digita l'iniziale per fare la tua scelta ";
		g.drawString(str, 200, 490);
	}

	private void drawRectangleMenu(Graphics g) {
		if (isStart() == true) {
			g.setColor(new Color(0, 204, 0));
			g.fillRoundRect(Setting.IM_W_C1, Setting.IM_H_S, Setting.IM_W_C2, Setting.IM_H_R, 20, 20);
			g.fillRoundRect(Setting.IM_W_R1, Setting.IM_H_S, Setting.IM_W_R, Setting.IM_H_R, 20, 20);
		} else if (isHelp() == true) {
			g.setColor(new Color(0, 204, 0));
			g.fillRoundRect(Setting.IM_W_C1, Setting.IM_H_H, Setting.IM_W_C2, Setting.IM_H_R, 20, 20);
			g.fillRoundRect(Setting.IM_W_R1, Setting.IM_H_H, Setting.IM_W_R, Setting.IM_H_R, 20, 20);

		}

		else if (isQuit() == true) {
			g.setColor(Color.RED);
			g.fillRoundRect(Setting.IM_W_C1, Setting.IM_H_Q, Setting.IM_W_C2, Setting.IM_H_R, 20, 20);
			g.fillRoundRect(Setting.IM_W_R1, Setting.IM_H_Q, Setting.IM_W_R, Setting.IM_H_R, 20, 20);
		}

		else {
			g.setColor(Color.BLACK);

		}

	}

	public void drawPause(Graphics g) {
		g.drawImage(loadImage.getImage(Setting.R_MENU + "pause.png"), 0, 0, Setting.WIDTH, Setting.HEIGHT, null);
		font = new Font("HELVETICA", Font.BOLD, 40);
		g.setFont(font);
		
		drawRectangleGame(g);
		g.setColor(Color.WHITE);
		g.drawString("QUIT", 690, 490);
		g.drawString("RESUME", 8, 490);

	}
	
	

	public void drawWin(Graphics g) {
		g.drawImage(loadImage.getImage(Setting.R_MENU + "win.png"), 0, 0, Setting.WIDTH, Setting.HEIGHT, null);
		font = new Font("HELVETICA", Font.BOLD, 40);
		g.setFont(font);
		if (isQuit() == true) {
			g.setColor(Color.RED);
			g.fillRoundRect(680, 458, 115, 40, 20, 20);
		} 
		g.setColor(Color.WHITE);
		g.drawString("QUIT", 690, 490);

	}

	public void drawGameOver(Graphics g) {
		g.drawImage(loadImage.getImage(Setting.R_MENU + "gameOver.png"), 0, 0, Setting.WIDTH, Setting.HEIGHT, null);
		font = new Font("HELVETICA", Font.BOLD, 40);
		g.setFont(font);
		if (isQuit() == true) {
			g.setColor(Color.RED);
			g.fillRoundRect(680, 458, 115, 40, 20, 20);
		} 
		g.setColor(Color.WHITE);
		g.drawString("QUIT", 690, 490);

	}

	public void drawOnGame(Graphics g) {

		font = new Font("HELVETICA", Font.BOLD, 40);
		g.setFont(font);

		drawRectangleGame(g);

		g.setColor(Color.WHITE);
		g.drawString("QUIT", 690, 490);
		g.drawString("PAUSE", 10, 490);
	}

	public void drawRectangleGame(Graphics g) {
		if (isPause() == true) {
		
			g.setColor(new Color(0, 204, 0));

		} else {
			g.setColor(Color.DARK_GRAY);
		}

		g.fillRoundRect(0, 458, 174, 40, 20, 20);

		if (isQuit() == true) {
			g.setColor(Color.RED);
		} else
			g.setColor(Color.DARK_GRAY);

		g.fillRoundRect(680, 458, 115, 40, 20, 20);
	}

	public void drawHelp(Graphics g) {
		g.drawImage(loadImage.getImage(Setting.R_MENU + "help.png"), 0, 0, Setting.WIDTH, Setting.HEIGHT, null);
		font = new Font("HELVETICA", Font.BOLD, 40);
		g.setFont(font);

		g.setColor(Color.WHITE);
		g.drawString("QUIT", 690, 490);
		g.drawString("MENU", 10, 490);

	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isHelp() {
		return help;
	}

	public void setHelp(boolean help) {
		this.help = help;
	}

	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

}
