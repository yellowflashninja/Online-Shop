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
}
