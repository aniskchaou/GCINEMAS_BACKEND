package fr.uha.anis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.uha.anis.service.ICinemaService;

@SpringBootApplication
public class GestionDesCinemasApplication implements CommandLineRunner {

	@Autowired
	ICinemaService cinemaService;
	public static void main(String[] args) {
		SpringApplication.run(GestionDesCinemasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cinemaService.initVilles();
		cinemaService.initCinemas();
	    cinemaService.initSalles();
	    cinemaService.initPlaces();
	    cinemaService.initSeances();
	    cinemaService.initCategories();
	    cinemaService.initFilms();
	    cinemaService.initProjections();
	    cinemaService.initTickets();
		
	}

}
