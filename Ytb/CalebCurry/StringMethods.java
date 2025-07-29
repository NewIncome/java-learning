package Ytb.CalebCurry;

public class StringMethods {
  public static void main(String[] args) {
    //String format method
    String name = "Caleb";
    System.out.println(String.format("Hello %s", name));
    
    String x = "yummm...my oh my chicken pot pie";
    //To get the character at the last index position
    System.out.println(x.charAt(x.length() - 1));
    String fullAd = x + " Now with 20% more chicken";
    System.out.println(fullAd);
    System.out.println(fullAd.contains("chicken"));
    System.out.println(fullAd.indexOf("my"));
    //It has an overloaded option, for a 2nd argument that is 'index to start at'
    System.out.println(fullAd.indexOf("my", 13));
    //Trick to skip 'ocurrence no.1' dinamically, if you don't know what index it is at
    //That +1 skips the 1st ocurrence
    System.out.println(fullAd.indexOf("my", fullAd.indexOf("my") + 1));
    //To grab the last ocurrence
    //Searches backwards
    System.out.println(fullAd.lastIndexOf("p"));

    System.out.println(fullAd.toLowerCase());
    System.out.println(fullAd.toUpperCase());
    //Removes all leading and trailing white spaces and tabs
    System.out.println(fullAd.strip()); //there's also .stripLeading(), and .stripTrailing
    //Beginning index is INCLUSIVE
    System.out.println(fullAd.substring(9));
    //Ending index is EXCLUSIVE
    System.out.println(fullAd.substring(9, 13));
  }
}
