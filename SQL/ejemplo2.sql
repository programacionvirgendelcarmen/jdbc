DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	nombre TEXT,
	dni TEXT,
	check (dni regexp '^[0-9]{8}[a-zA-Z]$')
);
