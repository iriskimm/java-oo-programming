/**
 * 
 */
package practice;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author iriskim
 *
 */
public class HelloWorld extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// first #: indent from left
		// second #: indent from top
		Text text = new Text(20,100,"Hello World");
		text.setFont(Font.font(100));
		text.setFill(Color.AQUAMARINE);
		text.setStroke(Color.WHITE);
		
		Group root = new Group(text);
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Welcome to JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
