import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main panel for selecting which product to add.
 * @author DrewOsborne
 *
 */
public class ProductsPanel extends JPanel
{
	public static JRadioButton coffeeButton;
	public static JRadioButton sandwichesButton;
	public static JRadioButton pastryButton;
	public static JRadioButton cappuccinoButton;
	public ButtonGroup bg;
	
	/**
	 * Constructor
	 */
	public ProductsPanel()
	{
		setLayout(new GridLayout(4, 1));
		
		//Creates the buttons.
		coffeeButton = new JRadioButton("Кафе");
		cappuccinoButton = new JRadioButton("Капучино");
		sandwichesButton = new JRadioButton("Сандвичи");
		pastryButton = new JRadioButton("Сладкиши");
		
		//Groups the buttons.
		bg = new ButtonGroup();
		bg.add(coffeeButton);
		bg.add(cappuccinoButton);
		bg.add(sandwichesButton);
		bg.add(pastryButton);
		
		
		
		setBorder(BorderFactory.createTitledBorder("Продукти"));
		
		//Adds the buttons.
		add(coffeeButton);
		add(cappuccinoButton);
		add(sandwichesButton);
		add(pastryButton);
	}
	
	
}
