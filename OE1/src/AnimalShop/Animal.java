package AnimalShop;

public class Animal {
	
	protected String breed, color;
	
	public Animal(String breed, String color) {
		
		this.breed = breed;
		this.color = color;
	}
	
	public void PrintAnimal() {
		
		System.out.println("Animal Breed: " + this.breed);
		System.out.println("Animal Color: " + this.color);
	}
}
