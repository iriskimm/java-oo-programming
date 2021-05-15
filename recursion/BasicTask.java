/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 15th, 2021
Submit Date: Mar. 16th, 2021
*/

package recursion;

public class BasicTask {

	public static void main(String[] args) {

		// Question 1
		// a) 3.00, 5.00, 7.00, 9.00, 11.00
		System.out.printf("%.2f", problemOneA(5));
		System.out.println();

		// b) 2.00, 0.50, -1.00, 2.00, 0.50
		System.out.printf("%.2f", problemOneB(5));
		System.out.println();

		// c) 2.00, 3.00, 5.00, 8.00, 12.00
		System.out.printf("%.2f", problemOneC(5));
		System.out.println();

		// d) 1.00, 2.00, 3.00, 5.00, 8.00
		System.out.printf("%.2f", problemOneD(5));
		System.out.println();

		// Question 2
		// a) t1 = 10 || tn = (tn-1) + 3, n > 1
		System.out.println(problemTwoA(4));

		// b) t1 = 5 || tn = (tn-1) * 3, n > 1

		// c) t1 = 256 || tn = (tn-1) / 4, n > 1

		// d) t1 = 0.5 || tn = (tn-1) + 1, n > 1

	} // end main

	/*
	 * Method name: problemOneA
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 3 || tn = tn-1 + 2, n > 1
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static double problemOneA(int n) {

		// base case
		if (n == 1) {
			return 3;
		}

		// recursive call
		else if (n > 1) {
			return problemOneA(n - 1) + 2;
		}

		// error case
		else
			return -1;

	} // end problemOneA()

	/*
	 * Method name: problemOneB
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 2 || tn+1 = 1 - (1 / tn), n > 0
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static double problemOneB(int n) {

		// base case
		if (n == 1) {
			return 2;
		}

		// recursive call
		else if (n > 1) {
			return 1 - (1 / (problemOneB(n - 1)));
		}

		// error case
		else
			return -1;

	} // end problemOneB()

	/*
	 * Method name: problemOneC
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 2 || tn+1 = n + tn, n> 0
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static double problemOneC(int n) {

		// base case
		if (n == 1) {
			return 2;
		}

		// recursive call
		else if (n > 1) {
			return (n - 1) + (problemOneC(n - 1));
		}

		// error case
		else
			return -1;

	} // end problemOneC()

	/*
	 * Method name: problemOneD
	 * Author: Iris Kim
	 * Description:
	 * - determines the term at a specific location in the following sequence:
	 * - t1 = 1 || t2 = 2 || tn = tn-1 + tn-2, n > 2
	 * - returns -1 when input is < 1
	 * Parameter: int n
	 * Return: the term at the specific location
	 */
	public static double problemOneD(int n) {

		// base case
		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		// recursive call
		else if (n > 2) {
			return (problemOneD(n - 1) + problemOneD(n - 2));
		}

		// error case
		else
			return -1;

	} // end problemOneD()

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

} // end class basicTaskOne
