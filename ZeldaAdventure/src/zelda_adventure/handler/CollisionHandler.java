package zelda_adventure.handler;

import java.util.ArrayList;

import zelda_adventure.model.Tile;
import zelda_adventure.model.World;
import zelda_adventure.model.character.enemy.Bat;
import zelda_adventure.model.character.enemy.Solider;
import zelda_adventure.model.character.hero.Zelda;
import zelda_adventure.model.game_object.Obstacle;
import zelda_adventure.model.game_object.Prize;
import zelda_adventure.resources.LoadSound;
import zelda_adventure.config.Action;
import zelda_adventure.config.Setting;
import zelda_adventure.config.TypePrize;

public class CollisionHandler {
	private World world;
	private WorldHandler worldHandler;
	private ArrayList<Tile> remove;

	private boolean gameOver;
	private boolean win;

	private LoadSound loadSound;

	public CollisionHandler() {
		worldHandler = new WorldHandler();
		world = worldHandler.generateWorld();
		loadSound = LoadSound.getInstance();
		remove = new ArrayList<Tile>();
		setGameOver(false);
		setWin(false);
	}

	public void update() {
		getWorld().update();
		checkCollision();
		remove();
		
	}
	

	private void checkCollision() {
		checkZeldaObstacleCollision();
		checkEnemyObstacleCollision();
		checkZeldaEnemyResearchCollision();
		checkZeldaEnemyCollision();
		checkZeldaAttackEnemyCollision();
		checkZeldaPrizeCollision();
		checkZeldaStairsCollision();
	}

	private void checkZeldaStairsCollision() {
		if (getZelda().getMain().intersects(getWorld().getStairs().getMain())) {
			loadSound.playWin();
			setWin(true);

		}
	}

	private void checkZeldaObstacleCollision() {
		for (Obstacle obstacle : getWorld().getObstacles()) {
			if (getZelda().getNord().intersects(obstacle.getSud())) {
				getZelda().setY(obstacle.getY() + obstacle.getDimension().width);
				getZelda().setMove(false);
			} else if (getZelda().getSud().intersects(obstacle.getNord())) {
				getZelda().setY(obstacle.getY() - getZelda().getDimension().height + 4);
				getZelda().setMove(false);

			} else if (getZelda().getWest().intersects(obstacle.getEst())) {
				getZelda().setX(obstacle.getX() + obstacle.getDimension().width + 1);
				getZelda().setMove(false);

			} else if (getZelda().getEst().intersects(obstacle.getWest())) {
				getZelda().setX(obstacle.getX() - getZelda().getDimension().width);
				getZelda().setMove(false);

			}
		}
	}

	private void checkEnemyObstacleCollision() {
		for (Obstacle obstacle : getWorld().getObstacles()) {
			for (Bat bat : getWorld().getBats()) {
				if (bat.getNord().intersects(obstacle.getSud())) {

					bat.setGoUp(false);
				} else if (bat.getSud().intersects(obstacle.getNord())) {
					bat.setGoUp(true);
				} else if (bat.getWest().intersects(obstacle.getEst())) {
					bat.setGoRight(true);
				} else if (bat.getEst().intersects(obstacle.getWest())) {
					bat.setGoRight(false);
				}
			}
			for (Solider solider : getWorld().getSoliders()) {
				if (solider.getNord().intersects(obstacle.getSud())) {
					solider.setY(obstacle.getY() + obstacle.getDimension().height);
					solider.setMoveInX(false);
					solider.setGoUp(true);
				} else if (solider.getSud().intersects(obstacle.getNord())) {
					solider.setY(obstacle.getY() - solider.getDimension().height - 1);
					solider.setMoveInX(false);
					solider.setGoUp(true);
				} else if (solider.getWest().intersects(obstacle.getEst())) {
					solider.setX(obstacle.getX() + obstacle.getDimension().width + 1);
					solider.setMoveInX(true);
					solider.setGoRight(true);
				} else if (solider.getEst().intersects(obstacle.getWest())) {
					solider.setX(obstacle.getX() - solider.getDimension().width - 1);
					solider.setMoveInX(true);
					solider.setGoRight(false);
				}
			}
		}
	}

	private void checkZeldaEnemyResearchCollision() {
		for (Bat bat : getWorld().getBats()) {
			if (getZelda().getRNord().intersects(bat.getRSud())) {
				bat.setGoUp(false);
			} else if (getZelda().getRSud().intersects(bat.getRNord())) {
				bat.setGoUp(true);
			} else if (getZelda().getRWest().intersects(bat.getREst())) {
				bat.setGoRight(true);
			} else if (getZelda().getREst().intersects(bat.getRWest())) {
				bat.setGoRight(false);
			} else if (getZelda().getRNord().intersects(bat.getREst())
					&& getZelda().getRWest().intersects(bat.getRSud())) {
				bat.setGoRight(true);
				bat.setGoUp(false);
			} else if (getZelda().getRNord().intersects(bat.getRWest())
					&& getZelda().getREst().intersects(bat.getRSud())) {
				bat.setGoRight(false);
				bat.setGoUp(false);
			} else if (getZelda().getRSud().intersects(bat.getREst())
					&& getZelda().getRWest().intersects(bat.getRNord())) {
				bat.setGoRight(true);
				bat.setGoUp(true);
			} else if (getZelda().getRSud().intersects(bat.getRWest())
					&& getZelda().getREst().intersects(bat.getRNord())) {
				bat.setGoRight(false);
				bat.setGoUp(true);
			}
		}

		for (Solider solider : getWorld().getSoliders()) {
			if (getZelda().getRNord().intersects(solider.getSud())) {
				solider.setMoveInX(false);
				solider.setGoUp(false);
			} else if (getZelda().getRSud().intersects(solider.getNord())) {
				solider.setMoveInX(false);
				solider.setGoUp(true);
			} else if (getZelda().getREst().intersects(solider.getRWest())) {
				solider.setMoveInX(true);
				solider.setGoRight(false);
			} else if (getZelda().getRWest().intersects(solider.getREst())) {
				solider.setMoveInX(true);
				solider.setGoRight(true);
			}
		}
	}

