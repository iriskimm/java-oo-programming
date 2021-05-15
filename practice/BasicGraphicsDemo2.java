/**
 * 
 */
package practice;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author iriskim
 *
 */
public class BasicGraphicsDemo2 extends Application {

	int WIDTH = 600;
	int HEIGHT = 400;

	double ballRadius = 40;
	double ballX = 100;
	double ballY = 200;
	double xSpeed = 4;

	@Override
	 public void start(Stage stage) throws Exception {
	       
        stage.setTitle("Basic JavaFX demo");
          
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
          
        // Bouncing Ball
        Circle circle = new Circle();
        circle.setCenterX(ballX);
        circle.setCenterY(ballY);
        circle.setRadius(ballRadius);
        circle.setFill(Color.BLUE);
        root.getChildren().add(circle);
          
        // need to attach KeyEvent caller to a Node of some sort.
        // How about an invisible Box?
        Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        
        root.getChildren().add(keyboardNode);
          
        stage.setScene(scene);
        stage.show();
        
        AnimationTimer animator = new AnimationTimer(){

            @Override
            public void handle(long arg0) {
   
                // UPDATE
                ballX += xSpeed;
                       
                if (ballX + ballRadius >= WIDTH)
                {
                    ballX = WIDTH - ballRadius;
                    xSpeed *= -1;
                } else if (ballX - ballRadius < 0) {
                    ballX = 0 + ballRadius;
                    xSpeed *= -1;
                }
   
                // RENDER
                circle.setCenterX(ballX);
            }
        };

        animator.start();
    }

    public void handle(KeyEvent arg0) {
          
        if (arg0.getCode() == KeyCode.SPACE )
        {
            xSpeed *= -1;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		launch(args);

	}

}
