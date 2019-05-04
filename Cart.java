package finalproj;

import java.text.*;
import java.util.*;


public class Cart {
	DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,###0.00");
	
	
	private ArrayList<Items> shopCart;

	public Cart() {
		shopCart = new ArrayList<Items>();
	}
	
	public String toString() {
		String str = "";
		double tot = 0;
		str += "Items\t\t\t\tCost\n";
		for(Items temp: shopCart) {
			str += temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()) + "\n";
			tot += temp.getCost();
		}
		str += "Total Price = " + dfMoney.format(tot);
		return str;
	}
	
	
	
	
	public ArrayList<Items> getCart() {
		return shopCart;
	}

	public void add(Items item) {
		shopCart.add(item);
	}

	
}
