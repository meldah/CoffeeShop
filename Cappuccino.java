import  java.awt.GridLayout;

import javax.swing.*;

public class Cappuccino extends JPanel 
{
	public SizePanelCapp size;
	public TypeCappPanel type;
	public CappuccinoFlavor flavor;
	
	public Cappuccino()
	{
		setLayout(new GridLayout(3, 1));
		size = new SizePanelCapp();
		type = new TypeCappPanel();
		flavor = new CappuccinoFlavor();
		
		add(size);
		add(type);
		add(flavor);
	}
	
	public Double getCappuccinoTotalCost()
	{
		double sizeCost = size.getSizeCost();
		double extrasCost = flavor.getCappuccinoCost();
		double coffeeCost = sizeCost + extrasCost;
		
		return coffeeCost;
	}
	
	public String getCappuccinoTotalType()
	{
		String sizeString = size.getCoffeeSize();
		String coffeeString = type.getCoffeeType();
		String extrasString = flavor.getCappuccinoType();
		
		return "Капучино: " + sizeString + ", " + coffeeString + " / " + extrasString;
	}
}
