package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;

public class Unit extends InGameObjekt {
	Unit(int posX, int posY, int atk, int maxLive, int ID) {
		this.posX = posX;
		this.posY = posY;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		alive = true;
	}

	public void draw(Graphics g) {
		g.drawImage(GrafikLibery.allUnitTextures[ID], World.getDrawPos(new Point(posX,posY), 4, 4).x, World.getDrawPos(new Point(posX,posY), 4, 4).y, null);
	}
}
