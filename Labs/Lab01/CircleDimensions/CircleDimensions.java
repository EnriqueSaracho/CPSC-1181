import javax.swing.JOptionPane;

public class CircleDimensions {
    public static void main(String[] args) {
        int option = 0;

        while (option == 0) {
            double radius = getRadius();

            String area = computeArea(radius);

            String crfc = computeCircunference(radius);

            printResults(area, crfc);

            option = displayOptions();
        }

        return;
    }

    public static double getRadius() {
        String userInput = JOptionPane.showInputDialog(null, "Enter the radius of the circle:");
        double radius = Double.parseDouble(userInput);
        return radius;
    }

    public static String computeArea(double radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double roundOff = Math.round(area * 100.0) / 100.0;
        String result = Double.toString(roundOff);
        return result;
    }

    public static String computeCircunference(double radius) {
        double crfc = 2 * Math.PI * radius;
        double roundOff = Math.round(crfc * 100.0) / 100.0;
        String result = Double.toString(roundOff);
        return result;
    }

    public static void printResults(String area, String crfc) {
        String message = "Area: " + area + "\nCircumference: " + crfc;
        JOptionPane.showMessageDialog(null, message);
    }

    public static int displayOptions() {
        String message = "Would you like to try another circle?";
        String title = "Circle Dimensions";
        String[] options = { "Yes", "No" };
        int option = JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return option;
    }
}