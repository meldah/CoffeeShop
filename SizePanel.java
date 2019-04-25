import java.awt.*;
import javax.swing.*;

/**
 * Main panel for the sizes of coffee.
 *
 */
public class SizePanel extends JPanel
{
	private JRadioButton small;
	private JRadioButton medium;
	private JRadioButton large;
	public ButtonGroup sizeGroup;

	private final Double sCost = 0.75;
	private final Double mCost = 1.00;
	private final Double lCost = 1.25;
	
	/**
	 * Constructor
	 */
	public SizePanel()
	{
		setLayout(new GridLayout(3, 1));
		
		small = new JRadioButton("����");
		medium = new JRadioButton("��������");
		large = new JRadioButton("�����");
		sizeGroup = new ButtonGroup();
		sizeGroup.add(small);
		sizeGroup.add(medium);
		sizeGroup.add(large);
		
		setBorder(BorderFactory.createTitledBorder("������"));
		
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
			size = "����";
		else if (medium.isSelected())
			size = "��������";
		else if (large.isSelected())
			size = "�����";
		else
		{
			JOptionPane.showMessageDialog(null, "���� �������� ������ �� ��������!");
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
		
		return cost;	
	}
}
