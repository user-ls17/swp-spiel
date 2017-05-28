package SoftwareGame;

public class Button {
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int buttonID;

	public Button(int posX, int posY, int width, int height, int buttonID) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.buttonID = buttonID;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getButtonID() {
		return buttonID;
	}
}
