package finalproj;

import java.io.*;
import java.util.*;



public class Store {
	private ArrayList<Items> itemList;
	private ArrayList<Account> database;
	public Store() {
		itemList = new ArrayList<Items>();
		database = new ArrayList<Account>();
	}
	
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
	
	public void addToDatabase(Account newAcc) {
		this.database.add(newAcc);
		
	}
	
	public boolean inDatabase(String user, String pass) {
		for(Account temp: this.database) {
			if(user.equals(temp.getUsername()) && pass.equals(temp.getPassword())) {
				return true;
			
			}
		}
		return false;
		
	}
	
	public boolean inStore(String item) {
		for(Items temp: this.itemList) {
			if(item.equals(temp.getName())){
				return true;
			}
		}
		return false;
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
