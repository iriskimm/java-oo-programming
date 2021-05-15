/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Feb. 3rd, 2021
Submit Date: Mar. 2nd, 2021
Description: contains methods that can create new arrays or makes changes to an existing array 
*/

package sorting;

import java.util.*;
import java.io.PrintWriter;

public class Array {

	public static void main(String[] args) {

		// initializes values
		int size = 4;
		int[] newArray = new int[size];
		int min = 0;
		int max = 5;
		int position1 = 0;
		int position2 = 3;
		int position = 0;
		int value = 3;
		int numOfElements;
		int[] array2 = new int[size];
		boolean isCopy;
		boolean identical;
		int newValue = 7;
		String[] arrayReverse = new String[size];

		
		
		// returns empty array of size indicated
		createEmptyIntArray(size);
		createEmptyStringArray(size);

		// returns array with random integers between min and max
		newArray = createRandomIntArray(4, 0, 5);

		// returns array filled with integers entered by the user
		createUserDefinedArray(size);

		// prints each element in the array (one in each line)
		print(newArray);

		// returns position of the max value in the array
		findMax(newArray);

		// returns position of the min value in the array
		findMin(newArray);

		// swaps the values at index position1 with index position2
		swapElements(newArray, 0, 3);

		// returns position of when the value first appears
		findElement(newArray, value);

		// returns the number of times the value is found in the array
		countElements(newArray, value);

		// returns a copy of the original array
		copyArray(newArray);

		// compares two arrays to see if they contain same values
		checkIfCopy(newArray, array2);

		// compares two arrays to see if they are identical
		checkIfIdentical(newArray, array2);

		// replaces array[position] with the indicated value
		replaceElement(newArray, value, position);

		// replaces all elements of the original value with the new value
		replaceElements(newArray, value, newValue);

		// creates a new array with one extra value at index "position"
		insertElementByIndex(newArray, value, position);

		// creates a new array with one less value (element of value removed)
		deleteElementByValue(newArray, value);

		// creates a new array with one less value (element at position removed)
		deleteElementByIndex(newArray, position);

		// creates a new array with values from original array sorted from low to high
		sortLowToHigh(newArray);

		// creates a new array with values from original array sorted from high to low
		sortHighToLow(newArray);

		// reverse the order of values in an array
		reverse(arrayReverse);

	} // end main method

	/*
	 * Mrs. McCaffery
	 * Method Name: printArrayToFile
	 * Description: Prints each element in an array to a file on a single line,
	 * separated by commas
	 * Parameters:
	 * - PrintWriter: the printWriter variable tells the method where to print
	 * - String []: the array containing the elements to be printed
	 * Returns: n/a
	 */
	public static void printArrayToFile(PrintWriter myOutput, String[] array) {
		// prints first line
		myOutput.print(array[0]);

		// prints the rest of the elements separated by commas and spaces
		for (int i = 1; i <= array.length - 1; i++) {
			myOutput.print(", " + array[i]);
		}
		myOutput.println(); // brings cursor to a new line

	}// ends printArrayToFile method

	/*
	 * Mrs. McCaffery
	 * Method Name: printArrayToFile
	 * Description: Prints each element in an array to a file on a single line,
	 * separated by commas
	 * Parameters: PrintWriter, int []
	 * Returns: n/a
	 */
	public static void printArrayToFile(PrintWriter myOutput, int[] array) { // prints first line
		myOutput.print(array[0]);
		// prints the rest of the elements separated by commas and spaces
		for (int i = 1; i <= array.length - 1; i++) {
			myOutput.print(", " + array[i]);
		}
	}// ends printArrayToFile method

	/*
	 * Author: Iris Kim
	 * Method name: reverse
	 * Description: reverse the order of string values in the array
	 * Parameters: String[] array
	 * Return: arrayReverse
	 */
	public static String[] reverse(String[] array) {

		// creates a new string array
		String[] arrayReverse = new String[array.length];

		// makes a copy of the original array but its values in reversed order
		int i = arrayReverse.length-1;
		for(String item : array) {
			arrayReverse[i] = item;
			i--;
		}
		
		return arrayReverse;
	} // end method reverse (String)

