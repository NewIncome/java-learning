/**
 * UML:
 * BankAccount
 * -----------
 * - owner : String
 * - balance : int
 * ----------------
 * + BankAccount(owner : String)
 * + BankAccount(owner : String, balance : int)
 * + deposit(amount : int) : void
 * + withdraw(amount : int) : void
 * + getOwner() : String
 * + getBalance() : int
 */

class BankAccount {
  private String owner;
  private int balance;

  public BankAccount(String owner) {
    this(owner, 0);
  }//end 1 param ctor
  public BankAccount(String owner, int balance) {
    this.owner = owner;
    if(balance > 0) {
      this.balance = balance;
    } else {
      System.out.println("Error: Can't initialize an account with less than $1\n");
    }//end if-else
  }//end 2 param ctor

  public void deposit(int amount) {
    if(amount > 0) {
      balance += amount;
    } else {
      System.out.println("Error: Can't deposit less than $1\n");
    }//end if-else
    System.out.println("Deposit successful!");
  }//end deposit

  public void withdraw(int amount) {
    if(amount <= 0 && amount > balance) {
      balance -= amount;
    } else {
      System.out.println("Error: That's an invalid amount to withdraw! Must be 0 < <= " + balance + "\n");
    }//end if-else
    System.out.println("Withdrawl successful!");
  }//end withdraw

  public String getOwner() {
    return owner;
  }//end getOwner

  public int getBalance() {
    return balance;
  }//end getBalance

  public void printInfo() {
    System.out.println("owner: " + owner);
    System.out.println("balance: " + balance);
    System.out.println();
  }//end printInfo
}//end BankAccount class