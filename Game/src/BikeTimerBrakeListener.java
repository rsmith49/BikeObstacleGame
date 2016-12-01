import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BikeTimerBrakeListener implements ActionListener {

	private Bicycle bike;
	private long delay;
	
	public BikeTimerBrakeListener(Bicycle bike, long delay)
	{
		this.bike = bike;
		this.delay = delay;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		bike.brake(delay);
	}
}
