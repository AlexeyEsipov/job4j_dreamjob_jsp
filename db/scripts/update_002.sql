DROP TABLE IF EXISTS users cascade ;
CREATE TABLE if not exists users (
                                     id SERIAL PRIMARY KEY,
                                     name TEXT,
                                     email TEXT unique ,
                                     password TEXT,
                                     created TIMESTAMP DEFAULT now(),
                                     modified TIMESTAMP DEFAULT now()
);
