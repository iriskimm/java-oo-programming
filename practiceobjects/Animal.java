package practiceobjects;

public class Animal {

	private String name;
	private int age;
	private double weight;

	public Animal(String n, int a, double w) {
		this.setName(n);
		this.setAge(a);
		this.setWeight(w);
	}

	public void PrintInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Weight: " + this.weight);
	}
	
	public void setWeight(double w) {
		this.weight = w;
	}

	public double getWeight() {
		return this.weight;
	}
	
	public void setAge(int a) {
		this.age = a;
	}
	
	public int getAge() {
		return this.age;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return this.name;
	}

} // end class
