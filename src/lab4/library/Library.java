package lab4.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//import lab4.library.Book;

public class Library {

	// GRASP Principles: Creator, Controller
	// Manage the availableBooks of books and membersBorrowedBooks.
	// Track which books are borrowed and available

	// Attributes:
	// private availableBooks (list of Book)
	// private membersBorrowedBooks (list of membersBorrowedBooks)

	// DONE: implement functionality of Member class

	private List<Book> availableBooks = new ArrayList<>();
	private HashMap<Member, List<Book>> memberBorrowedBooks = new HashMap<>();

	Library() {
		this.availableBooks = new ArrayList<>();
		this.memberBorrowedBooks = new HashMap<>();
	}

	Library(List<Book> availableBooks, Member member) {
		this.availableBooks = availableBooks;
		memberBorrowedBooks.put(member, new ArrayList<Book>());
	}

	// Adds a book to the library availableBooks
	public void addBook(Book book) {
		// Search for member in the library
		if (availableBooks.contains(book)) {
			// Library is already apart of the library
			System.out.println("'" + book.getTitle() + "' already exists.");
		} else {
			availableBooks.add(book);
			System.out.println("Book: '" + book.getTitle() + "' by '" + book.getAuthor() + "' has been added.");
		}
	}

	public void removeBook(Book book) {
		if (availableBooks.contains(book)) {
			availableBooks.remove(book);
			System.out.println("'" + book.getTitle() + "' has been successfully removed.");
		} else {
			System.out.println("'" + book.getTitle() + "' could not be found in the list");
		}
	}

	// Adds a new member to the library (without a separate class)
	public void addMember(Member member) {
		// Search for member in the library
		if (memberBorrowedBooks.containsKey(member)) {
			// Member is already apart of the library
			System.out.println("Member '" + member.getName() + "' already exists.");
		} else {
			memberBorrowedBooks.put(member, new ArrayList<Book>());
			System.out.println("Member '" + member.getName() + "' has been added.");
			// System.out.println(memberBorrowedBooks.toString());
		}
	}

	public void removeMember(Member member) {
		Iterator<Map.Entry<Member, List<Book>>> iterator = memberBorrowedBooks.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Member, List<Book>> entry = iterator.next();
			if (entry.getKey().getName().equals(member.getName())) {
				iterator.remove();
				System.out.println("'" + member.getName() + "' has been successfully removed");
				return;
			}
		}
		System.out.println("'" + member.getName() + "' is not a member of this library");
	}

	// Borrow a book from the library
	public void borrowBook(Book book, Member member) {
		// Check if member exists in the Library
		if (!(memberBorrowedBooks.containsKey(member))) {
			// Member is not a registered member of the Library
			// System.out.println(memberBorrowedBooks.toString());
			System.out.println("Member '" + member.getName() + "' not found.");
			return;
		}

		if (!availableBooks.contains(book)) {
			// Book is not in stock
			System.out.println("Book is currently not available.");
			return;
		}

		availableBooks.remove(book);
		member.addBorrowedBook(book);
		memberBorrowedBooks.put(member, member.getBorrowedBooks());
		System.out.println("'" + member.getName() + "' has successfully borrowed the book '" + book.getTitle() + "'.");
	}

	public void returnBook(Book book, Member member) {
		if (!(memberBorrowedBooks.containsKey(member))) {
			// Member is not a registered member of the Library
			System.out.println("Member '" + member.getName() + "' not found.");
			return;
		}
		member.listBorrowedBooks();
		if (member.getBorrowedBooks().contains(book)) {
			member.removeBorrowedBook(book);
			availableBooks.add(book);
			System.out
					.println("'" + member.getName() + "' has successfully returned the book '" + book.getTitle() + "'");
		} else {
			System.out.println("This book is not being borrowed by '" + member.getName() + "'.");
		}
	}

	// Returns the first member of matching memberName in the library, else if no
	// membersBorrowedBooks with this name exist returns new Member
	public Member findMemberByName(String memberName) {
		for (Member member : memberBorrowedBooks.keySet()) {
			if (member.getName().equals(memberName)) {
				return member;
			}
		}
		// Member not found, create a new one
		System.out.println("Member '" + memberName + "' does not exist; adding to userbase.");
		Member mem = new Member(memberName, this);
		addMember(mem);
		return mem;
	}

	// Returns the first book of matching bookName in the availableBooks, else if no
	// book with this name exists returns new Book
	public Book findBookByTitle(String bookName) {
		for (Book b : availableBooks) {
			if (b.getTitle().equals(bookName)) {
				return b;
			}
		}
		System.out.println("Error: Book '" + bookName + "' is either checked out or unavailable.");
		return null;
	}

	public void showAvailableBooks() {
		System.out.println("Available books:");
		for (Book books : availableBooks) {
			System.out.println(books.getTitle() + " by author " + books.getAuthor());
		}
	}

	public void listMembers() {
		for (Map.Entry<Member, List<Book>> entry : memberBorrowedBooks.entrySet()) {
			Member member = entry.getKey();
			List<Book> books = entry.getValue();
			System.out.println("Member: " + member.getName());
			System.out.println("Books borrowed:");
			for (Book book : books) {
				System.out.println("-- " + book.getTitle());
			}
		}
	}
}