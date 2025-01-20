import javax.swing.JOptionPane;

public class FractionTest {
    public static void main(String args[]) {
        boolean flag = true;.

        while (flag) {

            // Ask user for the numerators and denominators of two fractions
            int num1, num2, den1, den2;
            num1 = Integer.parseInt(JOptionPane.showInputDialog("Enter numerator for fraction 1:"));
            den1 = Integer.parseInt(JOptionPane.showInputDialog("Enter denominator for fraction 1:"));
            num2 = Integer.parseInt(JOptionPane.showInputDialog("Enter numerator for fraction 2:"));
            den2 = Integer.parseInt(JOptionPane.showInputDialog("Enter denominator for fraction 2:"));

            // Create two Fraction objects
            Fraction f1 = new Fraction(num1, den1);
            Fraction f2 = new Fraction(num2, den2);

            // Add, multiply, and subract
            Fraction addition = f1.add(f2);
            Fraction multiply = f1.mulitply(f2);
            Fraction subtraction = f1.subraction(f2);

            // Display results
            String message = "Results:\n Addition: " + addition.toString() + "\n" +
                    "Multiplication: " + multiply.toString() + "\n" +
                    "Subtraction: " + subtraction.toString();
            JOptionPane.showMessageDialog(null, message, null, JOptionPane.DEFAULT_OPTION);

            // Repeat until user stops
            String[] options = { "Yes", "No" };
            int flagInt = JOptionPane.showOptionDialog(null, "Do you want to try again", null,
                    JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
            flag = (flagInt == 0);
        }
    }
}
