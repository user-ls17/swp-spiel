package SoftwareGame;

import java.awt.image.BufferedImage;

public class GrafikLibery {

	public static BufferedImage backGroundFiller;

	public static BufferedImage[] allMenuTextures;
	public static int menuTextureNumber = 1;
	public static BufferedImage[] allButtonTextures;
	public static int buttonTextureNumber = 1;
	public static BufferedImage[] allUnitTextures;
	public static int unitTextureNumber = 2;
	public static BufferedImage[] allBaseTextures;
	public static int baseTextureNumber = 3;
	public static BufferedImage[] allTileTextures;
	public static int tileTextureNumber = 4;
	public static BufferedImage[] allTileMarkingTextures;
	public static int tileMarkingNumber =4;

	public static void setup() {
		backGroundFiller = Imageloader.loadImage("backGroundFiller");

		allMenuTextures = new BufferedImage[menuTextureNumber];
		allMenuTextures[0] = Imageloader.loadImage("GameTestScreen");

		allButtonTextures = new BufferedImage[buttonTextureNumber];
		allButtonTextures[0] = Imageloader.loadImage("PlayButton");

		allUnitTextures = new BufferedImage[unitTextureNumber];
		allUnitTextures[0] = Imageloader.loadImage("char_Red");
		allUnitTextures[1] = Imageloader.loadImage("char_Blue");

		allBaseTextures = new BufferedImage[baseTextureNumber];
		allBaseTextures[0] = Imageloader.loadImage("base_free");
		allBaseTextures[1] = Imageloader.loadImage("base_Red_v4");
		allBaseTextures[2] = Imageloader.loadImage("base_Blue");

		allTileTextures = new BufferedImage[tileTextureNumber];
		allTileTextures[0] = Imageloader.loadImage("Tile_Grass");
		allTileTextures[1] = Imageloader.loadImage("Tile_Dessert");
		allTileTextures[2] = Imageloader.loadImage("Tile_Wald");
		allTileTextures[3] = Imageloader.loadImage("Tile_Mountain");
	
		allTileMarkingTextures = new BufferedImage[tileMarkingNumber];
		allTileMarkingTextures[0] = Imageloader.loadImage("marked_attackAble_v2");
		allTileMarkingTextures[1] = Imageloader.loadImage("marked_attackAble_mouseOver_v2");
		allTileMarkingTextures[2] = Imageloader.loadImage("marked_moveAble");
		allTileMarkingTextures[3] = Imageloader.loadImage("marked_moveAble_mouseOver");
	}
}
