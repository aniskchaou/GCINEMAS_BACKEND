package fr.uha.anis.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Id;


@Entity
public class Seance {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date heureDebut;
	public Seance() {
		// TODO Auto-generated constructor stub
	}
	public Seance(Date heureDebut) {
		super();
		this.heureDebut = heureDebut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	
	
	
}
