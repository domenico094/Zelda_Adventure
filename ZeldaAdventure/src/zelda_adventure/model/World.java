package zelda_adventure.model;

import java.awt.Graphics;
import java.util.ArrayList;

import zelda_adventure.model.character.enemy.Bat;
import zelda_adventure.model.character.enemy.Solider;
import zelda_adventure.model.character.hero.Zelda;
import zelda_adventure.model.game_object.Floor;
import zelda_adventure.model.game_object.Obstacle;
import zelda_adventure.model.game_object.Prize;
import zelda_adventure.model.game_object.Stairs;

public class World {

	private ArrayList<Floor> floor;
	private ArrayList<Obstacle> obstacle;
	private ArrayList<Prize> prizes;
	private ArrayList<Bat> bats;
	private ArrayList<Solider> soliders;

	private Stairs stairs=null;
	private Zelda zelda=null;

	public World() {
		floor = new ArrayList<Floor>();
		obstacle = new ArrayList<Obstacle>();
		prizes = new ArrayList<Prize>();
		bats = new ArrayList<Bat>();
		soliders = new ArrayList<Solider>();
	
	}

	public void update() {
		zeldaUpdate();
		batsUpdate();
		solidersUpdate();
		
	}
	
	public void draw(Graphics g) {
		drawFloor(g);
		drawObstacle(g);
		drawPrize(g);
		drawStairs(g);
		drawBats(g);
		drawSoliders(g);
		drawZelda(g);
	}

	private void drawFloor(Graphics g) {
		if (!floor.isEmpty())
			for (Floor f : floor)
				f.draw(g);
	}

	public void addFloor(Floor f) {
		floor.add(f);
	}

	private void drawObstacle(Graphics g) {
		if (!obstacle.isEmpty())
			for (Obstacle o : obstacle)
				o.draw(g);
	}

	public void addObstacle(Obstacle o) {
		obstacle.add(o);
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacle;
	}

	private void drawPrize(Graphics g) {
		if (!prizes.isEmpty())
			for (Prize p : prizes)
				p.draw(g);
	}

	public void addPrize(Prize p) {
		prizes.add(p);
	}

	public ArrayList<Prize> getPrizes() {
		return prizes;
	}

	public void removePrize(Prize p) {
		prizes.remove(p);
	}

	public void drawStairs(Graphics g) {
		if (stairs != null)
			stairs.draw(g);
	}

	public void setStairs(Stairs stairs) {
		this.stairs = stairs;
	}

	public Stairs getStairs() {
		return stairs;
	}

	public void drawZelda(Graphics g) {
		if (zelda != null)
			zelda.draw(g);
	}

	public void setZelda(Zelda zelda) {
		this.zelda = zelda;
	}

	public Zelda getZelda() {
		return zelda;
	}
	
	public void zeldaUpdate() {
		if(zelda!= null)
			zelda.update();
	}
	
	private void drawBats(Graphics g) {
		if(!bats.isEmpty())
			for(Bat b : bats)
				b.draw(g);
	}
	
	private void batsUpdate() {
		if(!bats.isEmpty())
			for(Bat b : bats)
				b.update();
	}
	
	public void addBat(Bat b) {
		bats.add(b);
	}
	
	public ArrayList<Bat> getBats() {
		return bats;
	}
	
	public void removeBats(Bat b) {
		bats.remove(b);
	}
	
	public void solidersUpdate() {
		if(!soliders.isEmpty())
			for(Solider s : soliders)
				s.update();
	}
	
	public void drawSoliders(Graphics g) {
		if(!soliders.isEmpty())
			for(Solider s : soliders)
				s.draw(g);
	}
	
	public void addSolider(Solider s) {
		soliders.add(s);
	}
	
	public ArrayList<Solider> getSoliders() {
		return soliders;
	}
	
	public void removeSolider(Solider s) {
		soliders.remove(s);
	}

	public void resetZelda() {
		this.zelda.setX(150);
		this.zelda.setY(150);
		
	}
}
