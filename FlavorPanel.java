import java.awt.*;

import javax.swing.*;

/**
 * Panel for bagel flavors.
 * @author DrewOsborne
 *
 */
public class FlavorPanel extends JPanel
{
	private JRadioButton white;
	private JRadioButton wheat;
	private JRadioButton salt;
	private JRadioButton seseme;
	private JRadioButton popy;
	public ButtonGroup bg;
	
	//Final costs of each type of bagel.
	private final Double whiteCost = 0.75;
	private final Double wheatCost = 0.85;
	private final Double saltCost = 0.75;
	private final Double sesemeCost = 0.90;
	private final Double popyCost = 0.90;
	
	/**
	 * Constructor
	 */
	public FlavorPanel()
	{
		white = new JRadioButton("Бяла");
		wheat = new JRadioButton("Черна");
		salt = new JRadioButton("Бяла пълнозърнеста");
		seseme = new JRadioButton("Черна пълнозърнеста");
		popy = new JRadioButton("С лимец");
		
		
		bg = new ButtonGroup();
		
		bg.add(white);
		bg.add(wheat);
		bg.add(salt);
		bg.add(seseme);
		bg.add(popy);
		
		setBorder(BorderFactory.createTitledBorder("Питка"));
		setLayout(new GridLayout(5, 1));
		
		add(white);
		add(wheat);
		add(salt);
		add(seseme);
		add(popy);
	}
	
	/**
	 * Allows access to the type of bagel.
	 * @return Type
	 */
	public String getBagelType()
	{
		String type = "";
		
		//Determines which bagel is selected.
		if (white.isSelected())
			type = "бяла питка";
		else if (wheat.isSelected())
			type = "пшеничена питка";
		else if (salt.isSelected())
			type = "солена питка";
		else if (seseme.isSelected())
			type = "сусамена питка";
		else if (popy.isSelected())
			type = "черна питка";
		
		return type;	
	}
	
	/**
	 * Allows acess to the cost of each type of bagel.
	 * @return Cost
	 */
	public Double getBagelCost()
	{
		Double cost = 0.0;
		
		//Determines which bagel is selected.
		if (white.isSelected())
			cost = whiteCost;
		else if (wheat.isSelected())
			cost = wheatCost;
		else if (salt.isSelected())
			cost = saltCost;
		else if (seseme.isSelected())
			cost = sesemeCost;
		else if (popy.isSelected())
			cost = popyCost;
		
		return cost;
	}
}
