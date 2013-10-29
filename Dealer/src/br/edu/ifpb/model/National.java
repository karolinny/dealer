package br.edu.ifpb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class National extends Book{
	private String gener;
	
	public National(){
		
	}

	public String getGener() {
		return gener;
	}

	public void setGener(String gener) {
		this.gener = gener;
	}
		
	
}
