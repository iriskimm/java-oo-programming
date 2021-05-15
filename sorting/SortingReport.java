/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Apr. 1st, 2021
Submit Date: Apr. 1st, 2021
Description: 
- sorts an array using 5 linear based sorting methods and 2 recursive based sorting method
- calculates average time to complete sorting(for 2 cases: worst, random)
- calculates average # of swaps, comparisons, and loop iterations
*/

package sorting;

import java.io.*;
import java.util.Arrays;

public class SortingReport {

	public static void main(String[] args) throws IOException {

		// declare FileWriter & PrintWriter
		FileWriter myWriter = new FileWriter("IrisKimSortingReport.txt");
		PrintWriter myOutput = new PrintWriter(myWriter);

		// declare arrays
		int[] randomArray = { 8, 14, 13, 20, 6, 1, 11, 18, 11, 6, 17, 3, 14, 4, 11 };

		int[] worstArray = { 20, 18, 17, 14, 14, 13, 11, 11, 11, 8, 6, 6, 4, 3, 1 };

		// initialize counts
		int numOfSwaps = 0, loopIterations = 0, comparisons = 0;
		int[] count = { 0, numOfSwaps, loopIterations, comparisons };

		// initializing elements
		int begin = 0;
		int length = (randomArray.length);
		int end = length - 1;
		int mid = 0;
		long[] durationInNano = new long[10];

		////////////////////////////////////////////////////////////
		// BUBBLE SORT
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Bubble Sort");
		myOutput.println("\t- list order: random");
		count = bubbleSort(Array.copyArray(randomArray), myOutput, count);
		// worst case
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Bubble Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		count = bubbleSort(Array.copyArray(worstArray), myOutput, count);

		////////////////////////////////////////////////////////////
		// INSERTION SORT
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Insertion Sort");
		myOutput.println("\t- list order: random");
		count = insertionSort(Array.copyArray(randomArray), myOutput, count);
		
		// worst case
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Insertion Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		count = insertionSort(Array.copyArray(worstArray), myOutput, count);
		

		////////////////////////////////////////////////////////////
		// SELECTION SORT
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Selection Sort");
		myOutput.println("\t- list order: random");
		count = selectionSort(Array.copyArray(randomArray), myOutput, count);

		// worst case
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Selection Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		count = selectionSort(Array.copyArray(worstArray), myOutput, count);


		////////////////////////////////////////////////////////////
		// SHELL SORT
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Shell Sort");
		myOutput.println("\t- list order: random");
		count = shellSort(Array.copyArray(randomArray), myOutput, count);

		
		// worst case
		count = resetCount(count);
		myOutput.println("Sorting Algorithm: Shell Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		count = shellSort(Array.copyArray(worstArray), myOutput, count);
		
		////////////////////////////////////////////////////////////
		// MERGE SORT
		count = resetCount(count);
		for (int runCount = 0; runCount < 10; runCount++) { // runs 10 times to calculate average run time
			long startTime = System.nanoTime();

			mergeSort(Array.copyArray(randomArray), begin, end, count);
			merge(Array.copyArray(randomArray), begin, mid, end, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		} // end for (runCount < 10)

		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;
		
		myOutput.println("Sorting Algorithm: Merge Sort");
		myOutput.println("\t- list order: random");
		myOutput.println("\t- size of list: " + randomArray.length);
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);
		myOutput.println("\t- average time to complete(in nanoseconds): " + calculateAvgTime(durationInNano));
		myOutput.println("----------------------------------------------------------------------------------------");

		// worst case
		count = resetCount(count);
		for (int runCount = 0; runCount < 10; runCount++) { // runs 10 times to calculate average run time
			long startTime = System.nanoTime();

			mergeSort(Array.copyArray(worstArray), begin, end, count);
			merge(Array.copyArray(worstArray), begin, mid, end, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		} // end for (runCount < 10)

		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;
		
		myOutput.println("Sorting Algorithm: Merge Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		myOutput.println("\t- size of list: " + worstArray.length);
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);
		myOutput.println("\t- average time to complete(in nanoseconds): " + calculateAvgTime(durationInNano));
		myOutput.println("----------------------------------------------------------------------------------------");

		////////////////////////////////////////////////////////////
		// COUNTING SORT
		myOutput.println("Sorting Algorithm: Counting Sort");
		myOutput.println("\t- list order: random");
		count = countingSort(Array.copyArray(randomArray), myOutput, count);

		myOutput.println("Sorting Algorithm: Counting Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		count = countingSort(Array.copyArray(worstArray), myOutput, count);

		////////////////////////////////////////////////////////////
		// QUICK SORT
		count = resetCount(count);
		int low = 0;
		int high = randomArray.length - 1;

		for (int runCount = 0; runCount < 10; runCount++) { // runs 10 times to calculate average run time
			long startTime = System.nanoTime();

			count = quickSort(Array.copyArray(randomArray), low, high, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		} // end for (runCount < 10)

		myOutput.println("Sorting Algorithm: Quick Sort");
		myOutput.println("\t- list order: random");
		myOutput.println("\t- size of list: " + worstArray.length);
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + (comparisons + count[3]));
		myOutput.println("\t- average time to complete(in nanoseconds): " + calculateAvgTime(durationInNano));
		myOutput.println("----------------------------------------------------------------------------------------");

		// worst case
		count = resetCount(count);
		low = 0;
		high = worstArray.length - 1;
		for (int runCount = 0; runCount < 10; runCount++) { // runs 10 times to calculate average run time
			long startTime = System.nanoTime();

			count = quickSort(Array.copyArray(worstArray), low, high, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		} // end for (runCount < 10)

		myOutput.println("Sorting Algorithm: Quick Sort");
		myOutput.println("\t- list order: reversed (worst case)");
		myOutput.println("\t- size of list: " + worstArray.length);
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + (comparisons + count[3]));
		myOutput.println("\t- average time to complete(in nanoseconds): " + calculateAvgTime(durationInNano));
		myOutput.println("----------------------------------------------------------------------------------------");

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
	 * Parameter: int[] array, PrintWriter myOutput, int[] count
	 * Return: n/a
	 */
	public static int[] countingSort(int[] array, PrintWriter myOutput, int[] count) {


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

					count[3]++;

					for (int k = 0; k < countingArray[index]; k++) {

						// copys the value into arrayCopy
						if (j < arrayCopy.length) {
							arrayCopy[j] = index + 1;
							j++;
							count[3]++;
							count[1]++;

						} // end if j < arrayCopy.length

						count[2]++;

					} // end for k = 0

				} // end if countingArray[index] > 0

				index++;
				count[2]++;

			} // end for i = min

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		} // end for runCount
		
		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;

		myOutput.println("\t- average time to complete(in nanoseconds): " + calculateAvgTime(durationInNano));
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);
		myOutput.println("----------------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(arrayCopy)); // for testing

		return count;
	} // end countingSort()

	/*
	 * Method name: mergeSort
	 * Author: Iris Kim
	 * Description:
	 * - returns if the list has only 0 or 1 element
	 * - else, divide the array into two sub-arrays & repeat
	 * Parameter: int[] array, int begin, int end, int[] count
	 * Return: count[]
	 */
	public static int[] mergeSort(int[] array, int begin, int end, int[] count) {

		int length = array.length;

		// base case
		if (length == 1 || length == 0) {
			count[3]++;

			return count;
		}

		// recursive call
		else if (begin < end) {

			count[3]++;

			// splits array into 2 subarrays of equal size
			int mid = (begin + end) / 2;
			mergeSort(array, begin, mid, count);
			mergeSort(array, mid + 1, end, count);
			merge(array, begin, mid, end, count);

		}

		return count;

	} // end mergeSort()

	/*
	 * Method name: merge
	 * Author: Iris Kim
	 * Description: takes two sorted arrays and combines them (smaller value comes
	 * first)
	 * Parameter: int[] array, int begin, int mid, int end, int[] count
	 * Return: count[]
	 */
	public static int[] merge(int[] array, int begin, int mid, int end, int[] count) {

		int left = mid - begin + 1;
		int right = end - mid;

		// creates left & right array
		int[] LeftArray = new int[left];
		int[] RightArray = new int[right];

		// fills in left & right array
		for (int i = 0; i < left; i++) {
			LeftArray[i] = array[begin + i];
			count[1]++;
			count[2]++;
			count[3]++;
		}

		for (int j = 0; j < right; j++) {
			RightArray[j] = array[mid + 1 + j];
			count[1]++;
			count[2]++;
			count[3]++;
		}

		// initial indexes of subarrays
		int i = 0, j = 0;
		int k = begin;

		// adds the smaller number to the original array
		while (i < left && j < right) {
			count[3]++;

			if (LeftArray[i] <= RightArray[j]) {
				array[k] = LeftArray[i];
				i++;
				count[3]++;
				count[1]++;
			} // end if
			else {
				array[k] = RightArray[j];
				j++;
				count[1]++;
			} // end else
			k++;

			count[2]++;

		} // end while

		// if only elements in left array are left
		while (i < left) {
			array[k] = LeftArray[i];
			i++;
			k++;

			count[1]++;
			count[2]++;
			count[3]++;

		} // end while

		// if only elements in right array are left
		while (j < right) {
			array[k] = RightArray[j];
			j++;
			k++;

			count[1]++;
			count[2]++;
			count[3]++;

		} // end while

		return count;
	} // end merge()

	/*
	 * Method name:shellSort
	 * Author: Iris Kim
	 * Description:
	 * - sorts every nth values
	 * - divide n by 2, keep sorting until n = 1
	 * Parameter: int[] array, PrintWriter myOutput
	 * Return: n/a
	 */
	public static int[] shellSort(int[] array, PrintWriter myOutput, int[] count) {

		// calculates run time
		long[] durationInNano = new long[10];

		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			// calculates initial shell size
			int log2 = (int) (Math.log(array.length) / Math.log(2));
			int shellsize = (int) Math.pow(2, log2 - 1);

//		System.out.println(shellsize);

			int length = (array.length);

			for (int i = 0; i < length; i++) {

				for (int j = 0; j < length; j++) {

					// repeat until shell size > 0, divide shellsize by 2 every time the loop is
					// repeated
					for (shellsize = (int) Math.pow(2, log2 - 1); shellsize > 0; shellsize /= 2) {

						// swaps values to put them in order
						while (j >= shellsize && array[j - shellsize] > array[i]) {

							int temp = array[j - shellsize];
							array[j - shellsize] = array[i];
							array[i] = temp;

							count[1]++;
							count[2]++;
							count[3]++;

						} // end while

						count[2]++;
					} // end for shellsize

					count[2]++;
				} // end for j = 0

				count[2]++;
			} // end for i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		} // end runCount

		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;

		// prints out to .txt file
		myOutput.println("\t- size of list: " + array.length);
		myOutput.println("\t- after sort: " + Arrays.toString(array));
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);
		myOutput.println("----------------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(array));

		return count;
	} // end shellSort()

	/*
	 * Method name: selectionSort
	 * Author: Iris Kim
	 * Description:
	 * - finds the smallest element from unsorted portion of the list
	 * - puts the smallest element from above to the correct position (in sorted
	 * portion)
	 * Parameter: int[] array, PrintWriter myOutput
	 * Return: n/a
	 */
	public static int[] selectionSort(int[] array, PrintWriter myOutput, int[] count) {

		long[] durationInNano = new long[10];

		// runs the program 10 times to calculate average time
		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			int length = (array.length) - 1; // calculates array length

			for (int i = 0; i < length; i++) {

				int smallest = i; // set first element to "smallest"

				// compares array[smallest] with the next value
				for (int j = i + 1; j < length + 1; j++) {

					count[3]++;

					if (array[j] < array[smallest]) {
						count[3]++;
						smallest = j;
						count[1]++;
					} // end if

					count[2]++;
				} // end for

				// swaps values if there is a smaller value than original "smallest"
				if (smallest != i) {
					count[3]++;
					int temp = array[smallest];
					array[smallest] = array[i];
					array[i] = temp;
					count[1]++;
				} // end if

			} // end for int i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		} // end for runCount

		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;

//		System.out.println(Arrays.toString(array)); // for testing

		// PRINTS OUT to txt. file
		myOutput.println("\t- size of list: " + array.length);
		myOutput.println("\t- after sort: " + Arrays.toString(array));
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);
		
		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);

