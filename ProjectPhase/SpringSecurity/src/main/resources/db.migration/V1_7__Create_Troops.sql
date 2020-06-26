CREATE TABLE IF NOT EXISTS Troops (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    level int NOT NULL,
    hp int NOT NULL,
    attack int NOT NULL,
    defence int NOT NULL,
    finished_at int NOT NULL,
    started_at int NOT NULL,
    kingdom_id int DEFAULT NULL,
    FOREIGN KEY (kingdom_id) REFERENCES kingdoms (id)

);
