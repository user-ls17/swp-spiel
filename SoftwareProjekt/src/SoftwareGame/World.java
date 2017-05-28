package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;

public class World {

	private Tile[][] tile;

	private Unit[] units;
	private int unitNumbers = 4;
	private Unit coosenUnit;

	private int tileWidth;
	private int tileHeight;

	private Point tileMousePos;

	private static int normalTileWidth = 32;
	private static int normalTileHeight = 32;

	public World(int tileWidth, int tileHeight) {
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		setup();
	}

	public World() {
		tileWidth = 19;
		tileHeight = 13;
		setup();
	}

	public void setup() {
		tile = new Tile[tileWidth][tileHeight];
		for (int x = 0; x < tileWidth; x++) {
			for (int y = 0; y < tileHeight; y++) {
				boolean b = false;
				int i = 0;

				if (x == 0 || y == 0 || x == tileWidth - 1 || y == tileHeight - 1) {
					b = true;
					i = 3;
				}
				tile[x][y] = new Tile(i, b, GrafikLibery.allTileTextures[0].getWidth(),
						GrafikLibery.allTileTextures[0].getHeight(), new Point(x, y));
			}
		}

		normalTileWidth = tile[0][0].getWidth();
		normalTileHeight = tile[0][0].getHeight();

		units = new Unit[unitNumbers];
		units[0] = new Unit(3, 3, 1, 10, 0);
		units[1] = new Unit(3, 4, 1, 10, 0);
		units[2] = new Unit(5, 5, 1, 10, 0);
		units[3] = new Unit(4, 3, 1, 10, 0);
	}

	public void draw(Graphics g) {
		for (int x = 0; x < tileWidth; x++) {
			for (int y = 0; y < tileHeight; y++) {
				g.drawImage(GrafikLibery.allTileTextures[tile[x][y].getType()], tile[x][y].getWidth() * x, tile[x][y].getHeight() * y,
						null);
			}
		}
		for (int i = 0; i < units.length; i++) {
			units[i].draw(g);
		}
	}

	public void update(float tslf) {
		tileMousePos = tileMouseBerechnen();
	}

	public static Point getDrawPos(Point tilePosition, int width, int height) {
		return new Point(tilePosition.x * normalTileWidth - (normalTileWidth + width) / 2,
				tilePosition.y * normalTileHeight - (normalTileHeight + height) / 2);
	}

	public Point tileMouseBerechnen() {
		return new Point((Keyboard.getMouseX() + (Frame.cursorsize / 2)) / GrafikLibery.allTileTextures[0].getWidth(),
				(Keyboard.getMouseY() + (Frame.cursorsize / 2)) / GrafikLibery.allTileTextures[0].getHeight());
	}

	public Point getTileMousePos() {
		return tileMousePos;
	}

	public void setTileMousePos(Point tileMousePos) {
		this.tileMousePos = tileMousePos;
	}
}
