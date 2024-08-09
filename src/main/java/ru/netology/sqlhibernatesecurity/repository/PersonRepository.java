package ru.netology.sqlhibernatesecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.sqlhibernatesecurity.entity.Person;
import ru.netology.sqlhibernatesecurity.entity.PersonId;

import java.util.List;
import java.util.Optional;
@Repository
public interface PersonRepository extends CrudRepository<Person, PersonId> {

    List<Person> findByCity(String city);
    Optional<Person> findByNameAndSurname(String name, String surname);
    List<Person> findByAgeLessThanOrderByAge(int age);
}
