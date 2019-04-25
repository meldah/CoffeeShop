import java.awt.*;
import javax.swing.*;

/**
 * Main panel to select which type of coffee to add to the order.
 *
 */
public class TypeCappPanel extends JPanel
{
	private JRadioButton lCoffee;
	private JRadioButton bCoffee;
	private JRadioButton cCoffee;
	private JRadioButton bioCoffee;
	public ButtonGroup typeGroup;
	
	/**
	 * Constructor
	 */
	public TypeCappPanel()
	{
		setLayout(new GridLayout(3, 1));
		
		lCoffee = new JRadioButton("Lavazza");
		bCoffee = new JRadioButton("Bianchi");
		cCoffee = new JRadioButton("Безкофеиново");
		bioCoffee = new JRadioButton("Био");
		
		typeGroup = new ButtonGroup();
		
		typeGroup.add(lCoffee);
		typeGroup.add(bCoffee);
		typeGroup.add(cCoffee);
		typeGroup.add(bioCoffee);
		
		setBorder(BorderFactory.createTitledBorder("Тип"));
		
		add(lCoffee);
		add(bCoffee);
		add(cCoffee);
		add(bioCoffee);
	}

	/**
	 * Allows access to which type of coffee is selected.
	 * @return Type
	 */
	public String getCoffeeType()
	{
		String type = "";
		
		if (lCoffee.isSelected())
			type = "лаваца";
		else if (bCoffee.isSelected())
			type = "бианчи";
		else if (cCoffee.isSelected())
			type = "безкофеиново";
		else if (bioCoffee.isSelected())
			type = "био";
		else
		{
			JOptionPane.showMessageDialog(null, "Моля изберете тип на продукта!");
		}
		return type;	
	}
}