	/*
	 * Author: Iris Kim
	 * Method name: reverse
	 * Description: reverse the order of integer values in the array
	 * Parameters: int[] array
	 * Return: arrayReverse
	 */
	public static int[] reverse(int[] array) {

		// creates a new string array
		int[] arrayReverse = new int[array.length];

		// makes a copy of the original array but its values in reversed order
		int i = arrayReverse.length-1;
		for(int item : array) {
			arrayReverse[i] = item;
			i--;
		}
		
		return arrayReverse;
	} // end method reverse (int)

	/*
	 * Author: Iris Kim
	 * Method name: sortHighToLow
	 * Description: a new string array with values from original sorted from the
	 * last to first alphabetical value
	 * Parameters: String[] array
	 * Return: newArray
	 */
	public static String[] sortHighToLow(String[] array) {

		String[] newArray = sortLowToHigh(array);

		// creates a temporary array to store newArray
		String[] temp = new String[newArray.length];
		for (int i = 0; i < newArray.length; i++) {
			temp[i] = newArray[i];
		}

		// reverse the order of values in newArray
		for (int i = newArray.length - 1; i >= 0; i--) {
			newArray[temp.length - i - 1] = temp[i];
		}

		return newArray;
	} // end sortHighToLow method (String)

	/*
	 * Author: Iris Kim
	 * Method name: sortHighToLow
	 * Description: reverse the order of values in newArray(from sortLowToHigh
	 * method) to sort values from high to low
	 * Parameters: int[] array
	 * Return: newArray
	 */
	public static int[] sortHighToLow(int[] array) {

		int[] newArray = sortLowToHigh(array);

		// creates a temporary array to store newArray
		int[] temp = new int[newArray.length];
		for (int i = 0; i < newArray.length; i++) {
			temp[i] = newArray[i];
		}

		// reverse the order of values in newArray
		for (int i = newArray.length - 1; i >= 0; i--) {
			newArray[temp.length - i - 1] = temp[i];
		}

		return newArray;
	} // end sortHighToLow (int)

	/*
	 * Author: Iris Kim
	 * Method name: sortLowToHigh
	 * Description: a new string array with values from original sorted from the
	 * first to last alphabetical value
	 * Parameters: String[] array
	 * Return: newArray
	 */
	public static String[] sortLowToHigh(String[] array) {

		// calls in newArray from the method copyArray
		String[] newArray = copyArray(array);

		// sorts newArray from low to high
		Arrays.sort(newArray);

		return newArray;
	} // end sortLowToHigh method (String)

	/*
	 * Author: Iris Kim
	 * Method name: sortLowToHigh
	 * Description: a new integer array with values from original sorted from low to
	 * high
	 * Parameters: array
	 * Return: newArray
	 */
	public static int[] sortLowToHigh(int[] array) {

		// calls in newArray from the method copyArray
		int[] newArray = copyArray(array);

		// sorts newArray from low to high
		Arrays.sort(newArray);

		return newArray;
	} // end sortLowToHigh method (int)

	/*
	 * Author: Iris Kim
	 * Method name: deleteElementByIndex
	 * Description: creates a new string array with a value at position removed
	 * Parameters: String[] array, pint osition
	 * Return: newArray
	 */
	public static String[] deleteElementByIndex(String[] array, int position) {

		// creates a new array with a length shorter by one
		String[] newArray = new String[array.length - 1];

		// values in array before "position" remain the same
		for (int i = 0; i < position; i++) {
			newArray[i] = array[i];
		}

		// values in array after "position" are shifted to index-1
		for (int i = position; i <= newArray.length - 1; i++) {
			newArray[i] = array[i + 1];
		}

		return newArray;
	} // end deleteElementByIndex method (String)

	/*
	 * Author: Iris Kim
	 * Method name: deleteElementByIndex
	 * Description: creates a new integer array with a value at position removed
	 * Parameters: int[] array, int position
	 * Return: newArray
	 */
	public static int[] deleteElementByIndex(int[] array, int position) {

		// creates a new array with a length shorter by one
		int[] newArray = new int[array.length - 1];

		// values in array before "position" remain the same
		for (int i = 0; i < position; i++) {
			newArray[i] = array[i];
		}

		// values in array after "position" are shifted to index-1
		for (int i = position; i <= newArray.length - 1; i++) {
			newArray[i] = array[i + 1];
		}

		return newArray;
	} // end deleteElementByIndex method (int)

