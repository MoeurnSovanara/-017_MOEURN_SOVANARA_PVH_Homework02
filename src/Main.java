import java.security.PublicKey;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            BankingMenu();
            System.out.print("=> Enter your choice(1-7) : ");
            String choice =scanner.nextLine();
            switch (choice) {
                case "1":{
                    while (true){
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Creating Account <<<<<<<<<<<<<<<<<<<<<<<<");
                        TargetBankMenu();
                        System.out.print("=> What type of account do you want to Create ? ");
                        String choiceCreateAccout = scanner.nextLine();
                        if ("3".equals(choiceCreateAccout)){
                            System.out.println("Exiting...");
                            break;
                        }
                        switch (choiceCreateAccout) {
                            case "1":{
                                CheckingAccount checkingAccount =new CheckingAccount();
                                System.out.println("=============== Checking Account Information =====================");
                                checkingAccount.createAccount();
                                System.out.println("=======================================");
                                System.out.println("Your Checking account has been created successfully");
                            }
                            break;
                            case "2":{
                                // Savings Account
                                SavingAccount savingsAccount =new SavingAccount();
                                System.out.println("=============== Savings Account Information =====================");
                                savingsAccount.createAccount();
                                System.out.println("=======================================");
                                System.out.println("Your Savings account has been created successfully");
                            }
                            break;
                            default:{
                                System.out.println("Invalid choice, Please try again");
                                System.out.println("Can input from 1-3");
                                break;
                            }

                        }
                    }
                }
                case "2":{
                    while (true){
                        System.out.println(">>>>>>>>>>>>>>>>>>>> Deposit Money <<<<<<<<<<<<<<<<<<<<<<<<<<<");
                        TargetBankMenu();
                        System.out.print("=> Enter your choice(1-3) : ");
                        String choiceDepositMoney = scanner.nextLine();
                        switch (choiceDepositMoney) {
                            case "1":{
                                // Checking Account
                                break;
                            }
                            case "2":{
                                // Savings Account
                                break;
                            }
                            case "3":{
                                // Exiting...
                                break;
                            }
                            default:{
                                System.out.println("Invalid choice, Please try again");
                                System.out.println("Can input from 1-3");
                                break;
                            }
                        }
                    }

                }
                case "3":{
                    // Withdraw Money
                    break;
                }
                case "4":{
                    // Transfer Money
                    break;
                }
                case "5":{
                    // Display Account information
                    break;
                }
                case "6":{
                    // Delete Account
                    break;
                }
                case "7":{
                    // Exit
                    System.exit(0);
                    break;
                }
            }
        }
    }
    public static void BankingMenu(){
        System.out.println("============================ Online Banking System =============================");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Display Account information");
        System.out.println("6. Delete Account");
        System.out.println("7. Exit");
        System.out.println("----------------------------------------------------------------------");
    }
    public static void TargetBankMenu(){
        System.out.println("1. Checking Accout");
        System.out.println("2. Savings Account");
        System.out.println("3. Back");
        System.out.println("----------------------------------------------------------------------");
    }
}
