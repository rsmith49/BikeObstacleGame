import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BikeTimerPedalListener implements ActionListener {

	private Bicycle bike;
	private long delay;
	
	public BikeTimerPedalListener(Bicycle bike, long delay)
	{
		this.bike = bike;
		this.delay = delay;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		bike.pedal(delay);
	}

}
