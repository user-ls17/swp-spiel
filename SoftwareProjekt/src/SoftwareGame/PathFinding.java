package SoftwareGame;

import java.awt.Point;

public class PathFinding {
	public static Path findPathAStar(Point startPos, Point endPos) {
		return null;
	}

	public static Path findNormalPath(Point startPos, Point endPos) {
		Path path = new Path();
		path.addLastTarget(startPos);
		Point p = startPos;
		Point p2 = null;
		while (p.x != endPos.x && p.y != endPos.y) {
			if (p.x < endPos.x) {
				if (p.y < endPos.y) {
					p2 = new Point(1, 0);
				} else {
					p2 = new Point(-1, 0);
				}
			} else {
				if (p.y < endPos.y) {
					p2 = new Point(0, 1);
				} else {
					p2 = new Point(0, -1);
				}
			}
			path.addLastTarget(p2);
			p = new Point(p.x+p2.x,p.y+p2.y);
		}
		return null;
	}
}
