
public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects.

	// TODO: implement functionality of Member class
	// Just testing
	private Library library;

	public LibrarianController(Library library) {
		this.library = library;
	}

	public void addBook(String bookTitle) {
		library.addBook(new Book(bookTitle));
	}

	public void addBook(String bookTitle, String author) {
		library.addBook(new Book(bookTitle, author));
	}

	public void removeBook(String bookTitle, String author) {
		library.removeBook(new Book(bookTitle, author));
	}
	public void removeBook(String bookTitle) {
		library.removeBook(new Book(bookTitle));
	}

	public void addMember(String name) {
		library.addMember(new Member(name, library));
	}

	public void removeMember(String name) {
		library.removeMember(new Member(name, library));
	}

	public void borrowBook(String memberName, String bookTitle) {
		library.findMemberByName(memberName).borrowBook(library.findBookByTitle(bookTitle));
	}

	public void returnBook(String memberName, String bookTitle) {
		library.findMemberByName(memberName).returnBook(library.findBookByTitle(bookTitle));
	}
	public void showAvailableBooks() {
		library.showAvailableBooks();
	}
	public void listMembers() {
		library.listMembers();
	}
	public void borrowedBooks(String memberName) {
		library.findMemberByName(memberName).listBorrowedBooks();
	}
}
