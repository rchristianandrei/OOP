package AnimalShop;

public class Cat extends Animal {
	
	private int age;
	private boolean isFriendly;
	
	public Cat(String breed, String color, int age, boolean isFriendly) {
		
		super(breed, color);
		this.age = age;
		this.isFriendly = isFriendly;
	}
	
	public int GetAge() {
		
		return this.age;
	}
	
	public boolean GetIsFriendly() {
		
		return this.isFriendly;
	}
	
	public void PrintAnimal() {
		
		super.PrintAnimal();
		System.out.println("Cat Age: " + this.age);
		System.out.println("Cat isFriendly?: " + this.isFriendly);
	}
}
