package lab8JUnit;

public class Member {

 public void borrowBook(Library library, Book book) {
  
  if (library.checkBook(book)& book.isAvailable){
   book.borrowBook();
   library.removeBook(book);
    }
    else {
     throw new IllegalStateException("Book not available");
    }
 }
 public void returnBook(Library library, Book book) {
  if (library.checkBook(book)) {
   throw new IllegalStateException("Book already in library");
  }
  library.addBook(book);
  System.out.println(book.getTitle()+" has been returned.");
 }
 
 
}