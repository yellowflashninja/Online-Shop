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
			str += temp.getName() + "\t\t\t" + temp.getCost() + "\n";
		}
		return str;
	}
	
	public void addCart(Items x) {
		shopCart.add(x);
	}
	
	public ArrayList<Items> getCart() {
		return shopCart;
	}
}
