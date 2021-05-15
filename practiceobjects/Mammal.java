package practiceobjects;

public class Mammal extends Animal {

	String furColour;
	boolean land;
	boolean herbivore;
	
	public Mammal (String s, int a, double w, String f, boolean l, boolean h) {
		
		super(s,a,w);
		this.furColour = f;
		this.land = l;
		this.herbivore = h;

		
	}
	
	public void PrintInfo() {
		super.PrintInfo();
		System.out.println("Fur: " + this.furColour);
	}
	
} // end class
