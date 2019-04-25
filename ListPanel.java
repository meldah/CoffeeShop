import java.util.*;

import javax.swing.*;

/**
 * Panel for the list of items added to the order.
 *
 */
public class ListPanel extends JPanel
{
	public JScrollPane scrollPanel;
	public JList<String> orders;
	public Vector<String> listInfo;
	
	/**
	 * Constructor
	 */
	public ListPanel()
	{
		//Vector to hold the items to add.
		listInfo = new Vector<String>();
		
		//Creates the list.
		orders = new JList<String>(listInfo);
		orders.setVisibleRowCount(50);
		scrollPanel = new JScrollPane(orders);
		add(scrollPanel);
	}
	
	/**
	 * Adds an item to the list of items.
	 * @param order Item to add.
	 */
	public void addToList(String order)
	{
		listInfo.addElement(order);
		orders.setListData(listInfo);
		
		//Updates the panel.
		scrollPanel.validate();
		scrollPanel.repaint();
	}
}
