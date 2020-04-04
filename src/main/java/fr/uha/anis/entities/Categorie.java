package fr.uha.anis.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categorie {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@OneToMany(mappedBy = "categorie")
	private Collection<Film> films;
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	public Categorie(String name, Collection<Film> films) {
		super();
		this.name = name;
		this.films = films;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Film> getFilms() {
		return films;
	}

	public void setFilms(Collection<Film> films) {
		this.films = films;
	}
	
	
}
