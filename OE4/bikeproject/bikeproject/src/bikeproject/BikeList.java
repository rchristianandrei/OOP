package bikeproject;

import java.util.ArrayList;
import java.util.Random;

public class BikeList {
	
	public static void main(String[] args) {
		
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		int mountainBikeSales, roadBikeSales = 0;
		
		fillArray(bikeList);
		displayStock(bikeList);
		System.out.println();
		displayBikeNumbers(bikeList);
	}
	
	static void fillArray(ArrayList<Bike> bikeList) {
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {	
			int choice = random.nextInt(0,2);
			
			switch(choice) {
				case 0: bikeList.add(new MountainBike()); break;
				case 1: bikeList.add(new RoadBike()); break;
			}
		}
	}

	static void displayStock(ArrayList<Bike> bikeList) {
		
		for(Bike bike : bikeList) {
			bike.printDescription();
		}
	}
	
	static int calculateStock(ArrayList<Bike> bikeList) {
		int bikesSold = 0;
		
		for(Bike bike : bikeList) {
			if(bike instanceof MountainBike) {
				bikesSold++;
			}
		}
		
		return bikesSold;
	}
	
	static int displayBikeNumbers(ArrayList<Bike> bikeList) {
		
		int mb = calculateStock(bikeList);
		int rb = bikeList.size() - mb;
		
		System.out.println("Stock Levels");
		System.out.println("We have "+mb+" Mountain Bikes in stock");
		System.out.println("We have "+rb+" Road Bikes in stock");
		
		return bikeList.size();
	}
}