		myOutput.println("---------------------------------------------------------------------------------");

		return count;
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
	public static int[] insertionSort(int[] array, PrintWriter myOutput, int[] count) {

		long[] durationInNano = new long[10];

		// runs the program 10 times to calculate average time
		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			for (int i = 0; i < (array.length) - 1; i++) {

				// loop from i back to 0
				for (int j = i + 1; j > 0; j--) {

					// swaps values
					if (array[j] < array[j - 1]) {

						count[3]++;

						int temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;

						count[1]++;
					} // end if

					count[2]++;
				} // end for j = i + 1

				count[2]++;
			} // end for i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		}

		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;

		// prints out to txt.file
		myOutput.println("\t- size of list: " + array.length);
		myOutput.println("\t- after sort: " + Arrays.toString(array));
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);
		
		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);

		myOutput.println("---------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(array)); // only for testing

		return count;
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
	public static int[] bubbleSort(int[] array, PrintWriter myOutput, int[] count) {

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
						count[3]++;

						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;

						count[1]++;

					} // end if

					count[2]++;
				} // end for j = 0

				count[2]++;
			} // end for i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		} // end for runCount

		count[1] /= 10;
		count[2] /= 10;
		count[3] /= 10;

		// prints out to .txt file
		myOutput.println("\t- size of list: " + array.length);
		myOutput.println("\t- after sort: " + Arrays.toString(array));
		myOutput.println("\t- number of swaps: " + count[1]);
		myOutput.println("\t- number of loop iterations: " + count[2]);
		myOutput.println("\t- number of comparisons: " + count[3]);

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);

		myOutput.println("---------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(array)); // only for testing

		return count;
	} // end bubbleSort()

	/*
	 * Method name: calculateAvgTime
	 * Author: Iris Kim
	 * Description:
	 * - calculates average run time
	 * Parameter: long[] durationInNano, long total
	 * Return: long[] overage
	 */
	public static long calculateAvgTime(long[] durationInNano) {

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		return average;
	} // end calculateAvgTime()

	/*
	 * Method name: resetCount
	 * Author: Iris Kim
	 * Description:
	 * - reset all elements in count[] to zero
	 * Parameter: int[] count
	 * Return: int[] count
	 */
	public static int[] resetCount(int[] count) {

		count[0] = 0;
		count[1] = 0;
		count[2] = 0;
		count[3] = 0;

		return count;
	} // end resetCount()

} // end class
