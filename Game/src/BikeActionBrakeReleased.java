import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Timer;


public class BikeActionBrakeReleased extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	
	public BikeActionBrakeReleased(Timer timer)
	{
		this.timer = timer;
	}
	public void actionPerformed(ActionEvent e) 
	{
		timer.stop();
	}

}
