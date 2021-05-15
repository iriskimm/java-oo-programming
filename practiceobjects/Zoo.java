package practiceobjects;

public class Zoo {

	public static void main(String[] args) {
	
		Mammal cow = new Mammal("Bessie", 2, 500, "brown", true, true);
		System.out.println(cow.getName());

		Animal chipmunk = new Mammal("Chip", 1, 0.5, "brown", true, true);
		System.out.println(chipmunk.getName());
		
	}
	
}