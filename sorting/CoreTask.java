/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 26th, 2021
Submit Date: Mar. 29th, 2021
Description: 
- sorts an array using one linear based sorting method and one recursive based sorting method
- calculates average time to complete sorting when using each sorting method
*/

package sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CoreTask {

	public static void main(String[] args) throws IOException {

		// declare FileWriter & PrintWriter
		FileWriter myWriter = new FileWriter("IrisKimSortingCore.txt");
		PrintWriter myOutput = new PrintWriter(myWriter);

		// initializes array
		int[] originalArray = Array.createRandomIntArray(100, 1, 6);
		int begin = 0;
		int length = (originalArray.length);
		int end = length - 1;
		int mid = 0;

		// calls method shellSort()
		shellSort(Array.copyArray(originalArray), myOutput);

		int numOfSwaps = 0, loopIterations = 0, comparisons = 0;
		int[] count = { numOfSwaps, loopIterations, comparisons };

		// calls method mergeSort() and merge()
		// runs these methods 10 times to calculate average time
		long[] durationInNano = new long[10];

		for (int runCount = 0; runCount < 10; runCount++) {

			long startTime = System.nanoTime();

			mergeSort(originalArray, begin, end, numOfSwaps, loopIterations, comparisons, count);
			merge(originalArray, begin, mid, end, numOfSwaps, loopIterations, comparisons, count);

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);
		}

		// prints out to .txt file
		myOutput.println("Sorting Algorithm: Merge Sort");
		myOutput.println("\t- list order: random");
		myOutput.println("\t- size of list: 10");
		myOutput.println("\t- after sort: " + Arrays.toString(originalArray));
		myOutput.println("\t- number of swaps: " + count[0]);
		myOutput.println("\t- number of loop iterations: " + count[1]);
		myOutput.println("\t- number of comparisons: " + (comparisons + count[2]));

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);
		myOutput.println("----------------------------------------------------------------------------------------");

		// close PrintWriter myOutput
		myOutput.close();

	} // end main

	/*
	 * Method name: mergeSort
	 * Author: Iris Kim
	 * Description:
	 * - returns if the list has only 0 or 1 element
	 * - else, divide the array into two sub-arrays & repeat
	 * Parameter: int[] array, int begin, int end, int numOfSwaps, int loopIterations, int comparisons, int[] count
	 * Return: count[]
	 */
	public static int[] mergeSort(int[] array, int begin, int end, int numOfSwaps, int loopIterations, int comparisons,
			int[] count) {

		int length = array.length;

		// base case
		if (length == 1 || length == 0) {
			comparisons++;

			return count;
		}

		// recursive call
		else if (begin < end) {

			comparisons++;

			// splits array into 2 subarrays of equal size
			int mid = (begin + end) / 2;
			mergeSort(array, begin, mid, numOfSwaps, loopIterations, comparisons, count);
			mergeSort(array, mid + 1, end, numOfSwaps, loopIterations, comparisons, count);
			merge(array, begin, mid, end, numOfSwaps, loopIterations, comparisons, count);

		}

		count[0] = numOfSwaps;
		count[1] = loopIterations;
		count[2] = comparisons;

		return count;

	} // end mergeSort()

	/*
	 * Method name: merge
	 * Author: Iris Kim
	 * Description: takes two sorted arrays and combines them (smaller value comes
	 * first)
	 * Parameter: int[] array, int begin, int mid, int end, int numOfSwaps, int loopIterations, int comparisons, int[] count
	 * Return: count[]
	 */
	public static int[] merge(int[] array, int begin, int mid, int end, int numOfSwaps, int loopIterations,
			int comparisons, int[] count) {

		int left = mid - begin + 1;
		int right = end - mid;

		// creates left & right array
		int[] LeftArray = new int[left];
		int[] RightArray = new int[right];

		// fills in left & right array
		for (int i = 0; i < left; i++) {
			LeftArray[i] = array[begin + i];
			loopIterations++;
			comparisons++;
			numOfSwaps++;
		}

		for (int j = 0; j < right; j++) {
			RightArray[j] = array[mid + 1 + j];
			loopIterations++;
			comparisons++;
			numOfSwaps++;
		}

		// initial indexes of subarrays
		int i = 0, j = 0;
		int k = begin;

		// adds the smaller number to the original array
		while (i < left && j < right) {
			comparisons++;

			if (LeftArray[i] <= RightArray[j]) {
				array[k] = LeftArray[i];
				i++;
				comparisons++;
				numOfSwaps++;
			} // end if
			else {
				array[k] = RightArray[j];
				j++;
				numOfSwaps++;
			} // end else
			k++;

			loopIterations++;

		} // end while

		// if only elements in left array are left
		while (i < left) {
			array[k] = LeftArray[i];
			i++;
			k++;

			loopIterations++;
			comparisons++;
			numOfSwaps++;

		} // end while

		// if only elements in right array are left
		while (j < right) {
			array[k] = RightArray[j];
			j++;
			k++;

			loopIterations++;
			comparisons++;
			numOfSwaps++;

		} // end while

		count[0] = numOfSwaps;
		count[1] = loopIterations;
		count[2] = comparisons;

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
	public static void shellSort(int[] array, PrintWriter myOutput) {

		// initializes variables
		int numOfSwaps = 0;
		int loopIterations = 0;
		int comparisons = 0;

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

							numOfSwaps++;
							loopIterations++;
							comparisons++;

						} // end while

						loopIterations++;
					} // end for shellsize

					loopIterations++;
				} // end for j = 0

				loopIterations++;
			} // end for i = 0

			long endTime = System.nanoTime();

			// calculates run time
			durationInNano[runCount] = (endTime - startTime);

		}

		// prints out to .txt file
		myOutput.println("Sorting Algorithm: Shell Sort");
		myOutput.println("\t- list order: random");
		myOutput.println("\t- size of list: 10");
		myOutput.println("\t- after sort: " + Arrays.toString(array));
		myOutput.println("\t- number of swaps: " + numOfSwaps);
		myOutput.println("\t- number of loop iterations: " + loopIterations);
		myOutput.println("\t- number of comparisons: " + comparisons);

		// calculates average run time
		long total = 0;

		for (int i = 0; i < durationInNano.length; i++) {
			total = total + durationInNano[i];
		}

		long average = total / durationInNano.length;

		myOutput.println("\t- average time to complete(in nanoseconds): " + average);
		myOutput.println("----------------------------------------------------------------------------------------");

//		System.out.println(Arrays.toString(array));

	} // end shellSort()

} // end class
