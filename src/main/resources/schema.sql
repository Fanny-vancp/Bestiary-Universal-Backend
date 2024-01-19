CREATE TABLE Beast (
                       id SERIAL PRIMARY KEY,
                       nom VARCHAR(255) NOT NULL,
                       description TEXT,
                       img VARCHAR(255)
);

CREATE TABLE Universe (
                          id SERIAL PRIMARY KEY,
                          nom VARCHAR(255) NOT NULL,
                          img VARCHAR(255)
);

CREATE TABLE BeastUniverse (
                               beast_id INT REFERENCES Beast(id),
                               universe_id INT REFERENCES Universe(id),
                               PRIMARY KEY (beast_id, universe_id)
);

CREATE TABLE "User" (
                      id SERIAL PRIMARY KEY,
                      firstName VARCHAR(255) NOT NULL,
                      lastName VARCHAR(255) NOT NULL,
                      login VARCHAR(255) UNIQUE NOT NULL,
                      email VARCHAR(255) UNIQUE NOT NULL,
                      password VARCHAR(255) NOT NULL
);

CREATE TABLE UserBeast (
                           user_id INT REFERENCES "User"(id),
                           beast_id INT REFERENCES Beast(id),
                           PRIMARY KEY (user_id, beast_id)
);

