package accountgenerator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	
	private static Scanner in = new Scanner(System.in);
	
	private static final Pattern validName = Pattern.compile("[0-9A-Za-z]+ [0-9A-Za-z]+", Pattern.CASE_INSENSITIVE);
	private static final Pattern containaz = Pattern.compile(".*([a-z]+).*", Pattern.CASE_INSENSITIVE);
	private static final Pattern containAZ = Pattern.compile(".*([A-Z]+).*", Pattern.CASE_INSENSITIVE);
	private static final Pattern containNum = Pattern.compile(".*([0-9]+).*");
	private static final Pattern containSc = Pattern.compile("[!@#$%^&*()_+=|<>?{}\\\\[\\\\]~-]");
	private static final Pattern stringMinLength = Pattern.compile(".{8}");
	
	private final String name;
	private final String username;
	private final String email;
	private String password;
	
	Employee(){
		this.name = setName();
		this.username = setUsername();
		this.email = setEmail();
		setPassword();
	}
	
	private String setName() {
		String temp = "";
		boolean isValid = true;
		do {
			isValid = true;
			
			System.out.print("Please enter your full name: ");
			temp = in.nextLine();
			
			if(!validName.matcher(temp).find()) {
				isValid = false;
				System.out.println("\nIncorrect format for name\n");
			}
		}while(!isValid);
		
		return temp;
	}
	
	private String setUsername() {
		return this.name.replace(' ', '.').toLowerCase();
	}
	
	private String setEmail() {
		String[] names = this.name.toLowerCase().split(" ");
		
		String email = "";
		
		for(int i = 0; i < names.length; i++) {
			if(i == 0) {
				email += names[i].charAt(0);
			}
			else {
				email += names[i];
			}
		}
		
		return email + "@oracleacademy.Test";
	}
	
	private String setInitialPassword() {
		System.out.print("Enter your New Password: ");
		return in.nextLine();
	}
	
	void setPassword() {
		
		String temp = "";
		do{
			temp = setInitialPassword();
		}while(!isValidPassword(temp));
		
		this.password = temp;
	}
	
	private boolean isValidPassword(String password) {
		
		Matcher hasSmallLetter = containaz.matcher(password);
		Matcher hasBigLetter = containAZ.matcher(password);
		Matcher hasNum = containNum.matcher(password);
		Matcher hasSc = containSc.matcher(password);
		Matcher hasValidLength = stringMinLength.matcher(password);
		
		return hasSmallLetter.find() && hasBigLetter.find() && hasNum.find()
				&& hasSc.find() && hasValidLength.find();

	}
	
	String getPassword() {
		return this.password;
	}
	
	String hidePassword(){
		
		StringBuilder temp = new StringBuilder(this.password);
		
		for(int i = 3; i < temp.length(); i++) {
				temp.setCharAt(i, '*');;
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
