package fr.uha.anis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.uha.anis.entities.Film;
@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film,Long>{

}
