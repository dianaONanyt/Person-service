package co.edu.uptc.personservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.personservice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
