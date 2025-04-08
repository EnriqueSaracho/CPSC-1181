
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

            switch (option) {
                case 1: // Add bank account
                    addBankAccount(bank, in);
                    break;
                case 2: // Deposit to bank account
                    deposit(bank, in);
                    break;
                case 3: // Withdraw from bank account
                    withdraw(bank, in);
                    break;
                case 4: // Get balance from bank account

                    break;
                case 5: // Find maximum balance account
                    maximum(bank);
                    break;
                case 6: // Find minimum balance account
                    minimum(bank);
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
     * @param in   the scanner object
     * @return the option selected
     */
    public static int getOption(Bank bank, Scanner in) {

        int option;

        System.out.println("\n" + "------ Welcome ------");
        System.out.println(bank);
        System.out.println("Choose one of the options [1-7]:");
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
     * @param in   the scanner object
     */
    public static void addBankAccount(Bank bank, Scanner in) {

        int accountNumber;
        String balanceInput;
        BankAccount a;

        System.out.println("\n" + "--- Adding New Account ---");
        System.out.print("Enter new account number: ");
        accountNumber = in.nextInt();
        in.nextLine();

        System.out.print("Enter new account initial balance (press enter to skip): ");
        balanceInput = in.nextLine();

        try {
            if (balanceInput.isEmpty()) {
                a = new BankAccount(accountNumber);
            } else {
                int initialBalance = Integer.parseInt(balanceInput);
                a = new BankAccount(accountNumber, initialBalance);
            }

            bank.addAccount(a);
            System.out.println("Account successfully created");
        } catch (BankAccountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Deposits a certain amount to an account's balance
     *
     * @param bank the user's bank
     * @param in   the Scanner object
     */
    public static void deposit(Bank bank, Scanner in) {

        int accountNumber;
        double amount;

        System.out.println("");
        System.out.println("\n" + "--- Deposit ---");
        System.out.print("Enter account number: ");
        accountNumber = in.nextInt();
        System.out.print("Enter deposit amount: ");
        amount = in.nextDouble();

        try {
            bank.deposit(amount, accountNumber);
            System.out.println("Deposit successfully made");
        } catch (BankException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Withdraws a certain amount from an account's balance
     *
     * @param bank the user's bank
     * @param in   the Scanner object
     */
    public static void withdraw(Bank bank, Scanner in) {

        int accountNumber;
        double amount;

        System.out.println("\n" + "--- Withdraw ---");
        System.out.print("Enter account number: ");
        accountNumber = in.nextInt();
        System.out.print("Enter withdraw amount: ");
        amount = in.nextDouble();

        try {
            bank.withdraw(amount, accountNumber);
            System.out.println("Withdraw successfully made");
        } catch (BankException exception) {
            System.out.println(exception.getMessage());
        } catch (BankAccountException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // public static void getBalance(Bank bank, Scanner in) {
    // int accountNumber;
    // System.out.println("--- Get Account Balance ---");
    // System.out.print("Enter account number: ");
    // accountNumber = in.nextInt();
    // for(BankAccount a : bank) {
    // }
    // System.out.println("Withdraw successfully made");
    // }

    /**
     * Displays the account with the highest balance
     *
     * @param bank the user's bank
     */
    public static void maximum(Bank bank) {

        try {
            BankAccount a = bank.getMaximum();

            System.out.println("\n" + "--- Maximum Balance Account ---");
            System.out.println(a);

        } catch (BankException exception) {
            System.out.println(exception.getMessage());
        }

    }

    /**
     * Displays the account with the highest balance
     *
     * @param bank the user's bank
     */
    public static void minimum(Bank bank) {

        try {
            BankAccount a = bank.getMinimum();

            System.out.println("\n" + "--- Minimum Balance Account ---");
            System.out.println(a);

        } catch (BankException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
