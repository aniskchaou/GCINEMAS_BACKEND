package fr.uha.anis.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Id;


@Entity
public class Ville {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double lattitude;
	private double attitude;
	private double longitude;
	@OneToMany(mappedBy = "ville")
	private Collection<Cinema> cinemas;
	
	public Ville() {
		// TODO Auto-generated constructor stub
	}

	public Ville(String name, double lattitude, double attitude, double longitude, Collection<Cinema> cinemas) {
		super();
		this.name = name;
		this.lattitude = lattitude;
		this.attitude = attitude;
		this.longitude = longitude;
		this.cinemas = cinemas;
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

	public double getLattitude() {
		return lattitude;
	}

	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	public double getAttitude() {
		return attitude;
	}

	public void setAttitude(double attitude) {
		this.attitude = attitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Collection<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(Collection<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	
	
}
