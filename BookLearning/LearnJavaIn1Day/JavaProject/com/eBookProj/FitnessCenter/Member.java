package com.eBookProj.FitnessCenter;

class Member {
  //Fields
  char memberType;
  int memberID;
  String name;
  double fees;

  //Constructor
  Member(char pMemberType, int pMemberID, String pName, double pFees) {
   memberType = pMemberType;
   memberID = pMemberID;
   name = pName;
   fees = pFees;
  }

  //Setter methods
  public void setMemberType(char pMemberType) {
   memberType = pMemberType;
  }
  public void setMemberID(char pMemberID) {
   memberID = pMemberID;
  }
  public void setName(String pName) {
   name = pName;
  }
  public void setFees(double pFees) {
   fees = pFees;
  }

  //Getter methods
  public char getMemberType() { return memberType; }
  public int getMemberID() { return memberID; }
  public String getName() { return name; }
  public double getFees() { return fees; }

  // toString overriden to be more informative //custom for all classes
  //Method that returns a string that provides information about a particular member
  @Override
  public String toString() {
    return "Member #" + memberID + "\n Name: " + name +
    ", Id: " + memberID + ", Type: '" + memberType + "', Fees: " + fees;
  }

  //Testing Method
  public static void main(String[] args) {
    Member m1 = new Member('s', 1, "Aria", 12.19);

    System.out.println(m1.toString());
  }
}