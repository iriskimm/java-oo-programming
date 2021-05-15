package practiceobjects;

import java.io.*;

public class RectangleInput {

	public static void main(String[] args) throws IOException {

		FileReader myReader = new FileReader("Rectangle.txt");
		BufferedReader fileInput = new BufferedReader(myReader);

		// makes arrays to store rectangle info
		String[] colour = new String[3];
		double[] length = new double[3]; // 3, 15, 27
		double[] width = new double[3]; // 5, 17, 29
		double[] area = new double[3];
		double[] perimeter = new double[3];
		String[] temp = new String[35];
		int j = 0, k = 0, l = 0, m = 0, n = 0;

		// stores rectangle info in arrays by each category
		for (int i = 0; i < 35; i++) {

			if (((i + 12) % 12) == 2) {
				temp[i] = fileInput.readLine();
				length[j] = Double.valueOf(temp[i]);
				j++;
			} // end if % 12 == 2

			else if (((i + 12) % 12) == 4) {
				temp[i] = fileInput.readLine();
				width[k] = Double.valueOf(temp[i]);
				k++;
			} // end else if % 12 == 4

			else if (((i + 12) % 12) == 6) {
				temp[i] = fileInput.readLine();
				colour[l] = temp[i];
				l++;
			} // end else if % 12 == 6

			else if (((i + 12) % 12) == 8) {
				temp[i] = fileInput.readLine();
				area[m] = Double.valueOf(temp[i]);
				m++;
			} // end else if % 12 == 8

			else if (((i + 12) % 12) == 10) {
				temp[i] = fileInput.readLine();
				perimeter[n] = Double.valueOf(temp[i]);
				n++;
			} // end else if % 12 == 10

			else {
				temp[i] = fileInput.readLine();
			} // end else

		} // end for loop

		System.out.println("Length: " + length[0] + ", " + length[1] + ", " + length[2]);
		System.out.println("Width: " + width[0] + ", " + width[1] + ", " + width[2]);
		System.out.println("Colour: " + colour[0] + ", " + colour[1] + ", " + colour[2]);
		System.out.println("Area: " + area[0] + ", " + area[1] + ", " + area[2]);
		System.out.println("Perimeter: " + perimeter[0] + ", " + perimeter[1] + ", " + perimeter[2]);

		fileInput.close();

	} // end main
} // end class
