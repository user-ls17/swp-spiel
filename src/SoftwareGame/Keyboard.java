package SoftwareGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Keyboard implements KeyListener, MouseMotionListener, MouseListener, MouseWheelListener {
	private static boolean[] keys = new boolean[1024];
	private static int mousex;
	private static int mousey;
	private static int button;
	private static boolean mouseWheelChanged = false;
	private static int mouseWheelMoved = 0;

	public static int getMouseX() {
		return mousex;
	}

	public static int getMouseY() {
		return mousey;
	}

	public static int getButton() {
		return button;
	}
	
	public static int getMouseWheelMoved()
	{
		if(mouseWheelChanged)
		{
			mouseWheelChanged = false;
			return mouseWheelMoved;
		}
		return 0;
	}
	
	public static boolean isKeyPressed(int keycode) {
		return keys[keycode];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		button = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		button = 0;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		int mouseWheelMove = arg0.getWheelRotation();
		if(mouseWheelMove < 0)
		{
			mouseWheelMoved = -1;
			mouseWheelChanged = true;
		}
		else if(mouseWheelMove > 0)
		{
			mouseWheelMoved = 1;
			mouseWheelChanged = true;
		}
	}
}
