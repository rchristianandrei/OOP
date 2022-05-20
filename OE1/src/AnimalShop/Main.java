package AnimalShop;

public class Main {

	public static void main(String[] args) {
		
		Animal[] animals = {
				
			new Cat("Persian", "White", true, false),
			new Cat("Ragdoll", "Brown", false, true),
			new Bird("American Pekin", "White", "Pond", "Pointy"),
			new Bird("Red Factor Canary", "Red", "Native Region", "Short"),
			new Dog("Bulldog", "Brown", true, 5.5),
			new Dog("Poodle", "Black", true, 4.7),
			new Fish("Koi", "Red", 1, 0.5),
			new Fish("Comet", "Yellow", 1, 0.2)
		};
		
		for(Animal animal : animals) {
			
			animal.PrintAnimal();
			System.out.println();
		}
	}

}
