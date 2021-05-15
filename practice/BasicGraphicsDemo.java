/**
 * 
 */
package practice;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author iriskim
 *
 */
public class BasicGraphicsDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, 600, 400);

		Circle circle = new Circle();
		circle.setCenterX(100);
		circle.setCenterY(200);
		circle.setRadius(40);
		circle.setFill(Color.BLUE);
		root.getChildren().add(circle);

		stage.setTitle("Basic JavaFX demo");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		launch(args);

	}

}
