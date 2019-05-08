package finalproj;

import java.text.*;
import java.util.*;


public class Cart {
	DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,###0.00");
	final int ZERO = 0;
	final double TAX = .10;
	
	private ArrayList<Items> shopCart;

	public Cart() {
		shopCart = new ArrayList<Items>();
	}
	
	/**
	 * Description: prints the cart and the sum of the prices inside the cart
	 * @return returns the string to be printed in the console
	 */
	public String toString() {
		String str = "";
		double sub = ZERO;
		double tot = ZERO;
		double taxDollar = ZERO;
		str += "Items\t\t\t\tCost\n";
		for(Items temp: shopCart) {
			str += temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()) + "\n";
			sub += temp.getCost();
		}
		str += "Subtotal = " + dfMoney.format(sub);
		str += "\nTax = " + dfMoney.format(TAX * sub); 
		str += "\nTotal Price = " + dfMoney.format(sub * TAX + sub);
		return str;
	}
	
	
	
	/**
	 * Description: returns shopping cart
	 * @return returns arraylist of shopping cart items
	 */
	public ArrayList<Items> getCart() {
		return shopCart;
	}

	/**
	 * Description: adds item to the shopping cart
	 * @param item item to be added to the cart
	 */
	public void add(Items item) {
		shopCart.add(item);
	}

	
}