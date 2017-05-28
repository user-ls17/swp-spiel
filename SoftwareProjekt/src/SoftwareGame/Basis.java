package SoftwareGame;

public class Basis extends InGameObjekt {
	public Basis(int posX, int posY, int atk, int maxLive, int ID) {
		this.posX = posX;
		this.posY = posY;
		this.atk = atk;
		this.maxLive = maxLive;
		this.live = maxLive;
		alive = true;
	}
}
