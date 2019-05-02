import java.awt.*;
import javax.swing.JPanel;

/**
 * Main panel for bagels and its sub-parts.
 *
 */
public class SandwichesPanel extends JPanel
{
	public FlavorPanel flavor;
	public SandwichProdPanel products;
	public SaladsPanel salads;
	
	/**
	 * Constructor
	 */
	public SandwichesPanel()
	{
		setLayout(new GridLayout(3, 1));
		flavor = new FlavorPanel();
		products = new SandwichProdPanel();
		salads = new SaladsPanel();
		
		add(flavor);
		add(products);
		add(salads);
	}
	
	/**
	 * Total cost of the sandwiches.
	 * @return Total cost.
	 */
	public Double getSandwichTotalCost()
	{
		//Adds up the totals of each sub-panel.
		double flavorCost = flavor.getBagelCost();
		double spreadsCost = products.getProdCost();
		if(spreadsCost==0)
		{
			return 0.0;
		}
		double saladsCost = salads.getsCost();
		double sandwichCost = flavorCost + spreadsCost + saladsCost;
		
		return sandwichCost;
	}
	
	/**
	 * Description of the sandwiches.
	 * @return	Description.
	 */
	public String getSandwichTotalType()
	{
		//Adds the descriptions of each sub-panel.
		String flavorString = flavor.getBagelType();
		String productsString = products.getProdType();
		if(productsString=="")
		{
			String result = "";
			return result;
		}
		String saladsString = salads.getSalads();
		
		return "Сандвич: " + flavorString + " , с " + productsString + " / " + saladsString;
	}
}
