package lab4.library;

import java.util.List;

public class Member {
	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.
	private String memberID;
	private String name;
	private List<Book> borrowedBooks;

	public void member(String name) {
		this.name = name;
		this.memberID = createMemberID();
	}
	
	// TODO: implement functionality of Member class
	// private borrowedbBooks TODO: implement collection of borrowed books
	// Borrow a book from the library, add book to borrowedBooks list
	// Borrow a book from the library
	public void borrowBook(String bookName, String name) {
		Library library = library.borrowBook(bookName, name);
		//library.borrowBook(bookName, name);
	}

	// Return a book to the library
	public void returnBook(String bookName, String name) {
		Library library = library.returnBook(bookName, name);
	}

	// Add book to list once borrowed
	public void addBorrowedBook(Book book) {
		borrowedBooks.add(book);
	}

	// Remove book from list upon return
	public void removeBorrowedBook(String bookName, String name) {
		borrowedBooks.remove(bookName, name);
	}
	// Make random member ID
	public int createMemberID() {
		return (int)(Math.random() * 100000) + 1;
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

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public void setName(String name) {
		this.name = name;
	}
}
