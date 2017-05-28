package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class World {

	private Tile[][] tile;

	private ArrayList<InGameObjekt> inGame;

	private int choosenObjekt;

	public static int tileWidth;
	public static int tileHeight;

	public static int worldState = 0;

	public static int attackingState = 1;
	public static int movingState = 2;
	public static int placingState = 3;

	private Point tileMousePos;

	private static int normalTileWidth = 32;
	private static int normalTileHeight = 32;

	private static float zoomFactor = 1.5f;
	private static float zoomSpeed = 0.1f;
	private static float zoomMax = 5f;
	private static float zoomMin = 1.3f;
	public static int zoomedTileWidth = (int) (normalTileWidth * zoomFactor);
	public static int zoomedTileHeight = (int) (normalTileHeight * zoomFactor);

	public World(int tileW, int tileH) {
		tileWidth = tileW;
		tileHeight = tileH;
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

		inGame = new ArrayList<InGameObjekt>();
		choosenObjekt = 0;

		// ArrayList<Point> atkAble = new ArrayList<Point>();
		// atkAble.add(new Point(2, 5));
		// atkAble.add(new Point(2, 7));
		// atkAble.add(new Point(1, 6));
		// atkAble.add(new Point(3, 6));

		inGame.add(UnitPerloads.getUnitbyID(3, 0, new Point(8, 8), 1));
		inGame.add(UnitPerloads.getUnitbyID(3, 1, new Point(7, 8), 1));
		inGame.add(UnitPerloads.getUnitbyID(2, 1, new Point(8, 7), 1));
		inGame.add(UnitPerloads.getUnitbyID(1, 0, new Point(7, 7), 1));

		inGame.add(new Basis(new Point(2, 6), 10, 10, 0, 0, 1, new Point(32, 32), 1, 0));
		inGame.add(new Basis(new Point(12, 6), 10, 10, 0, 1, 1, new Point(32, 32), 2, 0));
		inGame.add(new Basis(new Point(14, 8), 10, 10, 0, 2, 1, new Point(32, 32), 3, 0));
	}

	public void draw(Graphics g) {
		Point verschiebung = inGame.get(choosenObjekt).pos;
		for (int x = 0; x < tileWidth; x++) {
			for (int y = 0; y < tileHeight; y++) {
				g.drawImage(GrafikLibery.allTileTextures[tile[x][y].getType()], zoomedTileWidth * x,
						zoomedTileHeight * y, zoomedTileWidth, zoomedTileHeight, null);
			}
		}
		for (int i = 0; i < inGame.size(); i++) {
			inGame.get(i).draw(g, i == choosenObjekt && worldState == attackingState,
					i == choosenObjekt && worldState == movingState, verschiebung, tileMousePos, zoomFactor);
		}
	}

	public void update(float tslf) {
		zoomFactor += Keyboard.getMouseWheelMoved() * zoomSpeed;
		if (zoomFactor >= zoomMax)
			zoomFactor = zoomMax;
		if (zoomFactor <= zoomMin)
			zoomFactor = zoomMin;
		zoomedTileWidth = (int) (normalTileWidth * zoomFactor);
		zoomedTileHeight = (int) (normalTileHeight * zoomFactor);

		if (Keyboard.isKeyPressed(KeyEvent.VK_A)) {
			worldState = attackingState;
		}

		if (Keyboard.isKeyPressed(KeyEvent.VK_M)) {
			worldState = movingState;
		}

		tileMousePos = tileMouseBerechnen();

		if (tileMousePos.x <= tileWidth && tileMousePos.y <= tileHeight && tileMousePos.x >= 0 && tileMousePos.y >= 0) {
			if (Keyboard.getButton() == 1 && !isFieldBlocked(tileMousePos)) {
				if (worldState == movingState)
					inGame.get(choosenObjekt).teleportToo(tileMousePos);
				// inGame.get(choosenObjekt).move(tileMousePos);
				else if (worldState == attackingState) {
					for (int i = 0; i < inGame.size(); i++) {
						if (Game.compareTwoPoint(inGame.get(i).pos, tileMousePos) && i != choosenObjekt) {
							inGame.get(choosenObjekt).damage(inGame.get(i));
						}
					}
				}
			}
			for (int i = 0; i < inGame.size(); i++) {
				if (!inGame.get(i).alive) {
					inGame.remove(i);
				}
			}
		}
	}

	public boolean isFieldBlocked(Point field) {
		boolean b = false;

		if (field.x >= 0 && field.y >= 0 && field.x < tileWidth && field.y < tileHeight) {
			if (tile[field.x][field.y].isBlocked())
				b = true;
		} else
			b = true;

		for (int i = 0; i < inGame.size(); i++)
			if (inGame.get(i).pos.x == field.x && inGame.get(i).pos.y == field.y)
				b = true;
		return b;
	}

	public static Point getDrawPos(Point tilePosition, int width, int height) {
		return new Point(tilePosition.x * zoomedTileWidth - (zoomedTileWidth + width) / 2,
				tilePosition.y * zoomedTileHeight - (zoomedTileHeight + height) / 2);
	}

	public static Point getDrawPos(Point tilePosition, Point verschiebung, int width, int height) {
		return new Point(
				tilePosition.x * zoomedTileWidth - (zoomedTileWidth + (int) (width * zoomFactor)) / 2
						- verschiebung.x * zoomedTileWidth,
				tilePosition.y * zoomedTileHeight - (zoomedTileHeight + (int) (height * zoomFactor)) / 2
						- verschiebung.y * zoomedTileHeight);
	}

	public Point tileMouseBerechnen() {
		return new Point((Keyboard.getMouseX() + (Frame.cursorsize / 2)) / zoomedTileWidth + 1,
				(Keyboard.getMouseY() + (Frame.cursorsize / 2)) / zoomedTileHeight + 1);
	}

	public Point getTileMousePos() {
		return tileMousePos;
	}

	public void setTileMousePos(Point tileMousePos) {
		this.tileMousePos = tileMousePos;
	}
}
