package AnimalShop;

public class Fish extends Animal {

	private int age;
	private double size;
	
	public Fish(String breed, String color, int age, double size) {
		
		super(breed, color);
		this.age = age;
		this.size = size;
	}
	
	public void PrintAnimal() {
		
		System.out.println("Fish Breed: " + this.breed);
		System.out.println("Fish Color: " + this.color);
		System.out.println("Fish Age: " + this.age);
		System.out.println("Fish Size: " + this.size + " m");
	}
}