	/*
	 * Author: Iris Kim
	 * Method name: deleteElementByValue
	 * Description: creates a new string array with one indicated value removed
	 * Parameters: String[] array, String value
	 * Return: newArray
	 */
	public static String[] deleteElementByValue(String[] array, String value) {

		String[] newArray = new String[array.length - 1];

		// if the value is not found, tempPosition remains to be -1
		int tempPosition = -1;

		// if the value is found, tempPosition = location of the value
		for (int i = newArray.length - 1; i > -1; i--) {
			if (array[i].equals(array)) {
				tempPosition = i;
			}
		}

		// if the value is found
		if (tempPosition != -1) {
			for (int i = 0; i < tempPosition; i++) {
				newArray[i] = array[i];
			}
			for (int i = tempPosition; i < newArray.length; i++) {
				newArray[i] = array[i + 1];
			}
		} // end if

		// if the value is not found
		else if (tempPosition == -1) {
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = array[i];
			}
		} // end else if

		return newArray;
	} // end deleteElementByValue method (String)

	/*
	 * Author: Iris Kim
	 * Method name: deleteElementByValue
	 * Description: creates a new integer array with one indicated value removed
	 * Parameters: int[] array, int value
	 * Return: newArray
	 */
	public static int[] deleteElementByValue(int[] array, int value) {

		int[] newArray = new int[array.length - 1];

		// if the value is not found, tempPosition remains to be -1
		int tempPosition = -1;

		// if the value is found, tempPosition = location of the value
		for (int i = newArray.length - 1; i > -1; i--) {
			if (array[i] == value) {
				tempPosition = i;
			}
		}

		// if the value is found
		if (tempPosition != -1) {
			for (int i = 0; i < tempPosition; i++) {
				newArray[i] = array[i];
			}
			for (int i = tempPosition; i <= newArray.length - 1; i++) {
				newArray[i] = array[i + 1];
			}
		} // end if

		// if the value is not found
		else if (tempPosition == -1) {
			for (int i = 0; i < newArray.length - 1; i++) {
				newArray[i] = array[i];
			}
		} // end else if

		return newArray;
	} // end deleteElementByValue method (int)

	/*
	 * Author: Iris Kim
	 * Method name: insertElementByIndex
	 * Description: creates a new string array with one extra value
	 * Parameters: String[] array, String value, String position
	 * Return: newArray
	 */
	public static String[] insertElementByIndex(String[] array, String value, int position) {

		// new array with a length longer by one
		String[] newArray = new String[array.length + 1];

		// values before position are copied straight from original
		for (int i = 0; i < position; i++) {
			newArray[i] = array[i];
		}

		// inserts value at index position
		newArray[position] = value;

		// values after position are shifted right by one
		for (int i = position + 1; i < newArray.length; i++) {
			newArray[i] = array[i - 1];
		}

		return newArray;
	}// end insertElementByIndex method (string)

	/*
	 * Author: Iris Kim
	 * Method name: insertElementByIndex
	 * Description: creates a new integer array with one extra value
	 * Parameters: int[] array, int value, int position
	 * Return: newArray
	 */
	public static int[] insertElementByIndex(int[] array, int value, int position) {

		// new array with a length longer by one
		int[] newArray = new int[array.length + 1];

		// values before position are copied straight from original
		for (int i = 0; i < position; i++) {
			newArray[i] = array[i];
		}

		// inserts value at index position
		newArray[position] = value;

		// values after position are shifted right by one
		for (int i = position + 1; i < newArray.length; i++) {
			newArray[i] = array[i - 1];
		}

		return newArray;
	} // end insertElementByIndex method (int)

	/*
	 * Author: Iris Kim
	 * Method name: replaceElements
	 * Description: replaces all elements of the original value with the new value
	 * Parameters: String[] array, String value, String newValue
	 */
	public static void replaceElements(String[] array, String value, String newValue) {

		// replaces all values in the array
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].equals(value)) {
				array[i] = newValue;
			} // end if
		} // end for

	} // end method replaceElements (string)

	/*
	 * Author: Iris Kim
	 * Method name: replaceElements
	 * Description: replaces all elements of the original value with the new value
	 * Parameters: int[] array, int value, int newValue
	 */
	public static void replaceElements(int[] array, int value, int newValue) {

		// replaces all values in the array
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == value) {
				array[i] = newValue;
			} // end if
		} // end for

	} // end replaceElements method (int)

	/*
	 * Author: Iris Kim
	 * Method name: replaceElement
	 * Description: replaces array[position] with indicated string value
	 * Parameters: String[] array, String value, int position
	 */
	public static void replaceElement(String[] array, String value, int position) {

		// replaces a value at position
		array[position] = value;

	} // end replaceElement method (string)

	/*
	 * Author: Iris Kim
	 * Method name: replaceElement
	 * Description: replaces array[position] with indicated integer value
	 * Parameters: int[] array, int value, int position
	 */
	public static void replaceElement(int[] array, int value, int position) {

		// replaces a value at position
		array[position] = value;

	} // end replaceElement method (int)

	/*
	 * Author: Iris Kim
	 * Method name: checkIfIdentical
	 * Description: compares two string arrays to see if they are identical
	 * Parameters: String[] array, String[] array2
	 * Return: identical
	 */
	public static boolean checkIfIdentical(String[] array, String[] array2) {

		// returns true if two arrays are identical
		if (array.equals(array2)) {
			return true;
		}

		// otherwise returns false
		return false;

	}// end checkIfIdentical method (string)

	/*
	 * Author: Iris Kim
	 * Method name: checkIfIdentical
	 * Description: compares two integer arrays to see if they are identical
	 * Parameters: int[] array, int[] array2
	 * Return: identical
	 */
	public static boolean checkIfIdentical(int[] array, int[] array2) {

		// returns true if two arrays are identical
		if (array == array2) {
			return true;
		}

		// otherwise returns false
		return false;

	} // end checkIfIdentical method(int)

	/*
	 * Author: Iris Kim
	 * Method name: checkIfCopy
	 * Description: compares the two string arrays to see if they contain same
	 * values
	 * Parameters: String[] array, String[] array2
	 * Return: isCopy
	 */
	public static boolean checkIfCopy(String[] array, String[] array2) {

		// compares the length
		if (array.length != array2.length) {
			return false;
		} // end if

		// if two arrays[same spot] have a different value, returns false
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals(array2[i])) {
				return false;
			} // end if
		} // end for

		// otherwise (everything equals) returns true
		return true;

	}// end checkIfCopy method(String)

	/*
	 * Author: Iris Kim
	 * Method name: checkIfCopy
	 * Description: compares the two integer arrays to see if they contain same
	 * values
	 * Parameters: int[] array, int[] array2
	 * Return: isCopy
	 */
	public static boolean checkIfCopy(int[] array, int[] array2) {

		// compares the length
		if (array.length != array2.length) {
			return false;
		} // end if

		// if two arrays[same spot] have a different value, returns false
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array2[i]) {
				return false;
			} // end if
		} // end for

		// otherwise (everything equals) returns true
		return true;

	} // end checkIfCopy method(int)

	/*
	 * Author: Iris Kim
	 * Method name: copyArray
	 * Description: returns a copy of the original String array
	 * Parameters: String[] array
	 * Return: array2
	 */
	public static String[] copyArray(String[] array) {

		// creates array2 of same length
		String[] array2 = new String[array.length];

		// creates an identical copy of the array
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}

		return array2;
	} // end copyArray method (String)

	/*
	 * Author: Iris Kim
	 * Method name: copyArray
	 * Description: returns a copy of the original integer array
	 * Parameters: int[] array
	 * Return: array2
	 */
	public static int[] copyArray(int[] array) {

		// creates array2 of same length
		int[] array2 = new int[array.length];

		// creates an identical copy of the array
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}

		return array2;
	} // end copyArray method (int)

	/*
	 * Author: Iris Kim
	 * Method name: countElement
	 * Description: returns the number of times the string value is found
	 * Parameters: String[] array, String value
	 * Return: numOfElements
	 */
	public static int countElements(String[] array, String value) {

		// initializes value of numOfElements
		int numOfElements = 0;

		// counts how many times the value is found
		for (String item : array) {
			if (item.equals(value)) {
				numOfElements++;
			} // end if
		} // end for loop

		return numOfElements;
	} // end countElements method (String)

	/*
	 * Author: Iris Kim
	 * Method name: countElement
	 * Description: returns the number of times the integer value is found
	 * Parameters: int[] array, int value
	 * Return: numOfElements
	 */
	public static int countElements(int[] array, int value) {

		// initializes value of numOfElements
		int numOfElements = 0;

		// counts how many times the value is found
		for (int item : array) {
			if (item == value) {
				numOfElements++;
			} // end if
		} // end for loop

		return numOfElements;
	} // end countElements method (int)

	/*
	 * Author: Iris Kim
	 * Method name: findElement
	 * Description: returns the position of when the String value first appears
	 * Parameters: String[] array, value
	 * Return: position
	 */
	public static int findElement(String[] array, String value) {

		// position remains as -1 if the value is not found
		int position = -1;

		// if value is found, position = where it is found at
		for (int i = array.length - 1; i > -1; i--) {
			if (array[i].equals(value)) {
				position = i;
			} // end if
		} // end for loop

		return position;
	} // end method findElement (String)

	/*
	 * Author: Iris Kim
	 * Method name: findElement
	 * Description: returns the position of when the integer value first appears
	 * Parameters: int[] array, int value
	 * Return: position
	 */
	public static int findElement(int[] array, int value) {

		// position remains as -1 if the value is not found
		int position = -1;

		// if value is found, position = where it is found at
		for (int i = array.length - 1; i > -1; i--) {
			if (array[i] == value) {
				position = i;
			} // end if
		} // end for loop

		return position;
	} // end findElement method (int)

	/*
	 * Author: Iris Kim
	 * Method name: swapElement
	 * Description: swaps the String values at index position1 with index position2
	 * Parameters: String[] array, int ... values
	 */
	public static void swapElements(String[] array, int ... values) {

		// swaps position
		String temp = array[values[0]];
		array[values[0]] = array[values[1]];
		array[values[1]] = temp;

	} // end method swapElements (String)

	/*
	 * Author: Iris Kim
	 * Method name: swapElement
	 * Description: swaps the integer values at index position1 with index position2
	 * Parameters: int[] array, int ... values
	 */
	public static void swapElements(int[] array, int ... values) {

		// swaps position
		int temp = array[values[0]];
		array[values[0]] = array[values[1]];
		array[values[1]] = temp;

	} // end swapElements method (int)

	/*
	 * Author: Iris Kim
	 * Method name: findMin
	 * Description: returns the position of the first alphabetical value in the
	 * string array
	 * Parameters: String[] array
	 * Return: position
	 */
	public static int findMin(String[] array) {

		int position = 0;

		// sorts the array from first to last alphabetical value
		String[] tempArray = array;
		Arrays.sort(tempArray);

		// finds the first alphabetical value
		String maxValue = tempArray[0];

		// finds where the first alphabetical value is in original array
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(maxValue)) {
				position = i;
			} // end if loop
		} // end for loop

		return position;
	} // end method findMin (String)

	/*
	 * Author: Iris Kim
	 * Method name: findMin
	 * Description: returns the position of the min value in the integer array
	 * Parameters: int[] array
	 * Return: position
	 */
	public static int findMin(int[] array) {

		int min = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i] < min) {
				min = array[i];
			} // end if 
		} // end for

		return min;
	} // end findMin method (int)

	/*
	 * Author: Iris Kim
	 * Method name: findMax
	 * Description: returns the position of the last alphabetical value in the array
	 * Parameters: String[] array
	 * Return: position
	 */
	public static int findMax(String[] array) {

		int position = 0;

		// sorts the array from the first to last alphabetically
		String[] tempArray = array;
		Arrays.sort(tempArray);

		// finds the last alphabetical value
		String maxValue = tempArray[tempArray.length - 1];

		// finds where the alphabetical value is in original array
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(maxValue)) {
				position = i;
			} // end if loop
		} // end for loop

		return position;
	} // end method findMax (String)

	/*
	 * Author: Iris Kim
	 * Method name: findMax
	 * Description: returns the position of the max value in the integer array
	 * Parameters: int[] array
	 * Return: position
	 */
	public static int findMax(int[] array) {
				
		int max = array[0];
			for (int i = 1; i < array.length - 1; i++) {
				if (array[i] > max) {
					max = array[i];
				} // end if 
			} // end for
		
		
//		// finds the position of the max value
//		int position = 0;
//		for (int i = 1; i < array.length; i++) {
//			{
//				if (array[i] > array[position])
//					position = i;
//			} // end if
//		} // end for loop

		return max;
	} // end findMax method (int)

	/*
	 * Author: Iris Kim
	 * Method name: print
	 * Description: This method prints out each element in the string array.
	 * Parameters: String[] newArray
	 */
	public static void print(String[] newArray) {

		// prints out each element in the array
		for (String item : newArray) {
			System.out.println(item);
		}

	} // end print method (String)

	/*
	 * Author: Iris Kim
	 * Method name: print
	 * Description: This method prints out each element in the integer array.
	 * Parameters: int[] newArray
	 */
	public static void print(int[] newArray) {

		// prints out each element in the array
		for (int item : newArray) {
			System.out.println(item);
		}

	} // end print method (int)

	/*
	 * Author: Iris Kim
	 * Method name: createUserDefinedArray
	 * Description: returns a string array filled with information entered by the
	 * user
	 * Parameters: int size
	 * Return: newArray
	 */
