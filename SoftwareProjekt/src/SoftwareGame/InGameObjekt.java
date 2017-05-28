package SoftwareGame;

public abstract class InGameObjekt {
	protected int ID;
	protected int posX;
	protected int posY;
	protected int atk;
	protected int maxLive;
	protected int live;
	protected boolean alive;

	public int getPosX() {
		return posX;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getPosY() {
		return posY;
	}

	public int getAtk() {
		return atk;
	}

	public int getLive() {
		return live;
	}

	public int getMaxLive() {
		return maxLive;
	}

	public boolean isAlive() {
		return alive;
	}

	public void getDamage(int damage) {
		live -= damage;
		alive = live <= 0;
	}

	public void damage(InGameObjekt toDamage) {
		toDamage.getDamage(atk);
	}
}
