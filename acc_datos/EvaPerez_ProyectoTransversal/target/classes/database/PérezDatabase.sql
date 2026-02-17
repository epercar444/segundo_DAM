/*create database perez_spring_boot;
use perez_spring_boot;*/

/*CREATE USER IF NOT EXISTS 'evaSpring'@'172.17.0.1' IDENTIFIED BY 'root1234';
GRANT ALL PRIVILEGES ON perez_spring_boot.* TO 'evaSpring'@'172.17.0.1';

FLUSH PRIVILEGES;*/


INSERT INTO autor (id, nombre, pais_origen) VALUES (1, 'Gabriel García Márquez', 'Colombia');
INSERT INTO autor (id, nombre, pais_origen) VALUES (2, 'Isabel Allende', 'Chile');
INSERT INTO autor (id, nombre, pais_origen) VALUES (3, 'Miguel de Cervantes', 'España');

INSERT INTO libro (id, titulo, pag_totales, autor_id) VALUES (1, 'Cien años de soledad', 471, 1);
INSERT INTO libro (id, titulo, pag_totales, autor_id) VALUES (2, 'La casa de los espíritus', 450, 2);
INSERT INTO libro (id, titulo, pag_totales, autor_id) VALUES (3, 'Don Quijote de la Mancha', 1032, 3);

INSERT INTO lector (id, username, password) VALUES (1, 'lector_pro', 'pass123');
INSERT INTO lector (id, username, password) VALUES (2, 'biblioteca_viva', 'securePass456');
INSERT INTO lector (id, username, password) VALUES (3, 'ana_reads', 'mypassword789');

INSERT INTO libro_lectores (libros_id, lectores_id) VALUES (1, 1);
INSERT INTO libro_lectores (libros_id, lectores_id) VALUES (2, 1);
INSERT INTO libro_lectores (libros_id, lectores_id) VALUES (3, 2);
INSERT INTO libro_lectores (libros_id, lectores_id) VALUES (1, 3);
INSERT INTO libro_lectores (libros_id, lectores_id) VALUES (3, 3);