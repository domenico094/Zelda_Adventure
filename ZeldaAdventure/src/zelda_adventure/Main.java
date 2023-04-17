package zelda_adventure;

import javax.swing.JFrame;

import zelda_adventure.config.Setting;
import zelda_adventure.controller.KeyController;
import zelda_adventure.controller.MouseController;
import zelda_adventure.loop.GameLoop;
import zelda_adventure.view.GraphicsPanel;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(Setting.WIDTH, Setting.HEIGHT);

		GraphicsPanel panel = new GraphicsPanel();
		frame.add(panel);

		MouseController mouseController = new MouseController();
		frame.addMouseListener(mouseController);
		frame.addMouseMotionListener(mouseController);

		KeyController keyController = new KeyController();
		frame.addKeyListener(keyController);

		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameLoop loop = new GameLoop(panel);
		Thread thread = new Thread(loop);
		thread.start();

	}
}
