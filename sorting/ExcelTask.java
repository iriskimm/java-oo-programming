/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Apr. 1st, 2021
Submit Date: 
Description: 
- sorts an array using one linear based sorting method and 1 recursive based sorting method
- calculates average time to complete sorting when using each sorting method
*/

package sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ExcelTask {

	public static void main(String[] args) throws IOException {

		// declare FileWriter & PrintWriter
		FileWriter myWriter = new FileWriter("IrisKimSortingExcel.txt");
		PrintWriter myOutput = new PrintWriter(myWriter);

		// initializes arrays
		int[] randomArray = Array.createRandomIntArray(8, 1, 12);

		int[] worstCase = { 12, 8, 8, 5, 3, 2, 1, 1 };

		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		// COUNTING SORT
		myOutput.println("Sorting Algorithm: Counting Sort");
		myOutput.println("\t- list order: random");
		countingSort(Array.copyArray(randomArray), myOutput);

		myOutput.println("Sorting Algorithm: Counting Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		countingSort(Array.copyArray(worstCase), myOutput);

		int numOfSwaps = 0, loopIterations = 0, comparisons = 0;
		int[] count = { 0, numOfSwaps, loopIterations, comparisons };

		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		// QUICK SORT (RANDOM ARRAY)
		int low = 0;
		int high = randomArray.length - 1;

		// runs the program 10 times to calculate average time
		long[] durationInNano = new long[10];

		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			count = quickSort(Array.copyArray(randomArray), low, high, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		} // end for runCount

		long total = 0;

		// calculates average run time
		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
			loopIterations++;
		}

		long average = total / durationInNano.length;

		// prints out to .txt file
		myOutput.println("Sorting Algorithm: Quick Sort");
		myOutput.println("\t- list order: random");
		myOutput.println("\t- average time to complete(in nanoseconds): " + average);
		myOutput.println("\t- size of list: " + randomArray.length);
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + (comparisons + count[3]));
		myOutput.println("----------------------------------------------------------------------------------------");

		//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////
		// QUICK SORT (WORST CASE)
		low = 0;
		high = worstCase.length - 1;

		// runs the program 10 times to calculate average time
		durationInNano = new long[10];

		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			count = quickSort(Array.copyArray(worstCase), low, high, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		} // end for runCount

		total = 0;

		// calculates average run time
		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
			loopIterations++;
		}

		average = total / durationInNano.length;

		// prints out to .txt file
		myOutput.println("Sorting Algorithm: Quick Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		myOutput.println("\t- average time to complete(in nanoseconds): " + average);
		myOutput.println("\t- size of list: " + worstCase.length);
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + (comparisons + count[3]));

		// close PrintWriter myOutput
		myOutput.close();

	} // end main

	/*
	 * Method quickSort
	 * Author: Iris Kim
	 * Description:
	 * - uses a pivot point to split the list into two partitions
	 * Parameter: int arr[], int low, int high, int[] count
	 * Return: count[]
	 */
	public static int[] quickSort(int arr[], int low, int high, int[] count) {
		if (low < high) {

			count[3]++; // increase comparisons

			count = partition(arr, low, high, count);

			int pivot = count[0]; // count[0] is j + 1 from quickSort()

			// recursion methods
			quickSort(arr, low, pivot - 1, count);
			quickSort(arr, pivot + 1, high, count);
		}

//		System.out.println("\t- after sort: " + Arrays.toString(arr)); // testing

		return count;
	} // end quickSort()

	/*
	 * Method partition
	 * Author: Iris Kim
	 * Description:
	 * - sorts a list to items that are lower/higher than a chosen value in the
	 * array
	 * Parameter: int arr[], int low, int high, int[] count
	 * Return: count[]
	 */
	public static int[] partition(int arr[], int low, int high, int[] count) {

		// choosing pivot to be the last element in the array
		int pivot = arr[high];

		// splits the list at index j
		int j = (low - 1);

		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				// increment smaller index by 1
				j++;
				count[3]++; // increase comparisons

				// swaps smaller index with i
				int swapTemp = arr[j];
				arr[j] = arr[i];
				arr[i] = swapTemp;

				count[1]++; // increase numOfSwaps
			}

			count[2]++; // increase loopIterations
		}

		// swap (j+1) with high
		int swapTemp = arr[j + 1];
		arr[j + 1] = arr[high];
		arr[high] = swapTemp;

		count[1]++;

		count[0] = j + 1;

		// returning (j+1)
		return count;
	} // end partition()

	/*
	 * Method countingSort
	 * Author: Iris Kim
	 * Description:
	 * - counts the number of each element's occurrence -> store them in an array
	 * - copy the values into a new array
	 * Parameter: int[] array, PrintWriter myOutput
	 * Return: n/a
	 */
	public static void countingSort(int[] array, PrintWriter myOutput) {

		// initializes variables
		int numOfSwaps = 0;
		int loopIterations = 0;
		int comparisons = 0;

		long[] durationInNano = new long[10];
		int[] arrayCopy = Array.copyArray(array);

		// runs the program 10 times to calculate average time
		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			// find max and min to set size & range
			int max = Array.findMax(array);
			int min = Array.findMin(array);
			int[] countingArray = new int[max - min + 1];

			int index = 0;
			int j = 0;

			// search for values in range (min < x < max)
			for (int i = min; i < max + 1; i++) {

				// counts the number of element's occurence
				int numOfElements = Array.countElements(array, i);
				countingArray[index] = numOfElements;

				// if there is an occurence of the value
				if (countingArray[index] > 0) {

					comparisons++;

					for (int k = 0; k < countingArray[index]; k++) {

						// copys the value into arrayCopy
						if (j < arrayCopy.length) {
							arrayCopy[j] = index + 1;
							j++;
							comparisons++;
							numOfSwaps++;

						} // end if j < arrayCopy.length

						loopIterations++;

					} // end for k = 0

				} // end if countingArray[index] > 0

				index++;
				loopIterations++;

			} // end for i = min

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		} // end for runCount

		myOutput.println("\t- size of list: 9");
		myOutput.println("\t- after sort: " + Arrays.toString(arrayCopy));

		long total = 0;

		// calculates average run time
		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
			loopIterations++;
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);
		myOutput.println("\t- number of swaps: " + numOfSwaps);
		myOutput.println("\t- number of loop iterations: " + loopIterations);
		myOutput.println("\t- number of comparisons: " + comparisons);
		myOutput.println("----------------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(arrayCopy)); // for testing

	} // end countingSort()

} // end ExcelTask
