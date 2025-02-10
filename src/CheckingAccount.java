import java.util.Scanner;
public class CheckingAccount implements Account {
    private String userName,dateOfBirth,gender,phoneNumber;
    private double balance,rate=0.05;
    public CheckingAccount(String userName,String dateOfBirth,String gender,String phoneNumber){
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public CheckingAccount() {
        // default constructor
        this.userName = "Default User";
        this.dateOfBirth = "01/01/2000";
        this.gender = "Male";
        this.phoneNumber = "1234567890";
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        userName = scanner.nextLine();
        System.out.print("Enter Date of Birth(dd-mm-yyyy): ");
        dateOfBirth = scanner.nextLine();
        System.out.print("Enter Gender: ");
        gender = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        phoneNumber = scanner.nextLine();
    }

    @Override
    public void deposit(double amount) {
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void transfer(double amount, Account tagetAccount) {

    }

    @Override
    public void displayAccountInfo() {

    }


    public String getUserName() {
        return userName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public double getBalance() {
        return balance;
    }
}
