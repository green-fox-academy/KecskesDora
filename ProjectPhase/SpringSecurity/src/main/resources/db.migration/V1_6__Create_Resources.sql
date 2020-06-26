CREATE TABLE IF NOT EXISTS Resources (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type varchar(20) DEFAULT NULL,
    amount int NOT NULL,
    generation int NOT NULL,
    kingdom_id int DEFAULT NULL,
    FOREIGN KEY (kingdom_id) REFERENCES kingdoms (id)

);
