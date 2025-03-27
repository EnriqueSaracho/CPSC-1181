
import javax.swing.Action;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Arena extends Application {
    private Rectangle background;
    private Button button;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        background = new Rectangle(0, 0, 400, 400);
        
        button = new Button("Click here!");
        button.setLayoutX(40);
        button.setLayoutY(40);
        button.setOnAction(new ColorEventHandler());
        
        Pane root = new Pane();
        root.getChildren().addAll(background, button);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Arena");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ColorEventHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // do stuff here
            if(event.getSource() == button) {
                // do more stuff here
            }
        }
    }
}
