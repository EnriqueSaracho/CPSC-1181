import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This program serves as a GUI by utilizing JavaFX
 */
public class Scenery extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Contains the code to create and display the graphical elements
     * 
     * @param primaryStage - the window
     */
    @Override
    public void start(Stage primaryStage) {
        // Creating the root layout element
        Pane root = new Pane();

        // Creating ground
        Rectangle ground = new Rectangle(0, 400, 600, 100);
        ground.setFill(Color.DARKGREEN);
        root.getChildren().add(ground);

        // Creating tree with default dimensions
        Tree t1 = new Tree (100, 420);
        root.getChildren().addAll(t1.getAllNodes());

        // Creating tree with custom dimensions
        Tree t2 = new Tree(200, 440, 100, 100, Color.rgb(100, 100, 80));
        root.getChildren().addAll(t2.getAllNodes());

        // Creating tree with custom dimensions
        Tree t3 = new Tree(250, 440, 100, 250, Color.rgb(120, 120, 10));
        root.getChildren().addAll(t3.getAllNodes());

        // Creating rainbow
        Color[] rainbow = {Color.RED, Color.ORANGE, Color.YELLOW, Color.BLUE, Color.INDIGO, Color.PURPLE};
        int yIncrease = 0;
        for (int i = 0; i < 6; i++) {
            Circle stripe = new Circle(300, 500+yIncrease, 450);
            stripe.setFill(Color.TRANSPARENT);
            stripe.setStroke(rainbow[i]);
            stripe.setStrokeWidth(7);

            root.getChildren().add(stripe);

            yIncrease += 6;
        }

        // Creating bear
        Bear bear = new Bear(480, 330);
        root.getChildren().addAll(bear.getAllNodes());

        // Creating the scene out of all the elements in the root
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("JavaFX Trees");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
