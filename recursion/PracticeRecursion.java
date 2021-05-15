package recursion;

public class PracticeRecursion {

	public static void main(String[] args) {

		System.out.println(twoToThe(10));

	}

//	// for values >= 0
//	// non-recursive example
//	public static int twoToThe(int n) {
//		
//		int total = 1;
//		if(n > 0) {
//			for(int y = 1; y <= n; y++) {
//				total*=2;
//			} // end for 
//			
//		} // end if
//		
//		return total;
//		
//	} // end twoToThe()

	
	// recursive example
	// returns -1 if input is invalid
	public static int twoToThe(int n) {

		// base case(s)
		if (n == 0) {
			return 1;
		}

		// recursive call
		else if (n > 0) {
			return 2 * twoToThe(n - 1);
		}
		
		// error case
		else
			return -1;
		
	} // end twoToThe()

} // end class
