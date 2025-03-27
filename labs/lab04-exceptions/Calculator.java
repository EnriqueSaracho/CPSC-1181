
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int x, y;
        String op, result;

        boolean done = false;
        while (!done) {
            try {
                System.out.print("Enter the arithmetic expression: ");
                // Get the first operand
                x = getOperand(in);
                // Get the operation
                op = in.next();
                // Get the second operand
                y = getOperand(in);

                // Calculate result
                result = getResult(in, x, y, op);
                System.out.println(result);

            } catch (InputMismatchException exception) {
                System.out.println("The operand is not an integer");
            } catch (NumberFormatException exception) {
                System.out.println("Not an integer: " + exception.getMessage());
            } catch (ArithmeticException exception) {
                System.out.println("/ by 0");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } finally {
                in.nextLine();
            }
        }
    }

    public static int getOperand(Scanner in) throws InputMismatchException {
        int num = in.nextInt();
        return num;
    }

    public static String getResult(Scanner in, int x, int y, String op) throws ArithmeticException, IllegalArgumentException {
        int z = 0;
        switch (op) {
            case "+":
                z = x + y;
                break;
            case "-":
                z = x - y;
                break;
            case "*":
                z = x * y;
                break;
            case "/":
                z = x / y;
                break;
            case "%":
                z = x % y;
                break;
            case "q":
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid Operator");
        }

        String result = "" + x + " " + op + " " + y + " = " + z;
        return result;
    }
}
