package AnimalShop;

public class Bird extends Animal {

	private String habitat;
	private String beak;
	
	public Bird(String breed, String color, String habitat, String beak) {
		
		super(breed, color);
		this.habitat = habitat;
		this.beak = beak;
	}
	
	public String getHabitat() {
		
		return this.habitat;
	}
	
	public String getBeak() {
		
		return this.beak;
	}
	
	public void PrintAnimal() {
		
		super.PrintAnimal();
		System.out.println("Bird Habitat: " + this.habitat);
		System.out.println("Bird Beak: " + this.beak);
	}
}
