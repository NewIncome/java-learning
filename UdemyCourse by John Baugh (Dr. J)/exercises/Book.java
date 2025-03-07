/**
 * UML:
 * Book
 * ----
 * - author : String
 * - title : String
 * - genre : String
 * - numPages : int
 * -----------------
 * + Book(author : String, title : String,
 *        genre : String, numPages : int)
 * + geAuthor() : String
 * + getTitle() : String
 * + getGenre() : String
 * + getNumPages() : int
 */

class Book {
  private String author;
  private String title;
  private String genre;
  private int numPages;

  public Book(String author, String title, String genre, int numPages) {
    this.author = author;
    this.title = title;
    this.genre = genre;
    this.numPages = numPages;
  }//end param ctor

  // Setters or Mutators
  public String getAuthor() {
    return author;
  }//end getAuthor
  public String getTitle() {
    return title;
  }//end getTitle
  public String getGenre() {
    return genre;
  }//end getGenre
  public int getNumPages() {
    return numPages;
  }//end getNumPages

  public void printBookDetails() {
    System.out.println(title);
    System.out.println("by " + author);
    System.out.print("has " + numPages);
    System.out.println(" pages, and its genre is " + numPages);
    System.out.println();
  }//end printBookDetails
}//end Book class