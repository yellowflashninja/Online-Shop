package finalproj;

public class Account {
	private String username;
	private String password;
	private String name;
	private Cart shoppingCart;
	private static int aNum = 0;
	private int accNum;
	
	
	public Account(){
		username = "";
		password = "";
		name = "";
		accNum = aNum;
		aNum++;
		
	}
	
	public Account(String user, String pass, String name) {
		this.username = user;
		this.password = pass;
		this.name = name;
		shoppingCart = new Cart();
		accNum = aNum;
		aNum++;
	}
	
	

	/**
	 * @return the aNum
	 */
	public static int getaNum() {
		return aNum;
	}

	/**
	 * @param aNum the aNum to set
	 */
	public static void setaNum(int aNum) {
		Account.aNum = aNum;
	}

	/**
	 * @return the accNum
	 */
	public int getAccNum() {
		return accNum;
	}

	/**
	 * @param accNum the accNum to set
	 */
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the shoppingCart
	 */
	public Cart getShoppingCart() {
		return shoppingCart;
	}
	
	/**
	 * Description: adds item to cart
	 * @param item item to be added to the cart
	 */
	public void addToCart(Items item) {
		this.getShoppingCart().add(item);		
	}

	/**
	 * @param shoppingCart the shoppingCart to set
	 */
	public void setShoppingCart(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}