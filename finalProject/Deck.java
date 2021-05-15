/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 13th, 2021
Submit Date: Apr. 9th, 2021
Description: 
- Creates a deck of 52 cards. (for each suit, there are 10 number cards from 1 to 10 and three face cards. No jokers)
- Shuffles the deck to arrange the cards in random order. 
*/

package finalProject;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	Stack<Card> cards = new Stack<Card>();

	public static Stack<Card> createDeck(Stack<Card> cards) {

		cards.clear();

		String[] suits = { "spades", "hearts", "diamonds", "clubs" };

		// makes a deck of 52 cards
		for (String suit : suits) {
			
			for (int i = 1; i < 14; i++) {
				cards.push(new Card(i, suit));
			} // end for i
			
		} // end for suit : suits

		// shuffles the card
		Collections.shuffle(cards);

		return cards;

	} // end createDeck()

} // end class Deck
