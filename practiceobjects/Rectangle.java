package practiceobjects;

public class Rectangle {

	private double Length;
	private double Width;
	private String Colour;

	public Rectangle(double stLength, double stWidth, String stColour) {
		this.setLength(stLength);
		this.setWidth(stWidth);
		this.setColour(stColour);
	}

	public double getLength() {
		return this.Length;
	}

	public void setLength(double length) {
		this.Length = length;
	}

	public double getWidth() {
		return this.Width;
	}

	public void setWidth(double width) {
		this.Width = width;
	}

	public String getColour() {
		return this.Colour;
	}

	public void setColour(String colour) {
		this.Colour = colour;
	}

	public double calcArea() {
		double area = (this.Length * this.Width);
		return area;
	}
	
	public double calcPerimeter() {
		double perimeter = (this.Length * 2) + (this.Width * 2);
		return perimeter;
	}

} // end class Rectangle