//	public static String[] createUserDefinedArray(int size) {
//
//		Scanner myInput = new Scanner(System.in);
//
//		// creates an array of size indicated
//		String[] newArray = new String[size];
//
//		// array is filled with the integers entered by the user
//		for (int i = 0; i < size; i++) {
//			newArray[i] = myInput.nextLine();
//		}
//
//		myInput.close();
//
//		return newArray;
//	} 

	/*
	 * Author: Iris Kim
	 * Method name: createUserDefinedArray
	 * Description: returns an integer array filled with information entered by the
	 * user
	 * Parameters: int size
	 * Return: newArray
	 */
	public static int[] createUserDefinedArray(int size) {

		Scanner myInput = new Scanner(System.in);

		// creates an array of size indicated
		int[] newArray = new int[size];

		// array is filled with the integers entered by the user
		for (int i = 0; i < size; i++) {
			newArray[i] = myInput.nextInt();
		}

		myInput.close();

		return newArray;
	} // end createUserDefinedArray method
	
	/*
	 * Author: Iris Kim
	 * Method name: createRandomIntArray
	 * Description: returns an integer array filled with random integers btwn min
	 * and max.
	 * Parameters: int ... values
	 * Return: newArray
	 */
	public static int[] createRandomIntArray(int ... values) {
	
		// creates an array of size indicated
		int[] newArray = new int[values[0]];
		
		// array is filled with integers between min and max
		for (int i = 0; i < values[0]; i++) {
			newArray[i] = (int) (Math.random() * (values[2] - values[1] + 1)) + values[1];
		}
		
		return newArray;
	} // end createRandomIntArray method

	/*
	 * Author: Iris Kim
	 * Method name: createEmptyStringArray
	 * Description: This method returns an empty string array of size indicated.
	 * Parameters: int size
	 * Return: newArray
	 */
	public static String[] createEmptyStringArray(int size) {

		// creates an array of size indicated
		size = 5;
		String[] newArray = new String[size];
		return newArray;

	}// end createEmptyIntArray method (string)

	/*
	 * Author: Iris Kim
	 * Method name: createEmptyIntArray
	 * Description: This method returns an empty integer array of size indicated.
	 * Parameters: int size
	 * Return: newArray
	 */
	public static int[] createEmptyIntArray(int size) {

		// creates an array of size indicated
		size = 5;
		int[] newArray = new int[size];
		return newArray;

	} // end createEmptyIntArray method (int)

}
