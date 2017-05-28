package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public abstract class InGameObjekt {
	protected int ID;

	protected ArrayList<Point> attackable;
	protected ArrayList<Point> pointsInMoveRange;
	
	protected int markingTypes = 2;
	
	protected Point pos;
	protected Point targetPos;
	protected Point fianlTargetPos;
	protected Point realPos;
	protected Point movement;

	protected int rotation;

	protected Point size;

	protected int controller;

	protected int speed = 6;

	protected int atk;
	protected int maxLive;
	protected int live;
	protected boolean alive;
	protected boolean reachedGoal;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Point getPos() {
		return pos;
	}

	public int getAtk() {
		return atk;
	}

	public int getLive() {
		return live;
	}

	public int getMaxLive() {
		return maxLive;
	}

	public boolean isAlive() {
		return alive;
	}

	public void getDamage(int damage) {
		live -= damage;
		alive = live > 0;
	}

	public void damage(InGameObjekt toDamage) {
		toDamage.getDamage(atk);
	}

	public void setNewTarget(Point newTargtePos) {
		this.targetPos = newTargtePos;
	}
	
	public void teleportToo(Point newPos) {
		if (isPointInRange(newPos)) {
			for (int i = 0; i < attackable.size(); i++) {
				Point zwischen = attackable.get(i);
				attackable.set(i, new Point(zwischen.x + newPos.x - pos.x, zwischen.y + newPos.y - pos.y));
			}
			for (int i = 0; i < pointsInMoveRange.size(); i++) {
				Point zwischen = pointsInMoveRange.get(i);
				pointsInMoveRange.set(i, new Point(zwischen.x + newPos.x - pos.x, zwischen.y + newPos.y - pos.y));
			}
			this.pos = newPos;
		}
	}
	
	protected void createAttackAblePerLenght(int lenght) {
		attackable = new ArrayList<Point>();
		for (int w = 0; w < World.tileWidth; w++) {
			for (int h = 0; h < World.tileHeight; h++) {
				boolean thisField = w == pos.x && h == pos.y;
				boolean isLenght = w - pos.x == 0 || h - pos.y == 0;
				if ((Game.betrag(w - pos.x) + Game.betrag(h - pos.y)) <= lenght && !thisField && isLenght) {
					attackable.add(new Point(w, h));
				}
			}
		}
	}

	protected void createAttackAblePerRadius(int radius) {
		attackable = new ArrayList<Point>();
		for (int w = 0; w < World.tileWidth; w++) {
			for (int h = 0; h < World.tileHeight; h++) {
				boolean thisField = w == pos.x && h == pos.y;
				if ((Game.betrag(w - pos.x) + Game.betrag(h - pos.y)) <= radius && !thisField) {
					attackable.add(new Point(w, h));
				}
			}
		}
	}

	protected void createMoveToPerRadius(int radius) {
		pointsInMoveRange = new ArrayList<Point>();
		for (int w = 0; w < World.tileWidth; w++) {
			for (int h = 0; h < World.tileHeight; h++) {
				boolean thisField = w == pos.x && h == pos.y;
				if ((Game.betrag(w - pos.x) + Game.betrag(h - pos.y)) <= radius && !thisField) {
					pointsInMoveRange.add(new Point(w, h));
				}
			}
		}
	}

	public void move() {
		pos = new Point(pos.x + (int) (movement.x * speed), pos.y + (int) (movement.y * speed));

		if (Game.compareTwoPoint(movement, Game.links)) {
			if ((pos.x - targetPos.x) <= 0) {
				pos = targetPos;
			}
		} else if (Game.compareTwoPoint(movement, Game.rechts)) {
			if ((pos.x - targetPos.x) >= 0) {
				pos = targetPos;
			}
		} else if (Game.compareTwoPoint(movement, Game.oben)) {
			if ((pos.y - targetPos.y) <= 0) {
				pos = targetPos;
			}
		} else if (Game.compareTwoPoint(movement, Game.unten)) {
			if ((pos.y - targetPos.y) >= 0) {
				pos = targetPos;
			}
		}
	}

	public boolean hasReachedGoal() {
		return reachedGoal;
	}

	public abstract void draw(Graphics g, boolean shouldShowAtkRadius, boolean shouldShowMoveRadius, Point verschiebung,
			float zoomFactor);

	public abstract void draw(Graphics g, boolean shouldShowAtkRadius, boolean shouldShowMoveRadius, Point verschiebung,
			Point MousePos, float zoomFactor);

	public boolean isPointInRange(Point p) {
		for (int i = 0; i < pointsInMoveRange.size(); i++) {
			if (Game.compareTwoPoint(p, pointsInMoveRange.get(i)))
				return true;
		}
		return false;
	}

	protected abstract void drawRadius(ArrayList<Point> radius, Graphics g, int radiusType, Point MousePos);
}