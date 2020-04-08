package fr.uha.anis.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Id;

@Entity
public class Cinema implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double longitude;
	private double lattitude;
	private int nombreSalles;
	@OneToMany(mappedBy = "cinema")
	private Collection<Salle> salles;
	@ManyToOne
	private Ville ville;
	
	
	public Cinema() {
		// TODO Auto-generated constructor stub
	}


	public Cinema(String name, double longitude, double lattitude, int nombreSalles, Collection<Salle> salles,
			Ville ville) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.nombreSalles = nombreSalles;
		this.salles = salles;
		this.ville = ville;
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


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getLattitude() {
		return lattitude;
	}


	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}


	public int getNombreSalles() {
		return nombreSalles;
	}


	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}


	public Collection<Salle> getSalles() {
		return salles;
	}


	public void setSalles(Collection<Salle> salles) {
		this.salles = salles;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	 


}
