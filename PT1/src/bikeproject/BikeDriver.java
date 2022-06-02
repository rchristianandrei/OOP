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
		bikes.add(new RoadBike("drop", "tourer", "semi-grip", "comfort", 14, 25, 18));
		
		//	UI
		int command;
		boolean isValidCommand;
		do {//	Main Loop
			do {//	Command Loop
				System.out.println("List of Valid Commands");
				System.out.println("\t[1] Create Bike Object");
				System.out.println("\t[2] See Description of all Bikes");
				System.out.println("\t[3] Edit Bike");
				System.out.println("\t[4] Delete Bike");
				System.out.println("\t[0] Exit"); // Should I add delete command?
				System.out.print("Enter Command: ");
				
				command = inputInt();
				isValidCommand = command >= 0 && command <= 4;
				
				if(!isValidCommand) {
					System.out.println("\nInvalid Command\n");
				}
				
			}while(!isValidCommand);
			
			//	Executing Command
			switch(command) {
				case 1: createBikeObj(bikes); break;
				case 2: seeBikeDesc(bikes); break;
				case 3: editBike(bikes); break;
				case 4: deleteBike(bikes); break;
			}
			
		}while(!(command == 0));
		
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
				break;
			case "2":
				// Create Road Bike
				bikes.add(createMountainBike(createBike()));
				break;
			case "3":
				// Create Mountain Bike
				bikes.add(createRoadBike(createBike()));
				break;
		}
		System.out.println("Successfully Created");
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
		
		int numGears = inputInt("Enter No. of Gears: ");
		
		return new Bike(handleBars, frame, tyres, seatType, numGears);
	}
	
	private static RoadBike createRoadBike(Bike temp) {
		
		int tyreWidth = inputInt("Enter Tyre Width: ");
		int postHeight = inputInt("Enter Post Height: ");
		
		return new RoadBike(temp, tyreWidth, postHeight);
	}
	
	private static MountainBike createMountainBike(Bike temp) {
		
		System.out.println("Enter Suspension: ");
		String suspension = in.nextLine();
		
		System.out.println("Enter type: ");
		String type = in.nextLine();
		
		int frameSize = inputInt("Enter Frame size: ");
		
		return new MountainBike(temp, suspension, type, frameSize);
	}
	
	private static void seeBikeDesc(ArrayList<Bike> bikes) {
		
		if(bikes.isEmpty()) {
			System.out.println("There's no Bike to see.");
			return;
		}
		
		//	Traverse the Bike List
		System.out.println("\nList of all Bikes");
		for(int i = 0; i < bikes.size(); i++) {
			System.out.print("\n["+i+"] ");
			bikes.get(i).printDescription();
			System.out.println();
		}
		System.out.println();
	}
	
	private static void editBike(ArrayList<Bike> bikes) {
		
		if(bikes.isEmpty()) {
			System.out.println("There's no Bike to edit.");
			return;
		}
		
		//	Reusable variables
		int index = 0;
		boolean validIndex;
		
		//	Display all Bikes
		seeBikeDesc(bikes);
		
		//	Choose Bike to edit
		do {
			index = inputInt("Enter Bike to edit: ");
		}while(index < 0 || index >= bikes.size());
		
		do {
			do {
				//	Show parts of chosen bike
				Bike bikeToEdit = bikes.get(index);
				bikeToEdit.showBikeParts();
				System.out.println("\t[0] Cancel");
				
				//	Edit bike part
				do {
					validIndex = true;
					int part = inputInt("Choose Bike Part to edit: ");
					
					if(bikeToEdit instanceof RoadBike && validIndex) {
						if(part < 0 || part > 7) {
							System.out.println("Out of Range");
							validIndex = false;
						}
						else {
							if(part >= 0 && part <= 5) {
								editBikePart(bikeToEdit,part);
							}
							else {
								editRoadBikePart((RoadBike)bikeToEdit,part);
							}
						}
					}
					else if(bikeToEdit instanceof MountainBike && validIndex){
						if(part < 0 || part > 8) {
							System.out.println("Out of Range");
							validIndex = false;
						}
						else {
							if(part >= 0 && part <= 5) {
								editBikePart(bikeToEdit,part);
							}
							else {
								editMountainBikePart((MountainBike)bikeToEdit,part);
							}
						}
					}
					else if (validIndex) {
						if(part < 0 || part > 5) {
							System.out.println("Out of Range");
							validIndex = false;
						}
						else {
							editBikePart(bikeToEdit,part);
						}
					}
				}while(!validIndex);
			}while(index != 0);
			System.out.println("Done Replacing Parts");
			System.out.println("\nEdit this bike again? {y/n}");
		}while(in.nextLine().toLowerCase().equals("y"));
	}
	
	private static void editBikePart(Bike bike, int index) {
		switch(index) {
			case 1:
				System.out.println("Enter new Handle Bars: ");
				bike.setHandleBars(in.nextLine());
				break;
			case 2:
				System.out.println("Enter new Frame: ");
				bike.setFrame(in.nextLine());
				break;
			case 3:
				System.out.println("Enter new Tyres: ");
				bike.setTyres(in.nextLine());
				break;
			case 4:
				System.out.println("Enter new Seat Type: ");
				bike.setSeatType(in.nextLine());
				break;
			case 5:
				System.out.println();
				bike.setNumGears(inputInt("Enter new No. of Gears: "));
				break;
		}
	}
	
	private static void editRoadBikePart(RoadBike bike, int index) {
		
		switch(index) {
			case 6:
				bike.setTyreWidth(inputInt("Enter new Tyre Width: "));
				break;
			case 7:
				bike.setPostHeight(inputInt("Enter new Post Height: "));
				break;
		}
	}

	private static void editMountainBikePart(MountainBike bike, int index) {
		
		switch(index) {
			case 6:
				System.out.println("Enter new Suspension: ");
				bike.setSuspension(in.nextLine());
				break;
			case 7:
				System.out.println("Enter new Type: ");
				bike.setType(in.nextLine());
			case 8:
				bike.setFrameSize(inputInt("Enter new Frame Size: "));
				break;
		}
	}
	
	private static void deleteBike(ArrayList<Bike> bikes) {
		
		//	Show all bikes
		seeBikeDesc(bikes);
		
		//	Choose Bike to delete
		int index = 0;
		do {
			index = inputInt("Enter index of Bike to delete: ");
		}while(index < 0 || index >= bikes.size());
		
		bikes.remove(index);
		System.out.println("Bike Deleted!");
	}
	
	private static int inputInt(String prompt) {
		
		boolean validInput = true;
		int value = 0;
		do {
			validInput = true;
			try {
				System.out.println(prompt);
				value = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
				validInput = false;
			}
			finally {
				in.nextLine();
			}
		}while(!validInput);
		
		return value;
	}
	
	private static int inputInt() {
		
		boolean validInput = true;
		int value = 0;
		do {
			validInput = true;
			try {
				value = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
				validInput = false;
			}
			finally {
				in.nextLine();
			}
		}while(!validInput);
		
		return value;
	}
}