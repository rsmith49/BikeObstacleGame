import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class BikeActionMoveLeft extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private Bicycle bike;
	
	public BikeActionMoveLeft(Bicycle bike)
	{
		this.bike = bike;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		bike.moveLeft();
	}

}
