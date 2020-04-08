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
	private String heureDebut;
	
	public Seance() {
		
	}
	public Seance(String heureDebut) {
		super();
		this.heureDebut = heureDebut;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	
	
	
}
