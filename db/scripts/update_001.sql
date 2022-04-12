DROP TABLE IF EXISTS POST cascade ;
CREATE TABLE if not exists POST (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      created TIMESTAMP
);
