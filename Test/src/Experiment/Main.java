package Experiment;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		car.TurnOn().Drive();
	}

}

class Car{
	
	public Car Drive() {
		
		System.out.println("The Car is driving");
		return this;
	}
	
	public Car TurnOn() {
		
		System.out.println("The Car is on");
		return this;
	}
	
	public Car TurnOff() {
		
		System.out.println("The Car is off");
		return this;
	}
	
	public Car Stop() {
		
		System.out.println("The Car has stopped");
		return this;
	}
}
