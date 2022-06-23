package accountgenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner in = new Scanner(System.in);
	private static ArrayList<Employee> accounts = new ArrayList<Employee>();
	
	public static void main(String[] args) {
		
		boolean willRepeat = true;
		do {
			int choice = 0;
			do {
				System.out.println("\n\tAccount Generator!");
				System.out.println("[1] Create Account");
				System.out.println("[2] Edit Account Password");
				System.out.println("[3] Delete Account");
				System.out.println("[4] Show Accounts");
				System.out.println("[0] Exit");
				
				switch(inputInt("\nWhat do you want to do: ")) {
					case 1: createAccount(); break;
					case 2: editPassword(); break;
					case 3: deleteAccount(); break;
					case 4: printAccounts(); break;
					case 0: willRepeat = false; break;
					default: System.out.println("Do what?");
				}
				
			}while(choice < 0 || choice > 4);
		}while(willRepeat);
		
		System.out.println("Bye!");
		in.close();
	}
	
	private static void createAccount() {
		accounts.add(new Employee());
		System.out.println("Account Created!");
	}
	
	private static void editPassword() {
		
		if(accounts.isEmpty()) {
			System.out.println("Error: No Accounts");
			return;
		}
		
		printAccounts();
		
		int choice = 0;
		do {
			choice = inputInt("\nChoose Account to edit the Password: ");
		}while(choice < 0 || choice > accounts.size()-1);
		
		String password = "";
		boolean tryAgain = false;
		do {
			tryAgain = false;
			password = inputString("Enter Password: ");
			
			Employee tempAccount = accounts.get(choice);
			
			if(tempAccount.getPassword().equals(password)) {
				tempAccount.setPassword();
				System.out.println("Password changed successfully");
			}
			else {
				System.out.println("Wrong Password");
				tryAgain = inputString("Try Again? [y/n] ").toLowerCase().equals("y");
			}
		}while(tryAgain);
		
	}
	
	private static void deleteAccount() {
		
		if(accounts.isEmpty()) {
			System.out.println("Error: No Accounts");
			return;
		}
		
		printAccounts();
		
		int choice = 0;
		do {
			choice = inputInt("\nChoose Account to DELETE: ");
		}while(choice < 0 || choice > accounts.size()-1);
		
		String password = "";
		boolean tryAgain = false;
		do {
			tryAgain = false;
			password = inputString("Enter Password: ");
			
			Employee tempAccount = accounts.get(choice);
			
			if(tempAccount.getPassword().equals(password)) {
				accounts.remove(choice);
				System.out.println("Account Deleted!");
			}
			else {
				System.out.println("Wrong Password");
				tryAgain = inputString("Try Again? [y/n] ").toLowerCase().equals("y");
			}
		}while(tryAgain);
		
	}
	
	private static void printAccounts() {
		
		if(accounts.isEmpty()) {
			System.out.println("Error: No Accounts");
			return;
		}
		
		for(int i = 0; i < accounts.size(); i++) {
			System.out.println("\n[" + i + "]");
			System.out.println(accounts.get(i));
		}
	}
	
	private static String inputString(String prompt) {
		System.out.print(prompt);
		return in.nextLine();
	}
	
	private static int inputInt(String prompt) {
		
		boolean isValid = true;
		int value = 0;
		do {
			isValid = true;
			System.out.print(prompt);
			try {
				value = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("\nInvalid Input");
				isValid = false;
			}
			finally {
				in.nextLine();
			}
		}while(!isValid);
		
		return value;
	}
}
