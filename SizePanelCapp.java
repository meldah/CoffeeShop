import java.awt.*;
import javax.swing.*;

/**
 * Main panel for the sizes of coffee.
 *
 */
public class SizePanelCapp extends JPanel
{
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	public ButtonGroup sizeGroup;

	private final Double sCost = 1.75;
	private final Double mCost = 2.00;
	private final Double lCost = 3.25;
	
	/**
	 * Constructor
	 */
	public SizePanelCapp()
	{
		setLayout(new GridLayout(3, 1));
		
		small = new JRadioButton("Малко");
		medium = new JRadioButton("Средно");
		large = new JRadioButton("Голямо");
		sizeGroup = new ButtonGroup();
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);
		
		setBorder(BorderFactory.createTitledBorder("Размер"));
		
		add(small);
		add(medium);
		add(large);
	}
	
	/**
	 * Allows access to the size of coffee selected.
	 * @return Size
	 */
	public String getCoffeeSize()
	{
		String size = "";
		
		if (small.isSelected())
			size = "малко";
		else if (medium.isSelected())
			size = "средно";
		else if (large.isSelected())
			size = "голямо";
		else
		{
			size = "средно";
		}
		return size;	
	}
	
	/**
	 * Allows access to the price of the coffee selected.
	 * @return Cost
	 */
	public Double getSizeCost()
	{
		double cost = 0.0;
		
		if (small.isSelected())
			cost = sCost;
		else if (medium.isSelected())
			cost = mCost;
		else if (large.isSelected())
			cost = lCost;
		else
		{
			cost = mCost;
		}
		return cost;	
	}
}
