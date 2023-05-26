
//superclass
class Boat extends Vehicle {
	
	//returns all objects that represent the base class
	Boat(int speed, String color, double price) {
		super(speed, color, price); 
	}

}

//subclass of boat
class Fandango_Yatch extends Boat {
	private String mainSailColor;
	
	Fandango_Yatch(int speed, String color, double price, String mainSailColor) {
		super(speed, color, price);
		this.mainSailColor = mainSailColor;
	}

	public void floating() {
		System.out.println("Floating...");
	}
	
	@Override
	public void stop () { //overriding stop method
		System.out.println("Fandango Yatch is stopping...");
	}
}
