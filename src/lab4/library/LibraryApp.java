package lab4.library;

public class LibraryApp {

	public static void main(String[] args) {
		Library lb = new Library();
		LibrarianController lc = new LibrarianController(lb);
		
		lc.addBook("Dune");
		lc.addBook("1984");
		lc.addBook("Moby Dick");
		lc.addBook("Joestar", "Joe");
		lc.addMember("Jo");
		lc.addMember("Amanda");
		lc.addMember("Vlad");
		lc.showAvailableBooks();
		lc.listMembers();
//		lc.borrowBook("Jo", "Joestar");
//		lc.returnBook("Jo", "Joestar");
//		lc.returnBook("z", "y");
		lc.removeMember("Jo");
		lc.removeBook("Joestar", "Joe");
		lc.removeBook("Dune");
		lc.showAvailableBooks();
		lc.borrowBook("Vlad" , "1984");
		lc.listMembers();
//		lc.returnBook("testName", "testBook");
		lc.returnBook("Vlad" , "1984");
//		lc.listMembers();
		lc.borrowedBooks("Vlad");
	}
}