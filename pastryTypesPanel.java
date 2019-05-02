import javax.swing.*;
public class pastryTypesPanel extends JPanel
{
	private JList pastryList;
	private String[] pastries = {"�����", "�������",
											"�������", "������", "����"};
	
	private final Double[] pastriesCost = {2.50, 2.50, 1.75, 2.00, 2.25};
	
	/**
	 * Constructor
	 */
	public pastryTypesPanel()
	{
		//Creates a list of pastries and fills it from the pastry array.
		pastryList = new JList(pastries);
		
		setBorder(BorderFactory.createTitledBorder("��������"));
		
		add(pastryList);
	}
	
	/**
	 * Allows access to which pastry is selected.
	 * @return Type
	 */
	public String getPastryType()
	{
		if(pastryList.getSelectedIndex() < 0)
		{
			String result = "";
			return result;
		}
		return (String) pastryList.getSelectedValue();
	}
	
	/**
	 * Allows access to the cost of each pastry.
	 * @return Cost
	 */
	public double getPastryCost()
	{
		if(pastryList.getSelectedIndex() < 0)
		{
			return 0.0;
		}
		int i = pastryList.getSelectedIndex();
		return pastriesCost[i];
	}
}
