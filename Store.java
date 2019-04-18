package finalproj;

import java.io.*;
import java.util.*;



public class Store {
	private ArrayList<Items> itemList;
	
	public Store() {
		itemList = new ArrayList<Items>();
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
