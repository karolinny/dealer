package br.edu.ifpb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"id","books"})
public class Client extends People {
	
	private static int id = 0;
	private List<Book> books;

	
	public Client(){}
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id++;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	
}
