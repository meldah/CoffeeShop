import java.awt.*;

import javax.swing.*;
public class ClearPanel extends JPanel
{
	public static JButton clearItemButton;
	public ListPanel list;
	
	/**
	 * Constructor
	 */
	public ClearPanel()
	{
		setLayout(new GridLayout(1,1));
		
		clearItemButton = new JButton("Изчисти запис");
		
		add(clearItemButton);
	}
}
