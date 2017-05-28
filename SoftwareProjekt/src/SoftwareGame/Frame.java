package SoftwareGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Frame extends JFrame {
	public static int rand = 20;
	private BufferStrategy strat;
	private BufferedImage cursor;
	static int cursorsize = 16;
	Menu mainMenu;
	private World world;

	public Frame() {

		super("Game");

		GrafikLibery.setup();

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(new Button(300, 300, 300, 100, 0));
		mainMenu = new Menu(0);

		Keyboard kb = new Keyboard();
		addKeyListener(kb);
		addMouseMotionListener(kb);
		addMouseListener(kb);

		cursor = Imageloader.loadImage("cursor");
		cursorsize = cursor.getWidth();
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB),
				new Point(0, 0), "INVISIBLE"));

		world = new World(19, 13);
	}

	public void makestrat() {
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}

	public void repaint() {
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}

	public void draw(Graphics g) {
		if (Game.gameState == Game.inGame) {
			world.draw(g);
		} else if (Game.gameState == Game.mainMenu) {
			g.drawImage(GrafikLibery.allMenuTextures[Game.gameState], 0, rand, null);
		}
		g.drawImage(cursor, Keyboard.getMouseX(), Keyboard.getMouseY(), null);
	}

	public void update(float tslf) {
		world.update(tslf);
	}
}
