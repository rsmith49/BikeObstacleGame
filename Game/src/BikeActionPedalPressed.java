import java.awt.event.ActionEvent;

import javax.swing.Timer;
import javax.swing.AbstractAction;


public class BikeActionPedalPressed extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private Timer timer;
	
	public BikeActionPedalPressed(Timer timer)
	{
		this.timer = timer;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		timer.start();
	}
}
