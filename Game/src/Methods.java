
public class Methods 
{
	public static boolean within(double dist, double[] pos)
	{
		int i=0,j=0;
		for(i=1;i<pos.length;i++)
		{
			if((pos[i]-pos[0])*(pos[i]-pos[0])<dist*dist)
			{
				j++;
			}
		}
		return (j==pos.length-1);
	}
	
	public static boolean within(double dist, double p1, double p2)
	{
		if ((p1+dist>p2)&&(p1-dist<p2))
		{
			return true;
		}
		return false;
	}
	
	public static boolean within(double dist, double p1, double p2, double p3)
	{
		double[] arr = {
				p1, p2, p3
		};
		return within(dist,arr);
	}
	
	public static boolean allDiff(int[] num)
	{
		int i=0,j=0;
		for (i=0;i<num.length;i++)
		{
			for (j=0;j<num.length;j++)
			{
				if ((num[i]==num[j])&&(i!=j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static void doNothing()
	{
		System.currentTimeMillis();
	}
	
	public static double linkedFunction(double x)
	{
		double y=0;
		//function
		return y;
	}
}
