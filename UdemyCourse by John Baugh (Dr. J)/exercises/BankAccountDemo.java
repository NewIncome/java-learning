public class BankAccountDemo {
  public static void main(String[] args) {
    BankAccount maleAcc = new BankAccount("Jade Law", 4000);
    BankAccount femAcc = new BankAccount("July Law");

    femAcc.deposit(2500);
    femAcc.printInfo();

    femAcc.withdraw(3000); //warning
    femAcc.printInfo();

    maleAcc.printInfo();

    maleAcc.deposit(1000);
    maleAcc.printInfo();
  }//end main
}//end BankAccountDemo