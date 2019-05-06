package finalproj;

import java.io.*;
import java.text.*;
import java.util.*;
import java.lang.*;

public class Driver {
	 public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {
		
		Scanner kb = new Scanner(System.in);
		String choice;
		
		Store myStore = new Store();
		myStore.inputItems();
		
		boolean done = false;
		System.out.println("Welcome to JC Store"); 
		while(!done) {
			System.out.println("1. Sign in\n2. New Account\n3. Exit Store");
			choice = kb.nextLine();
			if(choice.equals("1")) {
				myStore.choiceOne();
			}
			else if(choice.equals("2")){
				myStore.choiceTwo();
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