package br.edu.ifpb.model;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class People {
	private String name;
	private Address address;
	private Calendar birthday;
	
	public People(){}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
