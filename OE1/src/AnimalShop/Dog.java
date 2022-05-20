package AnimalShop;

public class Dog extends Animal {

	private boolean isDomestic;
	private double weigth;
	
	public Dog(String breed, String color, boolean isDomestic, double weigth) {
		
		super(breed, color);
		this.isDomestic = isDomestic;
		this.weigth = weigth;
	}

	public void PrintAnimal() {
		
		System.out.println("Dog Breed: " + this.breed);
		System.out.println("Dog Color: " + this.color);
		System.out.println("Dog isDomestic: " + this.isDomestic);
		System.out.println("Dog Weight: " + this.weigth);
	}
}
