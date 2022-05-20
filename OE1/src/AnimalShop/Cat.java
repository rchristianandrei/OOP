package AnimalShop;

public class Cat extends Animal {
	
	private boolean isFriendly;
	private boolean isMale;
	
	public Cat(String breed, String color, boolean isFriendly, boolean isMale) {
		
		super(breed, color);
		this.isFriendly = isFriendly;
		this.isMale = isMale;
	}
	
	public void PrintAnimal() {
		
		System.out.println("Cat Breed: " + this.breed);
		System.out.println("Cat Color: " + this.color);
		System.out.println("Cat isFriendly?: " + this.isFriendly);
		System.out.println("Cat isMale?: " + this.isMale);
	}
}
