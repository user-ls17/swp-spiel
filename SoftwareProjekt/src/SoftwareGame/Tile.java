package SoftwareGame;

import java.awt.Point;

public class Tile {
	private int type;
	private boolean blocked;
	private int height;
	private int width;
	private Point pos;
	
	public Tile(int type, boolean blocked, int width, int height, Point pos) {
		this.type = type;
		this.blocked = blocked;
		this.height = height;
		this.width = width;
		this.setPos(pos);
	}

	public int getType() {
		return type;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}
}
