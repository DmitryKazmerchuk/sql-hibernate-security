CREATE SCHEMA persons_schema;

CREATE TABLE PERSONS (
                         name VARCHAR(254),
                         surname VARCHAR(254),
                         age INT,
                         phone_number VARCHAR(20),
                         city_of_living VARCHAR(254),
                         PRIMARY KEY (name, surname, age)
);

insert into PERSONS
values ('Ivan', 'Kosulin', 40, '+79101111111', 'Ufa');

insert into PERSONS
values ('Dmitry', 'Kazmerchuk', 41, '+79101111115', 'Moscow');

insert into PERSONS
values ('Alexandr', 'Senkin', 45, '+79101111113', 'Munich');

insert into PERSONS
values ('Petr', 'Ivanov', 25, '+79101111114', 'Moscow');

insert into PERSONS
values ('Roman', 'Sidorov', 35, '+79101111118', 'Moscow');

SELECT name, surname
FROM PERSONS
WHERE city_of_living = 'MOSCOW';
