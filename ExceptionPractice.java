package exception;
import java.util.*;

public class ExceptionPractice {
	public static void main(String[] args) {
		int number = 0;
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a number between 1-10:");
		boolean isValid = false;
		
		while(!isValid) {
			try {
				number = kb.nextInt();
				isValid = true;
			}
			catch(InputMismatchException e) {
				System.out.println("Your input was invalid");
				System.out.println("Please enter a number between 1-10:");
				kb.nextLine();
			}
		}
		while(number < 0 || number > 10) {
			System.out.println("Your input was invalid");
			System.out.println("Please enter a number between 1-10:");
			kb.nextLine();
		}
			System.out.println("Your number is: " + number);
		
	}
}
