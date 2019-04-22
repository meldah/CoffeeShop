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
		creamCheese = new JCheckBox("����� ������");
		yellowCheese = new JCheckBox("��������");
		ham = new JCheckBox("�����");
		tomatoes = new JCheckBox("������");
		cucumbers = new JCheckBox("����������");
		iceberg = new JCheckBox("�������");
		olives = new JCheckBox("�������");
		
		
		setBorder(BorderFactory.createTitledBorder("�������"));
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
			type += "����� ������, ";
		if (yellowCheese.isSelected())
			type += "��������, ";
		if (ham.isSelected())
			type += "�����, ";
		if (tomatoes.isSelected())
			type += "������, ";
		if (cucumbers.isSelected())
			type += "����������, ";
		if (iceberg.isSelected())
			type += "�������, ";
		if (olives.isSelected())
			type += "�������, ";
		/*
		else if (creamCheese.isSelected() && yellowCheese.isSelected())
			type = "����� ������ � ��������";
		else if (creamCheese.isSelected() && ham.isSelected())
			type = "����� ������ � �����";
		else if (creamCheese.isSelected() && tomatoes.isSelected())
			type = "����� ������ � ������";
		else if (creamCheese.isSelected() && cucumbers.isSelected())
			type = "����� ������ � ����������";
		else if (creamCheese.isSelected() && iceberg.isSelected())
			type = "����� ������ � �������";
		else if (creamCheese.isSelected() && olives.isSelected())
			type = "����� ������ � �������";
		
		else if (yellowCheese.isSelected() && ham.isSelected())
			type = "�������� � �����";
		else if (yellowCheese.isSelected() && tomatoes.isSelected())
			type = "�������� � ������";
		else if (yellowCheese.isSelected() && cucumbers.isSelected())
			type = "�������� � ����������";
		else if (yellowCheese.isSelected() && iceberg.isSelected())
			type = "�������� � �������";
		else if (yellowCheese.isSelected() && olives.isSelected())
			type = "�������� � �������";
		
		else if (ham.isSelected() && tomatoes.isSelected())
			type = "����� � ������";
		else if (ham.isSelected() && cucumbers.isSelected())
			type = "����� � ����������";
		else if (ham.isSelected() && iceberg.isSelected())
			type = "����� � �������";
		else if (ham.isSelected() && olives.isSelected())
			type = "����� � �������";
		
		else if (tomatoes.isSelected() && cucumbers.isSelected() )
			type = "������ � ����������";
		else if (tomatoes.isSelected() && iceberg.isSelected())
			type = "������ � �������";
		else if (tomatoes.isSelected() && olives.isSelected())
			type = "������ � �������";
		
		else if (cucumbers.isSelected() && iceberg.isSelected())
			type = "���������� � �������";
		else if (cucumbers.isSelected() && olives.isSelected())
			type = "���������� � �������";
		
		else if(olives.isSelected() && iceberg.isSelected())
			type = "������� � �������";
		//
		
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "����� ������, �������� � �����";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "����� ������, �������� � �����";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "����� ������, �������� � �����";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "����� ������, �������� � �����";
		else if (creamCheese.isSelected() && yellowCheese.isSelected() && ham.isSelected())
			type = "����� ������, �������� � �����";
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
