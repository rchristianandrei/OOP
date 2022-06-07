package algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static boolean isSorted = false;

	public static void main(String[] args) {
		
		int choice = 0;
		
		do {
			System.out.println("[1] Input Number");
			System.out.println("[2] Remove Number");
			System.out.println("[3] See Numbers");
			System.out.println("[4] Sort Numbers");
			System.out.println("[5] Search Number");
			System.out.println("[0] Exit");
			
			choice = inputInt("Enter your Choice: ");
			
			if(choice == 0) {
				break;
			}
			else {
				switch(choice) {
					case 1: inputNumber(); break;
					case 2: removeNumber(); break;
					case 3: seeNumbers(); break;
					case 4:	bubbleSort(); break;
					case 5: searchNumber(); break;
				}
			}
			
			System.out.print("Do you want to repeat? {y,n}: ");
		}while(in.nextLine().toLowerCase().equals("y") && choice != 0);
		
		System.out.println("Bye Bye!");
	}
	
	static void inputNumber() {
		
		int num = inputInt("Enter your Number to store: ");
		
		numbers.add(num);
		isSorted = false;
	}
	
	static void removeNumber() {
		
		int target;
		
		if(!numbers.isEmpty()) {
			target = inputInt("Enter the number to remove: ");
			try {
				numbers.remove(binarySearch(target));
			}
			catch(IndexOutOfBoundsException e) {
				System.out.println("Number not found!");
			}
		}
		else {
			System.out.println("Enter some numbers first!");
		}
	}
	
	static void seeNumbers() {
		
		if(!numbers.isEmpty()) {
			for(Integer num : numbers) {
				System.out.println(num);
			}
		}
		else {
			System.out.println("Enter some numbers first!");
		}
	}
	
	static void bubbleSort() {
		
		boolean flag = false;
		int temp = 0;
		
		do {
			flag = false;
			
			for(int i = 0; i < numbers.size()-1; i++) {
				if(numbers.get(i) > numbers.get(i+1)) {
					temp = numbers.get(i);
					numbers.set(i, numbers.get(i+1));
					numbers.set(i+1, temp);
					flag = true;
				}
			}
		}while(flag);
		
		isSorted = true;
	}
	
	static void searchNumber() {
		
		int num = inputInt("Enter number to find: ");
		int index = binarySearch(num);
		
		if(index <= -1) {
			System.out.println("The numeber "+num+" is not found");
		}
		else {
			System.out.println("The number "+num+" is at index "+index);
		}
	}
	
	static int binarySearch(int target) {
		
		if(!isSorted) {
			bubbleSort();
		}
		
		int low = 0;
		int high = numbers.size();
		
		while(low <= high) {
			int midpoint = low + (high - low) / 2;
			int value = numbers.get(midpoint);
			
			if(target == value) {
				return midpoint;
			}
			else if(target > value) {
				low = midpoint+1;
			}
			else {
				high = midpoint-1;
			}
		}
		
		return -1;
	}
	
	static int inputInt(String message) {
		
		boolean repeat = true;
		int num = 0;

		while(repeat) {
			repeat = false;
			
			System.out.print(message);
			try {
				num = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
				repeat = true;
			}
			finally {
				in.nextLine();
			}
		}
		
		return num;
	}
}
