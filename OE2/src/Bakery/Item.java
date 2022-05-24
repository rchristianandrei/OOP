package Bakery;

public abstract class Item implements Getter {
	
	private String name;
	private float price;
	private String type;
	
	protected Item(String name, float price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public float GetPrice() {
		return this.price;
	}
	
	public String GetType() {
		return this.type;
	}
}