	private void checkZeldaEnemyCollision() {
		for (Bat bat : getWorld().getBats()) {
			if (getZelda().getMain().intersects(bat.getMain()) && !bat.isDie()) {

				getZelda().setPotion(getZelda().getPotion() - 1);

				checkZeldaLife();
			}
		}
		for (Solider solider : getWorld().getSoliders()) {
			if (getZelda().getMain().intersects(solider.getMain()) && !solider.isDie()) {

				getZelda().setPotion(getZelda().getPotion() - 1);
				checkZeldaLife();
			}
		}
	}

	private void checkZeldaLife() {
		if (getZelda().getPotion() >= 1) {
			getWorld().resetZelda();
		} else {
			loadSound.playGameOver();
			setGameOver(true);
		}
	}

	private void checkZeldaAttackEnemyCollision() {
		for (Bat bat : getWorld().getBats()) {
			if (getZelda().getAttack() != null && getZelda().getAttack().intersects(bat.getMain())) {

				if (getZelda().getAction() == Action.DOWN)
					bat.setY(bat.getY() + 20);
				else if (getZelda().getAction() == Action.RIGHT || getZelda().getAction() == Action.UP_RIGHT
						|| getZelda().getAction() == Action.DOWN_RIGHT)
					bat.setX(bat.getX() + 20);
				else if (getZelda().getAction() == Action.UP)
					bat.setY(bat.getY() - 20);
				else if (getZelda().getAction() == Action.LEFT || getZelda().getAction() == Action.UP_LEFT
						|| getZelda().getAction() == Action.DOWN_LEFT)
					bat.setX(bat.getX() - 20);

				bat.setCont(bat.getCont() + 1);
			}

			if (bat.getCont() >= 2) {
				bat.setDie(true);
				getZelda().addScore(Setting.S_BAT);
				loadSound.playBatDie();
				bat.setCont(0);
			}

			if (!getZelda().getResearch().intersects(bat.getResearch()) && bat.isDie())
				remove.add(bat);

		}

		for (Solider solider : getWorld().getSoliders()) {
			if (getZelda().getAttack() != null && getZelda().getAttack().intersects(solider.getMain())) {

				if (getZelda().getAction() == Action.DOWN)
					solider.setY(solider.getY() + 20);
				else if (getZelda().getAction() == Action.RIGHT || getZelda().getAction() == Action.UP_RIGHT
						|| getZelda().getAction() == Action.DOWN_RIGHT)
					solider.setX(solider.getX() + 20);
				else if (getZelda().getAction() == Action.UP)
					solider.setY(solider.getY() - 20);
				else if (getZelda().getAction() == Action.LEFT || getZelda().getAction() == Action.UP_LEFT
						|| getZelda().getAction() == Action.DOWN_LEFT)
					solider.setX(solider.getX() - 20);

				solider.setCont(solider.getCont() + 1);
			}

			if (solider.getCont() >= 2) {
				solider.setDie(true);
				loadSound.playSoliderDie();
				getZelda().addScore(Setting.S_SOLIDER);
				remove.add(solider);
			}
		

		}

	}

	private void checkZeldaPrizeCollision() {
		for (Prize prize : getWorld().getPrizes()) {
			if (getZelda().getMain().intersects(prize.getMain())) {
				if (prize.getType() == TypePrize.CHEST) {
					getZelda().addScore(Setting.S_CHEST);
					loadSound.playChest();
					getZelda().setChest(getZelda().getChest() + 1);
				} else if (prize.getType() == TypePrize.POTION) {
					getZelda().addScore(Setting.S_POTION);
					loadSound.playPotion();
					getZelda().setPotion(getZelda().getPotion() + 1);
				} else if (prize.getType() == TypePrize.SWORD) {
					getZelda().addScore(Setting.S_SWORD);
					loadSound.playSword();
					getZelda().setSword(getZelda().getSword() + 1);

				}
				remove.add(prize);
			}
		} 
	}

	private void remove() {
		for (Tile tile : remove) {
			if (tile instanceof Bat) {
				getWorld().removeBats((Bat) tile);
			} else if (tile instanceof Solider) {
				getWorld().removeSolider((Solider) tile);
			} else if (tile instanceof Prize) {
				getWorld().removePrize((Prize) tile);
			}
		}
	}

	public World getWorld() {
		return world;
	}

	private Zelda getZelda() {
		return world.getZelda();
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

}
