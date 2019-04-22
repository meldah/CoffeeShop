import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

public class MainPanel extends JFrame
{
	private GreetingPanel greeting;
	private ProductsPanel products;
	private CoffeePanel coffeePanel;
	private Cappuccino cappuccinoPanel;
	private SandwichesPanel sandwichesPanel;
	private PastryPanel pastryPanel;
	private ListPanel list;
	private ButtonPanel buttons;
	private CountPanel countPanel;
	//Price of the entire order.
	private Double totalPrice = 0.0;

	public MainPanel()
	{
		setResizable(true);
		//Sets up the panel.
		setTitle("Coffee Shop");
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creates all of the sub-panels.
		greeting = new GreetingPanel();
		products = new ProductsPanel();
		coffeePanel = new CoffeePanel();
		cappuccinoPanel = new Cappuccino(); 
		sandwichesPanel = new SandwichesPanel();
		pastryPanel = new PastryPanel();
		list = new ListPanel();
		countPanel = new CountPanel();
		buttons = new ButtonPanel();
		buttons.addItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttons.totalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		//Adds the subpanels to the main panel.
		getContentPane().add(greeting, BorderLayout.NORTH);
		getContentPane().add(products, BorderLayout.WEST);
		getContentPane().add(coffeePanel, BorderLayout.CENTER);
		getContentPane().add(cappuccinoPanel, BorderLayout.CENTER);
		getContentPane().add(list, BorderLayout.EAST);
		getContentPane().add(buttons, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		
		//Adds action listeners to the buttons on sub-panels.
		ProductsPanel.coffeeButton.addActionListener(new RadioButtonListener());
		ProductsPanel.cappuccinoButton.addActionListener(new RadioButtonListener());
		ProductsPanel.sandwichesButton.addActionListener(new RadioButtonListener());
		ProductsPanel.pastryButton.addActionListener(new RadioButtonListener());

		ButtonPanel.addItemButton.addActionListener(new AddButtonListener());
		ButtonPanel.totalButton.addActionListener(new TotalButtonListener());
		ButtonPanel.newOrderButton.addActionListener(new NewOrderButtonListener());
	}
	
	/**
	 * Removes everything from the center panel.
	 */
	public void removeCenterPanel()
	{
		remove(coffeePanel);
		remove(cappuccinoPanel);
		remove(sandwichesPanel);
		remove(pastryPanel);
		remove(countPanel);
	}
	
	/**
	 * Adds the coffee panel to the center panel.
	 */
	public void addCoffeePanel()
	{
		getContentPane().add(coffeePanel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	/**
	 * Adds the cappuccino panel to the center panel.
	 */
	public void addCappuccinoPanel()
	{
		getContentPane().add(cappuccinoPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	/**
	 * adds the bagel panel to the center panel.
	 */
	public void addBagelPanel()
	{
		getContentPane().add(sandwichesPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}

	/**
	 * adds the pastry panel to the center panel.
	 */
	public void addPastryPanel()
	{
		getContentPane().add(pastryPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	public void addCountPanel()
	{
		getContentPane().add(countPanel,BorderLayout.CENTER);
		validate();
		repaint();
	}

	/**
	 * Action Listener for switching the center panel.
	 *
	 */
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Checks which button is selected.
			if (ProductsPanel.coffeeButton.isSelected())
			{
				//Removes everything and adds the coffee panel.
				removeCenterPanel();
				addCoffeePanel();
			}
			else if (ProductsPanel.cappuccinoButton.isSelected())
			{
				//Removes everything and adds the cappuccino panel.
				removeCenterPanel();
				addCappuccinoPanel();
			}
			else if (ProductsPanel.sandwichesButton.isSelected())
			{
				//Removes everything and adds the bagel panel.
				removeCenterPanel();
				addBagelPanel();
			}
			else if (ProductsPanel.pastryButton.isSelected())
			{
				//Removes everything and adds the pastry panel.
				removeCenterPanel();
				addPastryPanel();
			}

		}
	}

	/**
	 * Action listener for adding the item to the order.
	 *
	 */
	private class AddButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Formats the final output into dollars.
			NumberFormat formatter = new DecimalFormat("#0.00");
			if(!(ProductsPanel.coffeeButton.isSelected()) && !(ProductsPanel.cappuccinoButton.isSelected()) && !(ProductsPanel.sandwichesButton.isSelected()) && !(ProductsPanel.pastryButton.isSelected()))
			{
				JOptionPane.showMessageDialog(null, "���� �������� �������!");
			}
			//Checks which button is selected.
			if (ProductsPanel.coffeeButton.isSelected())
			{
				String order = coffeePanel.getCoffeeTotalType();
				Double cost = coffeePanel.getCoffeeTotalCost();

				//System.out.println(order + " : " + cost);
				
				//Makes the final string to output.
				String totalOrder = order + " :" + (formatter.format(cost)).toString() + " ��.";

				totalPrice += cost;
				if(cost!=0.00 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���� �������� ��� ����!");
				}

			}
			else if (ProductsPanel.cappuccinoButton.isSelected())
			{
				String order = cappuccinoPanel.getCappuccinoTotalType();
				Double cost = cappuccinoPanel.getCappuccinoTotalCost();
				
				String totalOrder = order + " :" + (formatter.format(cost)).toString() + " ��.";
				totalPrice += cost;
				if(cost!=0.00 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���� �������� ��� ��������!");
				}
			}
			else if (ProductsPanel.sandwichesButton.isSelected())
			{
				String order = sandwichesPanel.getSandwichTotalType();
				Double cost = sandwichesPanel.getSandwichTotalCost();

				//System.out.println(order + " : " + cost);
				
				//Makes the final string to output.
				String totalOrder = order + " :" + (formatter.format(cost)).toString() + " ��.";

				totalPrice += cost;
				if(cost!=0 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���� �������� ��� �������!");
				}

			}
			else if (ProductsPanel.pastryButton.isSelected())
			{
				String order = pastryPanel.getPastryType();
				Double cost = pastryPanel.getPastryCost();

				//System.out.println(order + " : " + cost);
				
				//Makes the final string to output.
				String totalOrder = order + " :" + (formatter.format(cost)).toString() + " ��.";

				totalPrice += cost;
				if(cost!=0.00 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���� �������� ��� �������!");
				}

			}
		}
	}
	
	/**
	 * Action listener for displaying the final total.
	 *
	 */
	private class TotalButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Formats to dollars
			NumberFormat formatter = new DecimalFormat("#0.00");

			JOptionPane.showMessageDialog(null, "���� ����:" + formatter.format(totalPrice));
		}
	}

	/**
	 * Action listener for resetting the program to enter a new order.
	 *
	 */
	private class NewOrderButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			NewOrder();
			
		}
	}
	public void NewOrder()
	{
		list.listInfo.clear();
		list.orders.setListData(list.listInfo);
		
		//Updates the panel.
		list.scrollPanel.validate();
		list.scrollPanel.repaint();
		
		coffeePanel.size.sizeGroup.clearSelection();
		coffeePanel.type.typeGroup.clearSelection();
		
		cappuccinoPanel.type.typeGroup.clearSelection();
		cappuccinoPanel.flavor.bg.clearSelection();
		cappuccinoPanel.size.sizeGroup.clearSelection();
		
		sandwichesPanel.flavor.bg.clearSelection();
		
		products.bg.clearSelection();
		
		coffeePanel.extras.cream.setSelected(false);
		coffeePanel.extras.milk.setSelected(false);
		coffeePanel.extras.sugar.setSelected(false);
		
		sandwichesPanel.salads.russianSalad.setSelected(false);
		sandwichesPanel.salads.snezhankaSalad.setSelected(false);
		
		sandwichesPanel.products.creamCheese.setSelected(false);
		sandwichesPanel.products.ham.setSelected(false);
		sandwichesPanel.products.cucumbers.setSelected(false);
		sandwichesPanel.products.tomatoes.setSelected(false);
		sandwichesPanel.products.yellowCheese.setSelected(false);
		sandwichesPanel.products.olives.setSelected(false);
		sandwichesPanel.products.iceberg.setSelected(false);
		
		totalPrice=0.0;
	}
	/**
	 * Main method for starting the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		new MainPanel();
	}
}