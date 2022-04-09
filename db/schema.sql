CREATE TABLE IF NOT EXISTS accident
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(2000),
    text TEXT,
    address TEXT
);