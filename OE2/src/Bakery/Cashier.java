package Bakery;

public class Cashier {

	public static void main(String[] args) {
		
		Item[] items = {
				new Bread("Pandesal", 2.00f),
				new Bread("Pande Coco", 5.00f),
				new Drink("Orange Juice", 10.00f),
				new Drink("Water", 10.00f)
		};
		
		System.out.println("Menu");
		
		for(Item item : items) {
			
			System.out.print(item.GetType()+": "+item.GetName()+": Php ");
			System.out.printf("%.2f", item.GetPrice());
			System.out.println();
		}
		
	}

}
