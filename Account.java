package finalproj;

public class Account {
	private String username;
	private String password;
	private String name;
	private Cart shoppingCart;
	
	
	public Account(){
		username = "";
		password = "";
		name = "";
		
	}
	
	public Account(String user, String pass, String name) {
		this.username = user;
		this.password = pass;
		this.name = name;
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
	 * @param shoppingCart the shoppingCart to set
	 */
	public void setShoppingCart(Cart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
