
import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<BankAccount>();
    }

    public void addAccount(BankAccount a) {
        accounts.add(a);
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount a : accounts) {
            total = total + a.getBalance();
        }
        return total;
    }

    /**
     * Counts the number of bank accounts whose balance is at least a given
     * value.
     *
     * @param atLeast the balance required to count an account
     * @return the number of accounts having least the given balance
     */
    public int count(double atLeast) {
        int matches = 0;

        for (BankAccount a : accounts) {
            if (a.getBalance() >= atLeast) {
                matches++;
            }
        }
        return matches;
    }

    /**
     * Finds a bank account with a given number.
     *
     * @param accountNumber the number to find
     * @return the account with the given number, or null if there is no such
     * account
     */
    public BankAccount find(int accountNumber) throws BankException {
        for (BankAccount a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        throw new BankException("Account not found: " + accountNumber);
    }

    /**
     * Gets the bank account with the largest balance.
     *
     * @return the account with the largest balance, or null if the bank has no
     * accounts
     */
    public BankAccount getMaximum() throws BankException {
        if (accounts.size() == 0) {
            throw new BankException("No bank accounts registered");
        }

        BankAccount largest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++) {
            BankAccount a = accounts.get(i);
            if (a.getBalance() > largest.getBalance()) {
                largest = a;
            }
        }
        return largest;
    }

    public BankAccount getMinimum() throws BankException {
        if (accounts.size() == 0) {
            throw new BankException("No bank accounts registered");
        }

        BankAccount smallest = accounts.get(0);

        for (int i = 1; i < accounts.size(); i++) {
            BankAccount a = accounts.get(i);
            if (a.getBalance() < smallest.getBalance()) {
                smallest = a;
            }
        }
        return smallest;
    }

    public void deposit(double amount, int accountNumber) throws BankException {
        BankAccount a = this.find(accountNumber);
        a.deposit(amount);
    }

    public void withdraw(double amount, int accountNumber) throws BankException, BankAccountException {
        BankAccount a = this.find(accountNumber);
        a.withdraw(amount);
    }

    public String toString() {
        return "Bank " + accounts.toString();
    }
}
