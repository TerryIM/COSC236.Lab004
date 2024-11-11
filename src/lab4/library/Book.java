package lab4.library;

import java.util.Objects;

public class Book {

	// GRASP Principle: Information Expert
	// available or borrowed.
	private String title;
	private String author;
	private boolean isAvailable;

	public Book(String title) {
		this.title = title;
		this.author = "Undefined";
		this.isAvailable = true;
	}

	public Book() {
	}

	// To initialize Book attributes
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	// Method to check if the book is available
	public boolean isAvailable() {
		return isAvailable;
	}

	// Method to borrow the book
	public void borrowBook() {
		if (isAvailable) {
			isAvailable = false;
		}
	}

	// Method to return the book
	public void returnBook() {
		isAvailable = true;
	}

	// Getter for title
	public String getTitle() {
		return title;
	}

	// Getter for author
	public String getAuthor() {
		return author;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
