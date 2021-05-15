/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 15th, 2021
Submit Date: Mar. 15th, 2021
*/

package recursion;

public class CoreTask {

	public static void main(String[] args) {

		// Question 1
		// a) t1 = 10 || tn = (tn-1) + 3, n > 1
		System.out.println(problemTwoA(5));

		// b) t1 = 5 || tn = (tn-1) * 3, n > 1
		System.out.println(problemTwoB(5));

		// c) t1 = 256 || tn = (tn-1) / 4, n > 1
		System.out.println(problemTwoC(5));

		// d) t1 = 0.5 || tn = (tn-1) + 1, n > 1
		System.out.printf("%.2f", problemTwoD(4));
		System.out.println();
		
		// Question 2
		System.out.println(FibonacciLoops(9));

		System.out.println(FibonacciRecursion(44)); 
		// doesn't print anything if the n value is > 46
		// this is because 47th or a higher number in a fibonacci sequence is beyond the max. integer value that int can hold

	} // end main

	/*
	 * Method name: FibonacciRecursion
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the Fibonacci sequence
	 * - returns -1 when input is < 1
	 * Parameter: int n; n should be 0 < n < 47
	 * Return: the term at the specific location
	 */
	public static int FibonacciRecursion(int n) {

		// base cases
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		}

		// recursive call
		else if (n > 2) {
			return (FibonacciRecursion(n - 1)) + (FibonacciRecursion(n - 2));
		}

		// error case
		else
			return -1;

	} // end FibonacciRecursion()

	/*
	 * Method name: FibonacciLoops
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the Fibonacci sequence
	 * - returns -1 when input is < 1
	 * Parameter: int n; n should be 0 < n < 47
	 * Return: the term at the specific location
	 */
	public static int FibonacciLoops(int n) {

		int term = 0;

		// base case
		if (n == 1 || n == 2) {
			term = 1;
		} // end if

		int t1 = 1, t2 = 1;

		// let sum of t1 and t2 become the next number and repeat
		for (int i = 0; i < n; i++) {
			int sum = t1 + t2;
			term = t1;
			t1 = t2;
			t2 = sum;
		} // end for

		// error case
		if (n < 1) {
			return -1;
		}

		return term;

	} // end FibonacciLoops()

	/*
	 * Method name: problemTwoA
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 10 || tn = (tn-1) + 3, n > 1
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static int problemTwoA(int n) {

		// base case
		if (n == 1) {
			return 10;
		}

		// recursive call
		else if (n > 1) {
			return problemTwoA(n - 1) + 3;
		}

		// error case
		else
			return -1;

	} // end problemTwoA()

	/*
	 * Method name: problemTwoB
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 5 || tn = (tn-1) * 3, n > 1
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static int problemTwoB(int n) {

		// base case
		if (n == 1) {
			return 5;
		}

		// recursive call
		else if (n > 1) {
			return problemTwoB(n - 1) * 3;
		}

		// error case
		else
			return -1;

	} // end problemTwoB()

	/*
	 * Method name: problemTwoC
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 256 || tn = (tn-1) / 4, n > 1
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static int problemTwoC(int n) {

		// base case
		if (n == 1) {
			return 256;
		}

		// recursive call
		else if (n > 1) {
			return problemTwoC(n - 1) / 4;
		}

		// error case
		else
			return -1;

	} // end problemTwoC()

	/*
	 * Method name: problemTwoD
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 0.5 || tn = (tn-1) + 1, n > 1
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static double problemTwoD(int n) {

		// base case
		if (n == 1) {
			return 0.5;
		}

		// recursive call
		else if (n > 1) {
			return problemTwoD(n - 1) + 1;
		}

		// error case
		else
			return -1;

	} // end problemTwoD()

} // end class CoreTask
