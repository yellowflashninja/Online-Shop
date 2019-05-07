package finalproj;

import java.text.*;
import java.util.*;


public class Cart {
	DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,###0.00");
	final int ZERO = 0;
	
	private ArrayList<Items> shopCart;

	public Cart() {
		shopCart = new ArrayList<Items>();
	}
	
	public String toString() {
		String str = "";
		double tot = ZERO;
		str += "Items\t\t\t\tCost\n";
		for(Items temp: shopCart) {
			str += temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()) + "\n";
			tot += temp.getCost();
		}
		str += "Total Price = " + dfMoney.format(tot);
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