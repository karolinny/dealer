package br.edu.ifpb.model;

import java.util.List;

public class Client extends People {
	
	private Long id;
	private List<Book> books;

	
	public Client(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	
}
