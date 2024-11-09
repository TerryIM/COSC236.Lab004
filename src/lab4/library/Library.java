package lab4.library;

import java.util.ArrayList;
import java.util.List;

//import lab4.library.Book;

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
		//Empty Library
		this.catalog = new ArrayList<>();
		this.members = new ArrayList<>();
	}
	
	Library(List<Book> catalog, List<Member> members){
		this.catalog = catalog;
		this.members = members;
		//memberBorrowedBooks.put(member, List<Book>);
	}
	
	// Adds a book to the library catalog
	 public void addBook(Book book) {
		//Search for member in the library
		 if (catalog.contains(book)) {
			 //Member is already apart of the library
			 System.out.println(book.getName() + " already exists.");
		 }else {
			 members.add(book);
	         System.out.println(book.getName() + " has been added.");
		 }
	 }

	 // Adds a new member to the library (without a separate class)
	 public void addMember(Member member) {
		 //Search for member in the library
		 if (members.contains(member)) {
			 //Member is already apart of the library
			 System.out.println("Member " + member.getName() + " already exists.");
		 }else {
			 members.add(member);
	         System.out.println("Member " + member.getName() + " has been added.");
		 }
	 }
	 
	 // Borrow a book from the library
	 public void borrowBook(Book book, Member member) {
		 //Check if member exists in the Library
		 if (!members.contains(member)) {
			 //Member is not a registered member of the Library
			 System.out.println("Member " + member.getName() + " not found.");
			 return;
		 }
		 
		 if (!catalog.contains(book)) {
			//Book is not in stock
			 System.out.println(book.getName() + " is currently not available.");
			 return;
		 }
		 
		 
		 catalog.remove(book);
		 member.addBorrowedBook(book);
		 System.out.println(member.getName() + " has successfully borrowed " + book.getName());
	 }
	 
	 public void returnBook(Book book, Member member) {
		 if (!members.contains(member)) {
			//Member is not a registered member of the Library
			 System.out.println("Member " + member.getName() + " not found.");
			 return;
		 }
		 
		 if (member.getBorrowedBooks().contains(book)) {
			 member.removeBorrowedBook(book);
			 catalog.add(book);
			 System.out.println(member.getName() + " has successfully returned " + book.getName());
		 }else {
			 System.out.println(book.getName() + " is not being borrowed by " + member.getName());
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
	 
	 //Returns the first member of matching memberName in the library, else if no members with this name exist returns new Member
	 public Member findMemberByName(String memberName) {
		 for (Member m : members) {
			 if (memberName == m.getName()) {
				 return m;
			 }
		 }
		 //System.out.println("Error: " + memberName + "is not a registered member of this Library");
		 return new Member(memberName);
	 }
	 //Returns the first book of matching bookName in the catalog, else if no book with this name exists returns new Book
	 public Book findBookByName(String bookName) {
		 for (Book b : catalog) {
			 if (bookName == b.getName()) {
				 return b;
			 }
		 }
		 //System.out.println("Error: " + bookName + "is not an available book of this Library");
		 return new Book(bookName);
	 }

}