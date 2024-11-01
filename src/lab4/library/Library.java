package lab4.library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	// private catalog (list of Book) 
	// private members (list of Members)

	// DONE: implement functionality of Member class
	
	private ArrayList<Book> availableBooks;
	private ArrayList<Member> members;
	private HashMap<Member, ArrayList<Book>> memberBorrowedBooks;
	
	Library(ArrayList<Book> availableBooks, ArrayList<Member> members){
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
	         memberBorrowedBooks.put(m, new ArrayList<Book>());
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
	         memberBorrowedBooks.get(memberName).add(availableBooks.get(availableBooks.indexOf(bookName)));
	         Member m = new Member();
	         
	         System.out.println(memberName + " has successfully borrowed " + bookName);
	     } else {
	         System.out.println(bookName + " is either already borrowed or not available.");
	     }
	 }

}
