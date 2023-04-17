package zelda_adventure.resources;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import zelda_adventure.config.Setting;

public class LoadSound {

	private static LoadSound instance = null;

	private Clip potion;
	private Clip chest;
	private Clip sword;
	private Clip bat;
	private Clip solider;
	private Clip gameOver;
	private Clip win;

	private LoadSound() {
		potion = getClip("potion.wav");
		chest = getClip("chest.wav");
		sword = getClip("sword.wav");
		bat = getClip("batDie.wav");
		solider = getClip("soliderDie.wav");
		gameOver = getClip("game_over.wav");
		win = getClip("win.wav");
	}

	private File getFile(String str) {
		File file = new File(Setting.R_SOUND + str);
		return file;
	}

	private Clip getClip(final String str) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(getFile(str)));
			return clip;
		} catch (Exception e) {

		}
		return null;
	}

	public void playWin() {
		win.start();
	}

	
	public void playPotion() {
		potion.start();

	}

	public void playGameOver() {
		gameOver.start();
	}

	
	public void playSword() {

		sword.start();

	}

	public void playChest() {
		chest.start();
	}

	public void playBatDie() {

		bat.start();

	}

	public void stopbat() {
		bat.stop();
	}

	public void playSoliderDie() {

		solider.start();
	}

	public static LoadSound getInstance() {
		if (instance == null)
			instance = new LoadSound();
		return instance;
	}
	
}
