package fr.uha.anis.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.uha.anis.dao.FilmRepository;
import fr.uha.anis.dao.TicketRepository;
import fr.uha.anis.entities.Film;
import fr.uha.anis.entities.Ticket;
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController

public class CinemaController {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	
	
	@GetMapping("/filmlists")
	public List<Film> getFilms()
	{
		return filmRepository.findAll();
	}
	
	//afficher image
	@GetMapping(path="/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable (name="id")Long id) throws IOException
	{
		Film film=filmRepository.findById(id).get();
		String nameFile=film.getPhoto();
		File file=new File(System.getProperty("user.home")+"/cinema/"+nameFile);
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	
	//payer ticket
	@PostMapping("/payerticket")
	@Transactional
	public List<Ticket> payerTicket(@RequestBody  TicketForm ticketForm)
	{
		List<Ticket> listTickets=new ArrayList<Ticket>();
		ticketForm.getTickets().forEach(idTicket->{
			Ticket ticket=ticketRepository.findById(idTicket).get();
			System.out.println(ticket.getId());
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setCodePayment(Integer.parseInt(ticketForm.getCodePayment()));
			ticket.setReserve(true);
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		});
		System.out.print(ticketForm.toString());
		return new ArrayList<Ticket>();
	}
}
