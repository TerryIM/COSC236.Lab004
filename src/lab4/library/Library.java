package lab4.library;

import java.util.ArrayList;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	// private catalog (list of Book) 
	// private members (list of Members)

	// TODO: implement functionality of Member class
	
	private ArrayList<Book> availableBooks;
	private ArrayList<Member> memberBorrowedBooks;
	
	Library(ArrayList<Book> availableBooks, ArrayList<Member> memberBorrowedBooks){
		this.availableBooks = availableBooks;
		this.memberBorrowedBooks = memberBorrowedBooks;
	}
	
	// Adds a book to the library catalog
	 public void addBook(String bookName) {
	     availableBooks.add(bookName);
	     System.out.println(bookName + " has been added to the catalog.");
	 }

	 // Adds a new member to the library (without a separate class)
	 public void addMember(String memberName) {
	     if (!memberBorrowedBooks.containsKey(memberName)) {
	         memberBorrowedBooks.put(memberName, new ArrayList<>());
	         System.out.println("Member " + memberName + " has been added.");
	     } else {
	         System.out.println("Member " + memberName + " already exists.");
	     }
	 }

}
