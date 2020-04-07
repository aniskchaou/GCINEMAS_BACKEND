package fr.uha.anis.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="ticket",types=Ticket.class)
public interface ITicketProjection {

	public Long getId();
	public String getNomClient();
	public double getPrix();
	public Integer getCodePayment();
	public boolean getReserve();
	public Place getPlace();
	
}
