package lab8JUnit;

public class Book {
  String title;
  private String author;
  private int ISBN;
  public Boolean isAvailable;
  
  public Book() {
   title = "";
   author = "";
   ISBN = 0000;
   isAvailable=false;
  }
  
  public Book(String title, String author, int ISBN, Boolean isAvailable) {
   this.title=title;
   this.author=author;
   this.ISBN=ISBN;
   this.isAvailable=isAvailable;
  }
  
  public void borrowBook() {
   isAvailable = false;
   System.out.println("Book " + this.title + " is borrowed.");
  }
  
  public void returnBook() {
   isAvailable = true;
   System.out.println("Book" + this.title + " is returned.");
  }
  
  public String toString() {
   String bookInfo;
   bookInfo = "Book title is: " + this.title + ". The author is: "+ this.author;
   return bookInfo;
  }
  
  public String getTitle() {
   return title;
   
  }
  public String getAuthor() {
   return author;
  }
  
  public int getISBN() {
   return ISBN;
  }
  //ISBN has to be 4 digits 
  public boolean isValidISBN() {
   return ISBN >= 1000 && ISBN <= 9999;
  }

 }