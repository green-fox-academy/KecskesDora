CREATE TABLE IF NOT EXISTS Locations (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    x int NOT NULL,
    y int NOT NULL,
    kingdom_id int DEFAULT NULL,
    FOREIGN KEY (kingdom_id) REFERENCES kingdoms (id)

);
