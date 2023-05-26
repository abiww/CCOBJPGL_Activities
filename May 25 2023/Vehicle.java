
//this is the base class that represents all TRANSPORTATION
public class Vehicle {
	private int speed;
	private String color;
	private double price;
	
	//constructor of vehicle class
	Vehicle(int speed, String color, double price) {
		this.speed = speed;
		this.color = color;
		this.price = price;
	}
	
	//method
	public void stop () {
		System.out.println("Stopping...");
	}
}
