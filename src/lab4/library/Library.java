package lab4.library;

import java.util.HashMap;
import java.util.List;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	// private catalog (list of Book) 
	// private members (list of Members)

	// DONE: imple ment functionality of Member class
	
	private List<Book> availableBooks;
	private List<Member> members;
	private HashMap<Member, List<Book>> memberBorrowedBooks;
	
	Library(List<Book> availableBooks, List<Member> members){
		this.availableBooks = availableBooks;
		this.members = members;
		//this.memberBorrowedBooks = memberBorrowedBooks;
	}
	
	// Adds a book to the library catalog
	 public void addBook(String bookName) {
		 Book b = new Book(bookName);
	     availableBooks.add(b);
	     System.out.println(bookName + " has been added to the catalog.");
	 }

	 // Adds a new member to the library (without a separate class)
	 public void addMember(String memberName) {
	     if (!memberBorrowedBooks.containsKey(memberName)) {
	    	 Member m = new Member(memberName);
	         memberBorrowedBooks.put(m, new List<Book>());
	         System.out.println("Member " + memberName + " has been added.");
	     } else {
	         System.out.println("Member " + memberName + " already exists.");
	     }
	 }
	 
	 // Borrow a book from the library
	 public void borrowBook(String bookName, String memberName) {
	     if (!memberBorrowedBooks.containsKey(memberName)) {
	         System.out.println("Member " + memberName + " not found.");
	         return;
	     }

	     if (availableBooks.contains(bookName)) {
	         availableBooks.remove(bookName);
	         //memberBorrowedBooks.get(memberName).add(availableBooks.get(availableBooks.indexOf(bookName)));
	         Member m = new Member(memberName);
	         Book b = new Book(bookName);
	         m.addBorrowedBook(b);
	         List borrowedBooks = m.getBorrowedBooks();
	         memberBorrowedBooks.put(m, borrowedBooks);
	         System.out.println(memberName + " has successfully borrowed " + bookName);
	     } else {
	         System.out.println(bookName + " is either already borrowed or not available.");
	     }
	 }
	 
	 public void returnBook(String bookName, String memberName) {
		 if (!memberBorrowedBooks.containsKey(memberName)) {
	         System.out.println("Member " + memberName + " not found.");
	         return;
	     }else {
	         Member m = new Member(memberName);
	         Book b = new Book(bookName);
	         List borrowedBooks = m.getBorrowedBooks();
	         memberBorrowedBooks.remove(m, borrowedBooks);
	         m.removeBorrowedBook(b);
	         availableBooks.add(b);
	         System.out.println(memberName + " has successfully returned " + bookName);
	     }
	 }

}
