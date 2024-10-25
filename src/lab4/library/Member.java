package lab4.library;

import java.util.List;

public class Member {
	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.
	private String memberID;
	private String name;
	private List<Book> borrowedBooks;
	
	public void member(String memberID, String name){
		this.memberID = memberID;
		this.name = name;
	}
	// TODO: implement functionality of Member class
	// private borrowedbBooks TODO: implement collection of borrowed books
	 // Borrow a book from the library, add book to borrowedBooks list
	 // Borrow a book from the library
	 public void borrowBook(String bookName, String memberName) {
		 Library library = new Library();
		 
		 //library.(getMemberBorrowedBooks()).containsKey(memberName);
	     if (!library.(getAvailableBooks()).contains(bookName)) {
	         System.out.println("Member " + memberName + " not found.");
	         return;
	     }
	     //library.(getAvailableBooks()).contains(bookName)
	     if (library.(getAvailableBooks()).contains(bookName))) {
	         availableBooks.remove(bookName);
	         memberBorrowedBooks.get(memberName).add(bookName);
	         System.out.println(memberName + " has successfully borrowed " + bookName);
	         borrowedBooks.add(book.setName(bookName));
	     } else {
	         System.out.println(bookName + " is either already borrowed or not available.");
	     }
	 }

	 public String getMemberID() {
		return memberID;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	// Return a book to the library
	 public void returnBook(String bookName, String memberName) {
		 
	     if (!memberBorrowedBooks.containsKey(memberName)) {
	         System.out.println("Member " + memberName + " not found.");
	         return;
	     }

	     if (memberBorrowedBooks.get(memberName).contains(bookName)) {
	         memberBorrowedBooks.get(memberName).remove(bookName);
	         availableBooks.add(bookName);
	         System.out.println(memberName + " has successfully returned " + bookName);
	     } else {
	         System.out.println(memberName + " didn't borrow " + bookName);
	     }
	 }

}
