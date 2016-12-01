import java.util.Collections;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.ArrayList;

import javax.swing.Timer;

public class TestRandomNumbers 
{
	static final int INITIAL_SIZE = 1000;
	static final double DIST = 5000000;
	static final double BIKE_SIZE = 10000;
	static final double OBSTACLE_SIZE = 5000;
	static final double SIGHT_DIST = 2000;

	public static void main(String[] args) 
	{
		Bicycle bike = new Bicycle();
		ObstacleMap om = new ObstacleMap(INITIAL_SIZE);
		CrashTimerListener crList = new CrashTimerListener(om,bike);
		Timer crashTimer = new Timer(10,crList);
		TestNumbers tNumb = new TestNumbers(bike);
		tNumb.run();
		crashTimer.start();
		while(!(bike.gameOver()))
		{
			if (bike.gameOver())
			{
				System.out.println("EH");
				crashTimer.stop();
			}
			Methods.doNothing();
		}
		crashTimer.stop();
		tNumb.stop();
		System.out.println("DONE");
		
	}
	
	static class ObstacleMap
	{
		
		private ArrayList<Obstacle> map;
		private int size;
		
		public ObstacleMap(int size)
		{
			this.size = size;
			Random random = new Random();
			int i=0;
			map = new ArrayList<Obstacle>();
			for (i=0;i<size;i++)
			{
				map.add(new Obstacle(random.nextInt(3),Math.pow(Math.pow(DIST,3.0/2.0)*Math.random(), 2.0/3.0),random.nextInt(3)+100));
			}
			Collections.sort(map);
			for(i=0;i<size-2;i++)
			{
				int[] num = { map.get(i).getLane(), map.get(i+1).getLane(), map.get(i+2).getLane() };
				if (Methods.within(OBSTACLE_SIZE, map.get(i).getPosition(), map.get(i+1).getPosition()))
				{
					map.get(i).setPos(-1*BIKE_SIZE);
				}
				if ((Methods.within(BIKE_SIZE, map.get(i).getPosition(), map.get(i+1).getPosition(), map.get(i+2).getPosition()))&&(Methods.allDiff(num)))
				{
					map.get(i).setPos(-1*BIKE_SIZE);
				}
			}
			if (Methods.within(OBSTACLE_SIZE, map.get(size-2).getPosition(),map.get(size-1).getPosition()))
			{
				map.get(size-2).setPos(-1*BIKE_SIZE);
			}
		}
		
		public ArrayList<Obstacle> getMap()
		{
			return map;
		}
		
		public ArrayList<Obstacle> getLane(int num)
		{
			int i=0;
			ArrayList<Obstacle> lane = new ArrayList<Obstacle>();
			for (i=0;i<size;i++)
			{
				if (map.get(i).getLane()==num)
				{
					lane.add(map.get(i));
				}
			}
			return lane;
		}
		
		public double[] getPos(int lane)
		{
			int i=0,j=0;
			double[] posMap = new double[size];
			for(i=0;i<size;i++)
			{
				if (map.get(i).getLane()==lane)
				{
					posMap[j] = map.get(i).getPosition();
					j++;
				}
			}
			return posMap;
		}
		
		public void checkMap(int n)
		{
			int i=0;
			for (i=0;i<n;i++)
			{
				System.out.println(map.get(i).getPosition());
			}
		}
	}
	
	static class CrashTimerListener implements ActionListener
	{
		
		private ObstacleMap om;
		private Bicycle bike;
		private double safePos = 0;
		
		public CrashTimerListener(ObstacleMap map, Bicycle bike)
		{
			om = map;
			this.bike = bike;
			
		}
		
		public void actionPerformed(ActionEvent arg0) 
		{
			int i=0;
			double[] posMap = om.getPos(bike.getLane());
			for(i=0;i<posMap.length;i++)
			{
				if((posMap[i]!=safePos)&&(bike.getPos()-BIKE_SIZE/2<posMap[i])&&(bike.getPos()+BIKE_SIZE/2>posMap[i]))
				{
					bike.crash();
					safePos = posMap[i];
					return;
				}
			}
		}
	}
}
