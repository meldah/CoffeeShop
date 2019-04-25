import java.awt.*;
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
		setLayout(new GridLayout(1,2));
		
		JLabel lblcount = new JLabel("Брой");
		lblcount.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblcount);
		
		count = new JSpinner();
		count.setModel(new SpinnerNumberModel(1, 0, 10, 1));
		Dimension d = count.getPreferredSize();
		d.width = 20;
        count.setPreferredSize(new Dimension(20, 20));
        count.setSize(d);
		add(count);
	}
}
