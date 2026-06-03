psql "postgresql://postgres:postgres@localhost:5432"
CREATE DATABASE griesytaxi;
CREATE USER griesytaxi WITH PASSWORD 'griesytaxi';
GRANT ALL PRIVILEGES ON DATABASE griesytaxi TO griesytaxi;
quit;

psql -U griesytaxi -d griesytaxi