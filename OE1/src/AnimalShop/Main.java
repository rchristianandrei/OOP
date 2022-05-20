package AnimalShop;

public class Main {

	public static void main(String[] args) {
		
		Animal[] animals = {
				
				new Cat("Persian", "White", 2, true),
				new Cat("Ragdoll", "Brown", 1, false),
				new Bird("American Pekin", "White", "Pond", "Pointy"),
				new Bird("Red Factor Canary", "Red", "Native Region", "Short")
		};
		
		for(Animal animal : animals) {
			
			animal.PrintAnimal();
			System.out.println();
		}
	}

}
