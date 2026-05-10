package com.beehood.library.system;

import java.util.HashMap;

import com.beehood.library.model.Book;

public class LibrarySystem {

	private HashMap<Integer, Book> map = new HashMap<>();

	public void add(int id, String title, String author) {

		map.put(id, new Book(id, title, author));
		System.out.println("Book added.");
	}

	public boolean exists(int id) {
		return map.containsKey(id);
	}

	public void view() {

		if (map.isEmpty()) {
			System.out.println("No books found.");
			return;
		}

		for (Book b : map.values()) {
			System.out.println(b);
		}
	}

	public void search(int id) {

		Book b = map.get(id);

		if (b != null) {
			System.out.println("Found: " + b);
		} else {
			System.out.println("Book not found.");
		}
	}

	public void update(int id, String title, String author) {

		Book b = map.get(id);

		if (b == null) {
			System.out.println("Book not found.");
			return;
		}

		b.setTitle(title);
		b.setAuthor(author);
		System.out.println("Updated successfully.");
	}

	public void delete(int id) {

		if (map.remove(id) != null) {
			System.out.println("Deleted successfully.");
		} else {
			System.out.println("Book not found.");
		}
	}

}