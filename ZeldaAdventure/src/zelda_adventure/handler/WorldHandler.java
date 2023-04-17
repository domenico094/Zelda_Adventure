package zelda_adventure.handler;

import java.util.ArrayList;

import zelda_adventure.config.Setting;
import zelda_adventure.config.TypePrize;
import zelda_adventure.model.World;
import zelda_adventure.model.character.enemy.Bat;
import zelda_adventure.model.character.enemy.Solider;
import zelda_adventure.model.character.hero.Zelda;
import zelda_adventure.model.game_object.Floor;
import zelda_adventure.model.game_object.Obstacle;
import zelda_adventure.model.game_object.Prize;
import zelda_adventure.model.game_object.Stairs;
import zelda_adventure.resources.LoadImage;
import zelda_adventure.resources.LoadWorld;

public class WorldHandler {

	private World world;

	private ArrayList<ArrayList<Integer>> worldMap;
	LoadImage loadImage;

	public WorldHandler() {

		loadImage = LoadImage.getInstance();
		worldMap = new ArrayList<ArrayList<Integer>>();
		setWorldMap();

	}

	private void setWorldMap() {
		worldMap = LoadWorld.getWorldMap();
	}

	public World generateWorld() {
		world = new World();
		for (int y = 0; y < worldMap.size(); y++) {
			for (int x = 0; x < worldMap.get(y).size(); x++) {

				switch (worldMap.get(y).get(x)) {
				case Setting.TILE:
					Floor tile = new Floor(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getTile());
					world.addFloor(tile);
					break;
				case Setting.GARDEN:
					Floor garden = new Floor(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getGarden());
					world.addFloor(garden);
					break;
				case Setting.FLOOR:
					Floor floor = new Floor(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getFloor());
					world.addFloor(floor);
					break;
				case Setting.STONE:
					Obstacle stone = new Obstacle(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getStone());
					world.addObstacle(stone);
					break;
				case Setting.WALL:
					Obstacle wall = new Obstacle(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getWall());
					world.addObstacle(wall);
					break;

				case Setting.CHEST:
					Prize chest = new Prize(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getChest(),
							TypePrize.CHEST);
					world.addPrize(chest);
					break;
				case Setting.POTION:
					Prize potion = new Prize(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getPotion(),
							TypePrize.POTION);
					world.addPrize(potion);
					break;
				case Setting.SWORD:
					Prize sword = new Prize(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getSword(),
							TypePrize.SWORD);
					world.addPrize(sword);
					break;
				case Setting.STAIRS:
					Stairs stairs = new Stairs(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, loadImage.getStairs());
					world.setStairs(stairs);
					break;
				case Setting.BAT:
					Bat bat = new Bat(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, null);
					world.addBat(bat);
					break;
				case Setting.SOLIDER:
					Solider solider = new Solider(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, null);
					world.addSolider(solider);
					break;
				case Setting.ZELDA:
					Zelda zelda = new Zelda(x * Setting.T_WIDTH, y * Setting.T_HEIGHT, null);
					world.setZelda(zelda);
					break;

				default:
					break;
				}
			}
		}
		return world;
	}

	public World getWorld() {
		return world;
	}
}
