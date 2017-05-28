package SoftwareGame;

import java.awt.Point;

public class UnitPerloads 
{
	int ID;
	
	public UnitPerloads()
	{
		
	}
	
	public static Unit getUnitbyID(int ID, int controller, Point position,Point size, int rotation)
	{
		Unit u = null;
		if(ID == 1)
		{
			u = new MeleeUnit(position, 3, 10, ID, controller, 1, size, rotation, 2);
		}
		if(ID == 2)
		{
			u = new MeleeUnit(position, 6, 3, ID, controller, 1, size, rotation, 3);
		}
		if(ID == 3)
		{
			u = new RangedUnit(position, 4, 5, ID, controller,  size,4, rotation, 2);
		}
		return u;
	}
	
	public static Unit getUnitbyID(int ID, int controller, Point position, int rotation)
	{
		Unit u = null;
		if(ID == 1)
		{
			u = new MeleeUnit(position, 3, 10, ID, controller, 1, new Point(8,8), rotation, 2);
		}
		if(ID == 2)
		{
			u = new MeleeUnit(position, 6, 3, ID, controller, 1, new Point(8,8), rotation, 3);
		}
		if(ID == 3)
		{
			u = new RangedUnit(position, 4, 5, ID, controller,  new Point(8,8),4, rotation, 2);
		}
		
		return u;
	}
}
