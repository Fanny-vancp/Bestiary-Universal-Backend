CREATE TABLE Beast (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    img VARCHAR(255)
);

CREATE TABLE Universe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    img VARCHAR(255)
);

CREATE TABLE BeastUniverse (
    beast_id INT,
    universe_id INT,
    PRIMARY KEY (beast_id, universe_id),
    FOREIGN KEY (beast_id) REFERENCES Beast(id),
    FOREIGN KEY (universe_id) REFERENCES Universe(id)
);
