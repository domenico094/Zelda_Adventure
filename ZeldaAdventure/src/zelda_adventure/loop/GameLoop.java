package zelda_adventure.loop;




import zelda_adventure.config.Setting;
import zelda_adventure.handler.GameHandler;
import zelda_adventure.view.GraphicsPanel;

public class GameLoop extends Thread {

	private GraphicsPanel panel;
	private GameHandler gameHandler;
	public GameLoop(GraphicsPanel panel) {
		this.panel = panel;
		gameHandler = GameHandler.getInstance();
		 
	}

	@Override
	public void run() {
		while (true) {
			panel.update();
		
				gameHandler.update();
				
			try {
				Thread.sleep(Setting.FREQUENCY);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
			
		}
	}
}
