import java.util.Scanner;

public class Main {
	
	private static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		do {
			System.out.println("Currency Converter\n");
			
			Money amount = inputMoney("Please input the amount you want to convert and its currency\nExample: 100.00 Peso\nAmount> ");
			
			amount = showOptions(amount);
			
			System.out.println("\nYour money has been converted!");
			System.out.println("\t" + amount + "\n");
			
		}while(inputString("Do you want another transaction? {y|n} ").matches("[Yy]"));
		System.out.println("\nThank you and come again!");
	}
	
	private static Money showOptions(Money amount) {
		
		// Show and Choose
		String choice = "";
		String valid = "";
		do {
			
			System.out.println("\nServices");
			
			if(!amount.currency.matches("[Pp]eso")) {
				System.out.println("\t[P] Convert "+amount.currency+" to Peso");
				valid = "[Pp]";
			}
			if(!amount.currency.matches("[Dd]ollar")) {
				System.out.println("\t[D] Convert "+amount.currency+" to Dollar");
				if(!valid.isEmpty()) {
					valid = valid.substring(0, valid.length()-1) + "Dd]";
				}
				else {
					valid = "[Dd]";
				}
			}
			if(!amount.currency.matches("[Ee]uro")) {
				System.out.println("\t[E] Convert "+amount.currency+" to Euro");
				valid = valid.substring(0, valid.length()-1) + "Ee]";
			}
			
			choice = inputString("\nWhat currency you want to convert it to? ");
			
		}while(!choice.toLowerCase().matches(valid));
		
		
		switch(choice) {
			case "p":
				return toPeso(amount);
		case "d":
				return toDollar(amount);
			case "e":
				return toEuro(amount);
		}
		return amount;
	}
	
	private static Money toPeso(Money amount) {
		
		// Convert
		if(amount.currency.matches("[Dd]ollar")) {
			return new Money("Peso", amount.value * 56.23f);
		}
		else if(amount.currency.matches("[Ee]uro")) {
			return new Money("Peso", amount.value * 56.37f);
		}
		
		return amount;
	}

	private static Money toDollar(Money amount) { 
		
		// Convert
		if(amount.currency.matches("[Pp]eso")) {
			return new Money("Dollar", amount.value / 56.23f);
		}
		else if(amount.currency.matches("[Ee]uro")) {
			return new Money("Dollar", amount.value / 1);
		}
		
		return amount;
	}
	
	private static Money toEuro(Money amount) { 
		
		// Convert
		if(amount.currency.matches("[Pp]eso")) {
			return new Money("Euro", amount.value / 56.37f);
		}
		else if(amount.currency.matches("[Dd]ollar")) {
			return new Money("Euro", amount.value / 1);
		}
		
		return amount;
	}
	
	private static Money inputMoney(String message) {
		
		do {
			System.out.print(message);
			String amount = in.nextLine();
			
			if(amount.matches("[0-9]+\\.[0-9]{2} ([Pp]eso|[Dd]ollar|[Ee]uro)")) {
				float value = Float.parseFloat(amount.substring(0,amount.indexOf(" ")+1));
				String currency = amount.substring(amount.indexOf(" ")+1,amount.length());
				
				return new Money(currency, value);
			}
			else {
				System.out.println("\nInvalid format, please follow the example\n");
			}
		}while(true);
	}
	
	private static String inputString(String message) {
		
		System.out.print(message);
		return in.nextLine();
	}
}
