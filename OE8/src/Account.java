
public class Account {
	
	private static String username;
	private static String password;
	
	
	static String getUsername() {
		
		if(Account.username == null) {
			Account.username = "";
		}

		return Account.username;
	}
	
	static void setUsername(String username) {
		Account.username = username;
	}
	
	static String getPassword() {
		
		if(Account.password == null) {
			Account.password = "";
		}
		
		return Account.password;
	}
	
	static void setPassword(String pass) {
		Account.password = pass;
	}
}
