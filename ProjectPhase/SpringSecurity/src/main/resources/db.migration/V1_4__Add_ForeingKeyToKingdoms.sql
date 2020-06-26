ALTER TABLE Kingdoms
ADD FOREIGN KEY (user_id) REFERENCES users(id);