package ru.netology.sqlhibernatesecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
@Entity
@IdClass(PersonId.class)
public class Person implements Serializable {
    @Id
    @Column(nullable = false)
    private String name;
    @Id
    @Column(nullable = false)
    private String surname;
    @Id
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String phone_number;
    @Column(name = "city_of_living", nullable = false)
    private String city;
}