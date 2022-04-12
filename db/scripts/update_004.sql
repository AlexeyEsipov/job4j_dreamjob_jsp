DROP TABLE if exists candidate cascade ;
CREATE TABLE if not exists candidate (
                                         id SERIAL PRIMARY KEY,
                                         name TEXT,
                                         CITY_ID INT REFERENCES CITY(ID),
                                         CREATED TIMESTAMP
);
