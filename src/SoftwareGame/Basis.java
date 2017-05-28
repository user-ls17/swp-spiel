package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Basis extends InGameObjekt {
	public Basis(Point pos, int atk, int maxLive, int ID, int controller, Point size, ArrayList<Point> atkAble,
			int rotation) {
		this.rotation = rotation;
		this.pos = pos;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		this.controller = controller;
		this.size = size;
		this.attackable = atkAble;
		alive = true;
	}

	public Basis(Point pos, int atk, int maxLive, int ID, int controller, Point size, int lenght, int rotation,
			int moveRange) {
		this.rotation = rotation;
		this.pos = pos;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		this.controller = controller;
		this.size = size;
		createAttackAblePerLenght(lenght);
		createMoveToPerRadius(moveRange);
		alive = true;
	}

	public Basis(Point pos, int atk, int maxLive, int ID, int controller, int radius, Point size, int rotation,
			int moveRange) {
		this.rotation = rotation;
		this.pos = pos;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		this.controller = controller;
		this.size = size;
		createAttackAblePerRadius(radius);
		createMoveToPerRadius(moveRange);
		alive = true;
	}

	public void draw(Graphics g, boolean shouldShowAtkRadius, boolean shouldShowMoveRadius, Point verschiebung,
			float zoomFactor) {
		Point drawPos = World.getDrawPos(pos, (int) (size.x * zoomFactor), (int) (size.y * zoomFactor));
		g.drawImage(GrafikLibery.allBaseTextures[(ID * (Frame.anzahlSpieler + 1)) + controller], drawPos.x, drawPos.y,
				(int) (size.x * zoomFactor), (int) (size.y * zoomFactor), null);

		if (shouldShowAtkRadius) {
			drawRadius(attackable,g, 0, new Point(0, 0));
		}
		if (shouldShowMoveRadius) {
			drawRadius(pointsInMoveRange,g, 1, new Point(0, 0));
		}
	}

	public void draw(Graphics g, boolean shouldShowAtkRadius, boolean shouldShowMoveRadius, Point verschiebung,
			Point MousePos, float zoomFactor) {
		Point drawPos = World.getDrawPos(pos, (int) (size.x * zoomFactor), (int) (size.y * zoomFactor));
		g.drawImage(GrafikLibery.allBaseTextures[(ID * (Frame.anzahlSpieler + 1)) + controller], drawPos.x, drawPos.y,
				(int) (size.x * zoomFactor), (int) (size.y * zoomFactor), null);

		if (shouldShowAtkRadius) {
			drawRadius(attackable,g, 0, MousePos);
		}
		if (shouldShowMoveRadius) {
			drawRadius(pointsInMoveRange,g, 1, MousePos);
		}
	}

	protected void drawRadius(ArrayList<Point> radius, Graphics g, int radiusType, Point MousePos) {
		for (int i = 0; i < radius.size(); i++) {
			int isMouseOver = 0;
			if (radius.get(i).x == MousePos.x && radius.get(i).y == MousePos.y) {
				isMouseOver = 1;
			}
			Point drawPos = World.getDrawPos(radius.get(i), World.zoomedTileWidth, World.zoomedTileHeight);
			g.drawImage(GrafikLibery.allTileMarkingTextures[radiusType * 2 + isMouseOver], drawPos.x, drawPos.y,
					World.zoomedTileWidth, World.zoomedTileHeight, null);
		}
	}
}
