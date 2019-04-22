import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CountPanel extends JPanel
{
	public static JSpinner count;
	public ListPanel list;
	
	/**
	 * Constructor
	 */
	public CountPanel()
	{
		setLayout(new GridLayout(1,1));
		
		count = new JSpinner();
		count.setModel(new SpinnerNumberModel(0, 0, 10, 1));

		
		add(count);

	}
}
