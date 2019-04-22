import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Main panel to hold the buttons.
 * @author DrewOsborne
 *
 */
public class ButtonPanel extends JPanel
{
	public static JButton addItemButton;
	public static JButton totalButton;
	public static JButton newOrderButton;
	public ListPanel list;
	
	/**
	 * Constructor
	 */
	public ButtonPanel()
	{
		setLayout(new GridLayout(1,3));
		
		addItemButton = new JButton("Добави продукт");
		totalButton = new JButton("Общо");
		newOrderButton = new JButton("Нова поръчка");
		
		add(addItemButton);
		add(totalButton);
		add(newOrderButton);
	}
}
