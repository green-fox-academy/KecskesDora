CREATE TABLE IF NOT EXISTS Buildings (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type varchar(20) DEFAULT NULL,
    level int NOT NULL,
    hp int NOT NULL,
    started_at int NOT NULL,
    finished_at int NOT NULL,
    kingdom_id int DEFAULT NULL,
    FOREIGN KEY (kingdom_id) REFERENCES Kingdoms (id)

);
