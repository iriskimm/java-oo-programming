/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 15th, 2021
Submit Date: Mar. 16th, 2021
*/

package recursion;

public class ExcelTask {

	public static void main(String[] args) {

		// Fibonacci sequence task(question 1) is done in CoreTask.java

		// Question 2
		System.out.println(findGCD(20, -5));

	} // end main

	/*
	 * Method name: findGCD
	 * Author: Iris Kim
	 * Description:
	 * - determines the greatest common divisor of two integers
	 * - returns 1 when there is no other GCD than 1
	 * Parameter: int m, int n
	 * Return: the greatest common divisor
	 */
	public static int findGCD(int m, int n) {

		m = Math.abs(m);
		n = Math.abs(n);

		// base cases
		// if two zeros
		if (m == 0 && n == 0) {
			System.out.print("Invalid input. Do not enter two zeros.");
			return 0;
		} 
		// if one zero
		else if (m == 0 || n == 0) {
			return 0;
		} 
		// if same numbers
		else if (m == n) {
			return m;
		} 
		// switch positions of n and m
		else if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}

		// recursive call
		if (m != n) {
			return findGCD((m - n), n); // returns (difference, n)
		}

		// error case
		else
			return 1;

	} // end findGCD()

} // end class
