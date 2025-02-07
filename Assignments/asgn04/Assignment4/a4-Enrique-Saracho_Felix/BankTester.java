
import java.util.Scanner;

public class BankTester {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            // Create bank
            Bank bank = new Bank();

            // Ask the user for option
            int option = getOption(bank, in);

            System.out.println(option);

            switch (option) {
                case 1: // Add bank account
                    addBankAccount(bank, in);
                    break;
                case 2: // Deposit to bank account
                    bank.deposit(75, 1111);
                    break;
                case 3: // Withdraw from bank account
                    bank.withdraw(100, 1111);
                    break;
                case 4: // Get balance from bank account
                    System.out.print(bank.getMaximum() + "\n");
                    break;
                case 5: // Find maximum balance account
                    System.out.print(bank.getMaximum() + "\n");
                    break;
                case 6: // Find minimum balance account
                    System.out.print(bank.getMinimum() + "\n");
                    break;
                case 7: // Exit
                    done = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Displays options and returns the one selected
     *
     * @param bank the user's bank
     * @param in the scanner object
     * @return the option selected
     */
    public static int getOption(Bank bank, Scanner in) {
        int option;

        System.out.println("\n" + "------ Welcome ------");
        System.out.println(bank);
        System.out.println("Choose one of the options [1-6]:");
        System.out.println("  1. Add new account");
        System.out.println("  2. Deposit");
        System.out.println("  3. Withdraw");
        System.out.println("  4. Get account balance");
        System.out.println("  5. Maximum balance account");
        System.out.println("  6. Minimum balance account");
        System.out.println("  7. Exit");
        System.out.print(">> ");
        option = in.nextInt();

        return option;
    }

    /**
     * Creates a new account with user input and adds it to the bank.
     *
     * @param bank the user's bank
     * @param in the scanner object
     */
    public static void addBankAccount(Bank bank, Scanner in) {
        int accountNumber;
        String balanceInput;
        BankAccount a;

        System.out.println("--- Adding New Account ---");
        System.out.print("Enter new account number: ");
        accountNumber = in.nextInt();
        System.out.print("Enter new account initial balance (press enter to skip): ");
        balanceInput = in.nextLine();

        if (balanceInput.isEmpty()) {
            a = new BankAccount(accountNumber);
        } else {
            int initialBalance = Integer.parseInt(balanceInput);
            a = new BankAccount(accountNumber, initialBalance);
        }

        bank.addAccount(a);
        System.out.println("Account successfully created");
    }
}
