import java.awt.GridLayout;

import javax.swing.*;

/**
 * Main panel for the salads on a sandwiches.
 *
 */
public class SaladsPanel extends JPanel
{
	public JCheckBox snezhankaSalad;
	public JCheckBox russianSalad;
	
	private final Double snezhankaCost = 1.50;
	private final Double russianCost = 1.50;
	
	/**
	 * Constructor
	 */
	public SaladsPanel()
	{
		snezhankaSalad = new JCheckBox("Снежанка");
		russianSalad = new JCheckBox("Руска салата");
		
		setBorder(BorderFactory.createTitledBorder("Салати"));
		setLayout(new GridLayout(2, 1));
		
		add(snezhankaSalad);
		add(russianSalad);
	}
	
	/**
	 * Allows access to the cost of the salads selected..
	 * @return
	 */
	public Double getsCost()
	{
		Double cost = 0.0;
		
		if (snezhankaSalad.isSelected())
			cost += snezhankaCost;
		if (russianSalad.isSelected())
			cost += russianCost;
		
		return cost;
	}
	
	/**
	 * Allows access to the type of salads selected.
	 * @return
	 */
	public String getSalads()
	{
		String extras = "";
		
		if (snezhankaSalad.isSelected() && russianSalad.isSelected())
			extras = "Снежанка и руска салата";
		else if (snezhankaSalad.isSelected())
			extras = "Снежанка";
		else if (russianSalad.isSelected())
			extras = "Руска салата";
		
		return extras;
	}
}
