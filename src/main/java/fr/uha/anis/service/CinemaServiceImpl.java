package fr.uha.anis.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.uha.anis.dao.CategorieRepository;
import fr.uha.anis.dao.CinemaRepository;
import fr.uha.anis.dao.FilmRepository;
import fr.uha.anis.dao.PlaceRepository;
import fr.uha.anis.dao.ProjectionRepository;
import fr.uha.anis.dao.SalleRepository;
import fr.uha.anis.dao.SeanceRepository;
import fr.uha.anis.dao.TicketRepository;
import fr.uha.anis.dao.VilleRepository;
import fr.uha.anis.entities.Categorie;
import fr.uha.anis.entities.Cinema;
import fr.uha.anis.entities.Film;
import fr.uha.anis.entities.Place;
import fr.uha.anis.entities.Projection;
import fr.uha.anis.entities.Salle;
import fr.uha.anis.entities.Seance;
import fr.uha.anis.entities.Ticket;
import fr.uha.anis.entities.Ville;

@Service
@Transactional
public class CinemaServiceImpl implements ICinemaService{
    
	@Autowired
	VilleRepository villeRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	SalleRepository salleRepository;
	@Autowired
	PlaceRepository placeRepository;
	@Autowired
	SeanceRepository  seanceRepository;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	CategorieRepository  categorieRepository;
	@Autowired
	ProjectionRepository projectionRepository;
	@Autowired
	TicketRepository ticketRepository;
	
	//catagorie
	@Override
	public void initCategories() {
		Stream.of("Action","Fiction","Drama").forEach(cat->{
			Categorie categorie=new Categorie();
			categorie.setName(cat);
			categorieRepository.save(categorie);
		});
		
	}

	//cinemas
	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v->{
			Stream.of("Ciné Vox","Cinéma Star0","Kinepolis","The Palace").forEach(cinemaName->{
				Cinema cinema=new Cinema();
				cinema.setName(cinemaName);
				cinema.setVille(v);
				cinema.setNombreSalles(1);
				cinemaRepository.save(cinema);
				//cinema.setNombreSalles(nombreSalles);
			});
			
		});
		
	}

	//films
	@Override
	public void initFilms() {
		List<Categorie> categories=categorieRepository.findAll();
		Stream.of("Roma","Parasite","The irishman","Mariage Story","Moonlight").forEach(titre->{
			Film film=new Film();
			film.setTitre(titre);
			film.setDuree(22.00);
			film.setPhoto(titre.replaceAll(" ","")+".jpg");
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
		
	}

	//places
	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle->{
			for (int i = 0; i < salle.getNombrePlaces(); i++) {
				Place place=new Place();
				place.setNumero(i);
				place.setSalle(salle);
				placeRepository.save(place);
				
			}
		});
		
	}

	//projections
	@Override
	public void initProjections() {
		villeRepository.findAll().forEach(ville->{
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					filmRepository.findAll().forEach(film->{
						seanceRepository.findAll().forEach(seance->{
							Projection projection=new Projection();
							projection.setDateProjection(new Date());
							projection.setPrix(22.4);
							projection.setSalle(salle);
							projection.setFilm(film);
							projection.setSeance(seance);
							projectionRepository.save(projection);
						});
					});
				});
			});
		});
		
	}

	//salles
	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema->{
			for (int i = 0; i <= 4; i++) {
			Salle salle=new Salle();
			salle.setName("Salle "+i+1);
			salle.setNombrePlaces(5);
			salle.setCinema(cinema);
			salleRepository.save(salle);
			}
		});
	}

	//seances
	@Override
	public void initSeances() {
		SimpleDateFormat  simpleDate= new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00").forEach(s->{
			Seance seance=new Seance();
			seance.setHeureDebut(s);
			seanceRepository.save(seance);
		});
		
	}

	//tickets
	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(projection->{
			projection.getSalle().getPlaces().forEach(place->{
				Ticket ticket=new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(projection.getPrix());
				ticket.setProjection(projection);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});
		
	}

	//villes
	@Override
	public void initVilles() {
		Stream.of("Strasboug","Lyon","Paris").forEach(v->{
			Ville ville=new Ville();
			ville.setName(v);
			villeRepository.save(ville);
		});
		
	}

}
