
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to borrow a new book from a library
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with "setting" method.
 */
public class IssueBook {

    
    @BeforeEach
    public void initialize() {
    }


    @Test
    public void true_IssueBook() throws IllegalBookIssueException {              //Test 1 if a book can simply be issued
        LibraryCard libraryCard = new LibraryCard(new Student("Benedict Kim", 0), new Date(), new Date(), 1);
        Book book1 = new Book(1, "Book 0", 0);
        assertEquals(true, libraryCard.issueBook(book1));
    }


    @Test 
    public void false_IfTooManyBooksIssue() throws IllegalBookIssueException {          //Test 2 if more than 4 books can be issued
    LibraryCard libraryCard = new LibraryCard(new Student("Diana Wales", 1), new Date(), new Date(), 2);
    Book book1 = new Book(2, "Book 1", 0);
    Book book2 = new Book(3, "Book 2", 0);
    Book book3 = new Book(4, "Book 3", 0);
    Book book4 = new Book(5, "Book 4", 0);
    Book book5 = new Book(6, "Book 5", 0);
    Book[] books = {book1, book2, book3, book4, book5};
    
    for (Book book : books) {
        assertFalse(libraryCard.issueBook(book));}
    }

    @Test
     public void false_IfLibraryCardInvalid() throws IllegalBookIssueException {      //Test 3 if library card is invalid dont issue
         LibraryCard libraryCard = new LibraryCard(new Student("Anthony Bridgerton", 23), new Date(2023-01-12), new Date(2022-03-12), 3);
         Book book = new Book(8, "Book 8", 0);
         assertEquals(false, libraryCard.issueBook(book));
    }

     
    @Test
    public void false_IfFineDue() throws IllegalBookIssueException {               //Test 4 if fine is present (anything greater than 0) don't issue book
    LibraryCard libraryCard = new LibraryCard(new Student("Kate Smith", 11), new Date(), new Date(), 42);
    libraryCard.setFine(1.00); 
    boolean result = libraryCard.issueBook(new Book(33, "Book 33", 0));
    assertFalse(result);  }

    @Test
    public void true_IfFineNotDue() throws IllegalBookIssueException {             //Test 5 if no fine present then issue book
    LibraryCard libraryCard = new LibraryCard(new Student("Lebron James", 28), new Date(), new Date(), 28);
    libraryCard.setFine(0.00);
    boolean result = libraryCard.issueBook(new Book(21, "Book 66", 0));
    assertTrue(result);  }


    @Test
    public void false_IfBookUnavailable() throws IllegalBookIssueException {       //Test 6 if book unavailable dont issue book
        LibraryCard libraryCard = new LibraryCard(new Student("Meryl Streep", 777), new Date(), new Date(), 77);
        Book book1 = new Book(77, "Book 77", 0);
        book1.setStatus(false);
        assertEquals(false, libraryCard.issueBook(book1));
    }

    @Test
    public void true_IfBookAvailable() throws IllegalBookIssueException {         //test 7 if book available issue book
        LibraryCard libraryCard = new LibraryCard(new Student("Nick Jonas", 1), new Date(), new Date(), 30);
        Book book1 = new Book(30, "Book 30", 0);
        book1.setStatus(true);
        assertEquals(true, libraryCard.issueBook(book1));
    }

    @Test
    public void ThrowsException_ifBookAlreadyIssued() throws IllegalBookIssueException {          //test 8 if book already issued dont issue again.
        LibraryCard libraryCard = new LibraryCard(new Student("Kate Bridgerton", 12), new Date(), new Date(), 12);
        Book book1 = new Book(12, "Book 12", 0);
        libraryCard.issueBook(book1);
        assertEquals(false, libraryCard.issueBook(book1)); }


    





}




