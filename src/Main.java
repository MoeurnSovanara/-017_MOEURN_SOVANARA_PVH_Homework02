import java.time.Year;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[1;33m";
    private static final String GREEN = "\033[1;32m";
    private static final String BLUE = "\033[1;34m";
    private static final String CYAN = "\033[1;36m";
    private static final String RED = "\033[1;31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckingAccount checkingAccount = null;
        SavingAccount savingAccount = null;

        while (true) {
            System.out.println(BLUE + "================== Online Banking System ==================" + RESET);
            System.out.println(YELLOW + "1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Display Account Information");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit" + RESET);
            System.out.println(BLUE + "===========================================================" + RESET);
            System.out.print("=> Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Create Account
                    if (checkingAccount == null || savingAccount == null) {
                        System.out.println("1. Checking Account");
                        System.out.println("2. Saving Account");
                        System.out.print("Choose an option: ");
                        int accType = scanner.nextInt();
                        scanner.nextLine();
                        if (accType == 1 && checkingAccount == null) {
                            checkingAccount = new CheckingAccount();
                            System.out.println(GREEN + "Checking account created successfully!" + RESET);
                        } else if (accType == 2 && savingAccount == null) {
                            savingAccount = new SavingAccount();
                            System.out.println(GREEN + "Saving account created successfully!" + RESET);
                        } else {
                            System.out.println(RED + "Account already exists!" + RESET);
                        }
                    } else {
                        System.out.println(RED + "Both accounts already exist!" + RESET);
                    }
                    break;

                case 2: // Deposit Money
                    if (checkingAccount == null && savingAccount == null) {
                        System.out.println(RED + "No account exists. Create an account first." + RESET);
                        break;
                    }
                    System.out.println(BLUE + "1. Checking Account");
                    System.out.println("2. Saving Account" + RESET);
                    System.out.print("Choose an option: ");
                    int depType = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depType == 1 && checkingAccount != null) {
                        checkingAccount.deposit(depositAmount);
                    } else if (depType == 2 && savingAccount != null) {
                        savingAccount.deposit(depositAmount);
                    } else {
                        System.out.println(RED + "Invalid selection or account does not exist." + RESET);
                    }
                    break;

                case 3: // Withdraw Money
                    if (checkingAccount == null && savingAccount == null) {
                        System.out.println(RED + "No account exists. Create an account first." + RESET);
                        break;
                    }
                    System.out.println(BLUE + "1. Checking Account");
                    System.out.println("2. Saving Account");
                    System.out.println("3. Transfer Between Accounts" + RESET);
                    System.out.print("Choose an option: ");
                    int withType = scanner.nextInt();
                    if (withType == 3 && checkingAccount != null && savingAccount != null) {
                        System.out.println(BLUE + "1. Transfer from Checking to Saving");
                        System.out.println("2. Transfer from Saving to Checking" + RESET);
                        int transType = scanner.nextInt();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        if (transType == 1) {
                            checkingAccount.transfer(transferAmount, savingAccount);
                        } else if (transType == 2) {
                            savingAccount.transfer(transferAmount, checkingAccount);
                        } else {
                            System.out.println(RED + "Invalid option." + RESET);
                        }
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        if (withType == 1 && checkingAccount != null) {
                            checkingAccount.withdraw(withdrawAmount);
                        } else if (withType == 2 && savingAccount != null) {
                            savingAccount.withdraw(withdrawAmount);
                        } else {
                            System.out.println(RED + "Invalid selection or account does not exist." + RESET);
                        }
                    }
                    break;

                case 4: // Transfer Money
                    if (checkingAccount == null || savingAccount == null) {
                        System.out.println(RED + "Both accounts must exist to transfer money." + RESET);
                        break;
                    }
                    System.out.println(BLUE + "1. Transfer from Checking to Saving");
                    System.out.println("2. Transfer from Saving to Checking" + RESET);
                    System.out.print("Choose an option: ");
                    int transferChoice = scanner.nextInt();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    if (transferChoice == 1) {
                        checkingAccount.transfer(transferAmount, savingAccount);
                    } else if (transferChoice == 2) {
                        savingAccount.transfer(transferAmount, checkingAccount);
                    } else {
                        System.out.println(RED + "Invalid selection." + RESET);
                    }
                    break;

                case 5: // Display Account Information
                    if (checkingAccount == null && savingAccount == null) {
                        System.out.println(RED + "No account exists." + RESET);
                        break;
                    }
                    if (checkingAccount != null) checkingAccount.displayAccountInfo();
                    if (savingAccount != null) savingAccount.displayAccountInfo();
                    break;

                case 6: // Delete Account
                    if (checkingAccount == null && savingAccount == null) {
                        System.out.println(RED + "No account exists to delete." + RESET);
                        break;
                    }
                    System.out.println(BLUE + "1. Delete Checking Account");
                    System.out.println("2. Delete Saving Account" + RESET);
                    System.out.print("Choose an option: ");
                    int delType = scanner.nextInt();
                    if (delType == 1 && checkingAccount != null) {
                        if (savingAccount != null) {
                            savingAccount.deposit(checkingAccount.getBalance());
                        }
                        checkingAccount = null;
                        System.out.println(GREEN + "Checking account deleted successfully!" + RESET);
                    } else if (delType == 2 && savingAccount != null) {
                        if (checkingAccount != null) {
                            checkingAccount.deposit(savingAccount.getBalance());
                        }
                        savingAccount = null;
                        System.out.println(GREEN + "Saving account deleted successfully!" + RESET);
                    } else {
                        System.out.println(RED + "Invalid selection or account does not exist." + RESET);
                    }
                    break;

                case 7:
                    System.out.println(CYAN + "Exiting Online Banking System. Thank you!" + RESET);
                    scanner.close();
                    return;

                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
        }
    }
}

