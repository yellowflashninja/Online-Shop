package finalproj;

import java.io.*;
import java.text.*;
import java.util.*;


public class Driver {
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,##0.00");
		Scanner kb = new Scanner(System.in);
		int choice;
		String select;
		
		Store myStore = new Store();
		myStore.inputItems();
		boolean done = false;
		boolean dn = false;
		
		System.out.println("Welcome to JC Store"); 
		while(!done) {
			System.out.println("1. Sign in\n2. New Account\n3. Exit Store");
			choice = kb.nextInt();
			kb.nextLine();
			if(choice == 1) {
				String user, pass;
				System.out.println("Username:");
				user = kb.nextLine();
				System.out.println("Password:");
				pass = kb.nextLine();
				if(myStore.inDatabase(user, pass)) {
					System.out.println("Welcome back, " + user);
					while(!dn) {
						System.out.println("What would you like to do?\n1. Catalog\n2. See Cart\n3. Checkout\n4. Logout");
						choice = kb.nextInt();
						kb.nextLine();
						if(choice == 1) {
							for(Items temp: myStore.getItemList()) {
								System.out.println(temp.getName() + "\t\t\t" + temp.getCost());
							}
							System.out.println("Would you like to buy something? (Enter y/n)");
							if(kb.nextLine() = )
							select = kb.nextLine();
						}
					}
				}
				else {
					System.out.println("Account not found\n");
				}
			}
			else if(choice == 2){
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
