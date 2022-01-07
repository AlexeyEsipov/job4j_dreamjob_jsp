DROP TABLE IF EXISTS post cascade ;

DROP TABLE if exists candidate cascade ;

CREATE TABLE if not exists post (
                      id SERIAL PRIMARY KEY,
                      name TEXT
);
CREATE TABLE if not exists candidate (
                           id SERIAL PRIMARY KEY,
                           name TEXT
);
