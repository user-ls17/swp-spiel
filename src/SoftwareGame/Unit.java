package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Unit extends InGameObjekt {
	public void draw(Graphics g, boolean shouldShowAtkRadius, boolean shouldShowMoveRadius, Point verschiebung,
			float zoomFactor) {
		Point drawPos = World.getDrawPos(pos, (int) (size.x * zoomFactor), (int) (size.y * zoomFactor));
		g.drawImage(GrafikLibery.allUnitTextures[(ID * Frame.anzahlSpieler) + controller], drawPos.x, drawPos.y,
				(int) (size.x * zoomFactor), (int) (size.y * zoomFactor), null);

		if (shouldShowAtkRadius) {
			drawRadius(attackable, g, 0, new Point(0, 0));
		}
		if (shouldShowMoveRadius) {
			drawRadius(pointsInMoveRange, g, 1, new Point(0, 0));
		}
	}

	public void draw(Graphics g, boolean shouldShowAtkRadius, boolean shouldShowMoveRadius, Point verschiebung,
			Point MousePos, float zoomFactor) {
		Point drawPos = World.getDrawPos(pos, (int) (size.x * zoomFactor), (int) (size.y * zoomFactor));
		g.drawImage(GrafikLibery.allUnitTextures[(ID * Frame.anzahlSpieler) + controller], drawPos.x, drawPos.y,
				(int) (size.x * zoomFactor), (int) (size.y * zoomFactor), null);

		if (shouldShowAtkRadius) {
			drawRadius(attackable, g, 0, MousePos);
		}
		if (shouldShowMoveRadius) {
			drawRadius(pointsInMoveRange, g, 1, MousePos);
		}
	}
}
