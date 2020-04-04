package fr.uha.anis.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Id;


@Entity
public class Place {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	private double longitude;
	private double lattitude;
	private double attitude;
	@ManyToOne
	private Salle salle;
	@OneToMany(mappedBy = "place")
	private Collection<Ticket> tickets;
	
	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(int numero, double longitude, double lattitude, double attitude, Salle salle,
			Collection<Ticket> tickets) {
		super();
		this.numero = numero;
		this.longitude = longitude;
		this.lattitude = lattitude;
		this.attitude = attitude;
		this.salle = salle;
		this.tickets = tickets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public double getAttitude() {
		return attitude;
	}

	public void setAttitude(double attitude) {
		this.attitude = attitude;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Collection<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
}
