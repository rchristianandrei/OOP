package AnimalShop;

public class Cat extends Animal {
	
	private int age;
	private boolean isFriendly;
	private boolean isMale;
	
	public Cat(String breed, String color, int age, boolean isFriendly, boolean isMale) {
		
		super(breed, color);
		this.age = age;
		this.isFriendly = isFriendly;
		this.isMale = isMale; 
	}
	
	public int GetAge() {
		
		return this.age;
	}
	
	public boolean GetIsFriendly() {
		
		return this.isFriendly;
	}
	
	public void PrintAnimal() {
		
		System.out.println("Cat Breed: " + this.breed);
		System.out.println("Cat Color: " + this.color);
		System.out.println("Cat Age: " + this.age);
		System.out.println("Cat isFriendly?: " + this.isFriendly);
		System.out.println("Cat isMale?: " + this.isMale);
	}
}