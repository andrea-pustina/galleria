package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String title;
	
	@NotNull
	@Size(min=1)
	private int year;
	
	@NotNull
	@Size(min=1)
	private String dimensioni;
	
	@NotNull
	@ManyToOne
	private Author author;
	
	@NotNull
	@ManyToOne
	private Technique tecnique;	

	protected Opera() {}

	public Opera(String title, int year, String dimensioni, Author author, Technique technique) {
		this.title = title;
		this.year = year;
		this.dimensioni = dimensioni;
		this.author = author;
		this.tecnique = technique;
	}

	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, titolo='%s']",id, title);
	}



}
