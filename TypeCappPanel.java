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
		cCoffee = new JRadioButton("������������");
		bioCoffee = new JRadioButton("���");
		
		typeGroup = new ButtonGroup();
		
		typeGroup.add(lCoffee);
		typeGroup.add(bCoffee);
		typeGroup.add(cCoffee);
		typeGroup.add(bioCoffee);
		
		setBorder(BorderFactory.createTitledBorder("���"));
		
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
			type = "������";
		else if (bCoffee.isSelected())
			type = "������";
		else if (cCoffee.isSelected())
			type = "������������";
		else if (bioCoffee.isSelected())
			type = "���";
		else
		{
			JOptionPane.showMessageDialog(null, "���� �������� ��� �� ��������!");
		}
		return type;	
	}
}
