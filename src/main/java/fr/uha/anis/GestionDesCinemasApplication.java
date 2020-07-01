package fr.uha.anis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import fr.uha.anis.entities.Film;
import fr.uha.anis.entities.Salle;
import fr.uha.anis.entities.Ticket;
import fr.uha.anis.service.ICinemaService;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GestionDesCinemasApplication implements CommandLineRunner {

	@Autowired
	ICinemaService cinemaService;
	
	@Autowired
	RepositoryRestConfiguration restConfiguration;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionDesCinemasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class,Salle.class,Ticket.class);
	  /* cinemaService.initVilles();
		cinemaService.initCinemas();
	   cinemaService.initSalles();
	    cinemaService.initPlaces();
	    cinemaService.initSeances();
	    cinemaService.initCategories();
	    cinemaService.initFilms();
	    cinemaService.initProjections();
	    cinemaService.initTickets();
		*/
	}

}
