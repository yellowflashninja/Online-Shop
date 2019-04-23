package finalproj;

public class Items {
	private int numStock;
	private String name;
	private double cost;
	
	public Items() {
		numStock = 0;
		name = "";
		cost = 0;
	}
	
	public Items(String name, int stock, double cost) {
		this.name = name;
		this.numStock = stock;
		this.cost = cost;
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
