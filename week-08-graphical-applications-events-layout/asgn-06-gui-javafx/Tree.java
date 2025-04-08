import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * This class represents the drawing of a tree and can be added to the list of children of a root element
 */
public class Tree {
    // Declaring tree parts
    private Rectangle trunk;
    private Ellipse leaves;
    private Rectangle box;

    /**
     * Constructor function for creating a tree with the default dimensions. Places the tree in the specified coordinates
     *
     * @param x - x coordinates
     * @param y - y coordinates
     */
    public Tree(int x, int y){

        // Creating the tree trunk
        trunk = new Rectangle(x-10, y-100, 20, 100);
        trunk.setFill(Color.SADDLEBROWN);

        // Creating a box element for locating the coordinates
        box = new Rectangle(x, y, 5, 5);

        // Creating the tree leaves
        leaves = new Ellipse(x, y-100, 40, 60);
        leaves.setFill(Color.rgb(30, 120, 80));
    }

    /**
     * Constructor function for creating a tree with custom dimensions. Places the tree in the specified coordinates
     *
     * @param x - x coordinates
     * @param y - y coordinates
     * @param w - tree width
     * @param h - tree height
     * @param c - tree leaves' color
     */
    public Tree(int x, int y, int w, int h, Color c) {

        trunk = new Rectangle(x-w/6.0, y-h/2.0, w/3.0, h/2.0);
        trunk.setFill(Color.SADDLEBROWN);
        box = new Rectangle(x, y, 5, 5);

        leaves = new Ellipse(x, y-h*.7, w/2.0, h/2.0);
        leaves.setFill(c);
    }

    /**
     *  Returns the tree drawing parts to be added to a root element as nodes
     *
     * @return - tree drawing parts/nodes
     */
    public Node[] getAllNodes(){
        return new Node[] {trunk, leaves, box};
    }
}
