import javax.swing.*;

/**
 * Greeting for the ordering system.
 * @author DrewOsborne
 *
 */
public class GreetingPanel extends JPanel
{
	private JLabel greetingLabel;
	
	/**
	 * Constructor
	 */
	public GreetingPanel()
	{
		greetingLabel = new JLabel("Wake Up Cafe \nCoffee Shop");
		add(greetingLabel);
	}
}
