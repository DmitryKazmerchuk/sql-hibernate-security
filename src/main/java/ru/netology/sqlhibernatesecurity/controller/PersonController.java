package ru.netology.sqlhibernatesecurity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.sqlhibernatesecurity.entity.Person;
import ru.netology.sqlhibernatesecurity.repository.PersonRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {
@Autowired
    private final PersonRepository personRepository;

    @GetMapping("/by-city")
    public ResponseEntity <List<Person>> getPersonsByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(personRepository.findByCity(city));
    }

    @GetMapping("/by-name")
    public ResponseEntity<Person> getPersonsByCity(@RequestParam("name") String name, @RequestParam("surname") String surname){
        return personRepository.findByNameAndSurname(name, surname).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/by-age")
    public ResponseEntity<List<Person>> getPersonsByAge(@RequestParam("age") int age){
        return ResponseEntity.ok(personRepository.findByAgeLessThanOrderByAge(age));
    }
}
