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
		cream = new JCheckBox("�������");
		sugar = new JCheckBox("�����");
		milk = new JCheckBox("�����");
		
		
		setBorder(BorderFactory.createTitledBorder("�������"));
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
			extras = "������� + ����� + �����";
		else if (cream.isSelected() && sugar.isSelected())
			extras = "������� + �����";
		else if (cream.isSelected() && milk.isSelected())
			extras = "������� + �����";
		else if (sugar.isSelected() && milk.isSelected())
			extras = "����� + �����";
		else if (cream.isSelected())
			extras = "�������";
		else if (sugar.isSelected())
			extras = "�����";
		else if (milk.isSelected())
			extras = "�����";
		
		return extras;
	}
}
