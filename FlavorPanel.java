import java.awt.*;

import javax.swing.*;
public class FlavorPanel extends JPanel
{
	private JRadioButton white;
	private JRadioButton seseme;
	private JRadioButton whiteW;
	private JRadioButton cherna;
	private JRadioButton popy;
	public ButtonGroup bg;
	
	//Final costs of each type of bagel.
	private final Double whiteCost = 0.75;
	private final Double sesemeCost = 0.85;
	private final Double saltCost = 0.75;
	private final Double chernaCost = 0.90;
	private final Double popyCost = 0.90;
	
	/**
	 * Constructor
	 */
	public FlavorPanel()
	{
		white = new JRadioButton("���� (�� ������������)");
		seseme = new JRadioButton("���� ��� �����");
		whiteW = new JRadioButton("���� �������������");
		cherna = new JRadioButton("����� �������������");
		popy = new JRadioButton("� �����");
		
		
		bg = new ButtonGroup();
		
		bg.add(white);
		bg.add(seseme);
		bg.add(whiteW);
		bg.add(cherna);
		bg.add(popy);
		
		setBorder(BorderFactory.createTitledBorder("�����"));
		setLayout(new GridLayout(5, 1));
		
		add(white);
		add(seseme);
		add(whiteW);
		add(cherna);
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
			type = "���� �����";
		else if (seseme.isSelected())
			type = "���� ����� ��� �����";
		else if (whiteW.isSelected())
			type = "���� ������������� �����";
		else if (cherna.isSelected())
			type = "����� ������������� �����";
		else if (popy.isSelected())
			type = "����� � �����";
		else
		{
			type = "���� �����";
		}
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
		else if (seseme.isSelected())
			cost = sesemeCost;
		else if (whiteW.isSelected())
			cost = saltCost;
		else if (cherna.isSelected())
			cost = chernaCost;
		else if (popy.isSelected())
			cost = popyCost;
		else
		{
			cost = whiteCost;
		}
		return cost;
	}
}
