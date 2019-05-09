package finalproj;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.*;


public class Cart {
	DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,###0.00");
	final int ZERO = 0;
	final double TAX = .10;
	
	private ArrayList<Items> shopCart;
	private int numItems;
	
	public Cart() {
		shopCart = new ArrayList<Items>();
		numItems = 0;
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
	 * Description: Prints a receipt of items bought
	 * @throws IOException
	 */
	public void printReceipt() throws IOException {
		PrintWriter outF = new PrintWriter(new FileWriter("receipt.txt"));
		String str = "";
		double sub = ZERO;
		double tot = ZERO;
		double taxDollar = ZERO;
		outF.println("YOUR RECEIPT");
		outF.println("Items\t\t\t\tCost\n");
		for(Items temp: shopCart) {
			outF.println(temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()));
			sub = temp.getCost();
		}
		outF.println("Subtotal = " + dfMoney.format(sub));
		outF.println("\nTax = " + dfMoney.format(TAX * sub)); 
		outF.println("\nTotal Price = " + dfMoney.format(sub * TAX + sub));
		outF.close();
		System.out.println("Your receipt has been printed");
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

	/**
	 * @return the shopCart
	 */
	public ArrayList<Items> getShopCart() {
		return shopCart;
	}

	/**
	 * @param shopCart the shopCart to set
	 */
	public void setShopCart(ArrayList<Items> shopCart) {
		this.shopCart = shopCart;
	}

	/**
	 * @return the numItems
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * @param numItems the numItems to set
	 */
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	
}