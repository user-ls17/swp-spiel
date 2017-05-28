package SoftwareGame;

import java.awt.image.BufferedImage;

public class GrafikLibery {
	public static BufferedImage[] allMenuTextures;
	public static int menuTextureNumber = 1;
	public static BufferedImage[] allButtonTextures;
	public static int buttonTextureNumber = 1;
	public static BufferedImage[] allUnitTextures;
	public static int unitTextureNumber = 1;
	public static BufferedImage[] allTileTextures;
	public static int tileTextureNumber = 4;

	public static void setup() {
		allMenuTextures = new BufferedImage[menuTextureNumber];
		allMenuTextures[0] = Imageloader.loadImage("GameTestScreen");
		allButtonTextures = new BufferedImage[buttonTextureNumber];
		allButtonTextures[0] = Imageloader.loadImage("PlayButton");
		allUnitTextures = new BufferedImage[unitTextureNumber];
		allUnitTextures[0] = Imageloader.loadImage("character");
		allTileTextures = new BufferedImage[tileTextureNumber];
		allTileTextures[0] = Imageloader.loadImage("Tile_Grass");
		allTileTextures[1] = Imageloader.loadImage("Tile_Dessert");
		allTileTextures[2] = Imageloader.loadImage("Tile_Wald");
		allTileTextures[3] = Imageloader.loadImage("Tile_Mountain");
	}
}
