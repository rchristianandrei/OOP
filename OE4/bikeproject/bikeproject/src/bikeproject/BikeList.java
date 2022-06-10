package bikeproject;

import java.util.ArrayList;

public class BikeList {
	
	public static void main(String[] args) {
		
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		int mountainBikeSales, roadBikeSales = 0;
		
		fillArray(bikeList);
		displayStock(bikeList);
		
		displayBikeNumbers(bikeList);
	}
	
	static void fillArray(ArrayList<Bike> bikeList) {
		
	}

	static void displayStock(ArrayList<Bike> bikeList) {
		
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
