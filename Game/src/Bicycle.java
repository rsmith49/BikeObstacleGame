
public class Bicycle
{
	private static final double DRAG = .0001;
	private static final double BRAKE = .0002;
	private static final double PEDAL_FORCE = .005;
	
	private double pos=0;
	private int wheels=2;
//	private double weight;
	private double speed=0;
	private int lane=1;
	private boolean gameOver=false;
	
	public void pedal(long time)
	{
		speed = speed + wheels*PEDAL_FORCE*time;
		pos = pos + speed*time;
	}
	public void coast(long time)
	{
		speed = speed - DRAG*speed*time;
		pos = pos + speed*time;
	}
	public void brake(long time)
	{
		speed = speed - wheels*BRAKE*speed*time;
		pos = pos + speed*time;
	}
	public void crash()
	{
		speed = 0;
		wheels--;
		if (wheels<1)
		{
			gameOver = true;
		}
	}
	public void moveRight()
	{
		if (lane==2)
		{
			return;
		}
		lane++;
	}
	public void moveLeft()
	{
		if (lane==0)
		{
			return;
		}
		lane--;
	}
	public double getPos()
	{
		return pos;
	}
	public double getSpeed()
	{
		return speed;
	}
	public int getLane()
	{
		return lane;
	}
/*	public double getWeight()
	{
		return weight;
	} */
	public int getWheels()
	{
		return wheels;
	}
	public boolean gameOver()
	{
		return gameOver;
	}
}
