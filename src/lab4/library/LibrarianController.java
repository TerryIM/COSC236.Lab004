package lab4.library;

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
	
	public void borrowBook(String memberName, String bookTitle ) {
		Member member = library.findMemberByName(memberName);
        Book book = library.findBookByTitle(bookTitle);
        
        member.addBorrowedBook(book);
	}
	
	public void returnBook(String memberName, String bookTitle) {
		Member member = library.findMemberByName(memberName);
		Book book = library.findBookByTitle(bookTitle);
		
		member.removeBorrowedBook(book);
	}

}
