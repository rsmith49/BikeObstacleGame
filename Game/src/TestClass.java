
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TestClass {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("Start/Stop");
		JButton button2 = new JButton("Restart");
		JTextField time = new JTextField("0:00");
		TimerListener timerListener = new TimerListener(time);
		Timer timer = new Timer(10,timerListener);
		ButtonListener buttonListener = new ButtonListener(timer);
		ButtonListener2 buttonListener2 = new ButtonListener2(timerListener, timer, buttonListener, time);
		button.addActionListener(buttonListener);
		button2.addActionListener(buttonListener2);
		frame.getContentPane().add(panel);
		panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("typed a"), "keyAction");
		panel.getActionMap().put("keyAction", new KeyAction(timerListener, timer, buttonListener, time));
		button.getInputMap().put(KeyStroke.getKeyStroke("typed a"), "none");
		button2.getInputMap().put(KeyStroke.getKeyStroke("typed a"), "none");
		time.getInputMap().put(KeyStroke.getKeyStroke("typed a"), "none");
		panel.add(button);
		panel.add(time);
		panel.add(button2);
		frame.pack();

		frame.setVisible(true);
	}
	
	static class TimerListener implements ActionListener
	{
		private JTextField clock;
		private long timeCounter=0;
		
		public TimerListener(JTextField clock)
		{
			this.clock = clock;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			timeCounter = timeCounter + 10;
			long d = timeCounter;
			String string;
			if (d<1000)
			{
				string = "0:"+d/10;
			}
			else
			{
				string = d/1000+":"+(d%1000)/10;
			}
			clock.setText(string);
		}
		
		public void resetTimeCounter()
		{
			timeCounter = 0;
		}
	}
	static class ButtonListener implements ActionListener
	{
		private Timer timer;
		private boolean running=false;
		
		public ButtonListener(Timer timer)
		{
			this.timer = timer;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			if (running)
			{
				timer.stop();
				running = false;
			}
			else
			{
				timer.start();
				running = true;
			}
		}
		
		public void setRunning(boolean running)
		{
			this.running = running;
		}
	}
	static class ButtonListener2 implements ActionListener
	{
		private TimerListener timerListener;
		private Timer timer;
		private ButtonListener buttonListener;
		private JTextField time;
		
		public ButtonListener2(TimerListener tl,Timer timer,ButtonListener bl,JTextField clock)
		{
			timerListener = tl;
			this.timer = timer;
			buttonListener = bl;
			time = clock;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			timer.stop();
			timerListener.resetTimeCounter();
			buttonListener.setRunning(false);
			time.setText("0:00");
		}
	}
	
	static class KeyAction extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private TimerListener timerListener;
		private Timer timer;
		private ButtonListener buttonListener;
		private JTextField time;
		
		public KeyAction(TimerListener tl,Timer timer,ButtonListener bl,JTextField clock)
		{
			timerListener = tl;
			this.timer = timer;
			buttonListener = bl;
			time = clock;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			timer.stop();
			timerListener.resetTimeCounter();
			buttonListener.setRunning(false);
			time.setText("0:00");
		}
	}
}
