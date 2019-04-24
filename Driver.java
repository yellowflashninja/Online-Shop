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
		boolean dn = false;
		
		System.out.println("Welcome to JC Store"); 
		while(!done) {
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
							for(Items temp: myStore.getItemList()) {
								System.out.println(temp.getItemNum() + "  " + temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()));
							}
							System.out.println("Would you like to buy something? (Enter y/n)");
							select = kb.nextLine();
							if(select.equals("y")) {
								System.out.println("Select the item you would like to buy by typing in its number");
								select = kb.nextLine();
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
			else {
				done = true;
				System.out.println("Thank you for using JC Store. See you next time.");
			}
		}
	 }

}
