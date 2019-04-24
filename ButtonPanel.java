import java.awt.*;

import javax.swing.*;
public class ButtonPanel extends JPanel
{
	public static JButton addItemButton;
	public static JButton totalButton;
	public static JButton newOrderButton;
	public static JButton receipt;
	public ListPanel list;
	
	/**
	 * Constructor
	 */
	public ButtonPanel()
	{
		setLayout(new GridLayout(1,4));
		
		addItemButton = new JButton("Добави продукт");
		totalButton = new JButton("Общо");
		newOrderButton = new JButton("Нова поръчка");		
		receipt = new JButton("Касова бележка");
		
		
		add(addItemButton);
		add(totalButton);
		add(receipt);
		add(newOrderButton);
	}
}
