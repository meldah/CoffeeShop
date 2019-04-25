import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;

public class CappuccinoFlavor extends JPanel {

	/**
	 * Create the panel.
	 */

	private JRadioButton cinnamon;
	private JRadioButton hazelnut;
	private JRadioButton chocolate;
	private JRadioButton cocunut;
	public ButtonGroup bg;
	
	//Final costs of each type of bagel.
	private final Double cinnamonCost = 0.75;
	private final Double hazelnutCost = 0.85;
	private final Double chocolateCost = 0.75;
	private final Double cocunutCost = 0.90;
	
	/**
	 * Constructor
	 */
	public CappuccinoFlavor()
	{
		cinnamon = new JRadioButton("Канела");
		hazelnut = new JRadioButton("Лешник");
		chocolate = new JRadioButton("Шоколад");
		cocunut = new JRadioButton("Кокос");
		
		bg = new ButtonGroup();
		
		bg.add(cinnamon);
		bg.add(hazelnut);
		bg.add(chocolate);
		bg.add(cocunut);
		
		setBorder(BorderFactory.createTitledBorder("С вкус"));
		setLayout(new GridLayout(4, 1));
		
		add(cinnamon);
		add(hazelnut);
		add(chocolate);
		add(cocunut);
	}
	

	public String getCappuccinoType()
	{
		String type = "";
		
		//Determines which bagel is selected.
		if (cinnamon.isSelected())
			type = "канела";
		else if (hazelnut.isSelected())
			type = "лешник";
		else if (chocolate.isSelected())
			type = "шоколад";
		else if (cocunut.isSelected())
			type = "кокос";
		
		return type;	
	}
	
	public Double getCappuccinoCost()
	{
		Double cost = 0.0;
		
		if (cinnamon.isSelected())
			cost = cinnamonCost;
		else if (hazelnut.isSelected())
			cost = hazelnutCost;
		else if (chocolate.isSelected())
			cost = chocolateCost;
		else if (cocunut.isSelected())
			cost = cocunutCost;
		
		return cost;
	}

}
