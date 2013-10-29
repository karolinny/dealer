package br.edu.ifpb.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Foreign extends Book{
	private String Idiome;
	
	public Foreign(){}

	public String getIdiome() {
		return Idiome;
	}

	public void setIdiome(String idiome) {
		Idiome = idiome;
	}
	
		
}
