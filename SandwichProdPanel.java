import java.awt.*;
import javax.swing.*;

/**
 * Main panel for the spreads on a bagel.
 *
 */
public class SandwichProdPanel extends JPanel
{
	public JCheckBox creamCheese;
	public JCheckBox yellowCheese;
	public JCheckBox ham;
	public JCheckBox tomatoes;
	public JCheckBox cucumbers;
	public JCheckBox iceberg;
	public JCheckBox olives;

	
	private final Double creamCheeseCost = 0.30;
	private final Double yellowCheeseCost = 0.50;
	private final Double hamCost = 1.00;
	private final Double tomatoesCost = 0.40;
	private final Double cucumberCost = 0.40;
	private final Double icebergCost = 0.40;
	private final Double olivesCost = 0.30; 
	
	/**
	 * Constructor
	 */
	public SandwichProdPanel()
	{
		creamCheese = new JCheckBox(" рема сирене");
		yellowCheese = new JCheckBox(" ашкавал");
		ham = new JCheckBox("Ўунка");
		tomatoes = new JCheckBox("ƒомати");
		cucumbers = new JCheckBox(" раставици");
		iceberg = new JCheckBox("јйсберг");
		olives = new JCheckBox("ћаслини");
		
		
		setBorder(BorderFactory.createTitledBorder("ƒобавки"));
		setLayout(new GridLayout(7, 1));
		
		add(creamCheese);
		add(yellowCheese);
		add(ham);
		add(tomatoes);
		add(cucumbers);
		add(iceberg);
		add(olives);
	}
	
	/**
	 * Allows access to which type of spread is selected.
	 * @return Type
	 */
	public String getSpreadType()
	{
		String type = "";
		
		if (creamCheese.isSelected())
			type += "крема сирене, ";
		if (yellowCheese.isSelected())
			type += "кашкавал, ";
		if (ham.isSelected())
			type += "шунка, ";
		if (tomatoes.isSelected())
			type += "домати, ";
		if (cucumbers.isSelected())
			type += "краставици, ";
		if (iceberg.isSelected())
			type += "айсберг, ";
		if (olives.isSelected())
			type += "маслини, ";
		/*
		else if (creamCheese.isSelected() && yellowCheese.isSelected())
			type = "крема сирене и кашкавал";
		else if (creamCheese.isSelected() && ham.isSelected())
			type = "крема сирене и шунка";
		else if (creamCheese.isSelected() && tomatoes.isSelected())
			type = "крема сирене и домати";
		else if (creamCheese.isSelected() && cucumbers.isSelected())
			type = "крема сирене и краставици";
		else if (creamCheese.isSelected() && iceberg.isSelected())
			type = "крема сирене и айсберг";
		else if (creamCheese.isSelected() && olives.isSelected())
			type = "крема сирене и маслини";
		
		else if (yellowCheese.isSelected() && ham.isSelected())
			type = "кашкавал и шунка";
		else if (yellowCheese.isSelected() && tomatoes.isSelected())
			type = "кашкавал и домати";
		else if (yellowCheese.isSelected() && cucumbers.isSelected())
			type = "кашкавал и краставици";
		else if (yellowCheese.isSelected() && iceberg.isSelected())
			type = "кашкавал и айсберг";
		else if (yellowCheese.isSelected() && olives.isSelected())
			type = "кашкавал и маслини";
		
		else if (ham.isSelected() && tomatoes.isSelected())
			type = "шунка и домати";
		else if (ham.isSelected() && cucumbers.isSelected())
			type = "шунка и краставици";
		else if (ham.isSelected() && iceberg.isSelected())
			type = "шунка и айсберг";
		else if (ham.isSelected() && olives.isSelected())
			type = "шунка и маслини";
		
		else if (tomatoes.isSelected() && cucumbers.isSelected() )
			type = "домати и краставици";
		else if (tomatoes.isSelected() && iceberg.isSelected())
			type = "домати и айсберг";
		else if (tomatoes.isSelected() && olives.isSelected())
			type = "домати и маслини";
		
		else if (cucumbers.isSelected() && iceberg.isSelected())
			type = "краставици и айсберг";
		else if (cucumbers.isSelected() && olives.isSelected())
			type = "краставици и маслини";
		
		else if(olives.isSelected() && iceberg.isSelected())
			type = "айсберг и маслини";
		//
		
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "крема сирене, кашкавал и шунка";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "крема сирене, кашкавал и шунка";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "крема сирене, кашкавал и шунка";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "крема сирене, кашкавал и шунка";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "крема сирене, кашкавал и шунка";
		//
		*/
		int len=type.length();
		if(type.charAt(len-2)==',')
		{
			type = type.substring(0, len-2);
		}
		return type;
	}
	
	/**
	 * Allows access to the cost of the spread selected.
	 * @return Cost
	 */
	public Double getSpreadCost()
	{
		Double cost = 0.0;
		
		if (creamCheese.isSelected())
			cost += creamCheeseCost;
		if (yellowCheese.isSelected())
			cost += yellowCheeseCost;
		if (ham.isSelected())
			cost += hamCost;
		if (tomatoes.isSelected())
			cost += tomatoesCost;
		if (cucumbers.isSelected())
			cost += cucumberCost;
		if (iceberg.isSelected())
			cost += icebergCost;
		if (olives.isSelected())
			cost += olivesCost;
		
		return cost;
	}
}
