package finalproj;

public class Items {
	private int numStock;
	private String name;
	private double cost;
	private static int catNum = 0;
	private int itemNum;
	
	public Items() {
		numStock = 0;
		name = "";
		cost = 0;
		itemNum = catNum;
		catNum++;
	}

	public Items(String name, int stock, double cost) {
		this.name = name;
		this.numStock = stock;
		this.cost = cost;
		itemNum = catNum;
		catNum++;
	}
	
	
	/**
	 * @return the catNum
	 */
	public static int getCatNum() {
		return catNum;
	}

	/**
	 * @param catNum the catNum to set
	 */
	public static void setCatNum(int catNum) {
		Items.catNum = catNum;
	}

	/**
	 * @return the itemNum
	 */
	public int getItemNum() {
		return itemNum;
	}

	/**
	 * @param itemNum the itemNum to set
	 */
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	/**
	 * @return the numStock
	 */
	public int getNumStock() {
		return numStock;
	}

	/**
	 * @param numStock the numStock to set
	 */
	public void setNumStock(int numStock) {
		this.numStock = numStock;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}	
}