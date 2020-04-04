package fr.uha.anis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.uha.anis.entities.Place;
@RepositoryRestResource
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
