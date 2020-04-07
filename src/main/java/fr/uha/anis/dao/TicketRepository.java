package fr.uha.anis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.uha.anis.entities.Ticket;
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RepositoryRestResource

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
