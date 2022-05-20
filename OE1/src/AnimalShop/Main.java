package AnimalShop;

public class Main {

	public static void main(String[] args) {
		
		Animal[] animals = {
				
			new Cat("Persian", "White", 2, true, false),
			new Cat("Ragdoll", "Brown", 1, false, true),
			new Bird("American Pekin", "White", "Pond", "Pointy"),
			new Bird("Red Factor Canary", "Red", "Native Region", "Short"),
			new Dog("Bulldog", "Brown", true, 5.5),
			new Dog("Poodle", "Black", true, 4.7)
		};
		
		for(Animal animal : animals) {
			
			animal.PrintAnimal();
			System.out.println();
		}
	}

}
