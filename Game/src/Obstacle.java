public class Obstacle implements Comparable<Obstacle>
{
	public static final int TREE = 100;
	public static final int ROCK = 101;
	public static final int BUSH = 102;
	
	private int lane;
	private double position;
	private int type;
	
	public Obstacle(int lane, double pos, int type)
	{
		this.lane = lane;
		position = pos;
		this.type = type;
	}
	
	public int getLane()
	{
		return lane;
	}
	
	public double getPosition()
	{
		return position;
	}
	
	public String getType()
	{
		if (type==TREE)
		{
			return "TREE";
		}
		if (type==ROCK)
		{
			return "ROCK";
		}
		if (type==BUSH)
		{
			return "BUSH";
		}
		return "NO TYPE";
	}

	public int compareTo(Obstacle o) 
	{
		if(position!=o.position)
		{
			return (int)Math.round(position-o.position);
		}
		if (lane!=o.lane)
		{
			return lane-o.lane;
		}
		return 0;
	}
	
	public void setPos(double pos)
	{
		position = pos;
	}
	
	public void setLane(int lane)
	{
		this.lane = lane;
	}
}
