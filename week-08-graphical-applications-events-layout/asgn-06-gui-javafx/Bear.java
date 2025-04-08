import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * This class represents a drawing of a bear and can be added to the list of children of a root element
 */
public class Bear {
    // Declaring bear drawing parts
    private Ellipse head;
    private Circle eye1;
    private Circle eye2;
    private Rectangle mouth;
    private Ellipse nose;
    private Ellipse ear1;
    private Ellipse ear2;
    private Ellipse neck;
    private Ellipse body;
    private Ellipse backend;
    private Ellipse leg1;
    private Rectangle forearm1;
    private Ellipse leg2;
    private Rectangle forearm2;
    private Ellipse paw1;
    private Ellipse paw2;
    private Ellipse butt;
    private Rectangle hindleg;
    private Ellipse hindpaw;

    /**
     * Bear class constructor. Places the bear in the specified coordinates.
     *
     * @param x - x coordinates
     * @param y - y coordinates
     */
    public Bear(int x, int y) {
        // Creating head
        head = new Ellipse(x, y, 40, 32);
        head.setFill(Color.SADDLEBROWN);
        head.setStroke(Color.BURLYWOOD);

        // Creating eyes
        eye1 = new Circle(x-15, y-3, 2);
        eye2 = new Circle(x+7, y-3, 2);

        // Creating mouth
        mouth = new Rectangle(x-20, y+2, 20, 16);
        mouth.setFill(Color.BURLYWOOD);

        // Creating nose
        nose = new Ellipse(x-13, y+6, 10, 5);

        // Creating right ear (bear's POV)
        ear1 = new Ellipse(x-22, y-20, 7, 12);
        ear1.setFill(Color.SADDLEBROWN);
        ear1.setStroke(Color.BURLYWOOD);

        // Creating left ear
        ear2 = new Ellipse(x+30, y-20, 8, 12);
        ear2.setFill(Color.SADDLEBROWN);
        ear2.setStroke(Color.BURLYWOOD);

        // Creating neck
        neck = new Ellipse(x-16, y+15, 35, 40);
        neck.setFill(Color.SADDLEBROWN);
        neck.setStroke(Color.BURLYWOOD);

        // Creating body/torso
        body = new Ellipse(x-50, y+25, 60, 40);
        body.setFill(Color.SADDLEBROWN);

        // Creating back
        backend = new Ellipse(x-80, y+20, 60, 40);
        backend.setFill(Color.SADDLEBROWN);
        backend.setStroke(Color.BURLYWOOD);

        // Creating right front leg
        leg1 = new Ellipse(x-50, y+40, 20, 35);
        leg1.setFill(Color.SADDLEBROWN);

        // Creating left front leg
        leg2 = new Ellipse(x+10, y+40, 20, 35);
        leg2.setFill(Color.SADDLEBROWN);

        // Creating lower part of right front leg
        forearm1 = new Rectangle(x-60, y+55, 22, 40);
        forearm1.setFill(Color.SADDLEBROWN);

        // Creating lower part of left front leg
        forearm2 = new Rectangle(x-2, y+55, 22, 40);
        forearm2.setFill(Color.SADDLEBROWN);

        // Creating right front paw
        paw1 = new Ellipse(x-45, y+90, 18, 9);
        paw1.setFill(Color.SADDLEBROWN);
        paw1.setStroke(Color.BURLYWOOD);

        // Creating left front paw
        paw2 = new Ellipse(x+10, y+90, 18, 9);
        paw2.setFill(Color.SADDLEBROWN);
        paw2.setStroke(Color.BURLYWOOD);

        // Creating rear end
        butt = new Ellipse(x-110, y+40, 40, 35);
        butt.setFill(Color.SADDLEBROWN);

        // Creating back leg
        hindleg = new Rectangle(x-140, y+45, 40, 50);
        hindleg.setFill(Color.SADDLEBROWN);

        // Creating hind leg
        hindpaw = new Ellipse(x-110, y+90, 20, 10);
        hindpaw.setFill(Color.SADDLEBROWN);
        hindpaw.setStroke(Color.BURLYWOOD);
    }

    /**
     *  Returns the bear drawing parts to be added to a root element as nodes
     *
     * @return - bear drawing parts/nodes
     */
    public Node[] getAllNodes(){
        return new Node[] {backend, hindleg, butt, hindpaw, body, forearm2, forearm1, leg2, leg1, paw2, paw1, neck, ear2, ear1, head, eye1, eye2, mouth, nose};
    }
}
