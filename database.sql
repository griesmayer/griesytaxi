psql "postgresql://postgres:postgres@localhost:5432/"
CREATE USER taxiuser WITH PASSWORD 'taxiuser';
CREATE DATABASE taxiuser OWNER taxiuser;
quit;