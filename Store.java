package finalproj;

import java.io.*;
import java.text.*;
import java.util.*;



public class Store {
	
	DecimalFormat dfMoney  = new DecimalFormat ("$###,###,###,##0.00");
	Scanner kb = new Scanner(System.in);
	
	final int ZERO = 0;
	final int ONE = 1;
	final double TAX = .10;
	private ArrayList<Items> itemList;		
	private ArrayList<Account> database;	
	
	public Store() {
		itemList = new ArrayList<Items>();
		database = new ArrayList<Account>();
	}
	
	/**
	 * Description: Inputs the items from the catalog.txt file
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void inputItems() throws IOException, FileNotFoundException {
		Scanner inF = new Scanner(new File("catalog.txt")); 
		String name;
		int stock;
		double cost;
		while(inF.hasNextLine()){         
            name = inF.nextLine();
            stock = inF.nextInt();
            inF.nextLine();
            cost = inF.nextDouble();
            
            if(inF.hasNextLine())
            	inF.nextLine();    
            
            Items newItem = new Items(name, stock, cost);  
            itemList.add(newItem);
      
		}
	}
	
	/**
	 * Description: adds account to database
	 * @param newAcc an account to be added to the store database
	 */
	public void addToDatabase(Account newAcc) {
		this.database.add(newAcc);
		
	}
	
	/**
	 * Description: sees if account is in database
	 * @param user: username of user
	 * @param pass: password of user
	 * @return if account is in database
	 */
	public boolean inDatabase(String user, String pass) {
		for(Account temp: this.database) {
			if(user.equals(temp.getUsername()) && pass.equals(temp.getPassword())) {
				return true;
			
			}
		}
		return false;
		
	}
	
	/**
	 * Description: sees if account is in database
	 * @param user: username of user
	 * @return if account is in database
	 */
	public boolean inDatabase(String user) {
		for(Account temp: this.database) {
			if(user.equals(temp.getUsername())) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Description: returns boolean if item is in the store
	 * @param item item being searched for in store
	 * @return if item is in store
	 */
	public boolean inStore(String item) {
		for(Items temp: this.itemList) {
			if(item.equals(temp.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Description: goes through the sign in process and online shopping process
	 */
	public void choiceOne() throws IOException, FileNotFoundException {
		
		boolean done = false, dn = false;
		String user, pass;
		int userInd = ZERO, itemInd = ZERO;
		System.out.println("Username:");
		user = kb.nextLine();
		System.out.println("Password:");
		pass = kb.nextLine();
		if(this.inDatabase(user, pass)) {
			for(Account temp: this.getDatabase()) {
				if(temp.getUsername().equals(user)) {
					userInd = temp.getAccNum();
					System.out.println("Welcome back, " + temp.getName());
				}
			}
			
			
			
			while(!dn) {
				System.out.println("What would you like to do?\n1. Catalog\n2. See Cart\n3. Checkout\n4. Logout");
				String choice = kb.nextLine();
				if(choice.equals("1")) {
					System.out.println("Item Name\t\t\tCost\t\t# in Stock");
					for(Items temp: this.getItemList()) {
						System.out.println(temp.getName() + "\t\t\t\t" + dfMoney.format(temp.getCost()) + "\t\t" + temp.getNumStock());
					}
					System.out.println("Would you like to buy something? (Enter y/n)");
					String select = kb.nextLine();
					if(select.equals("y")) {
						System.out.println("Select the item you would like to buy by typing in the full item name (Case sensitive)");
						select = kb.nextLine();
						if(this.inStore(select)) {
							for(Items temp: this.getItemList()) {
								if(temp.getName().equalsIgnoreCase(select)) {
									itemInd = temp.getItemNum();
								}
							}
							if(this.getItemList().get(itemInd).getNumStock() <= ZERO) {
								System.out.println("No more \"" + select + "\" in stock");
								
							}
							else {
								this.getItemList().get(itemInd).setNumStock(this.getItemList().get(itemInd).getNumStock()-ONE);
								this.getDatabase().get(userInd).addToCart(this.getItemList().get(itemInd));
								System.out.println("One \"" + select + "\" was added to cart");
								this.getDatabase().get(userInd).getShoppingCart().setNumItems(this.getDatabase().get(userInd).getShoppingCart().getNumItems()+1);
							}
						}
						else {
							System.out.println("Item not found");
						}
						
					}
				}
				else if(choice.equals("2")) {
					System.out.println(this.getDatabase().get(userInd).getShoppingCart());
				}
				else if(choice.equals("3")) {
					if(this.getDatabase().get(userInd).getShoppingCart().getNumItems()<=0) {
						System.out.println("There is nothing in your cart!! Add items before checking out.");
					}
					else {
						String card = "", finalDec = "", address = "";
						Cart x = this.getDatabase().get(userInd).getShoppingCart();
					
						System.out.println("YOUR BILL:");
						System.out.println(this.getDatabase().get(userInd).getShoppingCart());
						System.out.println("Please enter your credit card information\nCard Number:");
						card = kb.nextLine();
						System.out.println("House Address:");
						address = kb.nextLine();
						System.out.println("Are you sure you want to proceed? (y/n)");
						finalDec = kb.nextLine();
						if(finalDec.equals("y")) {
							System.out.println("Your items have been billed to \"" + card + "\" and will be sent to \"" + address + "\". Thank you for shopping at JC Store!");
							this.getDatabase().get(userInd).getShoppingCart().printReceipt();
							x.getCart().clear();
						}	
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
	
	/**
	 * Description: goes through the account making process
	 */
	public void choiceTwo() {
		String username, password, name;
		System.out.println("Create new account\nYour Name:");
		name = kb.nextLine();
		System.out.println("New Username:");
		username = kb.nextLine();
		System.out.println("New Password:");
		password = kb.nextLine();
		if(this.inDatabase(username)) {
			System.out.println("Username in use. Please choose another username.");
			this.choiceTwo();
		}
		else {
			System.out.println("Please remember your username and password!!");
			this.addToDatabase(new Account(username, password, name));
			System.out.println("Please log back in");
		}
	}
	
	
	
	/**
	 * @return the database
	 */
	public ArrayList<Account> getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	public void setDatabase(ArrayList<Account> database) {
		this.database = database;
	}

	/**
	 * @return the itemList
	 */
	public ArrayList<Items> getItemList() {
		return itemList;
	}

	/**
	 * @param itemList the itemList to set
	 */
	public void setItemList(ArrayList<Items> itemList) {
		this.itemList = itemList;
	}
	
	
	
}