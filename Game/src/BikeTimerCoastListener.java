import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BikeTimerCoastListener implements ActionListener {

	private Bicycle bike;
	private long delay;
	
	public BikeTimerCoastListener(Bicycle bike, long delay)
	{
		this.bike = bike;
		this.delay = delay;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		bike.coast(delay);
	}

}
