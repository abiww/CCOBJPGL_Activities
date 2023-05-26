
//superclass
class Car extends Vehicle {

	//returns all objects that represent the base class
	Car(int speed, String color, double price) {
		super(speed, color, price); 
	}
}

//subclass of car
class Toyota_Vios extends Car {
	private String tire;
	
	Toyota_Vios(int speed, String color, double price, String tire) {
		super(speed, color, price);
		this.tire = tire;
	}
	
	public String getTire() {
		return tire;
	}

	public void printInfo() {
		
	}
  
	public void drive() {
		System.out.println("Driving...");
	}
	
	@Override 
	public void stop () { //overriding stop method
		System.out.println("Toyota Vios is stopping..."); 
	}
}
