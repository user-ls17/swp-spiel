package SoftwareGame;

import java.awt.Point;
import java.util.ArrayList;

public class Path {
	
	private ArrayList<Point> path;
	private int progress;
	
	public Path(ArrayList<Point> path) {
		this.path = path;
	}
	
	public Path() {
		path = new ArrayList<Point>();
	}
	
	public void addLastTarget(Point p)
	{
		path.add(p);
	}
	
	public Point getNextTarget()
	{
		progress++;
		return path.get(progress);
	}
	
	public Point getLastTarget()
	{
		return (Point) path.toArray()[path.toArray().length];
	}
	
	public ArrayList<Point> getPath() {
		return path;
	}

	public void setPath(ArrayList<Point> path) {
		this.path = path;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
}
