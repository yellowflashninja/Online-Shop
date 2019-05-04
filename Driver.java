package finalproj;

import java.io.*;
import java.text.*;
import java.util.*;
import java.lang.*;

public class Driver {
	 public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {
		DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,##0.00");
		Scanner kb = new Scanner(System.in);
		String choice, select, currentUser;
		Items item;
		int userInd = 0, itemInd = 0;
		
		Store myStore = new Store();
		myStore.inputItems();
		boolean done = false;
		
		
		System.out.println("Welcome to JC Store"); 
		while(!done) {
			boolean dn = false;
			System.out.println("1. Sign in\n2. New Account\n3. Exit Store");
			choice = kb.nextLine();
			if(choice.equals("1")) {
				String user, pass;
				System.out.println("Username:");
				user = kb.nextLine();
				System.out.println("Password:");
				pass = kb.nextLine();
				if(myStore.inDatabase(user, pass)) {
					System.out.println("Welcome back, " + user);
					currentUser = user;
					for(Account temp: myStore.getDatabase()) {
						if(temp.getUsername().equals(currentUser)) {
							userInd = temp.getAccNum();
						}
					}
					
					while(!dn) {
						System.out.println("What would you like to do?\n1. Catalog\n2. See Cart\n3. Checkout\n4. Logout");
						choice = kb.nextLine();
						if(choice.equals("1")) {
							System.out.println("Item Name\t\t\tCost\t\t# in Stock");
							for(Items temp: myStore.getItemList()) {
								System.out.println(temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()) + "\t\t" + temp.getNumStock());
							}
							System.out.println("Would you like to buy something? (Enter y/n)");
							select = kb.nextLine();
							if(select.equals("y")) {
								System.out.println("Select the item you would like to buy by typing in the full item name (Case sensitive)");
								select = kb.nextLine();
								if(myStore.inStore(select)) {
									for(Items temp: myStore.getItemList()) {
										if(temp.getName().equalsIgnoreCase(select)) {
											itemInd = temp.getItemNum();
										}
									}
									if(myStore.getItemList().get(itemInd).getNumStock() <= 0) {
										System.out.println("No more \"" + select + "\" in stock");
										
									}
									else {
										myStore.getItemList().get(itemInd).setNumStock(myStore.getItemList().get(itemInd).getNumStock()-1);
										item = myStore.getItemList().get(itemInd);
										myStore.getDatabase().get(userInd).addToCart(item);
										System.out.println("One \"" + select + "\" was added to cart");
									}
								}
								else {
									System.out.println("Item not found");
								}
								
							}
						}
						else if(choice.equals("2")) {
							System.out.println(myStore.getDatabase().get(userInd).getShoppingCart());
						}
						else if(choice.equals("3")) {
							String card = "", finalDec = "";
							Cart x = myStore.getDatabase().get(userInd).getShoppingCart();
							
							System.out.println("YOUR BILL:");
							System.out.println(myStore.getDatabase().get(userInd).getShoppingCart());
							System.out.println("Please enter your credit card information\nCard Number:");
							card = kb.nextLine();
							System.out.println("Are you sure you want to proceed? (y/n)");
							finalDec = kb.nextLine();
							if(finalDec.equals("y")) {
								System.out.println("Your items have been billed to " + card +". Thank you for shopping at JC Store!");
								x.getCart().clear();
							}	
						}
						else if(choice.equals("4")){
							dn = true;
						}
						else {
							System.out.println("Please type in a number between 1-4");
						}
					}
				}
				else {
					System.out.println("Account not found\n");
				}
			}
			else if(choice.equals("2")){
				String username, password, name;
				System.out.println("Create new account\nYour Name:");
				name = kb.nextLine();
				System.out.println("New Username:");
				username = kb.nextLine();
				System.out.println("New Password:");
				password = kb.nextLine();
				System.out.println("Please remember your username and password!!");
				myStore.addToDatabase(new Account(username, password, name));
				System.out.println("Please log back in");
			}
			else if(choice.equals("3")){
				done = true;
				System.out.println("Thank you for using JC Store. See you next time.");
			}
			else {
				System.out.println("Please type in a number between 1 and 3");
			}
		}
		
		
	 }
}
