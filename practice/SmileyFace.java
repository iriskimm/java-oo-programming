/**
 * 
 */
package practice;

import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author iriskim
 *
 */
public class SmileyFace extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// create and configure the main circle for the face
		Circle face = new Circle(125, 125, 80);
		face.setFill(Color.YELLOW);
		face.setStroke(Color.RED);

		// create and configure the right eye for the face
		Circle rightEye = new Circle(86, 100, 10);
		rightEye.setFill(Color.YELLOW);
		rightEye.setStroke(Color.BLUE);

		// create and configure the left eye for the face
		Circle leftEye = new Circle(162, 100, 10);
		leftEye.setFill(Color.YELLOW);
		leftEye.setStroke(Color.BLUE);

		// create and configure a smiling mouth
		Arc mouth = new Arc(125, 150, 45, 35, 0, -180);
		mouth.setFill(Color.YELLOW);
		mouth.setStroke(Color.BLUE);
		mouth.setType(ArcType.OPEN);

		// create and configure the text
		Text caption = new Text(80, 240, "Smiley Face");
		caption.setFill(Color.STEELBLUE);
		caption.setFont(Font.font("Verdana", 15));

		Button button = new Button("switch face");
		Label label = new Label("");

		// Setting the location of the button
		button.setTranslateX(85);
		button.setTranslateY(260);

//		button.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

		// create a group that holds all the features and configure a scene to hold
		Group root = new Group(face, rightEye, leftEye, mouth, caption, button);
		Scene scene = new Scene(root, 250, 300, Color.YELLOW);

		// add the scene to the stage and set the title
		stage.setScene(scene);
		stage.setTitle("Smiley Face");

		// show the stage
		stage.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
