package finalproj;

import java.io.*;
import java.text.*;
import java.util.*;


public class Driver {
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,##0.00");
		Scanner kb = new Scanner(System.in);
		int choice;
		String user, pass;
		
		Store myStore = new Store();
		myStore.inputItems();	
		myStore.
		
		System.out.println("Welcome to JC Store"); 
		System.out.println("1. Sign in\n2. New Account");
		choice = kb.nextInt();
		kb.nextLine();
		if(choice == 1) {
			System.out.println("Username:");
			user = kb.nextLine();
			System.out.println("Password:");
			pass = kb.nextLine();
			if(getDatabase().inDatabase(user, pass)) {
				
			}
		}
	 }

}
