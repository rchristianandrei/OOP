package bikeproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;

public class BikeDriver {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
//		RoadBike bike1 = new RoadBike();
//		RoadBike bike2 = new RoadBike("drop", "tourer", "semi-grip", "comfort", 14, 25, 18);		
//		MountainBike bike3 = new MountainBike();
//		Bike bike4 = new Bike();
//		
//		bike1.printDescription();
//		bike2.printDescription();
//		bike3.printDescription();
//		bike4.printDescription();
//		
//		bike1.setPostHeight(20);
//		bike1.printDescription();
		
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		
		//	UI
		String command;
		boolean isValidCommand;
		do {//	Main Loop
			do {//	Command Loop
				System.out.println("List of Valid Commands");
				System.out.println("\t[1] Create Bike Object");
				System.out.println("\t[2] See Description of all Bikes");
				System.out.println("\t[0] Exit"); // Should I add delete command?
				System.out.print("Enter Command: ");
				
				command = in.nextLine();
				isValidCommand = !(command.equals("1") || command.equals("2") || command.equals("0"));
				
				if(isValidCommand) {
					System.out.println("\nInvalid Command\n");
				}
				
			}while(isValidCommand);
			
			//	Executing Command
			switch(command) {
				case "1": createBikeObj(bikes); break;
				case "2": seeBikeDesc(bikes); break;
			}
			
		}while(!command.equals("0"));
		
		System.out.println("Bye Bye!");
		in.close();
	}
	
	private static void createBikeObj(ArrayList<Bike> bikes) {
		
		String bikeVariant;
		boolean isValidBike;
		
		//	Choose which kind of Bike
		do {
			System.out.println("Bike List");
			System.out.println("\t[1] Bike");
			System.out.println("\t[2] Road Bike");
			System.out.println("\t[3] Mountain Bike");
			System.out.println("\t[0] Cancel");
			System.out.println("Enter Chosen Bike: ");
			
			bikeVariant = in.nextLine();
			isValidBike = !(bikeVariant.equals("1") || bikeVariant.equals("2") || bikeVariant.equals("3")
					|| bikeVariant.equals("0"));
		}while(isValidBike);
		
		//	Creating chosen Bike	
		switch(bikeVariant) {
			
			case "1": 
				bikes.add(createBike());
				System.out.println("Successfully Created");
				break;
			case "2":
				Bike temp1 = createBike();
				// Create Road Bike
				bikes.add(createMountainBike(temp1));
				break;
			case "3":
				Bike temp2 = createBike();
				// Create Mountain Bike
				bikes.add(createRoadBike(temp2));
				break;
		}
		
	}
	
	private static Bike createBike() {
		
		System.out.println("Creating Object...");
		System.out.println("Enter Handle Bars: ");
		String handleBars = in.nextLine();
		
		System.out.println("Enter Frame: ");
		String frame = in.nextLine();
		
		System.out.println("Enter Tyres: ");
		String tyres = in.nextLine();
		
		System.out.println("Enter Seat Type: ");
		String seatType = in.nextLine();
		
		int numGears = 0;
		boolean validInput;
		do {
			validInput = true;
			try {
				System.out.println("Enter No. of Gears: ");
				numGears = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("\nInvalid Input\n");
				validInput = false;
			}
			finally {
				in.nextLine();
			}
			
		}while(!validInput);
		
		return new Bike(handleBars, frame, tyres, seatType, numGears);
	}
	
	private static Bike createRoadBike(Bike temp) {
		
		boolean validInput;
		
		int tyreWidth = 0;
		do {
			validInput = true;
			try {
				System.out.println("Enter Tyre Width: ");
				tyreWidth = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("\nInvalid Input");
				validInput = false;
			}
			finally {
				in.nextLine();
			}
			
		}while(!validInput);
		
		
		int postHeight = 0;
		do {
			validInput = true;
			try {
				System.out.println("Enter Post Height: ");
				postHeight = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
				validInput = false;
			}
			finally {
				in.nextLine();
			}
			
		}while(!validInput);
		
		return new RoadBike(temp.getHandleBars(), temp.getFrame(), temp.getTyres(), temp.getSeatType(),
				temp.getNumGears(), tyreWidth, postHeight);
	}
	
	private static Bike createMountainBike(Bike temp) {
		
		System.out.println("Enter Suspension: ");
		String suspension = in.nextLine();
		
		System.out.println("Enter type: ");
		String type = in.nextLine();
		
		int frameSize = 0;
		boolean validInput;
		do {
			validInput = true;
			try {
				System.out.println("Enter Frame size: ");
				frameSize = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("\nInvalid Input\n");
				validInput = false;
			}
			finally {
				in.nextLine();
			}
			
		}while(!validInput);
		
		return new MountainBike(temp.getHandleBars(), temp.getFrame(), temp.getTyres(), temp.getSeatType(),
				temp.getNumGears(), suspension, type, frameSize);
	}
	
	private static void seeBikeDesc(ArrayList<Bike> bikes) {
		
		//	Traverse the Bike List
		for(Bike bike: bikes) {
			bike.printDescription();
			System.out.println();
		}
	}

}