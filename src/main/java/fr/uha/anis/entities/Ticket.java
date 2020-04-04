package fr.uha.anis.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Ticket {
    
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String nomClient;
	private double prix;
	private int codePayment;
	private boolean reserve;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Projection projection;
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(String nomClient, double prix, int codePayment, boolean reserve, Place place) {
		super();
		this.nomClient = nomClient;
		this.prix = prix;
		this.codePayment = codePayment;
		this.reserve = reserve;
		this.place = place;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getCodePayment() {
		return codePayment;
	}

	public void setCodePayment(int codePayment) {
		this.codePayment = codePayment;
	}

	public boolean isReserve() {
		return reserve;
	}

	public void setReserve(boolean reserve) {
		this.reserve = reserve;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}
