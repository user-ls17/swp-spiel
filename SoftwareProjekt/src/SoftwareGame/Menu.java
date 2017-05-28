package SoftwareGame;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Button> buttons;
	private int menuID;

	public Menu(int menuID) {
		buttons = new ArrayList<Button>();
		this.menuID = menuID;
	}

	public Menu(ArrayList<Button> buttons) {
		this.buttons = buttons;
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}

	public int getMenuID() {
		return menuID;
	}
}
