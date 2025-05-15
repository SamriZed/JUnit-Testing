package lab8JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BookTest {
 Library l;
 Member member;
 Book book1;
 @BeforeEach
 void init() {
  l = new Library ();
  member = new Member();
  book1 = new Book ("The Great Gatsby", "F. Scott Fitzgerald", 1234,  true);
 }

 @Test
 void testAddBook() {
  l.addBook(book1);
  assertTrue(l.checkBook(book1));
 }
 
 @Test
 void testRemoveBook() {
  l.removeBook(book1);
  assertFalse(l.checkBook(book1));
 }
 
 @Test
 void testBorrowBook() {
  l.addBook(book1);
  member.borrowBook(l,book1);
  assertFalse(l.checkBook(book1));
 }
 
 @Test
 void testReturnBook() {
  member.returnBook(l,book1);
  assertTrue(l.checkBook(book1));
 }
 
 //Test constructor
 @Test 
 void testGetters() {
  assertEquals("The Great Gatsby", book1.getTitle());
  assertEquals(1234, book1.getISBN());
  assertEquals("F. Scott Fitzgerald", book1.getAuthor());
  assertTrue(book1.isAvailable);
 }
 
 @ParameterizedTest
 @ValueSource(ints = {1111, 2222, 3333, 4444})
 void testisValidISBN(int ISBN) {
  Book book = new Book("Title", "Author", ISBN, true);
  assertTrue(book.isValidISBN());
 }
 
 @Test
 void testOverBorrowing() {
  Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1234, false);
  try {
   member.borrowBook(l, book2);
   fail();
  } catch (IllegalStateException e) {
   assertEquals("Book not available", e.getMessage());
  }
 }
 
 @Test
 void testDuplicateReturn() {
  l.addBook(book1);
  try {
   member.returnBook(l, book1);
   fail();
  }catch(IllegalStateException e){
   assertEquals("Book already in library", e.getMessage());
  }
 }
 
 
// @Test
// void test() {
//  fail();
// }
 
 
}