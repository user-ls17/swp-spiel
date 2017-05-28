package SoftwareGame;

import java.awt.Point;

public class Game {
	public static int gameState = 1;
	public static int mainMenu = 0;
	public static int inGame = 1;
	public static int endGame = -1;

	public static Point rechts = new Point(1, 0);
	public static Point links = new Point(-1, 0);
	public static Point unten = new Point(0, 1);
	public static Point oben = new Point(0, -1);

	static int width = 800;
	static int height = 600;

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(3); // 3 = Close on Exit
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setVisible(true);

		frame.makestrat();

		long lastFrame = System.currentTimeMillis();

		while (gameState != endGame) {
			long thisFrame = System.currentTimeMillis();
			float timeSinceLastFrame = (float) ((thisFrame - lastFrame) / 1000.0);
			lastFrame = thisFrame;
			frame.update(timeSinceLastFrame);

			frame.repaint();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean collisionPointRectangle(int pointX, int pointY, int RectangleX, int RectangleY, int width,
			int height) {
		boolean collisionX = pointX > RectangleX && pointX < RectangleX + width;
		boolean collisionY = pointY > RectangleY && pointY < RectangleY + height;
		return collisionX && collisionY;
	}

	public static boolean compareTwoPoint(Point pointOne, Point pointTwo) {
		return (pointOne.x == pointTwo.x && pointOne.y == pointTwo.y);
	}
	
	public static int betrag(int value)
	{
		if(value>=0)
			return value;
		return value*-1;
	}
}
