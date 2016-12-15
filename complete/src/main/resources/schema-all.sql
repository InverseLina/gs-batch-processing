DROP TABLE IF EXISTS people;

CREATE TABLE people  (
    person_id INTEGER (16) key not null auto_increment,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);
