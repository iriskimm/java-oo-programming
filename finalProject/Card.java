/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 13th, 2021
Submit Date: Apr. 9th, 2021
Description:
- Creates an object Card which contain 'number' and 'suit'
- Contains getters for name, suit, and value
- Contains setters for number, suit, and value
- Value of any face card is 10
*/

package finalProject;

public class Card {

	private int number;
	private int value;
	private String suit;

	public Card(int number, String suit) {
		this.number = number;
		this.value = number;
		this.suit = suit;
	} // end Card()

	public String getName() {
		return this.number + this.suit;
	}

	public String getSuit() {
		return this.suit;
	}

	public int getValue() {

		// set value of face cards to 10
		if (this.value > 10) {
			this.value = 10;
		}

		// ace can be 1 or 11
		if (this.number == 1) {
			this.value = 11;

		}

		return this.value;
	}

	public void setNumber(int number) {

		this.number = number;

	}

	public void setValue(int value) {

		this.value = value;

	}

	public void setSuit(String suit) {

		this.suit = suit;

	}

} // end class Card
