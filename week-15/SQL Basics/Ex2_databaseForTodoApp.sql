USE todoapp;
CREATE TABLE IF NOT EXISTS apprentices (
	id INT PRIMARY KEY AUTO_INCREMENT, 
	firstname VARCHAR(255),
    lastname VARCHAR(255),
    age TINYINT UNSIGNED,
    gender ENUM("MALE", "FEMALE")
    );

 INSERT INTO apprentices(firstname, lastname, age, gender) VALUES
	("Viola", "Toth", 22, "FEMALE"),
 	("Anna", "Szeles", 25, "FEMALE"),
 	("Berci", "Nagy", 26, "MALE"),
	("Loci", "Kis", 23, "MALE"),
	("Aliz", "Karikas", 26, "FEMALE"),
	("Balint", "Molnar", 35, "MALE");

SELECT * FROM apprentices;

CREATE TABLE IF NOT EXISTS todos (
	id INT PRIMARY KEY AUTO_INCREMENT,
	task VARCHAR(255),
    completed BOOLEAN NOT NULL DEFAULT 0
	);

INSERT INTO todos (task, completed) VALUES
	("Walk the dog", 1),
    ("Buy milk", 1),
    ("Do homework", 0),
    ("Feed the monkey", 0);
    
SELECT * FROM todos;
	