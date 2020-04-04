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
public class Film {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	private String description;
	private String realisateur;
	private Date dateSortie;
	private double duree;
	private String photo;
	@OneToMany(mappedBy = "film")
	private Collection<Projection> projections;
	@ManyToOne
	private Categorie categorie;
	
	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(String titre, String description, String realisateur, Date dateSortie, double duree, String photo,
			Collection<Projection> projections, Categorie categorie) {
		super();
		this.titre = titre;
		this.description = description;
		this.realisateur = realisateur;
		this.dateSortie = dateSortie;
		this.duree = duree;
		this.photo = photo;
		this.projections = projections;
		this.categorie = categorie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Collection<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Collection<Projection> projections) {
		this.projections = projections;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
	
}
