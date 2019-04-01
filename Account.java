package finalproj;

public class Account {
	private String username;
	private String password;
	private String name;
	private Cart shoppingCart;
	private int SSN;
	
	
	public Account(){
		username = "";
		password = "";
		name = "";
		
	}
	
	public Account(String user, String pass, String name, Cart cart) {
		this.username = user;
		this.password = pass;
		this.name = name;
		this.shoppingCart = cart;
	}
}
