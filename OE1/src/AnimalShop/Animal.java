package AnimalShop;

public class Animal {
	
	protected String breed, color;
	
	public Animal(String breed, String color) {
		
		this.breed = breed;
		this.color = color;
	}
	
	public String getBreed() {
		
		return this.breed;
	}
	
	public String getColor() {
		
		return this.color;
	}
	
	public void PrintAnimal() {
		
		System.out.println("Bird Breed: " + this.breed);
		System.out.println("Bird Color: " + this.color);
	}
}
