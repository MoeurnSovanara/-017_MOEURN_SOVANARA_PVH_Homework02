import java.util.Scanner;

import java.util.Scanner;

public class SavingAccount implements Account {
    private double balance;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private static final double WITHDRAW_LIMIT_PERCENTAGE = 0.8;

//    color
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[1;33m";
    private static final String GREEN = "\033[1;32m";
    private static final String BLUE = "\033[1;34m";
    private static final String CYAN = "\033[1;36m";
    private static final String RED = "\033[1;31m";

    public SavingAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        this.userName = scanner.nextLine();
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        this.dateOfBirth = scanner.nextLine();
        System.out.print("Enter Gender (Male/Female): ");
        this.gender = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        this.phoneNumber = scanner.nextLine();
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(GREEN+"Deposit successful!"+RESET);
            System.out.println(BLUE+"Current balance: $" + balance+RESET);
        } else {
            System.out.println(RED+"Invalid deposit amount."+RESET);
        }
    }

    @Override
    public void withdraw(double amount) {
        double withdrawLimit = balance * WITHDRAW_LIMIT_PERCENTAGE;
        if (amount > 0 && amount <= withdrawLimit) {
            balance -= amount;
            System.out.println(GREEN+"Withdraw successful!"+RESET);
            System.out.println(BLUE+"Remaining balance: $" + balance+RESET);
        } else {
            System.out.println(RED+"Invalid withdraw amount or exceeds 80% limit."+RESET);
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println(GREEN+"Transfer successful!"+RESET);
            System.out.println(BLUE+"Remaining balance: $" + balance+RESET);
        } else {
            System.out.println(RED+"Invalid transfer amount or insufficient funds."+RESET);
        }
    }

    @Override
    public void displayAccountInfo() {
        System.out.println(YELLOW+"===== Saving Account Info ====="+RESET);
        System.out.println(BLUE+"Username: "+RESET+GREEN + userName+RESET);
        System.out.println(BLUE+"Date of Birth: "+RESET+GREEN + dateOfBirth+RESET);
        System.out.println(BLUE+"Gender: "+RESET+GREEN+ gender+RESET);
        System.out.println(BLUE+"Phone Number: "+RESET+GREEN + phoneNumber+RESET);
        System.out.println(BLUE+"Balance: $"+RESET+GREEN + balance+RESET);
    }

    public double getBalance() {
        return balance;
    }
}

