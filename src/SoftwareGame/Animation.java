package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Animation {
	private BufferedImage texture;

	private int columns;
	private int rows;
	private int spriteWidth;
	private int spriteHeight;

	private int counter;
	private float timeBetweenFrames;
	private float newFrame;

	public Animation(BufferedImage texture, int spriteWidth, int spriteHeight, int columns, int rows, float tbf) {
		this.texture = texture;
		this.spriteHeight = spriteHeight;
		this.spriteWidth = spriteWidth;
		this.columns = columns;
		this.rows = rows;
		this.timeBetweenFrames = tbf;
		newFrame = 0;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void update(float tslf) {
		newFrame += tslf;
	}

	public void draw(Point position, int tileSize, Graphics g) {
		Point sourcePos = animationPos();
		g.drawImage(texture, position.x * tileSize, position.y * tileSize, (position.x + 1) * tileSize,
				(position.y + 1) * tileSize, sourcePos.x * spriteWidth, sourcePos.y * spriteHeight,
				(sourcePos.x + 1) * spriteWidth, (sourcePos.y + 1) * spriteHeight, null);
		
		if(newFrame >= timeBetweenFrames)
		{
			counter++;
			newFrame -= timeBetweenFrames;
		}

		if (counter > columns * rows)
			counter = 0;
	}

	public Point animationPos() {
		int momentanRow = 0;
		int momentanColumne = 0;

		for (int i = 0; i < rows; i++) {
			if (i * columns >= counter) {
				momentanRow = i;
				break;
			}
		}
		momentanColumne = counter - ((momentanRow - 1) * columns);

		return new Point(momentanColumne, momentanRow);
	}
}
