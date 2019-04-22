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
		snezhankaSalad = new JCheckBox("��������");
		russianSalad = new JCheckBox("����� ������");
		
		setBorder(BorderFactory.createTitledBorder("������"));
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
			extras = "�������� � ����� ������";
		else if (snezhankaSalad.isSelected())
			extras = "��������";
		else if (russianSalad.isSelected())
			extras = "����� ������";
		
		return extras;
	}
}
