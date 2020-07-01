package fr.uha.anis.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;
import javax.transaction.Transactional;

import org.apache.tomcat.util.buf.UDecoder;
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
public class CinemaServiceImpl implements ICinemaService {

	@Autowired
	VilleRepository villeRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	SalleRepository salleRepository;
	@Autowired
	PlaceRepository placeRepository;
	@Autowired
	SeanceRepository seanceRepository;
	@Autowired
	FilmRepository filmRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ProjectionRepository projectionRepository;
	@Autowired
	TicketRepository ticketRepository;

	// catagorie
	@Override
	public void initCategories() {
		Stream.of("Action", "Fiction", "Drama").forEach(cat -> {
			Categorie categorie = new Categorie();
			categorie.setName(cat);
			categorieRepository.save(categorie);
		});

	}

	// cinemas
	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(v -> {
			Stream.of("Ciné Vox", "Cinéma Star", "Kinepolis", "The Palace").forEach(cinemaName -> {
				Cinema cinema = new Cinema();
				cinema.setName(cinemaName);
				cinema.setVille(v);
				cinema.setNombreSalles(4);
				cinemaRepository.save(cinema);

			});

		});

	}

	// films
	@Override
	public void initFilms()  {
		 try {
			 int[] realisateurs={"David Lynch","David Lynch","Orson Welles","Nicolas Winding Refn","Akira Kurosawa"}
            List<Categorie> categories = categorieRepository.findAll();
		String pattern = "yyyy-MM-dd";
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                Date date = simpleDateFormat.parse("2018-09-09");
		
		Stream.of("Roma", "Parasite", "The irishman", "Mariage Story", "Moonlight").forEach(titre -> {
			Film film = new Film();
			film.setTitre(titre);
			film.setDuree(new Random().nextInt(100) + 50);
			film.setRealisateur(new Random().nextInt(realisateurs.length));
			film.setDateSortie(date);
			//film.setCategorie(new Random().nextInt(categories.size()));
			film.setPhoto(titre.replaceAll(" ", "") + ".jpg");
			film.setCategorie(categories.get(new Random().nextInt(categories.size())));
			filmRepository.save(film);
		});
        } catch (Exception e) {
            e.printStackTrace();
        }
		

	}

	// places
	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle -> {
			for (int i = 0; i < salle.getNombrePlaces(); i++) {
				Place place = new Place();
				place.setNumero(i);
				place.setSalle(salle);
				placeRepository.save(place);

			}
		});

	}

	// projections
	@Override
	public void initProjections() {
		seanceRepository.findAll().forEach(seance -> {
			villeRepository.findAll().forEach(ville -> {
				ville.getCinemas().forEach(cinema -> {
					cinema.getSalles().forEach(salle -> {

						List<Film> film = filmRepository.findAll();
						int random = new Random().nextInt(film.size());

						Projection projection = new Projection();
						projection.setDateProjection(new Date());
						projection.setPrix(10 * new Random().nextInt(film.size()) + 10);
						projection.setSalle(salle);
						projection.setFilm(film.get(random));
						projection.setSeance(seance);
						projectionRepository.save(projection);

					});
				});
			});
		});

	}

	// salles
	@Override
	public void initSalles() {

		cinemaRepository.findAll().forEach(cinema -> {

			for (int i = 0; i <= 3; i++) {
				Salle salle = new Salle();
				salle.setName("Salle " + (i + 1));
				salle.setNombrePlaces(9);
				salle.setCinema(cinema);
				salleRepository.save(salle);
			}

		});
	}

	// seances
	@Override
	public void initSeances() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
		Stream.of("9H00", "12H00", "15H00", "17H00", "20H00", "22H00").forEach(s -> {
			Seance seance = new Seance();
			seance.setHeureDebut(s);
			seanceRepository.save(seance);
		});

	}

	// tickets
	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(projection -> {
			projection.getSalle().getPlaces().forEach(place -> {
				Ticket ticket = new Ticket();
				ticket.setPlace(place);
				ticket.setPrix(projection.getPrix());
				ticket.setProjection(projection);
				ticket.setReserve(false);
				ticketRepository.save(ticket);
			});
		});

	}

	// villes
	@Override
	public void initVilles() {
		Stream.of("Strasboug", "Lyon", "Paris").forEach(v -> {
			Ville ville = new Ville();
			ville.setName(v);
			villeRepository.save(ville);
		});

	}

}
