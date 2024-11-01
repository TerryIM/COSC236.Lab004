package lab4.library;

import java.util.List;

public class Member {
	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.
	private int memberID;
	private String name;
	private List<Book> borrowedBooks;

	Library library = new Library();
	
	public Member(String name) {
		this.name = name;
		this.memberID = createMemberID();
	}
	
	// TODO: implement functionality of Member class
	// private borrowedbBooks TODO: implement collection of borrowed books
	// Borrow a book from the library, add book to borrowedBooks list
	// Borrow a book from the library
	public void borrowBook(String bookName, String name) {
		library.borrowBook(bookName, name);
	}

	// Return a book to the library
	public void returnBook(String bookName, String name) {
		library.returnBook(bookName, name);
	}

	// Add book to list once borrowed
	public void addBorrowedBook(Book book) {
		borrowedBooks.add(book);
	}

	// Remove book from list upon return
	public void removeBorrowedBook(Book book) {
		borrowedBooks.remove(book);
	}
	// Make random member ID
	public int createMemberID() {
		return (int)(Math.random() * 100000) + 1;
	}

	public int getMemberID() {
		return memberID;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public void setName(String name) {
		this.name = name;
	}
}
