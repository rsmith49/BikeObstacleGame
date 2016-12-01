import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class TestNumbers {

	private Bicycle bike;
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField speed = new JTextField("0.00");
	private JTextField position = new JTextField("0.00");
	private JTextField lane = new JTextField("1");
	private JTextField wheels = new JTextField("2");
	private JTextField gameOver = new JTextField("False");
	private TimerListener timerListener;
	private Timer scribe;
	private Timer brakeTimer;
	private Timer pedalTimer;
	private Timer coastListener;
	
	public TestNumbers(Bicycle bike)
	{
		this.bike = bike;
		timerListener = new TimerListener(speed, position, lane, wheels, gameOver, bike);
		scribe = new Timer(100,timerListener);		
		brakeTimer = new Timer(100,new BikeTimerBrakeListener(bike,100));
		pedalTimer = new Timer(100,new BikeTimerPedalListener(bike,100));
		coastListener = new Timer(100,new BikeTimerCoastListener(bike,100));

	}
	
	public void run() 
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		speed.setColumns(15);
		position.setColumns(15);
		lane.setColumns(1);
		wheels.setColumns(2);
		gameOver.setColumns(5);
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("W"), "pedalPressedAction");
		panel.getInputMap().put(KeyStroke.getKeyStroke("S"), "brakePressedAction");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released W"), "pedalReleasedAction");
		panel.getInputMap().put(KeyStroke.getKeyStroke("released S"), "brakeReleasedAction");
		panel.getInputMap().put(KeyStroke.getKeyStroke("typed a"), "leftAction");
		panel.getInputMap().put(KeyStroke.getKeyStroke("typed d"), "rightAction");
		panel.getInputMap().put(KeyStroke.getKeyStroke("typed c"), "crashAction");

		panel.getActionMap().put("pedalPressedAction", new BikeActionPedalPressed(pedalTimer));
		panel.getActionMap().put("pedalReleasedAction", new BikeActionPedalReleased(pedalTimer));
		panel.getActionMap().put("brakePressedAction", new BikeActionBrakePressed(brakeTimer));
		panel.getActionMap().put("brakeReleasedAction", new BikeActionBrakeReleased(brakeTimer));
		panel.getActionMap().put("leftAction", new BikeActionMoveLeft(bike));
		panel.getActionMap().put("rightAction", new BikeActionMoveRight(bike));
		panel.getActionMap().put("crashAction", new BikeActionCrash(bike));
		
		panel.add(speed);
		panel.add(position);
		panel.add(lane);
		panel.add(wheels);
		panel.add(gameOver);
		
		speed.getInputMap().put(KeyStroke.getKeyStroke("pressed w"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("typed w"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("released w"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("pressed s"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("typed s"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("released s"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("typed a"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("typed d"),"none");
		speed.getInputMap().put(KeyStroke.getKeyStroke("typed c"),"none");
		
		position.getInputMap().put(KeyStroke.getKeyStroke("pressed w"),"none");
		position.getInputMap().put(KeyStroke.getKeyStroke("released w"),"none");
		position.getInputMap().put(KeyStroke.getKeyStroke("pressed s"),"none");
		position.getInputMap().put(KeyStroke.getKeyStroke("released s"),"none");
		position.getInputMap().put(KeyStroke.getKeyStroke("typed a"),"none");
		position.getInputMap().put(KeyStroke.getKeyStroke("typed d"),"none");
		position.getInputMap().put(KeyStroke.getKeyStroke("typed c"),"none");
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		
		scribe.start();
		coastListener.start();
	}
	
	public void stop()
	{
		scribe.stop();
		coastListener.stop();
		frame.setVisible(false);
	}
	
	class TimerListener implements ActionListener
	{
		private JTextField speed;
		private JTextField position;
		private JTextField lane;
		private JTextField wheels;
		private JTextField go;
		private Bicycle bike;
		
		public TimerListener(JTextField spd, JTextField pos, JTextField lane, JTextField wheels, JTextField gameOver, Bicycle bike)
		{
			speed = spd;
			position = pos;
			this.lane = lane;
			this.wheels = wheels;
			go = gameOver;
			this.bike = bike;
		}

		public void actionPerformed(ActionEvent e) 
		{
			speed.setText(bike.getSpeed()+"");
			position.setText(bike.getPos()+"");
			lane.setText(bike.getLane()+"");
			wheels.setText(bike.getWheels()+"");
			go.setText(bike.gameOver()+"");
		}
		
		
	}

}
