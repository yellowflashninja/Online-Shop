package finalproj;

import java.io.*;
import java.text.*;
import java.util.*;


public class Driver {
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,##0.00");
		Scanner kb = new Scanner(System.in);
		String choice;
		String select;
		
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
								System.out.println("Select the item you would like to buy by typing in the full item name");
								select = kb.nextLine();
								System.out.println("One " + select + " was added to cart");
							}
							
						}
						else {
							dn = true;
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
