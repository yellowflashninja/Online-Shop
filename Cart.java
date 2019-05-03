package finalproj;

import java.util.*;


public class Cart {
	
	private ArrayList<Items> shopCart;

	public Cart() {
		shopCart = new ArrayList<Items>();
	}
	
	public String toString() {
		String str = "";
		for(Items temp: shopCart) {
			str += temp.getName() + "\t\t\t\t" + temp.getCost() + "\n";
		}
		return str;
	}
	
	
	
	
	public ArrayList<Items> getCart() {
		return shopCart;
	}

	public void add(Items items) {
		shopCart.add(items);
		
	}
}
