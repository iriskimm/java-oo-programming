package practiceobjects;

import java.io.*;

public class TestRectangle {

	public static void main(String[] args) throws IOException {

		FileWriter myWriter = new FileWriter("Rectangle.txt");
		PrintWriter myOutput = new PrintWriter(myWriter);

		Rectangle rect1 = new Rectangle(5, 10, "Red");
		double area1 = rect1.calcArea();
		double perimeter1 = rect1.calcPerimeter();

		Rectangle rect2 = new Rectangle(10, 20, "Yellow");
		double area2 = rect2.calcArea();
		double perimeter2 = rect2.calcPerimeter();

		Rectangle rect3 = new Rectangle(30, 40, "Blue");
		double area3 = rect3.calcArea();
		double perimeter3 = rect3.calcPerimeter();

		myOutput.println("Rectangle 1: ");
		myOutput.println("Length: ");
		myOutput.println(rect1.getLength());
		myOutput.println("Width: ");
		myOutput.println(rect1.getWidth());
		myOutput.println("Colour: ");
		myOutput.println(rect1.getColour());
		myOutput.println("Area: ");
		myOutput.println(area1);
		myOutput.println("Perimeter: ");
		myOutput.println(perimeter1);

		myOutput.println("\nRectangle 2: ");
		myOutput.println("Length: ");
		myOutput.println(rect2.getLength());
		myOutput.println("Width: ");
		myOutput.println(rect2.getWidth());
		myOutput.println("Colour: ");
		myOutput.println(rect2.getColour());
		myOutput.println("Area: ");
		myOutput.println(area2);
		myOutput.println("Perimeter: ");
		myOutput.println(perimeter2);

		myOutput.println("\nRectangle 3: ");
		myOutput.println("Length: ");
		myOutput.println(rect3.getLength());
		myOutput.println("Width: ");
		myOutput.println(rect3.getWidth());
		myOutput.println("Colour: ");
		myOutput.println(rect3.getColour());
		myOutput.println("Area: ");
		myOutput.println(area3);
		myOutput.println("Perimeter: ");
		myOutput.println(perimeter3);

		myOutput.close();

	} // end main

}
