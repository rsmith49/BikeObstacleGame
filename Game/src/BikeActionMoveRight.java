import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class BikeActionMoveRight extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private Bicycle bike;
	
	public BikeActionMoveRight(Bicycle bike)
	{
		this.bike = bike;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		bike.moveRight();
	}
}
