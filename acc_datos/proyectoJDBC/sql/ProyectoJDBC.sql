CREATE DATABASE jdbcMySqlAcceso;
use jdbcMySqlAcceso;

CREATE TABLE PérezEvaJugador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100)  NOT NULL,
    puntosTotales INT DEFAULT 0
);

CREATE TABLE PérezEvaPartida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    torneo_id INT,
    narrador_id INT,
    fecha DATE NOT NULL,
    resultado ENUM('TODOS', 'NADIE', 'ALGUNOS') NOT NULL,
    FOREIGN KEY (narrador_id) REFERENCES PérezEvaJugador(id)
);


