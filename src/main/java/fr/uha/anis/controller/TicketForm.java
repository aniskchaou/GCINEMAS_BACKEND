package fr.uha.anis.controller;

import java.util.ArrayList;
import java.util.List;

public class TicketForm {

	String nomClient;
	String codePayment;
	
	public String getCodePayment() {
		return codePayment;
	}
	public void setCodePayment(String codePayment) {
		this.codePayment = codePayment;
	}
	List<Long> tickets=new ArrayList<Long>();
	
	public TicketForm(String nomClient, List<Long> tickets) {
		super();
		this.nomClient = nomClient;
		this.tickets = tickets;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public List<Long> getTickets() {
		return tickets;
	}
	public void setTickets(List<Long> tickets) {
		this.tickets = tickets;
	}
	@Override
	public String toString() {
		return "TicketForm [nomClient=" + nomClient + ", codePayment=" + codePayment + ", tickets=" + tickets + "]";
	}
	
	
}
