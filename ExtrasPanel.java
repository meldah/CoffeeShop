import java.awt.*;
import javax.swing.*;

/**
 * Panel to hold the coffee extras.
 *
 */
public class ExtrasPanel extends JPanel
{
	public JCheckBox cream;
	public JCheckBox sugar;
	public JCheckBox milk;
	
	private final Double sugarCost = 0.25;
	private final Double creamCost = 0.25;
	private final Double milkCost = 0.50;
	
	/**
	 * Constructor
	 */
	public ExtrasPanel()
	{
		cream = new JCheckBox("Сметана");
		sugar = new JCheckBox("Захар");
		milk = new JCheckBox("Мляко");
		
		
		setBorder(BorderFactory.createTitledBorder("Добавки"));
		setLayout(new GridLayout(3, 1));
		
		add(cream);
		add(sugar);
		add(milk);
		
	}
	
	/*
	 * Gives access to the cost of the extras added into the coffee.
	 */
	public Double getExtrasCost()
	{
		Double cost = 0.0;
		
		if (cream.isSelected())
			cost += creamCost;
		if (sugar.isSelected())
			cost += sugarCost;
		if(milk.isSelected())
			cost += milkCost;
		
		return cost;
	}
	
	/*
	 * Describes the extras added into the coffee.
	 */
	public String getExtras()
	{
		String extras = "";
		
		//Checks for which boxes are selected.
		if (cream.isSelected() && sugar.isSelected() && milk.isSelected())
			extras = "сметана + захар + мляко";
		else if (cream.isSelected() && sugar.isSelected())
			extras = "сметана + захар";
		else if (cream.isSelected() && milk.isSelected())
			extras = "сметана + мляко";
		else if (sugar.isSelected() && milk.isSelected())
			extras = "захар + мляко";
		else if (cream.isSelected())
			extras = "сметана";
		else if (sugar.isSelected())
			extras = "захар";
		else if (milk.isSelected())
			extras = "мляко";
		
		return extras;
	}
}
