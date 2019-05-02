import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	private ClearPanel clearBtn;
	private CountPanel countPanel;
	//Price of the entire order.
	private Double totalPrice = 0.0;
	private int countOrd = 1;
	JPanel p1 = new JPanel();
	public MainPanel()
	{
		setResizable(true);
		setTitle("Coffee Shop");
		
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
		clearBtn = new ClearPanel();
		buttons.addItemButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		buttons.totalButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		buttons.receipt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			}
		});
		clearBtn.clearItemButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		countPanel.count.addChangeListener(new ChangeListener() 
		{
			
			@Override
			public void stateChanged(ChangeEvent e) 
			{

				countOrd = (Integer) CountPanel.count.getValue();
				
			}
		});
		
		Container cont = getContentPane();
        p1.setLayout(new BorderLayout());
        p1.add(greeting, BorderLayout.NORTH);
		p1.add(products, BorderLayout.WEST);
		p1.add(coffeePanel, BorderLayout.CENTER);
		p1.add(cappuccinoPanel, BorderLayout.CENTER);
		p1.add(list, BorderLayout.EAST);
		
	    p1.setPreferredSize( new Dimension(1000, 900));
	    
		JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout());
        p2.add(countPanel);
        
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1));
        p3.add(buttons);
        
        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(1,1));
        p4.add(clearBtn);

        cont.setLayout(new BorderLayout());
        cont.add(p1, BorderLayout.NORTH);
        cont.add(p2, BorderLayout.CENTER);
        cont.add(p3, BorderLayout.SOUTH);
        cont.add(p4, BorderLayout.EAST);
        
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
		ButtonPanel.receipt.addActionListener(new GetTheReceipt());
		
		ClearPanel.clearItemButton.addActionListener(new ClearItem());
	}
	
	
	/**
	 * Removes everything from the center panel.
	 */
	
	public void removeCenterPanel()
	{
		p1.remove(coffeePanel);
		p1.remove(cappuccinoPanel);
		p1.remove(sandwichesPanel);
		p1.remove(pastryPanel);
		p1.remove(countPanel);
	}
	
	/**
	 * Adds the coffee panel to the center panel.
	 */
	public void addCoffeePanel()
	{
		p1.add(coffeePanel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	/**
	 * Adds the cappuccino panel to the center panel.
	 */
	public void addCappuccinoPanel()
	{
		p1.add(cappuccinoPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	/**
	 * adds the bagel panel to the center panel.
	 */
	public void addBagelPanel()
	{
		p1.add(sandwichesPanel, BorderLayout.CENTER);
		validate();
		repaint();
	}

	/**
	 * adds the pastry panel to the center panel.
	 */
	public void addPastryPanel()
	{
		p1.add(pastryPanel, BorderLayout.CENTER);
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
				JOptionPane.showMessageDialog(null, "Моля изберете продукт!");
			}
			//Checks which button is selected.
			if (ProductsPanel.coffeeButton.isSelected())
			{
				String order = coffeePanel.getCoffeeTotalType();
				Double cost = coffeePanel.getCoffeeTotalCost();
				if(countOrd > 1)
				{
					cost = countOrd * cost;
				}
				//Makes the final string to output.
				String totalOrder = countOrd + "X" + order + " :" + (formatter.format(cost)).toString() + " лв.";
				totalPrice += cost;
				if(cost!=0.00 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
					//
					CountPanel.count.setModel(new SpinnerNumberModel(1, 0, 10, 1));
					countOrd = 1;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Моля изберете вид кафе!");
				}

			}
			else if (ProductsPanel.cappuccinoButton.isSelected())
			{
				String order = cappuccinoPanel.getCappuccinoTotalType();
				Double cost = cappuccinoPanel.getCappuccinoTotalCost();
				if(countOrd > 1)
				{
					cost = countOrd * cost;
				}
				String totalOrder =countOrd + "X" + order + " :" + (formatter.format(cost)).toString() + " лв.";
				totalPrice += cost;
				if(cost!=0.00 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
					//
					CountPanel.count.setModel(new SpinnerNumberModel(1, 0, 10, 1));
					countOrd = 1;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Моля изберете вид капучино!");
				}
			}
			else if (ProductsPanel.sandwichesButton.isSelected())
			{
				String order = sandwichesPanel.getSandwichTotalType();
				Double cost = sandwichesPanel.getSandwichTotalCost();
				if(countOrd > 1)
				{
					cost = countOrd * cost;
				}
				
				//Makes the final string to output.
				String totalOrder =countOrd + "X" + order + " :" + (formatter.format(cost)).toString() + " лв.";
				
				totalPrice += cost;
				if(cost!=0 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
					//
					CountPanel.count.setModel(new SpinnerNumberModel(1, 0, 10, 1));
					countOrd = 1;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Моля изберете вид сандвич!");
				}

			}
			else if (ProductsPanel.pastryButton.isSelected())
			{
				String order = pastryPanel.getPastryType();
				Double cost = pastryPanel.getPastryCost();
				if(countOrd > 1)
				{
					cost = countOrd * cost;
				}		
				//Makes the final string to output.
				String totalOrder =countOrd + "X" + order + " :" + (formatter.format(cost)).toString() + " лв.";

				totalPrice += cost;
				if(cost!=0.00 && order!="")
				{
					list.addToList(totalOrder);
					//
					list.invalidate();
					list.repaint();
					//
					CountPanel.count.setModel(new SpinnerNumberModel(1, 0, 10, 1));
					countOrd = 1;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Моля изберете вид сладкиш!");
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

			JOptionPane.showMessageDialog(null, "Обща сума:" + formatter.format(totalPrice));
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
		countOrd=1;
	}
	
	private class GetTheReceipt implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			try 
			{
				String fileName = NewReceipt();
				JOptionPane.showMessageDialog(null, "Касовата бележка е готова- " + fileName + "!");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		}
	}
	
	public String NewReceipt() throws IOException
	{
		String pattern = "MM-dd-yyyy HH:mm:ss";
		pattern = pattern.replaceAll("\\s","");
		pattern = pattern.replaceAll("-", "");
		pattern = pattern.replaceAll(":", "");
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(today);
		String fileName = "receipt"+ todayAsString + ".txt";
		//make directory
		String dir = System.getProperty("user.dir") + "\\Receipts\\";
		try 
		{
			new File(dir).mkdir();
		} 
		catch(SecurityException se) 
		{
			se.printStackTrace();
		}	
		dir += fileName;
		File file = new File(dir);			
			
		File recFile = new File(dir);
		if(!recFile.exists()) 
		{
			try 
			{
				new File(dir).createNewFile();
			} 
			catch(IOException ioe) 
			{
				ioe.printStackTrace();
			}
		} 
			
		PrintWriter printWriter = new PrintWriter(file);
						
		for(int i = 0; i < list.listInfo.size(); i++ )
		{
			String line = list.listInfo.get(i);
			printWriter.println (line);				
		}
		printWriter.println("Обща сума: " + totalPrice.toString());
		if(printWriter != null) 
		{
			printWriter.close();
		}
		
		return fileName;
	}
	private class ClearItem implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int clrInd = list.orders.getSelectedIndex();
			if(clrInd == -1)
			{
				JOptionPane.showMessageDialog(null, "Изберете продукт за премахване от списъка!", "Грешка", JOptionPane.ERROR_MESSAGE);
			}
			//remove deleted item's price from the total price
			String line = list.listInfo.get(clrInd);
			int first = line.lastIndexOf(":");
			int last = line.indexOf(' ', first);
			String costStr = line.substring(first+1, last);
			double result = Double.parseDouble(costStr.replaceAll(",", "."));
			totalPrice -= result;
			//remove deleted item from the list
			list.listInfo.remove(clrInd);
			list.orders.setListData(list.listInfo);
			//
			list.invalidate();
			list.repaint();
			//
			
		}
		
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
