package lab4.library;

import java.util.ArrayList;

public class Library {
	
	//  GRASP Principles: Creator, Controller
	//	Manage the catalog of books and members.
	//	Track which books are borrowed and available
	
	
	// Attributes:
	// private catalog (list of Book) 
	// private members (list of Members)

	// TODO: implement functionality of Member class
	
	private ArrayList<Book> catalog;
	private ArrayList<Member> members;
	
	Library(ArrayList<Book> catalog, ArrayList<Member> members){
		this.catalog = catalog;
		this.members = members;
	}
	
	public void manageBookCatalog() {
		
	}

}
