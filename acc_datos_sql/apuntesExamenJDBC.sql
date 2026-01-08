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








-- Esta consulta se utiliza para filtrar estudiantes basándose en un valor que se proporciona externamente (representado aquí por ? o un marcador de posición).
SELECT nombre, notaMedia
FROM Estudiantes
WHERE notaMedia < ?;

-- Esta consulta combina la información de las tablas Estudiantes y Direcciones para filtrar por la ciudad.
SELECT E.nombre, E.notaMedia, D.ciudad
FROM Estudiantes E
JOIN Direcciones D ON E.direccion_id = D.id
WHERE D.ciudad = 'Sevilla'
ORDER BY E.nombre DESC;

-- Esta consulta utiliza la función de agregación AVG() para calcular la media de las puntuaciones de cada estudiante.
SELECT E.nombre, AVG(S.puntuacion) AS score_medio
FROM Estudiantes E
JOIN Scores S ON E.id = S.estudiante_id
GROUP BY E.id, E.nombre;

-- Esta consulta utiliza la función COUNT() y agrupa los resultados por estudiante y por el tipo de puntuación (tipo).
SELECT E.nombre, S.tipo, COUNT(S.id) AS numero_puntuaciones
FROM Estudiantes E
JOIN Scores S ON E.id = S.estudiante_id
GROUP BY E.id, E.nombre, S.tipo
ORDER BY E.nombre, S.tipo;

-- Inserta un nuevo dispositivo con su nombre, categoría, precio y stock
INSERT INTO devices (name, category, price, stock) VALUES (?, ?, ?, ?);

-- Elimina un dispositivo de la base de datos según su id
DELETE FROM devices WHERE id = ?;

-- Obtiene todos los dispositivos que pertenecen a una categoría concreta
SELECT * FROM devices WHERE category = ?;

-- Muestra el nombre de cada dispositivo junto con la media de sus valoraciones
SELECT d.name, AVG(r.rating) AS media_rating
FROM devices d
LEFT JOIN reviews r ON d.id = r.device_id
GROUP BY d.id, d.name
HAVING media_rating IS NOT NULL;

-- Calcula el stock total sumando el stock de todos los dispositivos
String sql = "SELECT SUM(stock) AS total_stock FROM devices";

-- Obtiene el nombre y precio de los dispositivos ordenados de mayor a menor precio
String sql = "SELECT name, price FROM devices ORDER BY price DESC";

