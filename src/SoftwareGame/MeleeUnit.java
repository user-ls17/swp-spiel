package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class MeleeUnit extends Unit {
	public MeleeUnit(Point pos, int atk, int maxLive, int ID, int controller, Point size, ArrayList<Point> atkAble,
			int rotation) {
		this.rotation = rotation;
		this.pos = pos;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		this.controller = controller;
		this.size = size;
		this.attackable = atkAble;
		this.pointsInMoveRange = atkAble;
		alive = true;
	}

	public MeleeUnit(Point pos, int atk, int maxLive, int ID, int controller, int radius, Point size, int rotation, int moveRange) {
		this.pos = pos;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		this.controller = controller;
		createAttackAblePerRadius(radius);
		createMoveToPerRadius(moveRange);
		this.rotation = rotation;
		this.size = size;
		alive = true;
	}

	protected void drawRadius(ArrayList<Point> radius, Graphics g, int radiusType, Point MousePos) {
		for (int i = 0; i < radius.size(); i++) {
			int isMouseOver = 0;
			if (radius.get(i).x == MousePos.x && radius.get(i).y == MousePos.y) {
				isMouseOver = 1;
			}
			Point drawPos = World.getDrawPos(radius.get(i), World.zoomedTileWidth, World.zoomedTileHeight);
			g.drawImage(GrafikLibery.allTileMarkingTextures[radiusType * markingTypes + isMouseOver], drawPos.x, drawPos.y,
					World.zoomedTileWidth, World.zoomedTileHeight, null);
		}
	}
}
