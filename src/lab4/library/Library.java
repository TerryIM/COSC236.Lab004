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

	// DONE: implement functionality of Member class
	
	private List<Book> catalog;
	private List<Member> members;
	//private HashMap<Member, List<Book>> memberBorrowedBooks;
	
	Library(){
		//TODO Default values for catalog and members
	}
	
	Library(List<Book> catalog, List<Member> members){
		this.catalog = catalog;
		this.members = members;
		//memberBorrowedBooks.put(member, List<Book>);
	}
	
	// Adds a book to the library catalog
	 public void addBook(String bookName) {
		 Book b = new Book(bookName);
	     catalog.add(b);
	     System.out.println(bookName + " has been added to the catalog.");
	 }

	 // Adds a new member to the library (without a separate class)
	 public void addMember(String memberName) {
		 boolean isNewMember = true;
		 int memberID = Member.createMemberID(); //TODO Make Member's createMemberID() method static
		 
		 //Search for member with matching ID
		 for (Member m : members) {
			 if (m.getMemberID() == memberID) {
				 //Member is already apart of the library
				 isNewMember = false;
				 break;
			 }
		 }
		 
		 if (isNewMember) {
			 Member m = new Member(memberName, memberID); //TODO Allow Member's constructor accept both memberName and memberID
	         members.add(m);
	         System.out.println("Member " + memberName + " has been added.");
		 }else {
			 System.out.println("Member " + memberName + " already exists.");
		 }
		 
//	     if (!members.contains(memberName)) {
//	    	 Member m = new Member(memberName);
//	         members.add(m);
//	         System.out.println("Member " + memberName + " has been added.");
//	     } else {
//	         System.out.println("Member " + memberName + " already exists.");
//	     }
	 }
	 
	 // Borrow a book from the library
	 public void borrowBook(String bookName, String memberName) {
		 //Check if member exists in the Library
		 boolean isNewMember = true;
		 boolean bookAvailable = false;
		 Member member;
		 Book book;
		 for (Member m : members) {
			 if (m.getName() == memberName) { //TODO Possibly check memberID instead? can 2 members have the same name?
				 //Member is already apart of the library
				 isNewMember = false;
				 member = m;
				 break;
			 }
		 }
		 
		 if (isNewMember) {
			 //Member is not a registered member of the Library
			 System.out.println("Member " + memberName + " not found.");
			 return;
		 }
		 
		 //Check if Book is available to be borrowed
		 for (Book b : catalog) {
			//TODO Possibly check bookID instead? can 2 books have the same name?
			 if (b.getName() == bookName) { //TODO Create a getter for name in the Book class 
				 //Book is in stock
				 bookAvailable = true;
				 book = b;
				 break;
			 }
		 }
		 
		 if (!bookAvailable) {
			 //Book is not in the catalog
			 System.out.println(bookName + " is currently not available.");
			 return;
		 }
		 
		 catalog.remove(book);
		 member.addBorrowedBook(book);
		 System.out.println(memberName + " has successfully borrowed " + bookName);
		 
		 
//	     if (members.containsKey(memberName)) {
//	         System.out.println("Member " + memberName + " not found.");
//	         return;
//	     }
//
//	     if (catalog.contains(bookName)) {
//	         catalog.remove(bookName);
//	         //memberBorrowedBooks.get(memberName).add(availableBooks.get(availableBooks.indexOf(bookName)));
//	         Member m = new Member(memberName);
//	         Book b = new Book(bookName);
//	         m.addBorrowedBook(b);
//	         List borrowedBooks = m.getBorrowedBooks();
//	         memberBorrowedBooks.put(m, borrowedBooks);
//	         System.out.println(memberName + " has successfully borrowed " + bookName);
//	     } else {
//	         System.out.println(bookName + " is either already borrowed or not available.");
//	     }
	 }
	 
	 public void returnBook(String bookName, String memberName) {
		 boolean isNewMember = true;
		 boolean bookReturned = false;
		 Member memeber;
		 for (Member m : members) {
			 if (m.getName() == memberName) { //TODO Possibly check memberID instead? can 2 members have the same name?
				 //Member is already apart of the library
				 isNewMember = false;
				 member = m;
				 break;
			 }
		 }
		 
		 if (isNewMember) {
			 //Member is not a registered member of the Library
			 System.out.println("Member " + memberName + " not found.");
			 return;
		 }
		 
		 //Look through the member's borrowed books to find a match
		 for (Book b : member.getBorrowedBooks()) {
			 if (b.getName == bookName) {
				 //Match found
				 member.removeBorrowedBook(b);
				 catalog.add(b);
				 bookReturned = true;
				 System.out.println(memberName + " has successfully returned " + bookName);
				 break;
			 }
		 }
		 
		 if (!bookReturned) {
			 System.out.println(bookName + " is not being borrowed by " + memberName);
			 return;
		 }
		 
//		 if (!memberBorrowedBooks.containsKey(memberName)) {
//	         System.out.println("Member " + memberName + " not found.");
//	         return;
//	     }else {
//	         Member m = new Member(memberName);
//	         Book b = new Book(bookName);
//	         List borrowedBooks = m.getBorrowedBooks();
//	         memberBorrowedBooks.remove(m, borrowedBooks);
//	         m.removeBorrowedBook(b);
//	         availableBooks.add(b);
//	         System.out.println(memberName + " has successfully returned " + bookName);
//	     }
	 }

}