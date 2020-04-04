package fr.uha.anis.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity
public class Projection {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    private Film film;
    @ManyToOne
    private Salle salle;
	@OneToMany(mappedBy = "projection")
	private Collection<Ticket> tickets;
	@ManyToOne
	private Seance seance;
	
	public Projection() {
		// TODO Auto-generated constructor stub
	}

	public Projection(Date dateProjection, double prix, Film film, Salle salle, Collection<Ticket> tickets,
			Seance seance) {
		super();
		this.dateProjection = dateProjection;
		this.prix = prix;
		this.film = film;
		this.salle = salle;
		this.tickets = tickets;
		this.seance = seance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateProjection() {
		return dateProjection;
	}

	public void setDateProjection(Date dateProjection) {
		this.dateProjection = dateProjection;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	
	
	
	
	
}
