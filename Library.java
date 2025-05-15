package lab8JUnit;
// import java.util.Scanner;
 import java.util.ArrayList;
 public class Library {
  ArrayList<Book>bookArray = new ArrayList<>();
  
  public void addBook(Book book) {
   bookArray.add(book);
   System.out.println("Book" + book + " successfully added.");
  }
  public void removeBook(Book book) {
   bookArray.remove(book);
   System.out.println("Book"+ book + " sucessfully removed.");
  }
  public void displayBooks() {
   System.out.println("Displaying book...");
   for (Book x : bookArray) {
    System.out.println(x);
   }
  }
  
  public void searchBook(String title) {
//   Scanner scanner = new Scanner(System.in);
//   System.out.print("Search book: ");
//   String searchResult= scanner.nextLine();
//   scanner.close();
   boolean found = false;
   
   for(Book x: bookArray) {
    if(x.getTitle().equalsIgnoreCase(title)) {
     found = true;
     if(x.isAvailable) {
      System.out.println("Book Available");
     }
     else {
      System.out.println("Book not available");
     }
     break;
    }
   }
   if(!found) {
    System.out.println("Book not found.");
    
   
   }
  }
   public boolean checkBook(Book book) {
    return bookArray.contains(book);
   }
  }