package AnimalShop;

public class Bird extends Animal {

	private String habitat;
	private String beak;
	private boolean isDomestic;
	
	public Bird(String breed, String color, String habitat, String beak, boolean isDomestic) {
		
		super(breed, color);
		this.habitat = habitat;
		this.beak = beak;
		this.isDomestic = isDomestic;
	}
	
	public String getHabitat() {
		
		return this.habitat;
	}
	
	public String getBeak() {
		
		return this.beak;
	}
	
	public void PrintAnimal() {
		
		System.out.println("Bird Breed: " + this.breed);
		System.out.println("Bird Color: " + this.color);
		System.out.println("Bird Habitat: " + this.habitat);
		System.out.println("Bird Beak: " + this.beak);
	}
}
