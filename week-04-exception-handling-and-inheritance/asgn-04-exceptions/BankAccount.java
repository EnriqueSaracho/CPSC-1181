
public class BankAccount {

    private double balance;
    private int accountNumber;

    public BankAccount(int anAccountNumber) throws BankAccountException {
        if (anAccountNumber < 999 || anAccountNumber > 10000) {
            throw new BankAccountException("Invalid account number (not a 4-digit number)");
        }
        balance = 0;
        accountNumber = anAccountNumber;
    }

    public BankAccount(int anAccountNumber, double initialBalance) throws BankAccountException {
        if (anAccountNumber < 999 || anAccountNumber > 10000) {
            throw new BankAccountException("Invalid account number (not a 4-digit number)");
        }
        if (initialBalance < 0) {
            throw new BankAccountException("Inital balance less than zero");
        }
        balance = initialBalance;
        accountNumber = anAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws BankAccountException {
        if (balance - amount < 0) {
            throw new BankAccountException("Insufficient funds: Requested $" + amount + ", Available $" + balance);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "  balance: " + balance;
    }
}
