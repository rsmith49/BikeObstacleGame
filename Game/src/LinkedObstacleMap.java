import java.util.LinkedList;
import java.util.Random;


public class LinkedObstacleMap 
{
	private static final double SIGHT_DIST = 2000;
	
	private LinkedList<Obstacle> map;
	private Random random = new Random();
	private Bicycle bike;
	
	public LinkedObstacleMap(Bicycle bk)
	{
		map = new LinkedList<Obstacle>();
		bike = bk;
		
	}
	
}
