
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Library Card associated with the Student 
 */
public class LibraryCard {
    /**
     * Card id 
     */
    private int ID;

    /**
     * Issue Date of the Card
     */
    private Date IssueDate;

    /**
     * Expiry Date of the Card
     */
    private Date ExpiryDate;

    /**
     * Number of books borrowed
     */
    private List<Book> borrowed = new ArrayList<Book>();

    /**
     * Fine asscoaited with the card
     */
    private double fine;

    /**
     *  Details about the cardholder
     */
    private Student student;




    public LibraryCard(Student student, Date IssueDate, Date ExpiryDate, int ID) {
        this.student = student;
        this.IssueDate = IssueDate;
	   this.ExpiryDate = ExpiryDate;
	   this.ID = ID;
    }


    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }


    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date IssueDate) {
        this.IssueDate = IssueDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    
    public List<Book> getBooks() {
        return borrowed;
    }

    

    /**
     * Issue a new book
     * @param Book: book to borrow 
     * @return true if the book is successfully borrowed, false otherwise
     * @throws IllegalBookIssueException
     */

    public boolean issueBook(Book book) throws IllegalBookIssueException {
        boolean can_borrow = true;

        int numBooksBorowed = 4;
        List<Book> listofbook = this.getBooks();                       // Here we are making sure it returns false if more than 4 books are borrowed.
        int countbook = listofbook.size();


        if (countbook > numBooksBorowed) {                               // setting it so that it returns false
            can_borrow = false;                                        
            return can_borrow;
        }
        
        Date issue_date = this.getIssueDate();
        Date expiry_date = this.getExpiryDate();
        boolean alreadyOver = issue_date.after(expiry_date);       // Here we are checking if the library card is valid

        if (alreadyOver == true) {                       
            can_borrow = false;
            return can_borrow;
        }

        Date currentdate = new Date();
        boolean alreadyOver2 = expiry_date.before(currentdate);           //We do this by making sure the expiry is before current date to retrun not valid
        if (alreadyOver2 == true) {                       
            can_borrow = false;
            return can_borrow;
        }

        if (listofbook.contains(book)) {
            throw new IllegalBookIssueException("this book is already issued");       //checking if the book is already on account.
        }

        double finepay = 0.00; 
        Double fine = this.getFine();
    
        if (fine > finepay) {                                                          //not allowed to borrow if there is a fine present
            can_borrow = false;
            return can_borrow;
        }

        if (!book.getStatus()) {                                                       //checking the status if book is available/unavailable to borrow
            can_borrow = false; 
        }

    

    return can_borrow;                  //allow to borrow if conditions are met

   
    }




}