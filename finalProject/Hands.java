/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 13th, 2021
Submit Date: Apr. 9th, 2021
Description:
- Calculates the player's score (sum of cards in their hand)
- Aces can be treated as a 1 or 11, whichever makes a better hand for BlackJack
*/

package finalProject;

import java.util.List;

public class Hands {
	
	public static int calculateSum(List<Card> player) {

		int sum = 0;
		int numOfAce = 0;

		for (Card card : player) {

			int prevSum = sum;
			sum += card.getValue();

			// calculates number of ace
			if ((sum - prevSum) == 11) {
				numOfAce++;
			} // end if

		} // end for 
		
		// if sum > 21, make ace = 1
		for (int i = 0; i < numOfAce; i++) {
			if (sum > 21) {
				sum = sum - 10;
			} // end if
		} // end for

		return sum;
		
	} // end calculateSum()

} // end class Hands
