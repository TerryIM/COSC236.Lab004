
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {
	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.
	private int memberID;
	private String name;
	private List<Book> borrowedBooks;
	private Library library;

	public Member(String name, Library library) {
		this.name = name;
		this.memberID = createMemberID();
		this.borrowedBooks = new ArrayList<>();
		this.library = library;

	}

	// TODO: implement functionality of Member class
	// private borrowedbBooks TODO: implement collection of borrowed books
	// Borrow a book from the library, add book to borrowedBooks list
	// Borrow a book from the library
	public void borrowBook(Book book) {
		library.borrowBook(book, this);
	}

	// Return a book to the library
	public void returnBook(Book book) {
		library.returnBook(book, this);
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
		return (int) (Math.random() * 100000) + 1;
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
	public void listBorrowedBooks() {
		System.out.println(this.name + "'s borrowed books:");
		for (Book books : borrowedBooks) {
			System.out.println(books.getTitle() + " by author " + books.getAuthor());
		}
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Member other = (Member) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name); 
	}
}
