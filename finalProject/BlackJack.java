/*
Iris Kim
Ms. McCaffery
ICS4U
Start Date: Mar. 13th, 2021
Submit Date: Apr. 9th, 2021
Description: 
1. Displays the main page and the user is given two options: to go to rule page or to start game
2. If the user goes to rule page, the rules are displayed. Player may go back to main page. 
3. When the player presses on button start, it launches the game. 
4. 2 cards for both the dealer and the player are dealt in the beginning. 
5. Player can decide to hit or stand; the dealer can not play until the player is done. 
6. When the player is done, the dealer can decide to hit or stand. (unless winner is determined before)
7. When the winner is determined, it displays the winner. User can replay or exit as they wish. 
*/

package finalProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BlackJack extends Application {

	// declare variables
	Stack<Card> cards = new Stack<Card>();

	List<Card> playerCards = new ArrayList<Card>();
	List<Card> dealerCards = new ArrayList<Card>();

	List<ImageView> cardImages = new ArrayList<ImageView>();
	ImageView cardDeck = new ImageView();
	List<ImageView> cardDecks = new ArrayList<ImageView>();

	int playerSum;
	int dealerSum;
	Button replay, hit, stand, dealerHit, dealerStand;
	Label dealerTurn;

	Text result;
	Group ruleRoot, gameRoot;

	Scene startScene, ruleScene, gameScene;

	public static void main(String[] args) {
		Application.launch(args);
	} // end main()

	/*
	 * Method start
	 * Author: Iris Kim
	 * Description:
	 * - initializes buttons: start, rules, backToMain, exit, hit, stand, replay
	 * - a complete set up of startScene(image, 2 buttons)
	 * - switches to ruleScene when the button 'rules' is pressed
	 * - switches to gameScene when the button 'start' is pressed
	 * Parameter: Stage primaryStage
	 * Return: n/a
	 */
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Blackjack");

		//////////////// STARTING PAGE
		// Button "start"
		Button start = new Button("S t a r t");
		start.setLayoutX(50);
		start.setLayoutY(350);
		start.setStyle(
				"-fx-font-size:70px; -fx-background-color: transparent; -fx-text-fill: sandybrown; -fx-underline: true;");

		// BUTTON "rules"
		Button rules = new Button("R u l e s");
		rules.setLayoutX(310);
		rules.setLayoutY(350);
		rules.setStyle(
				"-fx-font-size:70px; -fx-background-color: transparent; -fx-text-fill: sandybrown; -fx-underline: true;");

		// welcome image in startScene
		InputStream stream = new FileInputStream("images/blackjack_startPage.jpeg");
		Image image = new Image(stream);
		ImageView intro = new ImageView(image);

		// Setting the image view parameters
		intro.setX(0);
		intro.setY(0);
		intro.setFitWidth(650);
		intro.setPreserveRatio(true);

		// switch to gameScene when button "start" is pressed
		start.setOnAction(e -> primaryStage.setScene(gameScene));

		// switch to ruleScene when button "rules" is pressed
		rules.setOnAction(e -> primaryStage.setScene(ruleScene));

		// set cursor to hand when mouse hovers over the button
		start.setOnMouseEntered(e -> startScene.setCursor(Cursor.HAND));
		start.setOnMouseExited(e -> startScene.setCursor(Cursor.DEFAULT));

		rules.setOnMouseEntered(e -> startScene.setCursor(Cursor.HAND));
		rules.setOnMouseExited(e -> startScene.setCursor(Cursor.DEFAULT));

		// setting up the startScene
		Group startRoot = new Group();
		startScene = new Scene(startRoot, 650, 500, Color.BLACK);

		// adds the image and two buttons to startRoot
		startRoot.getChildren().add(intro); // welcome image
		startRoot.getChildren().add(start); // start button
		startRoot.getChildren().add(rules); // rules button

		
		//////////////// RULE SCENE
		ruleRoot = new Group();
		ruleScene = new Scene(ruleRoot, 650, 500, Color.DARKGREEN);

		// display rules
		this.rule(primaryStage);

		
		//////////////// GAME SCENE
		gameRoot = new Group();
		gameScene = new Scene(gameRoot, 650, 500, Color.DARKGREEN);

		// BUTTON to go back to main
		Button backToMain = new Button("Back to main");
		backToMain.setLayoutX(5);
		backToMain.setLayoutY(5);
		backToMain.setStyle(
				"-fx-font-size:20px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// switches to startScene when start button "backToMain" is pressed
		backToMain.setOnAction(e -> primaryStage.setScene(startScene));

		// set cursor to hand when mouse hovers over the button
		backToMain.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		backToMain.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// BUTTON to exit game completely
		Button exit = new Button("Exit");
		exit.setLayoutX(585);
		exit.setLayoutY(5);
		exit.setStyle(
				"-fx-font-size:20px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// close stage when exit button is pressed
		exit.setOnAction(e -> primaryStage.close());

		// set cursor to hand when mouse hovers over the button
		exit.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		exit.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// BUTTON hit
		hit = new Button("Hit");
		hit.setLayoutX(512);
		hit.setLayoutY(165);
		hit.setStyle(
				"-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// execute hitPressed() when button 'hit' is pressed
		hit.setOnAction(e -> {
			try {
				this.hitPressed();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		}); // end EventHandler (hit)

		// set cursor to hand when mouse hovers over the button
		hit.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		hit.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// BUTTON stand
		stand = new Button("Stand");
		stand.setLayoutX(500);
		stand.setLayoutY(210);
		stand.setStyle(
				"-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// execute playerStandPressed() when stand button is pressed
		stand.setOnAction(e -> {
			try {
				this.playerStandPressed();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}); // end EventHandler (stand)

		// set cursor to hand when mouse hovers over the button
		stand.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		stand.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// BUTTON dealerHit
		dealerHit = new Button("Hit");
		dealerHit.setLayoutX(512);
		dealerHit.setLayoutY(180);
		dealerHit.setStyle(
				"-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// BUTTON dealerStand
		dealerStand = new Button("Stand");
		dealerStand.setLayoutX(500);
		dealerStand.setLayoutY(225);
		dealerStand.setStyle(
				"-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// BUTTON replay
		replay = new Button("Replay");
		replay.setLayoutX(500);
		replay.setLayoutY(255);
		replay.setStyle(
				"-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");
		replay.setVisible(false); // hide replay button unless the round is over

		// execute replayPressed() when button replay is pressed
		replay.setOnAction(e -> {
			try {
				this.replayPressed();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}); // end EventHandler (replay)

		// set cursor to hand when mouse hovers over the button
		replay.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		replay.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// adds buttons to the gameScene
		gameRoot.getChildren().add(hit);
		gameRoot.getChildren().add(backToMain);
		gameRoot.getChildren().add(exit);
		gameRoot.getChildren().add(stand);
		gameRoot.getChildren().add(replay);

		gameRoot.getChildren().add(dealerHit);
		gameRoot.getChildren().add(dealerStand);
		dealerHit.setVisible(false); // buttons for dealer do not show at first
		dealerStand.setVisible(false);
		gameRoot.getChildren().remove(dealerTurn);

		// execute prepareGame() to begin the game
		this.prepareGame();

		// start off with the startScene
		primaryStage.setScene(startScene);
		primaryStage.show();

	} // end start()

	/*
	 * Method name: hitPressed
	 * Author: Iris Kim
	 * Description:
	 * - player gets another card; the new card is displayed
	 * - playerSum is recalculated
	 * - if one or both players reach or go over 21, execute pickWinner()
	 * Parameter: n/a
	 * Return: void
	 */
	public void hitPressed() throws FileNotFoundException {

		// player can have a max. of 5 cards
		if (playerCards.size() > 5) {

			hit.setVisible(false);
			return;
		} // end if

		// player gets another card
		playerCards.add(cards.pop());

		// displays an appropriate image for player's new card
		InputStream stream = new FileInputStream(
				"images/" + playerCards.get(playerCards.size() - 1).getName() + ".jpg");
		Image image = new Image(stream);

		// Setting the image view parameters
		ImageView cardImage = new ImageView(image);
		cardImage.setX((playerCards.size() - 1) * 100 + 20);
		cardImage.setY(360);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds player's new card to gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

		// recalculate playerSum
		playerSum = Hands.calculateSum(playerCards);

		// displays winner when playerSum or dealerSum> 21
		if (playerSum >= 21 || dealerSum >= 21) {

			this.dealerCardReveal();
			this.pickWinner();

		} // end if

	} // end hitPressed()

	/*
	 * Method name: pickWinner
	 * Author: Iris Kim
	 * Description:
	 * - hides all buttons other than "replay"
	 * - decides on winner and display the winner
	 * Parameter: n/a
	 * Return: void
	 */
	public void pickWinner() throws FileNotFoundException {

		// only display replay button
		replay.setVisible(true);
		hit.setVisible(false);
		stand.setVisible(false);
		dealerHit.setVisible(false);
		dealerStand.setVisible(false);
		gameRoot.getChildren().remove(dealerTurn);

		// DECIDING WINNER

		// if one or both players' score is 21
		if (dealerSum == 21 || playerSum == 21) {

			if (dealerSum == 21 && playerSum == 21) {
				result = new Text(163, 265, "You tied");
			}

			else if (dealerSum == 21) {
				result = new Text(163, 265, "Dealer wins");
			}

			else if (playerSum == 21) {
				result = new Text(163, 265, "Player wins");
			}

		} // end if

		// if one or both players bust
		else if (dealerSum > 21 || playerSum > 21) {

			if (dealerSum > 21 && playerSum > 21) {
				result = new Text(163, 265, "You both busted.");
			}

			else if (dealerSum > 21) {
				result = new Text(163, 265, "Player wins");

			}

			else if (playerSum > 21) {
				result = new Text(163, 265, "Dealer wins");

			}

		} // end else if

		// both players neither bust or reach 21, so whoever with the higher sum wins
		else if (playerSum > dealerSum || dealerSum > playerSum) {

			if (playerSum > dealerSum) {
				result = new Text(163, 265, "Player wins");
			}

			if (dealerSum > playerSum) {
				result = new Text(163, 265, "Dealer wins");
			}

		} // end else if

		// both players neither bust or reach 21, and they have the same score
		else if (playerSum == dealerSum) {

			result = new Text(163, 265, "You tied");

		} // end else if

		// remove the card deck in the middle
		for (ImageView item : cardDecks) {
			gameRoot.getChildren().remove(item);
		}

		// displays result
		InnerShadow is = new InnerShadow();
		is.setOffsetX(4.0f);
		is.setOffsetY(4.0f);
		result.setStyle("-fx-font-size:60px;");
		result.setEffect(is);
		result.setFont(Font.font(null, FontWeight.BOLD, 80));
		result.setFill(Color.web("#DC143C"));
		gameRoot.getChildren().add(result);

	} // end pickWinner()

	/*
	 * Method name: dealCards
	 * Author: Iris Kim
	 * Description:
	 * - creates a shuffled deck of 52 cards
	 * - provides both player and dealer with 2 cards each
	 * Parameter: n/a
	 * Return: void
	 */
	public void dealCards() {

		// creates a deck of 52 cards
		cards = Deck.createDeck(cards);

		// picks random cards from the deck
		dealerCards.add(cards.pop());
		dealerCards.add(cards.pop());

		playerCards.add(cards.pop());
		playerCards.add(cards.pop());

	} // end dealCards()

	/*
	 * Method name: dealerHit
	 * Author: Iris Kim
	 * Description:
	 * - dealer gets one more card
	 * - image for dealer's new card is displayed
	 * - dealerSum is recalculated
	 * - if dealerSum or playerSum > 21, execute pickWinner()
	 * Parameter: n/a
	 * Return: void
	 */
	public void dealerHit() throws FileNotFoundException {

		// dealer gets another card
		dealerCards.add(cards.pop());

		// gets an approrpriate image for dealer's new card
		InputStream stream = new FileInputStream(
				"images/" + dealerCards.get(dealerCards.size() - 1).getName() + ".jpg");
		Image image = new Image(stream);

		// Setting the image view parameters
		ImageView cardImage = new ImageView(image);
		cardImage.setX((dealerCards.size() * 100) + 50);
		cardImage.setY(20);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds dealer's new card(s) to gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

		// recalculates dealerSum
		dealerSum = Hands.calculateSum(dealerCards);

		// execute pickWinner() when playerSum or dealerSum> 21
		if (playerSum >= 21 || dealerSum >= 17) {

			dealerHit.setVisible(false);
			dealerStand.setVisible(false);

			this.pickWinner();
		} // end if

	} // end dealerHit()

	/*
	 * Method name: playerStandPressed
	 * Author: Iris Kim
	 * Description:
	 * - player's turn is done; therefore, reveals dealer's card
	 * - if dealer hits, execute dealerHit()
	 * - if dealer stands, the round is over; execute pickWinner()
	 * - if someone wins, execute pickWinner()
	 * Parameter: n/a
	 * Return: void
	 */
	public void playerStandPressed() throws FileNotFoundException {

		// reveals dealer's first card
		this.dealerCardReveal();

		// Label dealerTurn
		dealerTurn = new Label("Dealer's turn: ");
		dealerTurn.setLayoutX(475);
		dealerTurn.setLayoutY(145);
		dealerTurn.setStyle("-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white;");

		// execute dealerHit() when button dealerHit is pressed
		dealerHit.setOnAction(e -> {
			try {
				this.dealerHit();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		}); // end EventHandler (hit)

		// set cursor to hand when mouse hovers over the button
		dealerHit.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		dealerHit.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// execute pickWinner() when dealerStand button is pressed
		dealerStand.setOnAction(e -> {
			try {
				this.pickWinner();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		}); // end EventHandler (dealerStand)

		// set cursor to hand when mouse hovers over the button
		dealerStand.setOnMouseEntered(e -> gameScene.setCursor(Cursor.HAND));
		dealerStand.setOnMouseExited(e -> gameScene.setCursor(Cursor.DEFAULT));

		// remove buttons hit and stand for the player
		hit.setVisible(false);
		stand.setVisible(false);

		// execute pickWinner() if appropriate
		if (dealerSum >= 17 || playerSum >= 21) {
			this.pickWinner();
		} // end if

		// otherwise, let the dealer play their turn
		else {
			dealerHit.setVisible(true);
			dealerStand.setVisible(true);
			gameRoot.getChildren().add(dealerTurn);
		} // end else

	} // end playerStandPressed()

	/*
	 * Method name: replayPressed
	 * Author: Iris Kim
	 * Description:
	 * - removes everything from the previous round
	 * - starts a new game
	 * - remove the every buttons while displaying hit and stand buttons
	 * Parameter: n/a
	 * Return: void
	 */
	public void replayPressed() throws FileNotFoundException {

		// removes all images from the screen
		for (ImageView image : cardImages) {
			gameRoot.getChildren().remove(image);
		}

		// removes the display of the result
		result.setVisible(false);
		gameRoot.getChildren().remove(result);

		// resets the game; resets both players' cards
		cardImages.clear();
		dealerCards.clear();
		playerCards.clear();

		// prepares a new game
		this.prepareGame();

		// set player's hit and stand buttons visible, others invisible
		hit.setVisible(true);
		stand.setVisible(true);
		replay.setVisible(false);
		dealerHit.setVisible(false);
		dealerStand.setVisible(false);

	} // end replayPressed()

	/*
	 * Method name: prepareGame
	 * Author: Iris Kim
	 * Description:
	 * - displays 4 cards (2 for the dealer, 2 for the player)
	 * - displays a deck of cards in the middle
	 * - calculates the sum of both players' cards
	 * - execute pickWinner() if their sum exceeds 21
	 * Parameter: n/a
	 * Return: void
	 */
	public void prepareGame() throws FileNotFoundException {

		// deals two cards to both dealer and player
		this.dealCards();

		// DEALER'S FIRST CARD (only shows the back)
		InputStream dealerCard1 = new FileInputStream("images/back.jpg");
		Image image = new Image(dealerCard1);

		// Setting the cardImage parameters
		ImageView cardImage = new ImageView(image);
		cardImage.setX(150);
		cardImage.setY(20);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds the image to gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

		// DEALER'S SECOND CARD (shows the front)
		InputStream dealerCard2 = new FileInputStream("images/" + dealerCards.get(1).getName() + ".jpg");
		image = new Image(dealerCard2);

		// Setting the image view parameters
		cardImage = new ImageView(image);
		cardImage.setX(250);
		cardImage.setY(20);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds the image to gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

		// PLAYER'S FIRST CARD
		InputStream playerCard1 = new FileInputStream("images/" + playerCards.get(0).getName() + ".jpg");
		image = new Image(playerCard1);

		// Setting the image view parameters
		cardImage = new ImageView(image);
		cardImage.setX(20);
		cardImage.setY(360);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds the image to gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

		// PLAYER'S SECOND CARD
		InputStream playerCard2 = new FileInputStream("images/" + playerCards.get(1).getName() + ".jpg");
		image = new Image(playerCard2);

		// Setting the image view parameters
		cardImage = new ImageView(image);
		cardImage.setX(120);
		cardImage.setY(360);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds the image to gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

		// displaying a deck of cards in the middle
		for (int i = 1; i < 6; i++) {
			InputStream decks = new FileInputStream("images/back.jpg");
			image = new Image(decks);
			cardDeck = new ImageView(image);

			// Setting the image view parameters
			cardDeck.setX(265 + (i * 10));
			cardDeck.setY(190);
			cardDeck.setFitWidth(70);
			cardDeck.setPreserveRatio(true);

			// adds the deck to gameRoot
			cardDecks.add(cardDeck);
			gameRoot.getChildren().add(cardDeck);
		} // end for

		// calculates each of dealer and player's sum
		dealerSum = Hands.calculateSum(dealerCards);
		playerSum = Hands.calculateSum(playerCards);

		// if someone wins, execute pickWinner()
		if (dealerSum >= 21 | playerSum >= 21) {
			this.pickWinner();
		} // end if

	} // end prepareGame()

	/*
	 * Method name: dealerCardReveal
	 * Author: Iris Kim
	 * Description:
	 * - flips the dealer's first card(which was originally faced-down) to reveal
	 * them
	 * Parameter: n/a
	 * Return: void
	 */
	public void dealerCardReveal() throws FileNotFoundException {

		// reveal dealer's first card (which was originally faced-down)
		InputStream stream = new FileInputStream("images/" + dealerCards.get(0).getName() + ".jpg");
		Image image = new Image(stream);

		// Setting the image view parameters
		ImageView cardImage = new ImageView(image);
		cardImage.setX(150);
		cardImage.setY(20);
		cardImage.setFitWidth(70);
		cardImage.setPreserveRatio(true);

		// adds the image to the gameRoot
		cardImages.add(cardImage);
		gameRoot.getChildren().add(cardImage);

	} // end dealerCardReveal()

	/*
	 * Method name: rule
	 * Author: Iris Kim
	 * Description:
	 * - display rules
	 * - contains a button to go back to main page
	 * Parameter: Stage primaryStage
	 * Return: void
	 */
	public void rule(Stage primaryStage) {

		// Title "How to Play"
		Text howToPlay = new Text("How to Play");
		howToPlay.setLayoutX(235);
		howToPlay.setLayoutY(45);
		howToPlay.setStyle("-fx-font-size:35px; -fx-background-color: transparent; -fx-underline: true;");
		howToPlay.setFill(Color.web("#FFFFFF"));

		// DISPLAYING RULES
		Label rules = new Label(
				"\n1. The goal of Blackjack is to beat the dealer's hand without going over 21. \n\n2. Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand. \n\n3. The player receives two cards face up and the dealer receives one card face up and one card face down. \n\n4. The player can decide to 'stand'(hold your total and end your turn) or 'hit'(ask for another card). \n\n5. If you go over 21 you bust and the dealer wins regardless of the dealer's hand. \n\n6. When the dealer is done serving the player, the dealer's face-down card is turned up. The dealer can hit until their cards total 17 or higher.");
		rules.setMaxWidth(580);
		rules.setWrapText(true);
		rules.setLayoutX(35);
		rules.setLayoutY(60);
		rules.setStyle("-fx-font-size:17px; -fx-background-color: transparent; -fx-text-fill: white");

		// BUTTON toMain
		Button toMain = new Button("Back to main");
		toMain.setLayoutX(235);
		toMain.setLayoutY(440);
		toMain.setStyle(
				"-fx-font-size:25px; -fx-background-color: transparent; -fx-text-fill: white; -fx-underline: true;");

		// switches to startScene when toMain button is pressed
		toMain.setOnAction(e -> primaryStage.setScene(startScene));

		// set cursor to hand when mouse hovers over the button
		toMain.setOnMouseEntered(e -> ruleScene.setCursor(Cursor.HAND));
		toMain.setOnMouseExited(e -> ruleScene.setCursor(Cursor.DEFAULT));

		// adding elements to the group
		ruleRoot.getChildren().add(howToPlay);
		ruleRoot.getChildren().add(rules);
		ruleRoot.getChildren().add(toMain);

	} // end rule()

} // end class BlackJack