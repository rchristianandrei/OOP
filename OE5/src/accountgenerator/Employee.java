package accountgenerator;

import java.util.Scanner;

public class Employee {
	
	private static Scanner in = new Scanner(System.in);
	
	private final String name;
	private final String username;
	private final String email;
	private String password;
	
	Employee(){
		this.name = setName();
		this.username = setUsername();
		this.email = setEmail();
		this.password = setInitialPassword();
	}
	
	private String setName() {
		System.out.print("Please enter your full name: ");
		return in.nextLine();
	}
	
	private String setUsername() {
		return this.name.replace(' ', '.').toLowerCase();
	}
	
	private String setEmail() {
		return this.username.replace(".", "") + "@oracleacademy.Test";
	}
	
	private String setInitialPassword() {
		System.out.print("Enter your New Password: ");
		return in.nextLine();
	}
	
	void setPassword() {
		this.password = setInitialPassword();
	}
	
	String getPassword() {
		return this.password;
	}
	
	String hidePassword(){
		
		StringBuilder temp = new StringBuilder(this.password);
		
		for(int i = 0; i < temp.length(); i++) {
			if(i%2 != 0) {
				temp.setCharAt(i, '*');;
			}
		}
		
		return temp.toString();
	}
	
	public String toString() {
		return "Employee Details"
				+ "\nName\t\t" + this.name
				+ "\nUsername\t" + this.username
				+ "\nEmail\t\t" + this.email
				+ "\nPassword\t" + hidePassword();
	}
}
