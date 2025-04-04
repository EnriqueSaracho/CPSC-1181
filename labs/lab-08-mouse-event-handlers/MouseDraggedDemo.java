import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class MouseDraggedDemo extends Application {
    private Ellipse circle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        circle = new Ellipse(-10, -10, -10, -10);
        root.getChildren().add(circle);

        root.setOnMousePressed(new MousePressEventHandler());
        root.setOnMouseDragged(new MouseDragEventHandler());

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class MousePressEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            circle.setCenterX(e.getX());
            circle.setRadiusX(0);
            circle.setCenterY(e.getY());
            circle.setRadiusY(0);
        }
    }

    private class MouseDragEventHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            double xRadius = Math.abs(e.getX() - circle.getCenterX());
            double yRadius = Math.abs(e.getY() - circle.getCenterY());
            
            circle.setRadiusX(xRadius);
            circle.setRadiusY(yRadius);
        }
    }
}
