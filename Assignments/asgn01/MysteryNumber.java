// Filename: MysteryNumber.java
// Written by Enrique Saracho Felix
// Written on 15-01-2025

/**
 * This program servers as a game called Mystery Game where the player is asked
 * to think of a number, and then do some calculations with it. The program then
 * calculates and shows the number based on the results provided.
 */
import javax.swing.JOptionPane;

public class MysteryNumber {

    final static String title = "Mystery Game";

    public static void main(String args[]) {
        boolean flag = true;

        while (flag) {
            // Choose difficulty
            int diff = getDifficulty();

            // Ask the user to generate a number. "Think of a number"
            thinkOfANumber();

            // Ask the user to perform operations based on that number
            performOperations(diff);

            // Ask the user to give the results of the operations
            double result = getResults();

            // Revealing the Mystery Number to the user
            revealResult(diff, result);

            // Ask the user if they want to play again
            flag = playAgain();
        }
    }

    /**
     * Generates an option dialog window to ask the user for the difficulty they
     * want for this game
     *
     * @return an integer in the range 0 to 2
     */
    public static int getDifficulty() {
        String message = "Choose the difficulty";
        String[] options = {"Novice", "Intermediate", "Expert"};
        int diff = JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return diff;
    }

    /**
     * Generates a message dialog window to ask the user to think of a number
     */
    public static void thinkOfANumber() {
        String message = "Think of a number";
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Guides the program to the corresponding method to display the operations
     * depending on the difficulty selected
     *
     * @param diff
     */
    public static void performOperations(int diff) {
        switch (diff) {
            case 0:
                noviceOperations();
                break;
            case 1:
                intermediateOperations();
                break;
            case 2:
                expertOperations();
                break;
            default:
                break;
        }
    }

    /**
     * Generates multiple message dialog windows displying the operations of
     * novice level difficulty
     */
    public static void noviceOperations() {
        String message1 = "Add 10";
        String message2 = "Subtract 5";
        String message3 = "Add 2";
        JOptionPane.showMessageDialog(null, message1, title, JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, message2, title, JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, message3, title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Generates multiple message dialog windows displying the operations of
     * intermediate level difficulty
     */
    public static void intermediateOperations() {
        String message1 = "Add 74";
        String message2 = "Subtract 51";
        String message3 = "Multiply by 3";
        JOptionPane.showMessageDialog(null, message1, title, JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, message2, title, JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, message3, title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Generates multiple message dialog windows displying the operations of
     * expert level difficulty
     */
    public static void expertOperations() {
        String message1 = "Multiply by 202";
        String message2 = "Divide by 10";
        String message3 = "Add 24";
        JOptionPane.showMessageDialog(null, message1, title, JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, message2, title, JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, message3, title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Generates an input dialog window to get the result of the operations from
     * the user
     *
     * @return a double
     */
    public static double getResults() {
        String resultStr = JOptionPane.showInputDialog("What is the result of the operations?");
        double result = Double.parseDouble(resultStr);
        return result;
    }

    /**
     * Calculates the mystery number based on the difficulty level its
     * operations and displays it to the user through a message dialog window
     *
     * @param diff
     * @param result
     */
    public static void revealResult(int diff, double result) {
        double answer = 0.0;
        switch (diff) {
            case 0:
                answer = result - 2 + 5 - 10;
                break;
            case 1:
                answer = (result / 3) + 51 - 74;
                break;
            case 2:
                answer = (((result - 24) * 10) / 202);
                break;
            default:
                break;
        }
        String message = "Your Mystery Number is: " + (int) answer;
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
    }

    /**
     * Generates an option dialog window to ask the user if they wish to keep
     * playing or not
     *
     * @return a boolean
     */
    public static boolean playAgain() {
        String message = "Do you want to play again?";
        String[] options = {"Yes", "No"};
        int result = JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_OPTION,
                JOptionPane.DEFAULT_OPTION, null, options, options[0]);
        boolean flag = (result == 0);
        return flag;
    }
}
