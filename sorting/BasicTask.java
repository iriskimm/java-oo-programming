/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 25th, 2021
Submit Date: Mar. 29th, 2021
Description: 
- sorts an array using three different linear based sorting methods
- calculates average time to complete sorting when using each sorting method
*/

package sorting;

import java.io.*;
import java.util.Arrays;

public class BasicTask {

	public static void main(String[] args) throws IOException {

		// declare FileWriter & PrintWriter
		FileWriter myWriter = new FileWriter("IrisKimSortingBasic.txt");
		PrintWriter myOutput = new PrintWriter(myWriter);

		// declare originalArray
		int[] originalArray = { 5, 1, 9, 7, 13, 4, 6, 2 };

		// calling methods
		bubbleSort(Array.copyArray(originalArray), myOutput);
		insertionSort(Array.copyArray(originalArray), myOutput);
		selectionSort(Array.copyArray(originalArray), myOutput);

		// close PrintWriter myOutput
		myOutput.close();

	} // end main

	/*
	 * Method name: selectionSort
	 * Author: Iris Kim
	 * Description: 
	 * - finds the smallest element from unsorted portion of the list 
	 * - puts the smallest element from above to the correct position (in sorted portion)
	 * Parameter: int[] array, PrintWriter myOutput
	 * Return: n/a
	 */
	public static void selectionSort(int[] array, PrintWriter myOutput) {

		long[] durationInNano = new long[10];

		// runs the program 10 times to calculate average time
		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			int length = (array.length) - 1; // calculates array length

			for (int i = 0; i < length; i++) {

				int smallest = i; // set first element to "smallest"

				// compares array[smallest] with the next value
				for (int j = i + 1; j < length + 1; j++) {
					
					if (array[j] < array[smallest]) {
						smallest = j;
					} // end if

				} // end for

				// swaps values if there is a smaller value than original "smallest" 
				if (smallest != i) {
					int temp = array[smallest];
					array[smallest] = array[i];
					array[i] = temp;
				} // end if

			} // end for int i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		}

//		System.out.println(Arrays.toString(array)); // for testing

		// PRINTS OUT to txt. file
		myOutput.println("Sorting Algorithm: Selection Sort");
		myOutput.println("\t- starts with: the data in random order; { 5, 1, 9, 7, 13, 4, 6, 2 }");
		myOutput.println("\t- size of list: 8");
		myOutput.println("\t- after sort: " + Arrays.toString(array));

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);

		myOutput.println("---------------------------------------------------------------------------------");

	} // end selectionSort()

	/*
	 * Method name: insertionSort
	 * Author: Iris Kim
	 * Description: 
	 * - compares values in turn, starting at the beginning of the list
	 * - the values are shifted to left until it meets a smaller value
	 * Parameter: int[] array, PrintWriter myOutput
	 * Return: n/a
	 */
	public static void insertionSort(int[] array, PrintWriter myOutput) {

		long[] durationInNano = new long[10];

		// runs the program 10 times to calculate average time
		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			for (int i = 0; i < (array.length) - 1; i++) {

				// loop from i back to 0 
				for (int j = i + 1; j > 0; j--) {

					// swaps values
					if (array[j] < array[j - 1]) {

						int temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;

					} // end if

				} // end for j = i + 1

			} // end for i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		}

		// prints out to txt.file
		myOutput.println("Sorting Algorithm: Insertion Sort");
		myOutput.println("\t- starts with: the data in random order; { 5, 1, 9, 7, 13, 4, 6, 2 }");
		myOutput.println("\t- size of list: 8");
		myOutput.println("\t- after sort: " + Arrays.toString(array));

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);

		myOutput.println("---------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(array)); // only for testing

	} // end insertionSort()

	/*
	 * Method name: bubbleSort
	 * Author: Iris Kim
	 * Description: 
	 * - compares two adjacent elements in turn, swap if needed to put them in order
	 * - double loop to compare each and every elements
	 * Parameter: int[] array, PrintWriter myOutput
	 * Return: n/a
	 */
	public static void bubbleSort(int[] array, PrintWriter myOutput) {

		long[] durationInNano = new long[10];

		// runs the program 10 times to calculate average time
		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			int length = (array.length) - 1;

			// double loop to keep comparing adjacent elements after each round
			for (int i = 0; i < length; i++) {

				for (int j = 0; j < length - i; j++) {

					// if values are not in order, swap
					if (array[j] > array[j + 1]) {

						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;

					} // end if

				} // end for j = 0

			} // end for i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		}

		// prints out to .txt file
		myOutput.println("Sorting Algorithm: Bubble Sort");
		myOutput.println("\t- starts with: the data in random order; { 5, 1, 9, 7, 13, 4, 6, 2 }");
		myOutput.println("\t- size of list: 8");
		myOutput.println("\t- after sort: " + Arrays.toString(array));

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);

		myOutput.println("---------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(array)); // only for testing

	} // end bubbleSort()

} // end class
